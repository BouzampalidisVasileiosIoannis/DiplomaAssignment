package myy803.diplomas_mgt_app_skeleton.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import myy803.diplomas_mgt_app_skeleton.dao.ApplicationDAO;
import myy803.diplomas_mgt_app_skeleton.dao.ProfessorDAO;
import myy803.diplomas_mgt_app_skeleton.dao.SubjectDAO;
import myy803.diplomas_mgt_app_skeleton.dao.ThesisDAO;
import myy803.diplomas_mgt_app_skeleton.model.Application;
import myy803.diplomas_mgt_app_skeleton.model.Professor;
import myy803.diplomas_mgt_app_skeleton.model.Student;
import myy803.diplomas_mgt_app_skeleton.model.Subject;
import myy803.diplomas_mgt_app_skeleton.model.Thesis;
import org.springframework.stereotype.Service;

@Service
public class ProfessorServiceImpl implements ProfessorService{

	
	@Autowired
	private ProfessorDAO professorDAO;
	
	@Autowired
	private SubjectDAO subjectDAO;
	
	@Autowired
	private ThesisDAO thesisDAO;
	
	@Autowired
	private ApplicationDAO applicationDAO;
	
	private List<Subject> professorSubjects = new ArrayList<Subject>();
	
	private List<Thesis> professorThesis = new ArrayList<Thesis>();
	
	private List<Application> professorApplications = new ArrayList<Application>();
	
	public ProfessorServiceImpl(ProfessorDAO professorDAO) {
		this.professorDAO = professorDAO;
	}
	
	public ProfessorServiceImpl() {
		super();
	}
	
	@Override
	public Professor retrieveProfile(int id) {

		Professor theProf = professorDAO.findById(id);

		return theProf;
	}

	@Override
	public void saveProfile(Professor p) {
		professorDAO.save(p);
		
	}

	@Override
	public List<Subject> listProfessorSubjects(Professor professor) {
		
		List<Subject> tempList = subjectDAO.findAll();

		for (int i=0; i<tempList.size(); i++)
		{
			if((tempList.get(i).getSupervisor().getProfessor_id()) == professor.getProfessor_id())
			{
				professorSubjects.add(tempList.get(i));
			}
		}
		
		return professorSubjects;
	}

	@Override
	public void addSubject(Subject subject) {
		subjectDAO.save(subject);
		professorSubjects.add(subject);
		
	}

	@Override
	public void deleteSubject(int subject_id) {
		subjectDAO.deleteById(subject_id);
	}

	@Override
	public List<Application> listApplications(Professor professor,int subject_id) {

		List<Application> tempList = applicationDAO.findAll();


		for (int i=0; i<tempList.size(); i++)
		{

			if(((tempList.get(i).getProfessor().getProfessor_id()) == professor.getProfessor_id()) && (tempList.get(i).getSubject().getSubject_id() == subject_id))
			{
				professorApplications.add(tempList.get(i));
			}
		}

		return professorApplications;
	}

	@Override
	public List<Thesis> listProfessorTheses(Professor professor) {

		List<Thesis> tempList = thesisDAO.findAll();

		for (int i=0; i<tempList.size(); i++)
		{
			if((tempList.get(i).getSupervisor().getProfessor_id()) == professor.getProfessor_id())
			{
				professorThesis.add(tempList.get(i));
			}
		}

		return professorThesis;
	}
	@Override
	public void assignSubject(Subject subject, Student student,Professor professor) {
		Thesis assignedSubject = new Thesis();
		assignedSubject.setSubject(subject);
		assignedSubject.setStudent(student);
		assignedSubject.setSupervisor(professor);
		thesisDAO.save(assignedSubject);
	}

	@Override
	public Professor findByUsername(String username) {
		return professorDAO.findByUsername(username);
	}

}
