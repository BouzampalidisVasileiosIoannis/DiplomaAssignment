package myy803.diplomas_mgt_app_skeleton.service;

import java.util.List;

import myy803.diplomas_mgt_app_skeleton.model.Subject;
import org.springframework.stereotype.Service;

@Service
public interface SubjectService {
	
	public void save(Subject subject);
	public List<Subject> findAll();
	public Subject findById(int subject_id);

	public Subject deleteById(int subject_id);
	public Subject findByTitle(String title);

}
