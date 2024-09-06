package com.medico.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medico.model.Exam;
import com.medico.model.StudyMaterial;
import com.medico.model.dto.ExamDto;
import com.medico.model.dto.StudyMaterialDto;
import com.medico.response.Response;
import com.medico.service.ExamService;
import com.medico.service.SMaterialService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	public ExamService examService;

	@Autowired
	SMaterialService sMaterialService;

	@PostMapping("/addQuestions")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Response> addQuestion(@RequestBody ExamDto examDto) {
		Response response = new Response();
		Exam addQuestions = this.examService.AddQuestions(examDto);
		response.setData(Collections.singletonList(addQuestions));
		response.setMessage("Questions added successfully");
		response.setError(false);
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}

	@PostMapping("/addMaterials")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Response> addMaterial(@RequestBody StudyMaterialDto studyMaterialDto) {
		Response response = new Response();
		StudyMaterial addMaterial = this.sMaterialService.addMaterial(studyMaterialDto);
		response.setData(Collections.singletonList(addMaterial));
		response.setMessage("Pushed Material Successfully");
		response.setError(false);
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}

	@PutMapping("/{examId}")
	@PreAuthorize("hasRole('ADMIN')")
	public Exam updateExam(@PathVariable Long examId, @RequestBody ExamDto exam) {
		return examService.updateExam(examId, exam);
	}

	@DeleteMapping("/{examId}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteExam(@PathVariable Long examId) {
		examService.deleteExam(examId);
	}

}
