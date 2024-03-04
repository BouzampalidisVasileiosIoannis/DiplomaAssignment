package myy803.diplomas_mgt_app_skeleton.service;

import java.util.List;

import myy803.diplomas_mgt_app_skeleton.model.Thesis;
import org.springframework.stereotype.Service;

@Service
public interface ThesisService {
	
	public void save(Thesis thesis);
	public List<Thesis> findAll();
	public Thesis findById(int thesis_id);

}
