package myy803.diplomas_mgt_app_skeleton.model.strategies;

import myy803.diplomas_mgt_app_skeleton.model.Application;

public class RandomChoiceStrategy extends TemplateStrategyAlgorithm{

	public RandomChoiceStrategy() {}
	
	public RandomChoiceStrategy(TemplateStrategyAlgorithm selectedStrategy)
	{
		super(selectedStrategy);
	}
	@Override
	public int compareApplications(Application app1, Application app2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
