package myy803.diplomas_mgt_app_skeleton.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import myy803.diplomas_mgt_app_skeleton.model.Student;
import myy803.diplomas_mgt_app_skeleton.model.Subject;
import myy803.diplomas_mgt_app_skeleton.service.StudentService;
import myy803.diplomas_mgt_app_skeleton.service.SubjectService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService)
	{
		this.studentService = studentService;
	}



	@RequestMapping("/main-menu")
    public String getStudentHome(){
		
        return "student/main-menu";
    }



	@RequestMapping("/saveProfile")
	public String saveProfile(@ModelAttribute("student") Student theStudent, Model theModel) {

		studentService.saveProfile(theStudent);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/student/main-menu";
	}

	@RequestMapping("/retrieve")
	public String retrieveProfile(Model theModel)
	{
		Student theStudent = new Student();
		int theStudentId = theStudent.getStudent_id();

		studentService.retrieveProfile(theStudentId);
		
		return "redirect:/student/main-menu";
	}
	
	
	@RequestMapping("/list-allSubject")
	public String subjectList(Model theModel)
	{

		List<Subject> theSubjects = studentService.listStudentSubjects();
		
		theModel.addAttribute("subjects", theSubjects);
		
		return "student/list-allSubject";
	}
	
	@RequestMapping("/edit")
	public String editAttributes(Model theModel)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();


		Student theStudent = studentService.findByUsername(currentPrincipalName);

		theModel.addAttribute("student", theStudent);

		
		return "student/student-form";
	}
	
	@RequestMapping("/apply")
	public String applyToSubject(@RequestParam("subject_id") int subject_id)
	{

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Student theStudent = studentService.findByUsername(currentPrincipalName);

		studentService.applyToSubject(subject_id, theStudent.getStudent_id());
		
		return "redirect:/student/main-menu";
	}

}
