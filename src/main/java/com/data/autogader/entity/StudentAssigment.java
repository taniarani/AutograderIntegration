package com.data.autogader.entity;

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
@Table(name = "student_assignment", schema = "autograder_metadatainfo")
public class StudentAssigment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence_generator")
	@SequenceGenerator(name = "hibernate_sequence_generator", sequenceName = "autograder_metadatainfo.hibernate_sequence", allocationSize = 1)
	private Long id;

	@Column(name = "stu_id")
	private int stu_Id;

	@Column(name = "assign_id")
	private int assign_Id;

	@Column(name = "file_name")
	private String fileName;

	@Column(name = "marks")
	private int marks;

	@Column(name = "no_of_passed_test_cases")
	private int no_Of_Passed_Test_Cases;

	@Column(name = "is_checked")
	private boolean isChecked;

	@Column(name = "checked_date")
	private Date checked_Date;

	@Column(name = "comment")
	private String comment;

	// Here This is int or
	@Column(name = "marked_By")
	private String marked_By;

}
