package com.medico.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.medico.model.User;
import com.medico.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		return org.springframework.security.core.userdetails.User.builder().username(user.getEmail())
				.password(user.getPassword()) // Password should be encoded
				.roles(user.getRole().name()) // ROLE_USER or ROLE_ADMIN
				.build();
	}
}
