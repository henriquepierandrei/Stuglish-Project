package tech.pierandrei.Stuglish.dto;

import tech.pierandrei.Stuglish.enuns.DifficultyEnum;
import tech.pierandrei.Stuglish.enuns.SentenceTypeEnum;

import java.util.List;

// Record principal que engloba tanto request quanto response
public record SentenceCompletionDTO(
        // Campos para request
        DifficultyEnum difficulty,
        SentenceTypeEnum sentenceType,
        Integer questionsQuantity,

        // Campos para response (opcionais no request)
        String responseType,
        Integer totalSentences,
        List<SentenceQuestionDTO> sentences
) {
    // Constructor apenas para request
    public SentenceCompletionDTO(DifficultyEnum difficulty, SentenceTypeEnum sentenceType, Integer questionsQuantity) {
        this(difficulty, sentenceType, questionsQuantity, null, null, null);
    }

    // Constructor apenas para response
    public static SentenceCompletionDTO createResponse(String responseType, Integer totalSentences, List<SentenceQuestionDTO> sentences) {
        return new SentenceCompletionDTO(null, null, null, responseType, totalSentences, sentences);
    }

    // Validação para request
    public boolean isValidRequest() {
        return difficulty != null &&
                sentenceType != null &&
                questionsQuantity != null &&
                questionsQuantity > 0 &&
                questionsQuantity <= 20;
    }

    // Verifica se é um request ou response
    public boolean isRequest() {
        return difficulty != null && sentenceType != null && questionsQuantity != null;
    }

    public boolean isResponse() {
        return responseType != null && totalSentences != null && sentences != null;
    }
}