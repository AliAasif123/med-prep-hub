package com.medico.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medico.model.Exam;
import com.medico.model.Question;
import com.medico.model.dto.ExamDto;
import com.medico.model.dto.QuestionDto;
import com.medico.repositories.ExamRepository;
import com.medico.repositories.QuestionRepository;
import com.medico.service.ExamService;

import jakarta.transaction.Transactional;

@Service
public class AddQuestionImpl implements ExamService {

	@Autowired
	ExamRepository examRepository;

	@Autowired
	QuestionRepository questionRepository;

	@Transactional
	public Exam AddQuestions(ExamDto examDto) {
		Exam exam = new Exam();
		exam.setId(examDto.getId());
		exam.setTitle(examDto.getTitle());
		exam.setDescription(examDto.getDescription());

		for (QuestionDto questionDto : examDto.getQuestions()) {
			Question question = new Question();
			question.setId(questionDto.getId());
			question.setText(questionDto.getText());
			question.setCorrectAnswer(questionDto.getCorrectAnswer());
			question.setExam(exam); // Set the exam reference here

			exam.addQuestion(question);
		}

		return examRepository.save(exam);
	}

	public Exam updateExam(Long examId, ExamDto updatedExam) {
		Exam exam = examRepository.findById(examId).orElse(null);

		if (updatedExam.getTitle() != null && !updatedExam.getTitle().isEmpty()) {
			exam.setTitle(updatedExam.getTitle());
		}

		if (updatedExam.getDescription() != null && !updatedExam.getDescription().isEmpty()) {
			exam.setDescription(updatedExam.getDescription());
		}

		return examRepository.save(exam);
	}

	@Override
	public void deleteExam(Long examId) {
		examRepository.deleteById(examId);

	}

}
