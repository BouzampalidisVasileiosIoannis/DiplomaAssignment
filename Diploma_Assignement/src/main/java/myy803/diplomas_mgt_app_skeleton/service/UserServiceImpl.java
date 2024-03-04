package myy803.diplomas_mgt_app_skeleton.service;

import myy803.diplomas_mgt_app_skeleton.dao.ProfessorDAO;
import myy803.diplomas_mgt_app_skeleton.dao.StudentDAO;
import myy803.diplomas_mgt_app_skeleton.model.Professor;
import myy803.diplomas_mgt_app_skeleton.model.Role;
import myy803.diplomas_mgt_app_skeleton.model.Student;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import myy803.diplomas_mgt_app_skeleton.dao.UserDAO;
import myy803.diplomas_mgt_app_skeleton.model.User;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserDAO userDAO;

	@Autowired
	private StudentDAO studentDAO;

	@Autowired
	private ProfessorDAO professorDAO;

	public UserServiceImpl() {
		super();
		
	}
	@Override
	@Transactional
	public void saveUser(User user) {
		String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userDAO.save(user);
		userDAO.flush();

		if (user.getRole() == Role.STUDENT) {
			Student student = new Student(user.getUsername());
			studentDAO.save(student);
		}
		else if (user.getRole() == Role.PROFESSOR) {
			Professor professor = new Professor(user.getUsername());
			professorDAO.save(professor);
		}
	}


	@Override
	public boolean isUserPresent(User user) {
		Optional<User> storedUser = userDAO.findByUsername(user.getUsername());
		return storedUser.isPresent();

	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 return userDAO.findByUsername(username).orElseThrow(
				 ()-> new UsernameNotFoundException(
						 String.format("USER_NOT_FOUND", username)
				 ));
	}



	@Override
	public User findById(int user_id) {
		User theUser = userDAO.findById(user_id);
		if (theUser != null ) {
			return theUser;
		}
		else {
			// User not found
			throw new RuntimeException("User id not found - " + user_id);
		}
	}



}
