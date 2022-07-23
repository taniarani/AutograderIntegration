package com.data.autogader.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ProfessorReqInfo {

	private String name;
	private String dob;
	private String coordinator;

	private boolean active;

	private boolean isPostingAllowed;

	private String username;

	private String password;

}
