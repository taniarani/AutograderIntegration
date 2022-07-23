package com.data.autogader.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.data.autogader.entity.Module;
import com.data.autogader.model.ModuleReqInfo;
import com.data.autogader.repository.ModuleRepository;
import com.data.autogader.serviceimpl.ModuleServiceImpl;

@RestController
public class ModuleController {

	@Autowired
	ModuleServiceImpl moduleServiceImpl;
	@Autowired
	ModuleRepository moduleRepository;

	@PostMapping("/module")
	public ModelAndView moduleCreation(ModuleReqInfo moduleReqInfo) {

		moduleServiceImpl.save(moduleReqInfo);
		/*
		 * return "module/editModule"; // view
		 */
		ModelAndView model1 = new ModelAndView("module/reviewModule");
	
		model1.addObject("module", moduleRepository.findAll());
		model1.setStatus(HttpStatus.CREATED);
		return model1; // view

	}

	@PostMapping("/module/{id}")
	public ModelAndView updateModuleCreation(ModuleReqInfo moduleReqInfo, @PathVariable("id") Long id) {

		moduleServiceImpl.update(moduleReqInfo, id);

		ModelAndView model1 = new ModelAndView("module/reviewModule");
		model1.addObject("students", moduleRepository.findAll());
		model1.setStatus(HttpStatus.CREATED);
		return model1; // view
	}

	@GetMapping("/module/update/{id}")
	public ModelAndView updateModuleDataCreation(ModuleReqInfo moduleReqInfo, @PathVariable("id") Long id) {
		moduleServiceImpl.update(moduleReqInfo, id);

		ModelAndView model1 = new ModelAndView("module/editModule");

		Optional<Module> findAll = moduleRepository.findById(id);
		System.out.println("ID called");
		Module module = findAll.get();
		model1.addObject("module", module);
		return model1; // view
	}

	@DeleteMapping("/module/{id}")
	public ModelAndView deleteModuleCreation(@PathVariable("id") Long id) {
		moduleServiceImpl.delete(id);
		ModelAndView model1 = new ModelAndView("module/reviewModule");

		model1.addObject("students", moduleRepository.findAll());
		model1.setStatus(HttpStatus.CREATED);
		return model1; // view
	}

	@GetMapping("/module/delete/{id}")
	public ModelAndView deleteModuleDataCreation(@PathVariable("id") Long id) {
		moduleServiceImpl.delete(id);
		ModelAndView model1 = new ModelAndView("module/reviewModule");

		model1.addObject("students", moduleRepository.findAll());
		model1.setStatus(HttpStatus.CREATED);
		return model1; // view
	}

	@GetMapping("/moduleRecords")
	public ModelAndView getModuleRecords() {

		ModelAndView model1 = new ModelAndView("module/reviewModule");

		model1.addObject("students", moduleRepository.findAll());
		model1.setStatus(HttpStatus.CREATED);
		return model1; //
	}

	
	@GetMapping("/module")
	public ModelAndView moduleCreation12(ModuleReqInfo moduleReqInfo) {

		moduleServiceImpl.save(moduleReqInfo);
		/*
		 * return "module/editModule"; // view
		 */
		ModelAndView model1 = new ModelAndView("module/editModule");
		/*
		 * Optional<Module> findAll = moduleRepository.findById(73l); Module module =
		 * findAll.get(); model1.addObject("module", module);
		 */
		model1.setStatus(HttpStatus.CREATED);
		return model1; // view

	}
}
