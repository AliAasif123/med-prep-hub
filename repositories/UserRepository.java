package com.medico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medico.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);


}
