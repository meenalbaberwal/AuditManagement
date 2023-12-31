package com.mfpe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * This is an entity class containing id,name,username,password and projectName as fields.
 * It contains all the getter-setter,constructors,equals method and overrides toString method.
 * @author Rupesh Lal
 *
 */
@Data
@Entity
@Table(name="project_manager")
@NoArgsConstructor
@AllArgsConstructor
public class ProjectManager{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@Column(unique = true)
	private String username;
	
	private String password;

	private String projectName;
	
}