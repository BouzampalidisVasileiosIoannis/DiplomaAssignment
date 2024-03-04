package myy803.diplomas_mgt_app_skeleton.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import myy803.diplomas_mgt_app_skeleton.model.User;

public interface UserDAO extends JpaRepository<User , Integer>{
	
	Optional<User> findByUsername(String username);

	public User findById(int id);

}
