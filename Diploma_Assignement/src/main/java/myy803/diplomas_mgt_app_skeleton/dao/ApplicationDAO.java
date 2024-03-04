package myy803.diplomas_mgt_app_skeleton.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import myy803.diplomas_mgt_app_skeleton.model.Application;


public interface ApplicationDAO extends JpaRepository<Application , Integer>{

	public Application findById(int id);

	public List<Application> findAll();
	
	

}
