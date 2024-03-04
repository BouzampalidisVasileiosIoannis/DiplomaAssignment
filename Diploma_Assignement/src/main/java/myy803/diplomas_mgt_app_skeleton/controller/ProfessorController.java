package myy803.diplomas_mgt_app_skeleton.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import myy803.diplomas_mgt_app_skeleton.model.Subject;
import myy803.diplomas_mgt_app_skeleton.model.Thesis;
import myy803.diplomas_mgt_app_skeleton.model.strategies.BestApplicantStrategy;
import myy803.diplomas_mgt_app_skeleton.model.strategies.BestApplicantStrategyFactory;
import myy803.diplomas_mgt_app_skeleton.model.Application;
import myy803.diplomas_mgt_app_skeleton.model.Professor;
import myy803.diplomas_mgt_app_skeleton.model.Student;
import myy803.diplomas_mgt_app_skeleton.service.ApplicationService;
import myy803.diplomas_mgt_app_skeleton.service.ProfessorService;
import myy803.diplomas_mgt_app_skeleton.service.SubjectService;
import myy803.diplomas_mgt_app_skeleton.service.ThesisService;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@RequestMapping("/professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private ThesisService thesisService;
	
	@Autowired
	private ApplicationService applicationService;

	@Autowired
	public ProfessorController() {}


	@RequestMapping("/main-menu")
    public String getProfessorHome(){
		
        return "/professor/main-menu";
    }

	@RequestMapping("/mySubjectList")
	public String listProfessorSubjects(Model theModel) {
		// get subjects from db

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Professor theProf = professorService.findByUsername(currentPrincipalName);
		List<Subject> tempList = professorService.listProfessorSubjects(theProf);

		// add to the spring model
		theModel.addAttribute("subject", tempList);
		
		return "professor/mySubjectList";
	}
	
	@RequestMapping("/addSubject")
	public String addSubject(Model theModel) {

		if (!theModel.containsAttribute("subject")) {
			Subject theSubject = new Subject();
			theModel.addAttribute("subject", theSubject);
		}

		return "professor/subject-form";
		
	}

	@RequestMapping("/deleteButton")
	public String deleteButton() {
		return "professor/delete-subject-form";
	}


	@RequestMapping("/deleteSubject")
	public String deleteSubjectByTitle(@RequestParam("title") String title) {
		Subject theSubject = subjectService.findByTitle(title);
		subjectService.deleteById(theSubject.getSubject_id());
		return "redirect:/professor/mySubjectList";
	}

	
	@RequestMapping("/saveSubject")
	public String saveSubject(@ModelAttribute("subject") Subject subject, Model theModel)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Professor theProfessor = professorService.findByUsername(currentPrincipalName);
		subject.setSupervisor(theProfessor);
		subjectService.save(subject);
		
		return "redirect:/professor/mySubjectList";
	}


	@RequestMapping("/selectStrategy")
	public String chooseStrategy()
	{
		return "professor/strategy-form";
	}


	@RequestMapping("/assignSubject")
	public String assignSubject(@RequestParam("title") String title,@RequestParam("selection") String selection,
									Model theModel) {
		
		// get the subject from the service
		
		Subject theSubject = subjectService.findByTitle(title);

		if(selection.equals("Threshold"))
		{
			if (theSubject.getSupervisor().getThreshold1() == 0.0 && theSubject.getSupervisor().getThreshold2() == 0)
			{
				theModel.addAttribute("errorMessage", "Invalid Thresholds");
				return "professor/prof-error";
			}
		}
		
		BestApplicantStrategy theStrategy = BestApplicantStrategyFactory.createStrategy(selection);
		
		List<Application> appList = applicationService.findAll();
		
		List<Application> tempList = new ArrayList<Application>();
		
		for (int i=0; i<appList.size(); i++)
		{
			if((appList.get(i).getSubject().getTitle()).equals(title))
			{
				tempList.add(appList.get(i));
			}
		}
		
		Student bestStudent = theStrategy.findBestApplicant(tempList);

		if(bestStudent.getStudent_id() == 0 && selection.equals("Threshold"))
		{
			theModel.addAttribute("errorMessage", "Please Select The Random Choice Strategy");
			return "professor/prof-error";
		}

		else if(bestStudent.getStudent_id() == 0)
		{
			theModel.addAttribute("errorMessage", "Please Select Another Strategy");
			return "professor/prof-error";
		}

		List<Thesis> thesesList = thesisService.findAll();

		for (Thesis thesis: thesesList)
		{
			if(thesis.getStudent().getStudent_id() == bestStudent.getStudent_id())
			{
				theModel.addAttribute("errorMessage", "This student is already working on a subject");
				return "professor/prof-error";
			}
		}

		professorService.assignSubject(theSubject, bestStudent,theSubject.getSupervisor());
		
		theModel.addAttribute("subject", theSubject);
		
		theModel.addAttribute("student", bestStudent);

		theModel.addAttribute("professor", theSubject.getSupervisor());

		
		return "redirect:/professor/myThesesList";
				
	}
	
	@RequestMapping("/saveProfile")
	public String saveProfile(@ModelAttribute("professor") Professor theProfessor, Model theModel) {
		
		// save the professor
		professorService.saveProfile(theProfessor);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/professor/main-menu";
	}
	
	@RequestMapping("/myThesesList")
	public String listProfessorThesis(Model theModel) {
		// get employees from db
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Professor theProf = professorService.findByUsername(currentPrincipalName);
		List<Thesis> tempList = professorService.listProfessorTheses(theProf);

		// add to the spring model
		theModel.addAttribute("theses", tempList);
		
		return "professor/myThesesList";
	}

	
	@RequestMapping("/retrieve")
	public String retrieveProfile(Model theModel)
	{
		Professor theProf = new Professor();
		int theProfId = theProf.getProfessor_id();
		
		// retrieve the professor
		professorService.retrieveProfile(theProfId);
		
		return "redirect:/professor/main-menu";
	}
	
	@RequestMapping("/myApplicationList")
	public String listApplications(@RequestParam("title") String title, Model theModel) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Professor theProf = professorService.findByUsername(currentPrincipalName);
		Subject theSub = subjectService.findByTitle(title);
		List<Application> tempList = professorService.listApplications(theProf,theSub.getSubject_id());

		theModel.addAttribute("applications", tempList);
		return "professor/myApplicationList";
	}

	@RequestMapping("/setSubjectTitle")
	public String intermediatePage()
	{
		return "professor/setSubjectTitle";
	}


	@RequestMapping("/edit")
	public String editAttributes(Model theModel)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();


		Professor theProfessor = professorService.findByUsername(currentPrincipalName);

		theModel.addAttribute("professor", theProfessor);


		return "professor/professor-form";
	}

	@RequestMapping("/calculateGrade")
	public String calculateGrade(@RequestParam("thesis_id") int thesis_id,@RequestParam("impl_grade") float impl_grade,
						   @RequestParam("presentation_grade") float presentation_grade,
						   @RequestParam("report_grade") float report_grade)
	{
		float final_grade = impl_grade*(float)0.7 + presentation_grade*(float)0.15 +  report_grade*(float)0.15;

		Thesis thesisWithGrade = thesisService.findById(thesis_id);
		thesisWithGrade.setGrade(final_grade);
		thesisService.save(thesisWithGrade);

		return "redirect:/professor/myThesesList";
	}

	@RequestMapping("/setGrade")
	public String setGrade(@RequestParam("thesis_id") int thesis_id,Model theModel)
	{
		theModel.addAttribute("thesis_id",thesis_id);

		return "professor/setGrade";
	}

}
