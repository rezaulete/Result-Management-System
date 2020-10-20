package school.services;

import java.util.List;

import school.model.school.Course;
import school.model.school.enumvalue.Coursetype;
import school.model.school.enumvalue.Stclass;

public interface CourseService {

	public List<Course> findAll();
	public Course getCourseByID(Long id);
	public List<Course> getCourseByIDDesc();
	public Course getSingleCourseByID();
	public List<Course> getCourseByStclass(Stclass stclass);
	public List<Course> getCourseByClassAndType(Stclass stclass,Coursetype coursetype);

}
