package com.medico.service;

import com.medico.model.Exam;
import com.medico.model.dto.ExamDto;

public interface ExamService {

	public Exam AddQuestions(ExamDto examDto);

	public Exam updateExam(Long examId, ExamDto exam);

	public void deleteExam(Long examId);

}
