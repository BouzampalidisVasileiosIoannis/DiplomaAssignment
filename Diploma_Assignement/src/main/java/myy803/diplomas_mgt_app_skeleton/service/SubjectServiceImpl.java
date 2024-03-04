package myy803.diplomas_mgt_app_skeleton.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import myy803.diplomas_mgt_app_skeleton.dao.SubjectDAO;
import myy803.diplomas_mgt_app_skeleton.model.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	private SubjectDAO subjectDAO;
	
	
	public SubjectServiceImpl(SubjectDAO subjectDAO)
	{
		this.subjectDAO = subjectDAO;
	}

	public SubjectServiceImpl()
	{
		super();
	}
	
	@Override
	public void save(Subject subject) {
		subjectDAO.save(subject);
		
	}

	@Override
	public List<Subject> findAll() {
		return subjectDAO.findAll();
	}

	@Override
	public Subject findById(int subject_id) {
		Subject theSubject = subjectDAO.findById(subject_id);
		if (theSubject != null ) {
			return theSubject;
		}
		else {
			// Subject not found
			throw new RuntimeException("Subject id not found - " + subject_id);
		}
	}

	@Override
	@Transactional
	public Subject deleteById(int subject_id) {
		return subjectDAO.deleteById(subject_id);
	}

	@Override
	public Subject findByTitle(String title) {
		return subjectDAO.findByTitle(title);
	}

}
