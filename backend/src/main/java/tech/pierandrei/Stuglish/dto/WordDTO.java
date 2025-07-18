package tech.pierandrei.Stuglish.dto;

import java.util.List;

public record WordDTO(
        Integer id,
        String word,
        List<TranslationOptionDTO> options
) {}