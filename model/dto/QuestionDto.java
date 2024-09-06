package com.medico.model.dto;

import com.medico.model.Exam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {

	    private Long id;

	    private String text;

	    private String correctAnswer;
	    private Exam exam;
}
