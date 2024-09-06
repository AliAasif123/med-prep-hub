package com.medico.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medico.model.StudyMaterial;
import com.medico.model.dto.StudyMaterialDto;
import com.medico.repositories.StudyMaterialRepository;
import com.medico.service.SMaterialService;

import jakarta.transaction.Transactional;

@Service
public class StudyMaterialImpl implements SMaterialService {

	@Autowired
	StudyMaterialRepository studyMaterialRepository;

	@Override
	@Transactional
	public StudyMaterial addMaterial(StudyMaterialDto materialDto) {
		StudyMaterial studyMaterial = new StudyMaterial();
		studyMaterial.setId(materialDto.getId());
		studyMaterial.setTitles(materialDto.getTitles());
		studyMaterial.setDescription(materialDto.getDescription());
		studyMaterial.setType(materialDto.getType());
		studyMaterial.setUrl(materialDto.getUrl());
		return studyMaterialRepository.save(studyMaterial);
	}

	@Override
	public List<StudyMaterial> getAllStudyMaterials() {
		return this.studyMaterialRepository.findAll();
				
	}

	@Override
	public StudyMaterial getStudyMaterialById(Long materialId) {
		return this.studyMaterialRepository.findById(materialId).orElse(null);
	}
	
	

}
