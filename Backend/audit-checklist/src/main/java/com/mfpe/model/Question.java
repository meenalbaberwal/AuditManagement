package com.mfpe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "question")
/**
 * This is an entity class containing questionId,question,auditType,response as fields
 * It contains all the getter-setter,constructors,equals method and overrides toString method.
 * @author Shifa Mirza
 *
 */
public class Question {
	
	@Id
	@GeneratedValue
	@Column(name="question_id")
	private int questionId;
	
	@Column(name="question")
	private String question;
	
	@Column(name="audit_type")
	private String auditType;
	
	@Column(name="response")
	private String response;
	
}
