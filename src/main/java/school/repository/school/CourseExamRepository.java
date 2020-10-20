package school.repository.school;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import school.model.school.Course;
import school.model.school.CourseExam;
import school.model.school.enumvalue.Stclass;

public interface CourseExamRepository extends CrudRepository<CourseExam, Long> {

	public CourseExam findById(Long id);

	public List<CourseExam> findByOrderByIdDesc();

	public List<CourseExam> findTop10ByOrderByIdDesc();

	public CourseExam findTopByOrderByIdDesc();

	public List<CourseExam> findByStclass(Stclass stclass);

	public List<CourseExam> findByExamId(Long exid);

	public List<CourseExam> findByStclassAndExamId(Stclass stclass, Long exid);
	
	public List<CourseExam> findByCourseIn(List<Course> course);

}
