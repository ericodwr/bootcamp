package com.ocire.boottest.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ocire.boottest.dao.FileDao;
import com.ocire.boottest.dao.ProfileDao;
import com.ocire.boottest.dao.RoleDao;
import com.ocire.boottest.dao.UserDao;
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
import com.ocire.boottest.model.Role;
import com.ocire.boottest.model.User;
import com.ocire.boottest.service.MailService;
import com.ocire.boottest.service.PrincipalService;
import com.ocire.boottest.service.UserService;
import com.ocire.boottest.util.RandomGenerateStrUtil;

@Service
public class UserServiceImpl implements UserService {
	@PersistenceContext
	private EntityManager em;

	private final RoleDao roleDao;
	private final UserDao userDao;
	private final ProfileDao profileDao;
	private final FileDao fileDao;
	private final PasswordEncoder encoder;
	private final MailService mailService;
	private PrincipalService principalService;
	private final PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserDao userDao, ProfileDao profileDao, FileDao fileDao, RoleDao roleDao,
			PasswordEncoder encoder, MailService mailService, PrincipalService principalService,
			PasswordEncoder passwordEncoder) {
		this.userDao = userDao;
		this.profileDao = profileDao;
		this.fileDao = fileDao;
		this.roleDao = roleDao;
		this.encoder = encoder;
		this.mailService = mailService;
		this.principalService = principalService;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public List<UsersResDto> getAll() {
		final List<UsersResDto> userList = new ArrayList<>();

		userDao.getAll().forEach(u -> {
			final UsersResDto data = new UsersResDto();
			data.setId(u.getId());
			data.setUsername(u.getUsername());
			data.setFullName(u.getProfile().getFullName());
			data.setRoleCode(u.getRole().getRoleCode());
			data.setRoleName(u.getRole().getRoleName());
			data.setIsActive(u.getIsActive());
			if (u.getProfile().getProfilePhoto() != null) {
				data.setPhotoId(u.getProfile().getProfilePhoto().getId());
			} else {
				data.setPhotoId(null);
			}
			userList.add(data);
		});
		return userList;

	}

	@Transactional
	@Override
	public InsertResDto insert(UserInsertReqDto userInsertReqDto) {
		InsertResDto result = new InsertResDto();

		final Profile profile = new Profile();
		profile.setFullName(userInsertReqDto.getFullName());
		profile.setPhoneNumb(userInsertReqDto.getPhoneNumb());
		profile.setCreatedBy(principalService.getPrincipal());

		final Profile profileResult = profileDao.insert(profile);

		final User user = new User();
		user.setUsername(userInsertReqDto.getUsername());

		final String password = RandomGenerateStrUtil.getAlphaNumericString(5);

		// generate encoded passworded
		final String encodedPassword = encoder.encode(password);
		user.setUserPassword(encodedPassword);
		user.setProfile(profileResult);
		user.setCreatedBy(principalService.getPrincipal());

		final Role role = roleDao.getById(userInsertReqDto.getRoleId());

		user.setRole(role);

		mailService.sendEmail(userInsertReqDto.getUsername(),
				"Created Account For Bootcamp Test as " + role.getRoleName(),
				"Please login with this password: " + password);

		final User userResult = userDao.insert(user);
		result.setId(userResult.getId());
		result.setMessage("Successfully create user!");

		return result;
	}

	@Transactional
	@Override
	public UpdateResDto updateStatus(UserUpdateStatusReqDto data) {
		UpdateResDto userResult = new UpdateResDto();

		User updatedUser = userDao.getById(data.getId());
		updatedUser.setIsActive(data.getIsActive());

		this.em.merge(updatedUser);
		this.em.flush();
		userResult.setVer(updatedUser.getVer());
		userResult.setMessage("Updated Successfully!");

		return userResult;
	}

	@Transactional
	@Override
	public UpdateResDto changeProfile(UserUpdateReqDto data) {
		UpdateResDto userResult = new UpdateResDto();
		final User user = userDao.getById(principalService.getPrincipal());
		final Profile profile = profileDao.getById(user.getProfile().getId());

		if (data.getFileName() != null && data.getFileExtens() != null) {
			final File fileImg = new File();
			fileImg.setFileName(data.getFileName());
			fileImg.setFileExtens(data.getFileExtens());
			fileImg.setCreatedBy(principalService.getPrincipal());
			final File newImg = fileDao.insert(fileImg);
			if (profile.getProfilePhoto() != null) {
				fileDao.deleteById(profile.getProfilePhoto().getId());
				profile.setProfilePhoto(newImg);
			} else {
				profile.setProfilePhoto(newImg);
			}
		}

		profile.setFullName(data.getFullName());
		profile.setPhoneNumb(data.getPhoneNumb());

		this.em.merge(profile);
		this.em.flush();
		userResult.setVer(profile.getVer());
		userResult.setMessage("Updated Profile Successfully!");

		return userResult;
	}

	@Override
	public User login(LoginReqDto data) {
		final User user = userDao.getByUsername(data.getUsername());
		if (!user.getIsActive()) {
			return null;
		} else {
			return user;
		}

	}

	@Override
	public List<UsersResDto> getUserByRoleCode(String roleCode) {
		final List<UsersResDto> userList = new ArrayList<>();

		userDao.getByRoleCode(roleCode).forEach(u -> {
			final UsersResDto data = new UsersResDto();
			data.setId(u.getId());
			data.setFullName(u.getProfile().getFullName());
			data.setRoleCode(u.getRole().getRoleCode());
			data.setRoleName(u.getRole().getRoleName());
			data.setUsername(u.getUsername());
			data.setIsActive(u.getIsActive());
			if (u.getProfile().getProfilePhoto() != null) {
				data.setPhotoId(u.getProfile().getProfilePhoto().getId());
			} else {
				data.setPhotoId(null);
			}
			userList.add(data);
		});
		return userList;
	}

	@Override
	public List<UsersResDto> getCandidatesByReviewer(Long reviewerId) {
		final List<UsersResDto> userList = new ArrayList<>();

		userDao.getCandidateByReviewerId(reviewerId).forEach(u -> {
			final UsersResDto data = new UsersResDto();
			data.setId(u.getId());
			data.setFullName(u.getProfile().getFullName());
			data.setRoleCode(u.getRole().getRoleCode());
			data.setRoleName(u.getRole().getRoleName());
			if (u.getProfile().getProfilePhoto() != null) {
				data.setPhotoId(u.getProfile().getProfilePhoto().getId());
			} else {
				data.setPhotoId(null);
			}
			userList.add(data);
		});
		return userList;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final User user = userDao.getByUsername(username);

		if (user != null) {
			return new org.springframework.security.core.userdetails.User(username, user.getUserPassword(),
					new ArrayList<>());
		}
		throw new UsernameNotFoundException("failed to login");
	}

	@Transactional
	@Override
	public UpdateResDto updatePassword(UserNewPasswordInsertDto data) {
		final UpdateResDto result = new UpdateResDto();

		final User userDb = userDao.getById(principalService.getPrincipal());
		final Boolean matches = passwordEncoder.matches(data.getOldPassword(), userDb.getUserPassword());

		if (matches) {
			final Profile profileDb = profileDao.getById(userDb.getProfile().getId());
			userDb.setProfile(profileDb);
			final String pwdEncoded = passwordEncoder.encode(data.getNewPassword());
			userDb.setUserPassword(pwdEncoded);

			this.em.merge(userDb);
			this.em.flush();

			result.setVer(userDb.getVer());
			result.setMessage("Success change password");
		}

		return result;
	}

	@Override
	public UsersResDto getById(Long id) {
		final User user = userDao.getById(id);
		final UsersResDto userRes = new UsersResDto();

		userRes.setId(user.getId());
		userRes.setUsername(user.getUsername());
		userRes.setFullName(user.getProfile().getFullName());
		userRes.setRoleName(user.getRole().getRoleName());
		userRes.setRoleCode(user.getRole().getRoleCode());
		userRes.setPhoneNumb(user.getProfile().getPhoneNumb());
		userRes.setIsActive(user.getIsActive());

		if (user.getProfile().getProfilePhoto() != null) {
			userRes.setPhotoId(user.getProfile().getProfilePhoto().getId());
		} else {
			userRes.setPhotoId(null);
		}

		return userRes;
	}

}
