package myy803.diplomas_mgt_app_skeleton.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import myy803.diplomas_mgt_app_skeleton.dao.ApplicationDAO;
import myy803.diplomas_mgt_app_skeleton.dao.StudentDAO;
import myy803.diplomas_mgt_app_skeleton.dao.SubjectDAO;
import myy803.diplomas_mgt_app_skeleton.model.Application;
import myy803.diplomas_mgt_app_skeleton.model.Professor;
import myy803.diplomas_mgt_app_skeleton.model.Student;
import myy803.diplomas_mgt_app_skeleton.model.Subject;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO; 
	
	@Autowired
	private SubjectDAO subjectDAO;
	
	@Autowired
	private ApplicationDAO applicationDAO;
	
	private List<Subject> studentSubjects = new ArrayList<>();
	
	public StudentServiceImpl(StudentDAO studentDAO)
	{
		this.studentDAO = studentDAO;
	}
	
	public StudentServiceImpl() {}

	@Override
	public void saveProfile(Student student) {
		studentDAO.save(student);
		
	}

	@Override
	public Student retrieveProfile(int id) {
		
		Student theStudent = studentDAO.findById(id);
		
		return theStudent;
	}

	@Override
	public List<Subject> listStudentSubjects() {
		studentSubjects = subjectDAO.findAll();
		
		return studentSubjects;
	}

	@Override   // controller paradeigma 4 lisemployees grammh 46 gia na kserw poios einai logged in kai otan pataei to koumpi apply --> url pou kanw request mapping
	public void applyToSubject(int subject_id, int student_id) {
		Student studentApply = studentDAO.findById(student_id);
		Subject subjectApply = subjectDAO.findById(subject_id);
		Professor professorApply = subjectApply.getSupervisor();
		Application theApp = new Application();
		theApp.setProfessor(professorApply);
		theApp.setStudent(studentApply);
		theApp.setSubject(subjectApply);
		applicationDAO.save(theApp);
		
	}

	@Override
	public Student findByUsername(String username) {
		return studentDAO.findByUsername(username);
	}

}
