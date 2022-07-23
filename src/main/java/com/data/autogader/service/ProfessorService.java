package com.data.autogader.service;

import org.springframework.web.client.RestClientException;

import com.data.autogader.model.ProfessorReqInfo;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ProfessorService {
	public void save(ProfessorReqInfo professorReqInfo) throws JsonProcessingException, RestClientException; 

	public void update(ProfessorReqInfo professorReqInfo,Long id) throws JsonProcessingException, RestClientException; 
	public void delete(Long id);
}
