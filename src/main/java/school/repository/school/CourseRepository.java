package school.repository.school;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import school.model.school.Course;
import school.model.school.enumvalue.Coursetype;
import school.model.school.enumvalue.Stclass;
public interface CourseRepository extends CrudRepository<Course, Long>{

	public Course findById(Long id);
	public List<Course> findByOrderByIdDesc();
	public Course findTopByOrderByIdDesc();
	public List<Course> findByStclass(Stclass stclass);
	public List<Course> findByStclassAndCoursetype(Stclass stclass, Coursetype coursetype);

}
