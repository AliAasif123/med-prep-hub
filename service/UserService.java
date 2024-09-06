package com.medico.service;

import com.medico.model.User;
import com.medico.model.dto.UserDto;

public interface UserService {

	public User addUserRecords(UserDto userDto);
}
