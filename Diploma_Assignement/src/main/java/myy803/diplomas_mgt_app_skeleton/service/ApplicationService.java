package myy803.diplomas_mgt_app_skeleton.service;

import java.util.List;

import myy803.diplomas_mgt_app_skeleton.model.Application;
import org.springframework.stereotype.Service;

@Service
public interface ApplicationService {
	
	public void save(Application application);
	public List<Application> findAll();
	public Application findById(int application_id);

}
