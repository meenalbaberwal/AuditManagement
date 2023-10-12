package com.mfpe.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mfpe.model.ProjectManager;

/**
 * This is repository class which extends the JpaRepository and uses inbuilt methods
 * @author Rupesh Lal
 *
 */
@Repository
public interface ProjectManagerRepo extends JpaRepository<ProjectManager, Integer>{

	@Query(value = "SELECT p FROM ProjectManager p WHERE p.username = ?1")
	public ProjectManager getProjectManagerByUserName(String username);
}
