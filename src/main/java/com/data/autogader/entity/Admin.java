package com.data.autogader.entity;

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
@Table(name = "admin", schema = "autograder_metadatainfo")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence_generator")
	@SequenceGenerator(name = "hibernate_sequence_generator", sequenceName = "autograder_metadatainfo.hibernate_sequence", allocationSize = 1)
	@Column(name = "id")

	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;

}
