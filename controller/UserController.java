package com.medico.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medico.model.StudyMaterial;
import com.medico.model.User;
import com.medico.model.dto.UserDto;
import com.medico.response.Response;
import com.medico.service.SMaterialService;
import com.medico.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {

	@Autowired
	public UserService userService;
	
	public SMaterialService sMaterialService;

	@PostMapping("/signup")
	public ResponseEntity<Response> addUser(@RequestBody UserDto userDto) {
		Response response = new Response();
		User addUserRecords = this.userService.addUserRecords(userDto);
		response.setData(Collections.singletonList(addUserRecords));
		response.setMessage("records saved successfully");
		response.setError(false);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping
    public List<StudyMaterial> getAllStudyMaterials() {
        return sMaterialService.getAllStudyMaterials();
    }
	
	@GetMapping("/{materialId}")
    public StudyMaterial getStudyMaterialById(@PathVariable Long materialId) {
        return sMaterialService.getStudyMaterialById(materialId);
    }

}
