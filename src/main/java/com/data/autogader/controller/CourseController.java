package com.data.autogader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.data.autogader.model.CourseReqInfo;
import com.data.autogader.repository.CourseRepository;
import com.data.autogader.serviceimpl.CourseImpl;

@RestController
public class CourseController {

	@Autowired
	CourseImpl courseImpl;

	@Autowired
	CourseRepository courseRepository;

	@PostMapping("/course")
	public ModelAndView courseCreation(CourseReqInfo courseReqInfo) {
		System.out.println("Hi course Controller Called");
		courseImpl.save(courseReqInfo);

		ModelAndView model1 = new ModelAndView("course/reviewCourse");
		model1.addObject("courses", courseRepository.findAll());
		model1.setStatus(HttpStatus.CREATED);
		return model1; // view

	}

	@PostMapping("/course/{id}")
	public ModelAndView updateCourseCreation(CourseReqInfo courseReqInfo, @PathVariable("id") Long id) {
		courseImpl.update(courseReqInfo, id);
System.out.println(id);
		ModelAndView model1 = new ModelAndView("course/reviewCourse");
		model1.addObject("courses", courseRepository.findAll());
		model1.setStatus(HttpStatus.CREATED);
		return model1; // view
	}

	@GetMapping("/course/{id}")
	public String deleteCourse(@PathVariable("id") Long id) {
		courseImpl.delete(id);

		return "success"; // view
	}

	@GetMapping("/courseRecords")
	public ModelAndView getCourseRecords() {

		ModelAndView model1 = new ModelAndView("course/reviewCourse");
		model1.addObject("courses", courseRepository.findAll());
		model1.setStatus(HttpStatus.CREATED);
		return model1; // view

	}

	@GetMapping("/course/delete/{id}")
	public ModelAndView deleteCourseS(@PathVariable("id") Long id) {

		courseImpl.delete(id);

		
		
		ModelAndView model1 = new ModelAndView("course/reviewCourse");

		model1.addObject("courses", courseRepository.findAll());
		model1.setStatus(HttpStatus.CREATED);
		return model1; // view

	}

	@GetMapping("/course/update/{id}")
	public ModelAndView updateCourseCreations(CourseReqInfo courseReqInfo, @PathVariable("id") Long id) {
		courseImpl.update(courseReqInfo, id);
		ModelAndView model1 = new ModelAndView("course/editCourse");
		model1.addObject("courses", courseRepository.findById(id).get());
		return model1; // view
	}

	@GetMapping("/course")
	public ModelAndView courseCreations(CourseReqInfo courseReqInfo) {
		System.out.println("Hi Get Create");
		// courseImpl.save(courseReqInfo);

		ModelAndView model1 = new ModelAndView("course/createCourse");
		model1.addObject("courses", courseRepository.findAll());
		model1.setStatus(HttpStatus.CREATED);
		return model1; // view

	}

}
