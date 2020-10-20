package school.services;

import java.util.List;

import school.model.school.Stsession;
import school.model.school.Student;
import school.model.school.enumvalue.Stclass;

public interface StudentService {

	public List<Student> findAll();

	public Student getStudentByID(Long id);

	public List<Student> getStudentByIDDesc();
	
	public List<Student> getStudentByIDDesc(int page);

	public Student getSingleStudentByID();

	public List<Student> getStudentByPresentClass(Stclass stclass);
	
	public List<Student> getStudentByPresentClass(Stclass stclass, int page);
	
	public List<Student> getStudentByCurrentSession(Stsession stsession);
	
	public List<Student> getStudentByCurrentSession(List<Stsession> stsession);

}
