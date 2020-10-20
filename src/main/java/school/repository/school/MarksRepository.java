package school.repository.school;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import school.model.school.Exam;
import school.model.school.Marks;
import school.model.school.Register;
import school.model.school.Student;

public interface MarksRepository extends CrudRepository<Marks, Long> {

	public Marks findById(Long id);

	public List<Marks> findByOrderByIdDesc();

	public Marks findTopByOrderByIdDesc();

	public List<Marks> findByStudentAndExam(Student student, Exam exam);

	public List<Marks> findByRegisterAndExam(Register register, Exam exam);

}
