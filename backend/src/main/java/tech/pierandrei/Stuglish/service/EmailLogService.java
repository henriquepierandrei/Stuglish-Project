package tech.pierandrei.Stuglish.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import tech.pierandrei.Stuglish.dto.EmailResponseDTO;
import org.thymeleaf.context.Context;

import java.util.concurrent.CompletableFuture;

@Service
public class EmailLogService {
    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;


    @Value("${log.email.to}")
    private String to;

    public EmailLogService(JavaMailSender mailSender, TemplateEngine templateEngine) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
    }

    @Async
    public CompletableFuture<Void> sendRequestAlert(EmailResponseDTO dto, String corpoRequest) throws MessagingException {
        MimeMessage mensagem = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensagem, true, "UTF-8");

        Context context = new Context();
        context.setVariable("TIMESTAMP", java.time.LocalDateTime.now().toString());
        context.setVariable("METHOD", dto.method());
        context.setVariable("URL", dto.url());
        context.setVariable("STATUS_CODE", dto.statusCode());
        context.setVariable("STATUS_CLASS", getStatusClass(dto.statusCode()));
        context.setVariable("CLIENT_IP", dto.clientIp());
        context.setVariable("USER_AGENT", dto.userAgent());
        context.setVariable("REFERRER", dto.referrer());
        context.setVariable("RESPONSE_TIME", dto.responseTimeMs());
        context.setVariable("PRIORITY", dto.priority().toUpperCase());
        context.setVariable("PRIORITY_CLASS", getPriorityClass(dto.priority()));
        context.setVariable("ACCEPT_HEADER", dto.acceptHeader());
        context.setVariable("CONTENT_TYPE", dto.contentType());
        context.setVariable("AUTH_HEADER", dto.authorizationHeader());
        context.setVariable("REQUEST_BODY", corpoRequest != null ? corpoRequest : "[Sem corpo]");

        String htmlContent = templateEngine.process("email-template", context);

        helper.setTo(to);
        helper.setSubject("🚨 Alerta de Requisição Detectada");
        helper.setText(htmlContent, true);

        mailSender.send(mensagem); // ← esta linha é o envio real

        return CompletableFuture.completedFuture(null); // ← retorno correto
    }

    private String getStatusClass(int statusCode) {
        if (statusCode >= 200 && statusCode < 300) return "success";
        if (statusCode >= 400 && statusCode < 500) return "warning";
        return "error";
    }

    private String getPriorityClass(String priority) {
        return switch (priority.toLowerCase()) {
            case "alta", "high" -> "high";
            case "media", "média", "medium" -> "medium";
            default -> "low";
        };
    }
}
