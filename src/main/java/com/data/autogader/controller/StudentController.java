package com.data.autogader.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.data.autogader.entity.Student;
import com.data.autogader.model.StudentReqInfo;
import com.data.autogader.model.StudentSubmissionRequestInfo;
import com.data.autogader.repository.StudentRepository;
import com.data.autogader.serviceimpl.StudentServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class StudentController {

	@Autowired
	StudentServiceImpl service;
	@Autowired
	StudentRepository studentRepository;

	@PostMapping("/login")
	public String studentSubit(Model model) {

		return "assignment"; // view
	}

	@PostMapping("/upload")
	public ModelAndView fileUpload(@RequestParam("file") MultipartFile file,
			@RequestParam("courseName") String courseName, @RequestParam("moduleName") String moduleName,
			@RequestParam("assignment") String assignment

	) throws IOException {
		final StudentSubmissionRequestInfo model = new StudentSubmissionRequestInfo();
		model.setAssignment(assignment);
		model.setCourseName(courseName);
		model.setModule(moduleName);
		String content = new String(file.getBytes(), "UTF-8");
		model.setMultiparg(content);
		model.setFileName(file.getName());
		service.save(model);
		ModelAndView model1 = new ModelAndView("course/createCourse");
		
		model1.setStatus(HttpStatus.CREATED);
		return model1; // view
	}

//////////////////////////////////
	
	@PostMapping("/student")
	public ModelAndView studentCreation(StudentReqInfo studentReqInfo)
			throws JsonProcessingException, RestClientException {

		service.saveData(studentReqInfo);
		ModelAndView model1 = new ModelAndView("student/reviewStudent");
		model1.addObject("students", studentRepository.findAll());
		model1.setStatus(HttpStatus.CREATED);
		return model1; // view

	}

	@GetMapping("/student")
	public ModelAndView studentCreations(StudentReqInfo studentReqInfo)
			throws JsonProcessingException, RestClientException {

		ModelAndView model1 = new ModelAndView("student/createStudent");
		model1.addObject("students", studentRepository.findAll());
		model1.setStatus(HttpStatus.CREATED);
		return model1; // view

	}

	@PostMapping("/student/{id}")
	public ModelAndView updatestudent(StudentReqInfo studentReqInfo, @PathVariable("id") Long id)
			throws JsonProcessingException, RestClientException {
		service.updateData(studentReqInfo, id);

		ModelAndView model1 = new ModelAndView("student/reviewStudent");
		model1.addObject("students", studentRepository.findAll());
		model1.setStatus(HttpStatus.CREATED);
		return model1; // view

	}

	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
		service.delete(id);

		return "success"; // view
	}

	@GetMapping("/studentRecords")
	public ModelAndView getStudentRecords1() {

		ModelAndView model1 = new ModelAndView("student/reviewStudent");

		model1.addObject("students", studentRepository.findAll());
		model1.setStatus(HttpStatus.CREATED);
		return model1; //
	}

	@GetMapping("/student/update/{id}")
	public ModelAndView updatestudentDataCreation(StudentReqInfo studentReqInfo, @PathVariable("id") Long id) {
		ModelAndView model1 = new ModelAndView("student/editStudent");
		System.out.println(id);
		Optional<Student> findAll = studentRepository.findById(id);
		System.out.println("ID called");
		Student role = findAll.get();
		model1.addObject("student", role);
		return model1; // view
	}

	@GetMapping("/student/delete/{id}")
	public ModelAndView deletestudentDataCreation(@PathVariable("id") Long id) {
		service.delete(id);
		ModelAndView model1 = new ModelAndView("student/reviewStudent");

		model1.addObject("students", studentRepository.findAll());
		model1.setStatus(HttpStatus.CREATED);
		return model1; // view
	}
}
