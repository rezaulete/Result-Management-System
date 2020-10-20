package school.repository.school;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import school.model.school.Stsession;
import school.model.school.enumvalue.Epoch;

public interface StsessionRepository extends CrudRepository<Stsession, Long> {

	public Stsession findById(Long id);

	public List<Stsession> findByOrderByIdDesc();

	public List<Stsession> findByOrderByIdDesc(Pageable pageable);

	public Stsession findTopByOrderByIdDesc();

	public List<Stsession> findByEpoch(Epoch epoch);

	public Stsession findTopByEpoch(Epoch epoch);

	public List<Stsession> findAll(Pageable page1);

}
