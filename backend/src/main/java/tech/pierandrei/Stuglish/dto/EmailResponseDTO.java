package tech.pierandrei.Stuglish.dto;

public record EmailResponseDTO(
        String method,             // Método HTTP
        String url,                // URL solicitada
        int statusCode,           // Status HTTP
        String clientIp,          // IP do cliente
        String userAgent,         // User-Agent
        String referrer,          // Referrer
        long responseTimeMs,      // Tempo de resposta
        String priority,          // Prioridade

        // Headers
        String acceptHeader,
        String contentType,
        String authorizationHeader
) {

}
