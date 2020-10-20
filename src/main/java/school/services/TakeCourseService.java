package school.services;

import java.util.List;

import school.model.school.TakeCourse;

public interface TakeCourseService {

	public List<TakeCourse> findAll();
	public TakeCourse getTakeCourseByID(Long id);
	public List<TakeCourse> getTakeCourseByIDDesc();
	public TakeCourse getSingleTakeCourseByID();

}
