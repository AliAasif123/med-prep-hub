package com.medico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medico.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {}
