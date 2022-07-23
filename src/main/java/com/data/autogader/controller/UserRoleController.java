package com.data.autogader.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.ModelAndView;

import com.data.autogader.entity.UserRole;
import com.data.autogader.model.UserRoleRequestInfo;
import com.data.autogader.repository.UserRoleRepository;
import com.data.autogader.service.UserRoleService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class UserRoleController {

	@Autowired
	UserRoleService userRoleService;
	@Autowired
	UserRoleRepository userRoleRepository;

	@PostMapping("/role")
	public ModelAndView roleCreation(UserRoleRequestInfo userRoleRequestInfo) {
		userRoleService.save(userRoleRequestInfo);
		ModelAndView model1 = new ModelAndView("role/reviewRole");
		model1.addObject("roles", userRoleRepository.findAll());
		model1.setStatus(HttpStatus.CREATED);
		return model1; // view
	}

	@GetMapping("/role")
	public ModelAndView roleCreations(UserRoleRequestInfo userRoleRequestInfo) {
		// userRoleService.save(userRoleRequestInfo);
		ModelAndView model1 = new ModelAndView("role/roleCreation");
		model1.addObject("roles", userRoleRepository.findAll());
		model1.setStatus(HttpStatus.CREATED);
		return model1; // view}

	}

	@PostMapping("/role/{id}")
	public ModelAndView updateRoleCreation(UserRoleRequestInfo userRoleRequestInfo, @PathVariable("id") Long id)
			throws JsonProcessingException, RestClientException {
		userRoleService.update(userRoleRequestInfo, id);
		ModelAndView model1 = new ModelAndView("role/reviewRole");

		model1.addObject("roles", userRoleRepository.findAll());
		model1.setStatus(HttpStatus.CREATED);
		return model1; // view
	}

	@GetMapping("/userRecords")
	public ModelAndView getUserRecords() {

		ModelAndView model1 = new ModelAndView("role/reviewRole");

		model1.addObject("roles", userRoleRepository.findAll());
		model1.setStatus(HttpStatus.CREATED);
		return model1; // view
	}

	@GetMapping("/role/delete/{id}")
	public ModelAndView deleteRoleDataCreations(@PathVariable("id") Long id) {
		userRoleService.delete(id);
		ModelAndView model1 = new ModelAndView("role/reviewRole");

		model1.addObject("roles", userRoleRepository.findAll());
		model1.setStatus(HttpStatus.CREATED);
		return model1; // view
	}

	@GetMapping("/role/update/{id}")
	public ModelAndView updateRoleDataCreations(UserRoleRequestInfo userRoleRequestInfo, @PathVariable("id") Long id) {

		ModelAndView model1 = new ModelAndView("role/updateRole");

		Optional<UserRole> findAll = userRoleRepository.findById(id);
		System.out.println("ID called");
		UserRole role = findAll.get();
		model1.addObject("roles", role);
		return model1; // view
	}

}
