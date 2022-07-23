package com.data.autogader.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.ModelAndView;

import com.data.autogader.entity.Module;
import com.data.autogader.entity.Professor;
import com.data.autogader.entity.UserRole;
import com.data.autogader.model.ModuleReqInfo;
import com.data.autogader.model.ProfessorReqInfo;
import com.data.autogader.repository.ProfessorRepository;
import com.data.autogader.serviceimpl.ProfessorServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class ProfessorController {
	@Autowired
	ProfessorServiceImpl professorServiceImpl;
	@Autowired
	ProfessorRepository professorRepository;

	@PostMapping("/professor")
	public ModelAndView professorCreation(ProfessorReqInfo professorReqInfo)
			throws JsonProcessingException, RestClientException {

		professorServiceImpl.save(professorReqInfo);
		ModelAndView model1 = new ModelAndView("professor/reviewProffesor");
		model1.addObject("professors", professorRepository.findAll());
		model1.setStatus(HttpStatus.CREATED);
		return model1; // view

	}

	@GetMapping("/professor")
	public ModelAndView professorCreations(ProfessorReqInfo professorReqInfo)
			throws JsonProcessingException, RestClientException {

		ModelAndView model1 = new ModelAndView("professor/proffessorCreation");
		model1.addObject("professors", professorRepository.findAll());
		model1.setStatus(HttpStatus.CREATED);
		return model1; // view

	}

	@PostMapping("/professor/{id}")
	public ModelAndView updateProfessor(ProfessorReqInfo professorReqInfo, @PathVariable("id") Long id)
			throws JsonProcessingException, RestClientException {
		professorServiceImpl.update(professorReqInfo, id);

		ModelAndView model1 = new ModelAndView("professor/reviewProffesor");
		model1.addObject("professors", professorRepository.findAll());
		model1.setStatus(HttpStatus.CREATED);
		return model1; // view

	}

	@DeleteMapping("/professor/{id}")
	public String deleteProfessor(@PathVariable("id") Long id) {
		professorServiceImpl.delete(id);

		return "success"; // view
	}

	@GetMapping("/professorRecords")
	public ModelAndView getProfessorRecords() {

		ModelAndView model1 = new ModelAndView("professor/reviewProffesor");

		model1.addObject("professors", professorRepository.findAll());
		model1.setStatus(HttpStatus.CREATED);
		return model1; //
	}

	@GetMapping("/professor/update/{id}")
	public ModelAndView updateProfessorDataCreation(ProfessorReqInfo professorReqInfo, @PathVariable("id") Long id) {
		ModelAndView model1 = new ModelAndView("professor/editProffessor");
		System.out.println(id);
		Optional<Professor> findAll = professorRepository.findById(id);
		System.out.println("ID called");
		Professor role = findAll.get();
		model1.addObject("professor", role);
		return model1; // view
	}

	@GetMapping("/professor/delete/{id}")
	public ModelAndView deleteProfessorDataCreation(@PathVariable("id") Long id) {
		professorServiceImpl.delete(id);
		ModelAndView model1 = new ModelAndView("professor/reviewProffesor");

		model1.addObject("professors", professorRepository.findAll());
		model1.setStatus(HttpStatus.CREATED);
		return model1; // view
	}

}
