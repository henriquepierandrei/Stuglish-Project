package tech.pierandrei.Stuglish.dto;
// Record para opções de completar frase
public record SentenceOptionDTO(
        Integer id,
        String word,
        Boolean isCorrect,
        String explanation
) {}