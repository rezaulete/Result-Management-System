package school.repository.school;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import school.model.school.Section;
import school.model.school.enumvalue.Stclass;

public interface SectionRepository extends CrudRepository<Section, Long> {

	public Section findById(Long id);

	public List<Section> findByStclass(Stclass stclass);

	public List<Section> findByOrderByIdDesc();

	public Section findTopByOrderByIdDesc();

}
