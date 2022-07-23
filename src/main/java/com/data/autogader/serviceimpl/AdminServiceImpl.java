package com.data.autogader.serviceimpl;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.autogader.entity.Admin;
import com.data.autogader.model.AdminRequestInfo;
import com.data.autogader.repository.AdminRepository;
import com.data.autogader.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	HttpServletRequest request;

	@Override
	public void save(AdminRequestInfo adminRequestInfo) {
		Admin admin = new Admin();
		admin.setName(adminRequestInfo.getName());
		admin.setUsername(adminRequestInfo.getUsername());
		admin.setPassword(adminRequestInfo.getPassword());
		adminRepository.save(admin);
	}

	@Override
	public void update(AdminRequestInfo adminRequestInfo, Long id) {
		Optional<Admin> findById = adminRepository.findById(id);
		if (findById.isPresent()) {

			Admin admin = new Admin();
			admin.setId(id);
			admin.setName(adminRequestInfo.getName());
			admin.setUsername(adminRequestInfo.getUsername());
			admin.setPassword(adminRequestInfo.getPassword());
			adminRepository.save(admin);

		}
	}

	@Override
	public void delete(Long id) {
		Optional<Admin> findById = adminRepository.findById(id);
		if (findById.isPresent()) {
			adminRepository.deleteById(id);
		}
	}

}
