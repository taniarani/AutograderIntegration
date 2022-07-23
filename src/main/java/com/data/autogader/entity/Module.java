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
@Table(name = "module", schema = "autograder_metadatainfo")
public class Module {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence_generator")
	@SequenceGenerator(name = "hibernate_sequence_generator", sequenceName = "autograder_metadatainfo.hibernate_sequence", allocationSize = 1)

	public Long id;
	@Column(name = "name")

	public String name;
	@Column(name = "module_description")

	public String description;
	@Column(name = "module_coordinator")

	public String coordinator;

}
