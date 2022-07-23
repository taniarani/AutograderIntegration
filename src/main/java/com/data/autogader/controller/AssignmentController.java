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
import com.data.autogader.entity.Assignment;
import com.data.autogader.model.AssignmentRequestInfo;
import com.data.autogader.repository.AssignmentRepository;
import com.data.autogader.serviceimpl.AssignmentServiceImpl;

@RestController
public class AssignmentController {
	@Autowired
	AssignmentServiceImpl assignmentServiceImpl;

	@Autowired
	AssignmentRepository assignmentRepository;

	@PostMapping("/assignment")
	public String assignmentCreation(AssignmentRequestInfo assignmentRequestInfo) {
		System.out.println("Hi");
		assignmentServiceImpl.save(assignmentRequestInfo);
		return "success"; // view
	}

	@PutMapping("/assignment/{id}")
	public String updateAssignmentCreation(@RequestBody AssignmentRequestInfo assignmentRequestInfo,
			@PathVariable("id") Long id) {
		assignmentServiceImpl.update(assignmentRequestInfo, id);
		return "success"; // view
	}

	@DeleteMapping("/assignment/{id}")
	public String deleteAssignmentCreation(@PathVariable("id") Long id) {
		assignmentServiceImpl.delete(id);

		return "success"; // view
	}

	@GetMapping("/assignmentRecords")
	public List<Assignment> getAssignmentRecords() {

		return assignmentRepository.findAll(); // view
	}

}
