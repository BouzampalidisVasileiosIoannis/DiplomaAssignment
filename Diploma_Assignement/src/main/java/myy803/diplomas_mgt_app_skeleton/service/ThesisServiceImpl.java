package myy803.diplomas_mgt_app_skeleton.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import myy803.diplomas_mgt_app_skeleton.dao.ThesisDAO;
import myy803.diplomas_mgt_app_skeleton.model.Thesis;
import org.springframework.stereotype.Service;

@Service
public class ThesisServiceImpl implements ThesisService {

	@Autowired
	private ThesisDAO thesisDAO;
	
	
	public ThesisServiceImpl(ThesisDAO thesisDAO)
	{
		this.thesisDAO = thesisDAO;
	}

	public ThesisServiceImpl()
	{
		super();
	}
	
	
	@Override
	public void save(Thesis thesis) {
		thesisDAO.save(thesis);
		
	}

	@Override
	public List<Thesis> findAll() {
		return thesisDAO.findAll();
	}

	@Override
	public Thesis findById(int thesis_id) {
		Thesis theThesis = thesisDAO.findById(thesis_id);
		if (theThesis != null ) {
			return theThesis;
		}
		else {
			// Thesis not found
			throw new RuntimeException("Thesis id not found - " + thesis_id);
		}
	}

}
