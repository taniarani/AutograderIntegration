package com.data.autogader.model;

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
@Table(name = "student_assignment_test_cases", schema = "autograder_metadatainfo")
public class StudentAssignmentTestCasesReqInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence_generator")
	@SequenceGenerator(name = "hibernate_sequence_generator", sequenceName = "autograder_metadatainfo.hibernate_sequence", allocationSize = 1)
	private int id;

	@Column(name = "stut_assignment_ad")
	private int stut_Assignment_Ad;

	@Column(name = "test_cases")
	private int test_cases;

	@Column(name = "is_passed")
	private boolean isPassed;

	@Column(name = "observed_output")
	private String observed_Output;

	@Column(name = "marks")
	private int marks;

	@Column(name = "comment")
	private String comment;

}
