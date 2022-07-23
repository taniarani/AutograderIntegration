package com.data.autogader.serviceimpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.data.autogader.entity.Student;
import com.data.autogader.entity.StudentAssignmentTestCases;
import com.data.autogader.model.ProfessorReqInfo;
import com.data.autogader.model.RequestInfo;
import com.data.autogader.model.ResponseInfo;
import com.data.autogader.model.StudentReqInfo;
import com.data.autogader.model.StudentSubmissionRequestInfo;
import com.data.autogader.repository.StudentAssignmentTestCasesRepository;
import com.data.autogader.repository.StudentRepository;
import com.data.autogader.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class StudentServiceImpl implements StudentService {

	@Value("${autogader.client.url}")
	String url;
	@Value("${autogader.client.clientId}")
	String clientId;
	@Value("${autogader.client.clientSecret}")
	String clientSecret;

	@Value("${autogader.client.language}")
	String language;
	@Value("${autogader.client.versionIndex}")
	String versionIndex;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	StudentAssignmentTestCasesRepository studentAssignmentTestCasesRepository;
	
	@Autowired
	StudentRepository studentRepository;
	

	String a[] = new String[] { "Ankit" };
	private String[] split;
	List<String> list = Arrays.asList(a);

	@Override
	public void save(StudentSubmissionRequestInfo studentSubmissionRequestInfo)
			throws JsonProcessingException, RestClientException {
		RequestInfo info = new RequestInfo();
		info.setClientId(clientId);
		info.setClientSecret(clientSecret);
		info.setLanguage(language);

		info.setScript(studentSubmissionRequestInfo.getMultiparg());
		info.setVersionIndex(versionIndex);
		String writeValueAsString = objectMapper.writeValueAsString(info);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(writeValueAsString, headers);
		RestTemplate rest = new RestTemplate();
		// ResponseEntity<String> response =
		ResponseEntity<ResponseInfo> exchange = rest.exchange(url, HttpMethod.POST, entity, ResponseInfo.class);
		ResponseInfo body = exchange.getBody();
		if (body.getStatusCode().equalsIgnoreCase("200")) {
			String output = body.getOutput();
			split = output.split("\n");
			List<String> as = new ArrayList<>();

			for (String string : split) {
				as.add(string);
			}
			StudentAssignmentTestCases aresponse = new StudentAssignmentTestCases();
			if (list.equals(as)) {
				aresponse.setComment("Good Job");
				aresponse.setMarks(100);
				aresponse.setObserved_Output(as.get(0));
				aresponse.setPassed(Boolean.TRUE);
				aresponse.setStut_Assignment_Ad(1);
				aresponse.setTest_cases(list.size());
				studentAssignmentTestCasesRepository.save(aresponse);

			} else {
				aresponse.setComment("Bad Job");
				aresponse.setMarks(0);
				aresponse.setObserved_Output(as.get(0));
				aresponse.setPassed(Boolean.FALSE);
				aresponse.setStut_Assignment_Ad(1);
				aresponse.setTest_cases(0);
				studentAssignmentTestCasesRepository.save(aresponse);
			}

		}

	}

	@Override
	public void delete(Long id) {
		studentRepository.deleteById(id);

	}

	@Override
	public void update(StudentSubmissionRequestInfo studentSubmissionRequestInfo, Long id)
			throws JsonProcessingException, RestClientException {

	}

	public void updateData(StudentReqInfo studentReqInfo, Long id) {
		Optional<Student> findById = studentRepository.findById(id);
		if (findById.get() != null) {
			Student student=new Student();
			student.setId(id);
			student.setCourseName(studentReqInfo.getCourseName());
			student.setDateOfBirth(getDate(studentReqInfo));;
			student.setFirstName(studentReqInfo.getFirstName());
			student.setMiddleName(studentReqInfo.getMiddleName());
			student.setLastName(studentReqInfo.getLastName());
			student.setPassword(studentReqInfo.getPassword());
			student.setUsername(studentReqInfo.getUsername());
			student.setStudentNumber(studentReqInfo.getStudentNumber());
			student.setProfile_image_Name(null);
			student.setEmail(studentReqInfo.getEmail());
			studentRepository.save(student);
	
		}
			}

	public void saveData(StudentReqInfo studentReqInfo) {

		Student student=new Student();
		student.setCourseName(studentReqInfo.getCourseName());
		student.setDateOfBirth(getDate(studentReqInfo));;
		student.setFirstName(studentReqInfo.getFirstName());
		student.setMiddleName(studentReqInfo.getMiddleName());
		student.setLastName(studentReqInfo.getLastName());
		student.setPassword(studentReqInfo.getPassword());
		student.setUsername(studentReqInfo.getUsername());
		student.setStudentNumber(studentReqInfo.getStudentNumber());
		student.setProfile_image_Name(null);
		student.setEmail(studentReqInfo.getEmail());
		studentRepository.save(student);

	}
	private Date getDate(StudentReqInfo studentReqInfo) {
		String sDate1 = studentReqInfo.getDateOfBirth();
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

}
