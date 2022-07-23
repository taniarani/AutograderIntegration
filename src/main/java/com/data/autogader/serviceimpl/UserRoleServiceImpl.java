package com.data.autogader.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.autogader.entity.Professor;
import com.data.autogader.entity.UserRole;
import com.data.autogader.model.UserRoleRequestInfo;
import com.data.autogader.repository.UserRoleRepository;
import com.data.autogader.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	UserRoleRepository userRoleRepository;

	@Override
	public void save(UserRoleRequestInfo userRoleRequestInfo) {
		UserRole userRole = new UserRole();
		userRole.setName(userRoleRequestInfo.getName());
		userRole.setDescription(userRoleRequestInfo.getDescription());
		userRoleRepository.save(userRole);
	}

	@Override
	public void delete(Long id) {
		Optional<UserRole> userRoleRequestInfoRepo = userRoleRepository.findById(id);
		if (userRoleRequestInfoRepo.isPresent()) {
			userRoleRepository.deleteById(id);
		}
	}

	@Override
	public void update(UserRoleRequestInfo userRoleRequestInfo, Long id) {
		Optional<UserRole> userRoleRequestInfoRepo = userRoleRepository.findById(id);
		if (userRoleRequestInfoRepo.isPresent()) {
			UserRole userRole = new UserRole();
			userRole.setId(id);
			userRole.setName(userRoleRequestInfo.getName());
			userRole.setDescription(userRoleRequestInfo.getDescription());
			userRoleRepository.save(userRole);

		}
	}

}
