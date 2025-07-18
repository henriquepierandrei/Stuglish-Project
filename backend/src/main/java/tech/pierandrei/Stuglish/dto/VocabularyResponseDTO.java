package tech.pierandrei.Stuglish.dto;

import java.util.List;

public record VocabularyResponseDTO(
        String difficulty,
        Integer totalWords,
        List<WordDTO> words
) {}