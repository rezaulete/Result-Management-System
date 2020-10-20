package school.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.model.school.ExamResult;
import school.repository.school.ExamResultRepository;

@Service
public class ExamResultServiceImp implements ExamResultService {

	@Autowired
	ExamResultRepository examResultRepository;
	
	@Override
	public List<ExamResult> findAll() {
		List<ExamResult> examResult=(List<ExamResult>) examResultRepository.findAll();		
		return examResult;
	}

	@Override
	public ExamResult getExamResultByID(Long id) {
		ExamResult examResult=examResultRepository.findById(id);
		return examResult;
	}

	@Override
	public List<ExamResult> getExamResultByIDDesc() {
		List<ExamResult> examResult=examResultRepository.findByOrderByIdDesc();
		return examResult;
	}

	@Override
	public ExamResult getSingleExamResultByID() {
		ExamResult examResult=examResultRepository.findTopByOrderByIdDesc();
		return examResult;
	}
}
