package com.data.autogader.service;

import com.data.autogader.model.AssignmentRequestInfo;

public interface AssignmentService {
	public void save(AssignmentRequestInfo assignmentRequestInfo); 
	public void update(AssignmentRequestInfo assignmentRequestInfo,Long id); 
	public void delete(Long id);

}
