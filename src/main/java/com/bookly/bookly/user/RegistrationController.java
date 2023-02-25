package com.bookly.bookly.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class RegistrationController {
	private final UserService userService;

	public RegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/create_account")
	public String renderCreateAccountPage(CreateUserRequestDto createUserRequestDto) {
		return "create_account";
	}

	@PostMapping("/create_account")
	public String createAccount(HttpServletRequest request, @Valid CreateUserRequestDto createUserRequestDto)
			throws ServletException {
		userService.createUser(createUserRequestDto);
		request.login(createUserRequestDto.email(), createUserRequestDto.password());
		return "redirect:/home";
	}
}
