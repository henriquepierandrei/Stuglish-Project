package tech.pierandrei.Stuglish.config;

import jakarta.mail.MessagingException;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tech.pierandrei.Stuglish.dto.EmailResponseDTO;
import tech.pierandrei.Stuglish.service.EmailLogService;

import java.io.IOException;

@Component
public class LoggingFilter implements Filter {

    private final EmailLogService emailLogService;

    public LoggingFilter(EmailLogService emailLogService) {
        this.emailLogService = emailLogService;
    }

    @Value("${log.email.available}")
    private boolean logAvailable;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        CachedBodyHttpServletRequest cachedRequest = new CachedBodyHttpServletRequest(req);

        long startTime = System.currentTimeMillis();
        chain.doFilter(cachedRequest, response);
        long responseTime = System.currentTimeMillis() - startTime;

        String requestBody = cachedRequest.getCachedBodyAsString();

        EmailResponseDTO dto = new EmailResponseDTO(
                req.getMethod(),
                req.getRequestURI(),
                res.getStatus(),
                req.getRemoteAddr(),
                req.getHeader("User-Agent"),
                req.getHeader("Referer"),
                responseTime,
                req.getHeader("X-Priority") != null ? req.getHeader("X-Priority") : "normal",
                req.getHeader("Accept"),
                req.getContentType(),
                req.getHeader("Authorization")
        );

        if (logAvailable) {
            try {
                emailLogService.sendRequestAlert(dto, requestBody);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
