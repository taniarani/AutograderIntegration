package com.data.autogader.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.data.autogader.entity.Admin;
import com.data.autogader.model.AdminRequestInfo;
import com.data.autogader.repository.AdminRepository;
import com.data.autogader.serviceimpl.AdminServiceImpl;

@RestController
public class AdminController {
	@Autowired
	AdminServiceImpl adminServiceImpl;

	@Autowired
	AdminRepository adminRepository;

	@PostMapping("/admin")
	public String adminCreation(AdminRequestInfo adminRequestInfo) {
		adminServiceImpl.save(adminRequestInfo);
		return "success"; // view
	}

	@PutMapping("/admin/{id}" )
	public String updateAdminCreation(AdminRequestInfo adminRequestInfo, @PathVariable("id") Long id) {
		adminServiceImpl.update(adminRequestInfo, id);

		return "success"; // view
	}

	@DeleteMapping("/admin/{id}")
	public String deleteAdminCreation(@PathVariable("id") Long id) {
		adminServiceImpl.delete(id);

		return "success"; // view
	}

	@GetMapping("/adminRecords")
	public List<Admin> getAdminRecords() {

		return adminRepository.findAll(); // view
	}

	@PostMapping("/homeAdmin")
	public String homeAdmin() {
	
		
		return "admin/welcomeAdmin"; // view
	}

	@PostMapping("/homeAdmin1")
	public String redirect() {
	
		
		return "admin/welcomeAdmin.html"; // view
	}

}
