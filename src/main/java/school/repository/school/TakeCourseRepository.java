package school.repository.school;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import school.model.school.TakeCourse;

public interface TakeCourseRepository extends CrudRepository<TakeCourse, Long> {

	public TakeCourse findById(Long id);

	public TakeCourse findByRegisterId(Long id);

	public TakeCourse findByRegisterIdOrderByCourseIdDesc(Long id);

	public List<TakeCourse> findByOrderByIdDesc();

	public TakeCourse findTopByOrderByIdDesc();

}
