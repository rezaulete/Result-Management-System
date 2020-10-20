package school.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.model.school.TakeCourse;
import school.repository.school.TakeCourseRepository;

@Service
public class TakeCourseServiceImp implements TakeCourseService {

	@Autowired
	TakeCourseRepository takeCourseRepository;
	
	@Override
	public List<TakeCourse> findAll() {
		List<TakeCourse> takeCourse=(List<TakeCourse>) takeCourseRepository.findAll();		
		return takeCourse;
	}

	@Override
	public TakeCourse getTakeCourseByID(Long id) {
		TakeCourse takeCourse=takeCourseRepository.findById(id);
		return takeCourse;
	}

	@Override
	public List<TakeCourse> getTakeCourseByIDDesc() {
		List<TakeCourse> takeCourse=takeCourseRepository.findByOrderByIdDesc();
		return takeCourse;
	}

	@Override
	public TakeCourse getSingleTakeCourseByID() {
		TakeCourse takeCourse=takeCourseRepository.findTopByOrderByIdDesc();
		return takeCourse;
	}
	

}
