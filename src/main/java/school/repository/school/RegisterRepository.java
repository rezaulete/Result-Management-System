package school.repository.school;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import school.model.school.Register;
import school.model.school.Student;
import school.model.school.enumvalue.Stclass;

public interface RegisterRepository extends CrudRepository<Register, Long> {

	public Register findById(Long id);

	public List<Register> findByOrderByIdDesc(Pageable page);

	public List<Register> findByOrderByIdDesc();

	public Register findTopByOrderByIdDesc();

	public Register findTop10ByOrderByIdDesc();

	public List<Register> findByStclass(Stclass stclass, Pageable page);

	public List<Register> findByStclass(Stclass stclass);
	
	
	public List<Register> findByStudent(Student student);

	public Register findTopByStudentAndStclass(Student Student,Stclass stclass);

}
