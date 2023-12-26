package com.ocire.boottest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ocire.boottest.dto.InsertResDto;
import com.ocire.boottest.dto.UpdateResDto;
import com.ocire.boottest.dto.role.RoleResDto;
import com.ocire.boottest.dto.user.UserInsertReqDto;
import com.ocire.boottest.dto.user.UserNewPasswordInsertDto;
import com.ocire.boottest.dto.user.UserUpdateReqDto;
import com.ocire.boottest.dto.user.UserUpdateStatusReqDto;
import com.ocire.boottest.dto.user.UsersResDto;
import com.ocire.boottest.service.RoleService;
import com.ocire.boottest.service.UserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("users")
public class UserController {
	private final UserService userService;
	private final RoleService roleService;

	public UserController(UserService userService, RoleService roleService) {
		this.userService = userService;
		this.roleService = roleService;
	}

	@GetMapping
	public ResponseEntity<List<UsersResDto>> getAll() {
		final List<UsersResDto> data = userService.getAll();

		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@GetMapping("/detail")
	public ResponseEntity<UsersResDto> getById(@RequestParam("id") Long id) {
		final UsersResDto data = userService.getById(id);

		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@GetMapping("/role")
	public ResponseEntity<List<UsersResDto>> getByRoleCode(@RequestParam("code") String roleCode) {
		final List<UsersResDto> data = userService.getUserByRoleCode(roleCode);

		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@GetMapping("/roles")
	public ResponseEntity<List<RoleResDto>> getUserRole() {
		final List<RoleResDto> data = roleService.getAll();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<InsertResDto> insertUser(@Valid @RequestBody UserInsertReqDto data) {
		final InsertResDto response = userService.insert(data);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PatchMapping("status")
	public ResponseEntity<UpdateResDto> updateStatusUser(@Valid @RequestBody UserUpdateStatusReqDto data) {
		final UpdateResDto response = userService.updateStatus(data);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PatchMapping("new-password")
	public ResponseEntity<UpdateResDto> updateUserPassowrd(@Valid @RequestBody UserNewPasswordInsertDto data) {
		final UpdateResDto response = userService.updatePassword(data);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PatchMapping("update-profile")
	public ResponseEntity<UpdateResDto> updateUser(@Valid @RequestBody UserUpdateReqDto data) {
		final UpdateResDto response = userService.changeProfile(data);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

}
