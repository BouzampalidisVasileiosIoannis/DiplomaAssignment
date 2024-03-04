package myy803.diplomas_mgt_app_skeleton.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import myy803.diplomas_mgt_app_skeleton.model.Subject;

public interface SubjectDAO extends JpaRepository<Subject , Integer>{
	
	public Subject findById(int id);

	public Subject findByTitle(String title);
	public Subject deleteById(int subject_id);

	public List<Subject> findAll();

}
