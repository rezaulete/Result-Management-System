package school.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.model.school.Marks;
import school.repository.school.MarksRepository;

@Service
public class MarksServiceImp implements MarksService {

	@Autowired
	MarksRepository marksRepository;
	
	@Override
	public List<Marks> findAll() {
		List<Marks> marks=(List<Marks>) marksRepository.findAll();		
		return marks;
	}

	@Override
	public Marks getMarksByID(Long id) {
		Marks marks=marksRepository.findById(id);
		return marks;
	}

	@Override
	public List<Marks> getMarksByIDDesc() {
		List<Marks> marks=marksRepository.findByOrderByIdDesc();
		return marks;
	}

	@Override
	public Marks getSingleMarksByID() {
		Marks marks=marksRepository.findTopByOrderByIdDesc();
		return marks;
	}

	@Override
	public String GradeCalculator(Double fullmark, Double passmark, Double obtainmark) {
		String grage = null;
		if (obtainmark <= fullmark && obtainmark >= fullmark*0.8) {
			
			grage="A+";
		       
		      } 
		else if (obtainmark < fullmark*0.8 && obtainmark >= fullmark*0.7) {
		       grage="A";
		      } 
		else if (obtainmark < fullmark*0.7 && obtainmark >= fullmark*0.6) {
		    	  grage="A-";
		      } 
		else if (obtainmark < fullmark*0.6 && obtainmark >= fullmark*0.5) {
		    	  grage="B";
		      } 
		else if (obtainmark < fullmark*0.5 && obtainmark >= fullmark*0.4) {
		    	  grage="C";
		      }
		else if (obtainmark < fullmark*0.5 && obtainmark >= passmark) {
	    	  grage="D";
	      }else if (obtainmark < passmark) {
	    	  grage="Fail";
	      }
		else {
			
		}
		
		return grage;
	}
	

}
