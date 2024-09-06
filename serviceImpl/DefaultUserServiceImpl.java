package com.medico.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.medico.model.User;
import com.medico.model.dto.UserDto;
import com.medico.repositories.UserRepository;
import com.medico.service.UserService;

@Service
public class DefaultUserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public User addUserRecords(UserDto userRegisteredDTO) {
		User user = new User();
		user.setId(userRegisteredDTO.getId());
		user.setEmail(userRegisteredDTO.getEmail());
		user.setPassword(passwordEncoder.encode(userRegisteredDTO.getPassword()));
		user.setRole(userRegisteredDTO.getRole());
		return userRepo.save(user);
	}
}