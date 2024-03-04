package myy803.diplomas_mgt_app_skeleton.model.strategies;

import myy803.diplomas_mgt_app_skeleton.model.Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class  ThresholdStrategy extends TemplateStrategyAlgorithm{

	public ThresholdStrategy(TemplateStrategyAlgorithm selectedStrategy)
	{
		super(selectedStrategy);
	}
	
	public ThresholdStrategy() {}
	

	@Override
	public int compareApplications(Application app1,Application app2 ) {
		if(app1 == null || app2== null)
		{
			throw new RuntimeException("Applicants not found");
		}
		
		int currentCourses1 = app1.getStudent().getNumberOfRemainingCoursesForGraduation();
		int currentCourses2 = app2.getStudent().getNumberOfRemainingCoursesForGraduation();
		float currentGrade1 = app1.getStudent().getCurrentAverageGrade();
		float currentGrade2 = app2.getStudent().getCurrentAverageGrade();
		int studentid=0;
		
		if(currentGrade1 > app1.getProfessor().getThreshold1() && currentCourses1 < app1.getProfessor().getThreshold2()
	    && currentGrade2 > app2.getProfessor().getThreshold1() && currentCourses2 < app2.getProfessor().getThreshold2())
		{
			List<Application> sameGrade = new ArrayList<Application>();
			sameGrade.add(app1);
			sameGrade.add(app2);
			Random randomChoice = new Random();
			int index = randomChoice.nextInt(sameGrade.size());
			studentid = sameGrade.get(index).getStudent().getStudent_id();
		}
		
		else if(currentGrade1 > app1.getProfessor().getThreshold1() && currentCourses1 < app1.getProfessor().getThreshold2())
		{
			studentid = app1.getStudent().getStudent_id();
		}
		
		else if(currentGrade2 > app2.getProfessor().getThreshold1() && currentCourses2 < app2.getProfessor().getThreshold2())
		{
			studentid = app2.getStudent().getStudent_id();
		}
		else 
		{
			return -1;
		}
		
		return studentid;
	}
}
