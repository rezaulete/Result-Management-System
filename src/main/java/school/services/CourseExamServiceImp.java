package school.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.model.school.CourseExam;
import school.model.school.enumvalue.Stclass;
import school.repository.school.CourseExamRepository;

@Service
public class CourseExamServiceImp implements CourseExamService {

	@Autowired
	CourseExamRepository courseExamRepository;
	
	@Override
	public List<CourseExam> findAll() {
		List<CourseExam> courseExam=(List<CourseExam>) courseExamRepository.findAll();		
		return courseExam;
	}

	@Override
	public CourseExam getCourseExamByID(Long id) {
		CourseExam courseExam=courseExamRepository.findById(id);
		return courseExam;
	}

	@Override
	public List<CourseExam> getCourseExamByIDDesc() {
		List<CourseExam> courseExam=courseExamRepository.findByOrderByIdDesc();
		return courseExam;
	}

	@Override
	public CourseExam getSingleCourseExamByID() {
		CourseExam courseExam=courseExamRepository.findTopByOrderByIdDesc();
		return courseExam;
	}
	
	
	@Override
	public List<CourseExam> getCourseExamByClass(Stclass schclass) {
		List<CourseExam> courseExam=courseExamRepository.findByStclass(schclass);
		return courseExam;
	}

	@Override
	public List<CourseExam> getCourseExamByExamId(Long exid) {
		List<CourseExam> courseExam=courseExamRepository.findByExamId(exid);
		return courseExam;
	}

	@Override
	public List<CourseExam> getCourseExamByExamIdAndClass(Stclass schclass, Long exid) {
		List<CourseExam> courseExam=courseExamRepository.findByStclassAndExamId(schclass,exid);
		return courseExam;
	}
}
