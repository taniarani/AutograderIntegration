package com.data.autogader.service;

import org.springframework.web.client.RestClientException;

import com.data.autogader.model.StudentSubmissionRequestInfo;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface StudentService {
	public void save(StudentSubmissionRequestInfo studentSubmissionRequestInfo) throws JsonProcessingException, RestClientException;

	public void update(StudentSubmissionRequestInfo studentSubmissionRequestInfo,Long id) throws JsonProcessingException, RestClientException;

	public void delete(Long id);
}
