package tech.pierandrei.Stuglish.dto;

import java.util.List;

public record SentenceQuestionDTO(
        Integer id,
        String incompleteSentence,    // Frase com lacuna: "I ___ to work every day"
        String missingWordPosition,   // Posição da palavra: "verb", "preposition", etc.
        List<SentenceOptionDTO> options,
        String translation
) {}