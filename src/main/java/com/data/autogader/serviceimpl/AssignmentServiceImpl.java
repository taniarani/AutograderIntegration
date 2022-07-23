package com.data.autogader.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.autogader.entity.Assignment;
import com.data.autogader.model.AssignmentRequestInfo;
import com.data.autogader.repository.AssignmentRepository;
import com.data.autogader.service.AssignmentService;

@Service
public class AssignmentServiceImpl implements AssignmentService {

	@Autowired
	AssignmentRepository assignmentRepository;

	@Override
	public void save(AssignmentRequestInfo assignmentRequestInfo) {
		Assignment assignment = new Assignment();
		assignment.setAssignment_Name(assignmentRequestInfo.getAssignment_Name());
		assignment.setCr_dt(assignmentRequestInfo.getCr_dt());
		assignment.setDi_dt(assignmentRequestInfo.getDi_dt());
		assignment.setDueDate(assignmentRequestInfo.getDueDate());
		assignment.setMarkingCompleted(assignmentRequestInfo.isMarkingCompleted());
		assignmentRepository.save(assignment);
	}

	@Override
	public void update(AssignmentRequestInfo assignmentRequestInfo, Long id) {
		Optional<Assignment> assignment1 = assignmentRepository.findById(id);
        if (assignment1.isPresent()) {
        	Assignment assignment = new Assignment();
        	assignment.setId(id);
    		assignment.setAssignment_Name(assignmentRequestInfo.getAssignment_Name());
    		assignment.setCr_dt(assignmentRequestInfo.getCr_dt());
    		assignment.setDi_dt(assignmentRequestInfo.getDi_dt());
    		assignment.setDueDate(assignmentRequestInfo.getDueDate());
    		assignment.setMarkingCompleted(assignmentRequestInfo.isMarkingCompleted());
    		assignmentRepository.save(assignment);
			
		}
	}

	@Override
	public void delete(Long id) {
		Optional<Assignment> assignment = assignmentRepository.findById(id);
		if (assignment.isPresent()) {
			assignmentRepository.deleteById(id);
		}

	}

}
