package com.app.ws.Service;

import com.app.ws.shared.dto.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);
	UserDto getUser(String email);
	UserDto getUserByUserId(String userId);
	UserDto updateUser(String userId, UserDto user);
}
