package com.data.autogader.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseInfo {

	private String output;
	private String statusCode;
	private String memory;
	private String cpuTime;

}
