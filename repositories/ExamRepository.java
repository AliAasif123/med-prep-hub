package com.medico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medico.model.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {

}
