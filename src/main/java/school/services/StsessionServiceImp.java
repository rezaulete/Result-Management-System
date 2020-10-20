package school.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import school.model.school.Stsession;
import school.model.school.enumvalue.Epoch;
import school.repository.school.StsessionRepository;

@Service
public class StsessionServiceImp implements StsessionService {

	@Autowired
	StsessionRepository stsessionRepository;
	
	@Override
	public List<Stsession> findAll() {
		List<Stsession> stsession=(List<Stsession>) stsessionRepository.findAll();		
		return stsession;
	}
	
	
	@Override
	public List<Stsession> findAll(int page) {

		Pageable page1=new PageRequest(page, 10);
      	List<Stsession> stsession=stsessionRepository.findAll(page1);		
		return stsession;
	}

	@Override
	public Stsession getStsessionByID(Long id) {
		Stsession stsession=stsessionRepository.findById(id);
		return stsession;
	}


	@Override
	public Stsession getSingleStsessionByID() {
		Stsession stsession=stsessionRepository.findTopByOrderByIdDesc();
		return stsession;
	}
	
	
	@Override
	public List<Stsession> getStsessionByIDDesc() {
		List<Stsession> stsession=stsessionRepository.findByOrderByIdDesc();
		return stsession;
	}


	@Override
	public List<Stsession> getContactByEpoch(Epoch epoch) {
		List<Stsession> stsession=stsessionRepository.findByEpoch(epoch);
		return stsession;
	}

	@Override
	public Void makecurrent(Long id) {
		Stsession current1= (Stsession) stsessionRepository.findTopByEpoch(Epoch.Current);
		List<Stsession> currentall= stsessionRepository.findByEpoch(Epoch.Current);
		Stsession newcurrent=stsessionRepository.findById(id);
		
		if(!(currentall.isEmpty())) {
			Long id1=current1.getId();
			String name1=current1.getTitle();
			current1.setId(id1);
			current1.setTitle(name1);
		    current1.setEpoch(Epoch.Past);	

			stsessionRepository.save(current1);
		}
		
	    Long id2=newcurrent.getId();
		String name2=newcurrent.getTitle();
		newcurrent.setId(id2);
		newcurrent.setTitle(name2);
		newcurrent.setEpoch(Epoch.Current);
	
		
	stsessionRepository.save(newcurrent);
		return null;
	}


	@Override
	public List<Stsession> getStsessionByIDDesc(int page) {
		Pageable pageable=new PageRequest(page, 10);
      	List<Stsession> stsession=stsessionRepository.findByOrderByIdDesc(pageable);	
		return stsession;
	}


}
