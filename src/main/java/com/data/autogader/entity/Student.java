package com.data.autogader.entity;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "student", schema = "autograder_metadatainfo")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence_generator")
	@SequenceGenerator(name = "hibernate_sequence_generator", sequenceName = "autograder_metadatainfo.hibernate_sequence", allocationSize = 1)
	public Long id;
	
	@Column(name = "first_name")
	public String firstName;
	
	@Column(name = "middle_name")
	public String middleName;

	@Column(name = "last_name")
	public String lastName;

	@Column(name = "dob")
	public Date dateOfBirth;

	@Column(name = "student_number")
	public String studentNumber;
	
	@Column(name = "courseName")
	public String courseName;
	
	@Column(name = "email")
	public String email;
	
	@Column(name = "profile_image_name")
	public Blob profile_image_Name;

	@Column(name = "username")
	public String username;
	
	@Column(name = "password")
	public String password;

}
