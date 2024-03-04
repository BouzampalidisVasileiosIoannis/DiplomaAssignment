package myy803.diplomas_mgt_app_skeleton.model.strategies;

import myy803.diplomas_mgt_app_skeleton.model.Student;

import java.util.List;

import myy803.diplomas_mgt_app_skeleton.model.Application;

public interface BestApplicantStrategy  {
	

	public Student findBestApplicant(List<Application> appList);
}
