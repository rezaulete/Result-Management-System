package school.repository.school;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import school.model.school.ExamResult;

public interface ExamResultRepository extends CrudRepository<ExamResult, Long>{

	public ExamResult findById(Long id);

	public List<ExamResult> findByOrderByIdDesc();
	public ExamResult findTopByOrderByIdDesc();

}
