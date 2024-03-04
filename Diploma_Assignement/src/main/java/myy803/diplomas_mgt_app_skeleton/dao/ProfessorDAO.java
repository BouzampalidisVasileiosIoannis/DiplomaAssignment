package myy803.diplomas_mgt_app_skeleton.dao;

import java.util.Optional;


import myy803.diplomas_mgt_app_skeleton.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import myy803.diplomas_mgt_app_skeleton.model.Professor;

public interface ProfessorDAO extends JpaRepository<Professor , Integer>{

	public Professor findById(int id);

	public Professor findByUsername(String username);

}
