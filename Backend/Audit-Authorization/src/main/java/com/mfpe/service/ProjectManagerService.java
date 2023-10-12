package com.mfpe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfpe.repository.ProjectManagerRepo;
import com.mfpe.exception.ProjectManagerNotFoundException;
import com.mfpe.model.ProjectManager;

/**
 * 
 * This is project manager repo service class.
 * It has a single method getProjectManagerByUserName which takes username as argument 
 * and returns the project manager details which matches the username provided in the parameter.
 * @author Rupesh Lal
 *
 */
@Service
public class ProjectManagerService {

	@Autowired
	private ProjectManagerRepo projectManagerRepo;
	/**
	 * 
	 * @param  username identifying the user whose data is required..
	 * @return project manager object which matches the provided username. 
	 * @throws ProjectManagerNotFoundException  if the project manager could not be found in database.
	 */
	public ProjectManager getProjectManagerByUserName(String username) throws ProjectManagerNotFoundException{
		ProjectManager projectManager = null;
		projectManager = projectManagerRepo.getProjectManagerByUserName(username);
		if(projectManager==null) {
			throw new ProjectManagerNotFoundException("Given Project-Manager-Details does not exist in our Database!!");
		}
		return projectManager;
	}
}
