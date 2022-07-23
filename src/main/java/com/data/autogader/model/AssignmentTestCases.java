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
@Table(name = "assignment_test_cases", schema = "autograder_metadatainfo")
public class AssignmentTestCases {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence_generator")
	@SequenceGenerator(name = "hibernate_sequence_generator", sequenceName = "autograder_metadatainfo.hibernate_sequence", allocationSize = 1)
	@Column(name = "id")

	private int id;
	@Column(name = "assignment_id")
	private int assignment_Id;
	@Column(name = "test_id")
	private int test_Id;
	@Column(name = "expected_output")
	private String expected_output;
	@Column(name = "marks")
	private int marks;

}
