package com.medico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medico.model.ExamResult;

public interface ExamResultRepository extends JpaRepository<ExamResult, Long> {
}
