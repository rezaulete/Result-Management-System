package school.repository.school;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import school.model.school.Stsession;
import school.model.school.Student;
import school.model.school.enumvalue.Stclass;

public interface StudentRepository extends CrudRepository<Student, Long> {

	public Student findById(Long id);

	public List<Student> findByOrderByIdDesc(Pageable page);

	public List<Student> findByOrderByIdDesc();

	public Student findTopByOrderByIdDesc();

	public List<Student> findTop5ByOrderByIdDesc();

	public List<Student> findByPresentclass(Stclass presentclass, Pageable pageable);

	public List<Student> findByPresentclass(Stclass presentclass);
	
	public List<Student> findByPresentclassAndPresentsession(Stclass presentclass,Stsession stsession);
	
	public List<Student> findByPresentsession(Stsession stsession);
	
	public List<Student> findByPresentsession(List<Stsession> stsession);

}
