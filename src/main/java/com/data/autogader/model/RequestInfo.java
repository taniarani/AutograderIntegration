package com.data.autogader.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonPropertyOrder({ "clientId", "clientSecret", "script", "language", "versionIndex"})
public class RequestInfo {

	String clientId;
	String clientSecret;
	String script;

	String language;
	String versionIndex;


}
