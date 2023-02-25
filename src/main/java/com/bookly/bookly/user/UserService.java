package com.bookly.bookly.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	User createUser(CreateUserRequestDto dto) {
		User user = new User();
		user.setEmail(dto.email());
		user.setPassword(passwordEncoder.encode(dto.password()));
		return userRepository.save(user);
	}
}
