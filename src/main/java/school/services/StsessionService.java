package school.services;

import java.util.List;

import school.model.school.Stsession;
import school.model.school.enumvalue.Epoch;

public interface StsessionService {

	public List<Stsession> findAll();
	
	public List<Stsession> findAll(int page);

	public Stsession getStsessionByID(Long id);

	public List<Stsession> getStsessionByIDDesc();
	
	public List<Stsession> getStsessionByIDDesc(int page);

	public Stsession getSingleStsessionByID();

	public List<Stsession> getContactByEpoch(Epoch epoch);
	
	
	public Void makecurrent(Long id);

}
