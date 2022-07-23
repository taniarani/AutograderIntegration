package com.data.autogader.serviceimpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.data.autogader.entity.Module;
import com.data.autogader.entity.Professor;
import com.data.autogader.model.ProfessorReqInfo;
import com.data.autogader.repository.ProfessorRepository;
import com.data.autogader.service.ProfessorService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class ProfessorServiceImpl implements ProfessorService {
	@Autowired
	ProfessorRepository professorRepository;

	@Override
	public void save(ProfessorReqInfo professorReqInfo) throws JsonProcessingException, RestClientException {
		Professor professor = new Professor();
		Date date1 = getDate(professorReqInfo);
		professor.setCoordinator(professorReqInfo.getCoordinator());
		professor.setDob(date1);
		professor.setActive(professorReqInfo.isActive());
		professor.setName(professorReqInfo.getName());
		professor.setPassword(professorReqInfo.getPassword());
		professor.setUsername(professorReqInfo.getUsername());
		professor.setPostingAllowed(professorReqInfo.isPostingAllowed());
		professorRepository.save(professor);
	}

	private Date getDate(ProfessorReqInfo professorReqInfo) {
		String sDate1 = professorReqInfo.getDob();
		System.out.println(sDate1);
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("dd-MM-yyyy").parse(sDate1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date1;
	}

	@Override
	public void delete(Long id) {
		Optional<Professor> professorReqInfoRepo = professorRepository.findById(id);
		if (professorReqInfoRepo.isPresent()) {
			professorRepository.deleteById(id);
		}

	}

	@Override
	public void update(ProfessorReqInfo professorReqInfo, Long id) throws JsonProcessingException, RestClientException {

		Optional<Professor> professorReqInfoRepo = professorRepository.findById(id);
		if (professorReqInfoRepo.isPresent()) {

			Professor professor = new Professor();
			professor.setId(id);
			professor.setCoordinator(professorReqInfo.getCoordinator());
			Date date1 = getDate(professorReqInfo);

			professor.setDob(date1);
			professor.setActive(professorReqInfo.isActive());
			professor.setName(professorReqInfo.getName());
			professor.setPassword(professorReqInfo.getPassword());
			professor.setUsername(professorReqInfo.getUsername());
			professor.setPostingAllowed(professorReqInfo.isPostingAllowed());
			professorRepository.save(professor);
		}
	}
}
