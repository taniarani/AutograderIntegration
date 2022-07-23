package com.data.autogader.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class AssignmentRequestInfo {
	private String assignment_Name;
	private Date dueDate;
	private boolean isMarkingCompleted;
	private int module_Id;
	private int cr_dt;
	private int di_dt;

	public static void main(String[] args) {

	}

}
