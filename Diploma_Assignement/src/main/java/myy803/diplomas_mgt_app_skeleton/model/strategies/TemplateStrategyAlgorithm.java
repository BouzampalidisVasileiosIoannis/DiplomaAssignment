package myy803.diplomas_mgt_app_skeleton.model.strategies;

import java.util.List;
import java.util.Random;

import myy803.diplomas_mgt_app_skeleton.model.Application;
import myy803.diplomas_mgt_app_skeleton.model.Student;

public abstract class TemplateStrategyAlgorithm implements BestApplicantStrategy{
	
private TemplateStrategyAlgorithm selectedStrategy;
	public TemplateStrategyAlgorithm() {}
	public TemplateStrategyAlgorithm(TemplateStrategyAlgorithm selectedStrategy) {
		this.selectedStrategy = selectedStrategy;
	}
	
	public Student findBestApplicant(List<Application> appList){
		int bestStudentId = appList.get(0).getStudent().getStudent_id();
		Student bestStudent = appList.get(0).getStudent();
		Application bestApp = appList.get(0);
		if(selectedStrategy instanceof RandomChoiceStrategy) {
			Random randomChoice = new Random();
			int index = randomChoice.nextInt(appList.size());
			bestStudent = appList.get(index).getStudent();
		}
		else{
			if (appList.size() > 1)
			{
				for(int i=1; i<appList.size(); i++) {

					if(!(selectedStrategy instanceof RandomChoiceStrategy)) {
						bestStudentId = selectedStrategy.compareApplications(bestApp,appList.get(i));
						if(bestStudentId == -1)
						{
							continue;
						}
						else if(bestStudentId == (appList.get(i).getStudent().getStudent_id())) {
							bestApp = appList.get(i);
							bestStudent = appList.get(i).getStudent();
						}
						else if(bestStudentId==(bestApp.getStudent().getStudent_id())) {
							bestStudent = bestApp.getStudent();
						}
					}
				}
			}
		}

		
		return bestStudent;
	}
	
	public abstract int compareApplications(Application app1,Application app2);
	
	public void setSelectedStrategy(TemplateStrategyAlgorithm selectedStrategy) {
		this.selectedStrategy = selectedStrategy;
	}
	
	
}