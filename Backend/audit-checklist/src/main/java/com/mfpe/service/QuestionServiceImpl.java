package com.mfpe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfpe.model.AuditType;
import com.mfpe.model.Question;
import com.mfpe.repository.QuestionRepo;
/**
 * This is a Question Service Implementation class which implements Question Service class
 * getQuestionByAuditType method returns the list of questions according to the auditType selected
 * @author Shifa Mirza
 *
 */
@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionRepo questionRepo;
	
	// Service for the Endpoint /AuditCheckListQuestions
	public List<Question> getQuestionsByAuditType(AuditType auditType){
		List<Question> qlist = questionRepo.getQuestionsByAuditType(auditType.getAuditType());
		return qlist;
	}

}
