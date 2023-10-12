package com.mfpe.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mfpe.model.ProjectManager;
import com.mfpe.model.ProjectManagerDetails;

/**
 * This is security service class which implements user details service interface of the spring security framework.
 * @author Rupesh Lal
 *
 */
@Service
public class ProjectManagerDetailsService implements UserDetailsService{
	

	@Autowired
	private ProjectManagerService projectManagerService;
	
	/**
	 * This method returns the User object based on the username...
	 * whose password will get checked with the password we provided in this User object..
	 * if match --> authenticated , if not match --> user not authenticated
	 */
	@Override
	public ProjectManagerDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// it gets the ProjectManager using ProjectManagerService and 
		// from there it gets the ProjecManagerDetails from ProjectManager using ProjectManagerDetailsService...
		// which is then used in SecurityConfig
		ProjectManagerDetails projectManagerDetails = null;
		ProjectManager projectManager = projectManagerService.getProjectManagerByUserName(username);
		if(projectManager!=null) {
			projectManagerDetails = new ProjectManagerDetails(projectManagerService
											.getProjectManagerByUserName(username));
		}
		
		return projectManagerDetails;
	}
	
}
