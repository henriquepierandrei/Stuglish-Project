package tech.pierandrei.Stuglish.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import tech.pierandrei.Stuglish.config.AIGeminiConfig;
import tech.pierandrei.Stuglish.config.ContextAIGemini;
import tech.pierandrei.Stuglish.dto.RequestDto;
import tech.pierandrei.Stuglish.dto.SentenceCompletionDTO;
import tech.pierandrei.Stuglish.dto.VocabularyResponseDTO;
import tech.pierandrei.Stuglish.exceptions.CredentialsUnauthorizedException;
import java.io.IOException;

@Service
public class ExercisesService {
    private final AIGeminiConfig aiGeminiConfig;
    private final ContextAIGemini contextAIGemini;

    public ExercisesService(AIGeminiConfig aiGeminiConfig, ContextAIGemini contextAIGemini) {
        this.aiGeminiConfig = aiGeminiConfig;
        this.contextAIGemini = contextAIGemini;
    }

    public VocabularyResponseDTO generateWords(RequestDto request) throws IOException {
        // Validação básica
        if (!request.isValid()) {
            throw new CredentialsUnauthorizedException("You can request a maximum of 20 words.");
        }

        var response = aiGeminiConfig.configAIGemini(contextAIGemini.contextAlpha(request));

        var jsonLimpo = response.text().replaceAll("(?s)```json(.*?)```", "$1").trim();
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(jsonLimpo, VocabularyResponseDTO.class);
    }

    public SentenceCompletionDTO generateSentences(SentenceCompletionDTO sentenceCompletionDTO) throws IOException {
        // Validação básica
        if (!sentenceCompletionDTO.isValidRequest()) {
            throw new CredentialsUnauthorizedException("You can request a maximum of 20 sentences.");
        }

        var response = aiGeminiConfig.configAIGemini(contextAIGemini.contextBeta(sentenceCompletionDTO));

        var jsonLimpo = response.text().replaceAll("(?s)```json(.*?)```", "$1").trim();
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(jsonLimpo, SentenceCompletionDTO.class);
    }

}
