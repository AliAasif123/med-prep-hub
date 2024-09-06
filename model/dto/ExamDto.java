package com.medico.model.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamDto {
    private Long id;

    private String title;

    private String description;

    private Set<QuestionDto> questions;

}
