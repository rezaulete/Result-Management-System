package school.services;

import java.util.List;

import school.model.school.ExamResult;

public interface ExamResultService {

	public List<ExamResult> findAll();
	public ExamResult getExamResultByID(Long id);
	public List<ExamResult> getExamResultByIDDesc();
	public ExamResult getSingleExamResultByID();

}
