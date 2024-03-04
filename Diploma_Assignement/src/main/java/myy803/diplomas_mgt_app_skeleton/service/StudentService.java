package myy803.diplomas_mgt_app_skeleton.service;

import myy803.diplomas_mgt_app_skeleton.model.Subject;
import myy803.diplomas_mgt_app_skeleton.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {
	
	public void saveProfile(Student student);
	public Student retrieveProfile(int id);
	public List<Subject> listStudentSubjects();
	public void applyToSubject(int subject_id, int student_id);

	public Student findByUsername(String username);

}
