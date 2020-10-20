package school.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import school.model.school.Stsession;
import school.model.school.Student;
import school.model.school.enumvalue.Stclass;
import school.repository.school.StudentRepository;

@Service
public class StudentServiceImp implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public List<Student> findAll() {
		List<Student> student=(List<Student>) studentRepository.findAll();		
		return student;
	}

	@Override
	public Student getStudentByID(Long id) {
		Student student=studentRepository.findById(id);
		return student;
	}

	@Override
	public List<Student> getStudentByIDDesc(int page) {
		List<Student> student=studentRepository.findByOrderByIdDesc(new PageRequest(page,4));
		return student;
	}

	@Override
	public Student getSingleStudentByID() {
		Student student=studentRepository.findTopByOrderByIdDesc();
		return student;
	}
	
	
	@Override
	public List<Student> getStudentByPresentClass(Stclass stclass,int page) {
//		List<Student> student=studentRepository.findBySchclass(stclass,new PageRequest(page,4));
		List<Student> student=studentRepository.findByPresentclass(stclass, new PageRequest(page,4));
		return student;
	}

	@Override
	public List<Student> getStudentByIDDesc() {
		List<Student> student=studentRepository.findByOrderByIdDesc();
		return student;
	}

	@Override
	public List<Student> getStudentByPresentClass(Stclass stclass) {
		// TODO Auto-generated method stub
		List<Student> student=studentRepository.findByPresentclass(stclass);
		return student;
	}

	@Override
	public List<Student> getStudentByCurrentSession(Stsession stsession) {
		
				List<Student> student=studentRepository.findByPresentsession(stsession);
				return student;
	}
	
	
	@Override
	public List<Student> getStudentByCurrentSession(List<Stsession> stsession) {
		
				List<Student> student=studentRepository.findByPresentsession(stsession);
				return student;
	}
}
