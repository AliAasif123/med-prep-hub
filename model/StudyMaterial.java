package com.medico.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "study_materials")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudyMaterial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String titles;

	@Column(nullable = false)
	private String url;

	@Column(nullable = false)
	private String type; // e.g., "video", "document"

	@Column(nullable = true)
	private String description;

}
