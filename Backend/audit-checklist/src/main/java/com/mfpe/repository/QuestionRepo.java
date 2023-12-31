package com.mfpe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mfpe.model.Question;

@Repository
/**
 * This is a repository class which extends JpaRepository and uses inbuilt methods
 * @author 2102072
 *
 */
public interface QuestionRepo extends JpaRepository<Question, Integer> {
	
	// Retrieves the data from the database by searching using the auditType
	@Query(value = "SELECT q FROM Question q WHERE q.auditType=?1")
	List<Question> getQuestionsByAuditType(String auditType);
	
}
