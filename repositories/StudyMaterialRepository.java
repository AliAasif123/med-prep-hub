package com.medico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medico.model.StudyMaterial;

public interface StudyMaterialRepository extends JpaRepository<StudyMaterial, Long> {
	
}