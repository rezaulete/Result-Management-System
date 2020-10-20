package school.repository.school;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import school.model.school.Exam;

public interface ExamRepository extends CrudRepository<Exam, Long> {

	public Exam findById(Long id);

	public List<Exam> findByOrderByIdDesc();

	public Exam findTopByOrderByIdDesc();
	
	

}
