package com.ocire.boottest.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ocire.boottest.dto.login.LoginReqDto;
import com.ocire.boottest.dto.login.LoginResDto;
import com.ocire.boottest.model.User;
import com.ocire.boottest.service.JwtService;
import com.ocire.boottest.service.UserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("login")
public class LoginController {

	private final UserService userService;
	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;

	public LoginController(UserService userService, AuthenticationManager authenticationManager,
			JwtService jwtService) {
		this.userService = userService;
		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
	}

	@PostMapping
	public ResponseEntity<?> login(@RequestBody final LoginReqDto user) {
		final Authentication auth = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

		authenticationManager.authenticate(auth);
		final User userLogin = userService.login(user);
		final LoginResDto loginRes = new LoginResDto();
		if (userLogin != null) {
			
			final Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.HOUR_OF_DAY, 1);

			final Map<String, Object> claims = new HashMap<>();
			claims.put("exp", cal.getTime());
			claims.put("id", userLogin.getId());

			loginRes.setToken(jwtService.generateJwt(claims));
			loginRes.setFullName(userLogin.getProfile().getFullName());
			loginRes.setId(userLogin.getId());
			loginRes.setRoleCode(userLogin.getRole().getRoleCode());
			loginRes.setRoleName(userLogin.getRole().getRoleName());

			if (userLogin.getProfile().getProfilePhoto() != null) {
				loginRes.setPhotoId(userLogin.getProfile().getProfilePhoto().getId());
			} else {
				loginRes.setPhotoId(null);
			}

			return new ResponseEntity<>(loginRes, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(loginRes, HttpStatus.BAD_REQUEST);
		}
	}
}