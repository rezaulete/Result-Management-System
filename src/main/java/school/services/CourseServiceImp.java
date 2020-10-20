package school.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.model.school.Course;
import school.model.school.enumvalue.Coursetype;
import school.model.school.enumvalue.Stclass;
import school.repository.school.CourseRepository;

@Service
public class CourseServiceImp implements CourseService {

	@Autowired
	CourseRepository courseRepository;
	
	@Override
	public List<Course> findAll() {
		List<Course> course=(List<Course>) courseRepository.findAll();		
		return course;
	}

	@Override
	public Course getCourseByID(Long id) {
		Course course=courseRepository.findById(id);
		return course;
	}

	@Override
	public List<Course> getCourseByIDDesc() {
		List<Course> course=courseRepository.findByOrderByIdDesc();
		return course;
	}

	@Override
	public Course getSingleCourseByID() {
		Course course=courseRepository.findTopByOrderByIdDesc();
		return course;
	}
	
	
	@Override
	public List<Course> getCourseByStclass(Stclass stclass) {
		List<Course> course=courseRepository.findByStclass(stclass);
		return course;
	}

	@Override
	public List<Course> getCourseByClassAndType(Stclass stclass, Coursetype coursetype) {
		List<Course> course=courseRepository.findByStclassAndCoursetype(stclass, coursetype);
		return course;
	}
}
