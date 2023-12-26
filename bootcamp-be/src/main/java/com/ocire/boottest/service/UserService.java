package com.ocire.boottest.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ocire.boottest.dto.InsertResDto;
import com.ocire.boottest.dto.UpdateResDto;
import com.ocire.boottest.dto.login.LoginReqDto;
import com.ocire.boottest.dto.user.UserInsertReqDto;
import com.ocire.boottest.dto.user.UserNewPasswordInsertDto;
import com.ocire.boottest.dto.user.UserUpdateReqDto;
import com.ocire.boottest.dto.user.UserUpdateStatusReqDto;
import com.ocire.boottest.dto.user.UsersResDto;
import com.ocire.boottest.model.File;
import com.ocire.boottest.model.Profile;
import com.ocire.boottest.model.User;

public interface UserService extends UserDetailsService {
	List<UsersResDto> getAll();

	InsertResDto insert(UserInsertReqDto userInsertReqDto);

	UpdateResDto updateStatus(UserUpdateStatusReqDto data);
	
	UpdateResDto changeProfile(UserUpdateReqDto data);

	User login(LoginReqDto loginReqDto);

	List<UsersResDto> getUserByRoleCode(String roleCode);
	
	List<UsersResDto> getCandidatesByReviewer(Long reviewerId);
	
	UsersResDto getById(Long id);
	
	UpdateResDto updatePassword(UserNewPasswordInsertDto data);
	
}
