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
@Table(name = "assignment", schema = "autograder_metadatainfo")
public class Assignment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence_generator")
	@SequenceGenerator(name = "hibernate_sequence_generator", sequenceName = "autograder_metadatainfo.hibernate_sequence", allocationSize = 1)
	@Column(name = "id")
	private Long id;
	@Column(name = "assignment_name")
	private String assignment_Name;
	@Column(name = "due_date")
	private Date dueDate;
	@Column(name = "isMarkingCompleted")
	private boolean isMarkingCompleted;
	@Column(name = "module_Id")
	private int module_Id;
	@Column(name = "create_dt")
	private int cr_dt;
	@Column(name = "due_dt")
	private int di_dt;


}
