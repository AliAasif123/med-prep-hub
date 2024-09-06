package com.medico.service;

import java.util.List;

import com.medico.model.StudyMaterial;
import com.medico.model.dto.StudyMaterialDto;

public interface SMaterialService {

	StudyMaterial addMaterial(StudyMaterialDto materialDto);

	List<StudyMaterial> getAllStudyMaterials();

	StudyMaterial getStudyMaterialById(Long materialId);

}
