package school.services;

import java.util.List;

import school.model.school.CourseExam;
import school.model.school.enumvalue.Stclass;

public interface CourseExamService {

	public List<CourseExam> findAll();
	public CourseExam getCourseExamByID(Long id);
	public List<CourseExam> getCourseExamByIDDesc();
	public CourseExam getSingleCourseExamByID();
	public List<CourseExam> getCourseExamByClass(Stclass schclass);
	public List<CourseExam> getCourseExamByExamId(Long exid);
	public List<CourseExam> getCourseExamByExamIdAndClass(Stclass schclass,Long exid);
}
