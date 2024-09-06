package com.medico.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medico.request.AuthRequest;
import com.medico.response.Response;
import com.medico.security.JwtUtil;
import com.medico.serviceImpl.MyUserDetailsService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/login")
	public ResponseEntity<Response> createAuthenticationToken(@RequestBody AuthRequest authRequest) throws Exception {
		Response response = new Response();
		try {
			Authentication auth = new UsernamePasswordAuthenticationToken(authRequest.getEmail(),
					authRequest.getPassword());
			authenticationManager.authenticate(auth);
		} catch (AuthenticationException e) {
			throw new Exception("Incorrect username or password", e);
		}

		UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getEmail());
		String generateToken = jwtUtil.generateToken(userDetails);
		response.setData(Collections.singletonList("AccessToken :" + generateToken));
		response.setMessage("token fetched successfully");
		response.setError(false);
		return ResponseEntity.ok(response);
	}
}
