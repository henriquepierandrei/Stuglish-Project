package tech.pierandrei.Stuglish.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import tech.pierandrei.Stuglish.dto.RequestDto;

import java.io.IOException;

@Configuration
public class AIGeminiConfig {
    private static final Logger log = LoggerFactory.getLogger(AIGeminiConfig.class);


    /**
     * KEY DA GEMINI API
     */
    @Value("${gemini.api.key}")
    private String key;

    /**
     * MODEL DA GEMINI API
     */
    @Value("${gemini.model}")
    private String model;


    /**
     *
     * @return - - Retorna o response da API da Gemini AI.
     */
    public GenerateContentResponse configAIGemini(String context) throws JsonProcessingException, IOException {
        try {
            Client client = Client.builder().apiKey(key).build();

            GenerateContentResponse response = client.models.generateContent(
                    model,
                    context,
                    null
            );

            log.debug("API Gemini AI | MODEL: {}", model);
            return response;

        } catch (IllegalArgumentException e) {
            // Caso o modelo não exista ou o nome esteja errado
            log.error("Modelo inválido ou inexistente: {}", model, e);
            throw new RuntimeException("Modelo especificado é inválido: " + model);

        } catch (Exception e) {
            // Qualquer outro erro inesperado
            log.error("Erro inesperado ao chamar a API Gemini", e);
            throw new RuntimeException("Erro inesperado: " + e.getMessage());
        }
    }

}