package com.example.miniproject.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Schema(description = "Модель студента для сохранения в базе")
public class StudentDtoSave {
    @Schema(description = "Имя студента", required = true, example = "Max")
    private String name;

    @Schema(description = "Возраст студента", required = true, example = "21")
    private Integer age;
}
