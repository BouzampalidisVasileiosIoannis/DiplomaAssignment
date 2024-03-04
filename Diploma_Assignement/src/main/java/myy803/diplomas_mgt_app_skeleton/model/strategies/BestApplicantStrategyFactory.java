package myy803.diplomas_mgt_app_skeleton.model.strategies;

public class BestApplicantStrategyFactory {

	public static TemplateStrategyAlgorithm selectedStrategy = null;
	public static BestApplicantStrategy createStrategy(String selection) {
		// tha valw koumpia best average grade kai ta loipa pou na pataei o xrhsths kai na ginetai to analogo strategy
		
		
		if (selection.equals("Best Average Grade")) {
			selectedStrategy = new BestAvgGradeStrategy(new BestAvgGradeStrategy());
		}
		else if (selection.equals("Fewest Courses")) {
			selectedStrategy = new FewestCoursesStrategy(new FewestCoursesStrategy());
		}
		
		else if (selection.equals("Random")) {
			selectedStrategy = new RandomChoiceStrategy(new RandomChoiceStrategy());
		}
		
		else if (selection.equals("Threshold")) {
			selectedStrategy = new ThresholdStrategy(new ThresholdStrategy());
		}
		
		else if(selectedStrategy == null)
		{
			throw new RuntimeException("Strategy not found");
		}
		
		
		return selectedStrategy;
	}
}
