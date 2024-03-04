package myy803.diplomas_mgt_app_skeleton.service;
import java.util.List;

import myy803.diplomas_mgt_app_skeleton.model.Application;
import myy803.diplomas_mgt_app_skeleton.model.Professor;
import myy803.diplomas_mgt_app_skeleton.model.Student;
import myy803.diplomas_mgt_app_skeleton.model.Subject;
import myy803.diplomas_mgt_app_skeleton.model.Thesis;
import org.springframework.stereotype.Service;

@Service
public interface ProfessorService {
	public Professor retrieveProfile(int id);
	public void saveProfile(Professor p);
	public List<Subject> listProfessorSubjects(Professor professor);
	public void addSubject(Subject subject);
	public void deleteSubject(int subject_id);
	public List<Application> listApplications(Professor professor, int subject_id);
	public List<Thesis> listProfessorTheses(Professor professor);
	public void assignSubject(Subject subject,Student student,Professor professor);

	public Professor findByUsername(String username);

}