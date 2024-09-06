package com.medico.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudyMaterialDto {

	private Long id;

	private String titles;

	private String url;

	private String type; // e.g., "video", "document"

	private String description;
}
