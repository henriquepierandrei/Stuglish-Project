package tech.pierandrei.Stuglish.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import tech.pierandrei.Stuglish.enuns.DifficultyEnum;

public record RequestDto(
        @JsonProperty("difficulty")
        DifficultyEnum difficultyEnum,

        @JsonProperty("questions_quantity")
        Integer questionsQuantity

) {
        @JsonIgnore
        public boolean isValid() {
                return difficultyEnum != null && questionsQuantity != null && questionsQuantity > 0 && questionsQuantity <= 20;
        }
}
