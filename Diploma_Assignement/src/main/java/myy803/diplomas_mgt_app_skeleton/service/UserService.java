package myy803.diplomas_mgt_app_skeleton.service;



import org.springframework.stereotype.Service;


import myy803.diplomas_mgt_app_skeleton.model.User;

@Service
public interface UserService {
	
	public void saveUser(User user);
	
	public boolean isUserPresent(User user);
	
	public User findById(int user_id);


}
