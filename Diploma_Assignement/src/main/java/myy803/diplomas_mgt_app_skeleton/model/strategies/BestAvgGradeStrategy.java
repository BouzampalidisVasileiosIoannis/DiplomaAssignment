package myy803.diplomas_mgt_app_skeleton.model.strategies;

import myy803.diplomas_mgt_app_skeleton.model.Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BestAvgGradeStrategy extends TemplateStrategyAlgorithm{
	
	public BestAvgGradeStrategy() {}
	
	public BestAvgGradeStrategy(TemplateStrategyAlgorithm selectedStrategy) {
		super(selectedStrategy);
	}
	
	@Override
	public int compareApplications(Application app1 , Application app2)
	{
		
		if(app1 == null || app2== null)
		{
			throw new RuntimeException("Applicants not found");
		}


		float current1 = app1.getStudent().getCurrentAverageGrade();
		float current2 = app2.getStudent().getCurrentAverageGrade();
		int studentid=0;
		
		if(current1 > current2)
		{
			studentid = app1.getStudent().getStudent_id();
		}
		else if(current2 > current1)
		{
			studentid = app2.getStudent().getStudent_id();
		}
		else
		{
			List<Application> sameGrade = new ArrayList<Application>();
			sameGrade.add(app1);
			sameGrade.add(app2);
			Random randomChoice = new Random();
			int index = randomChoice.nextInt(sameGrade.size());
			studentid = sameGrade.get(index).getStudent().getStudent_id();

		}
		
		return studentid;
	}

}
