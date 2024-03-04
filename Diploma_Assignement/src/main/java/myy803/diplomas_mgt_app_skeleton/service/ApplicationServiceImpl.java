package myy803.diplomas_mgt_app_skeleton.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import myy803.diplomas_mgt_app_skeleton.dao.ApplicationDAO;
import myy803.diplomas_mgt_app_skeleton.model.Application;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	
	@Autowired
	private ApplicationDAO applicationDAO;
	
	@Override
	public void save(Application application) {
		applicationDAO.save(application);
		
	}

	@Override
	public List<Application> findAll() {
		return applicationDAO.findAll();
	}

	@Override
	public Application findById(int application_id) {
		Application theApplication = applicationDAO.findById(application_id);
		if (theApplication != null ) {
			return theApplication;
		}
		else {
			// Application not found
			throw new RuntimeException("Application id not found - " + application_id);
		}
	}

}
