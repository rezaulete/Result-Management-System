package school.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import school.model.school.Register;
import school.model.school.enumvalue.Stclass;
import school.repository.school.RegisterRepository;

@Service
public class RegisterServiceImp implements RegisterService {

	@Autowired
	RegisterRepository registerRepository;
	
	@Override
	public List<Register> findAll() {
		List<Register> register=(List<Register>) registerRepository.findAll();		
		return register;
	}

	@Override
	public Register getRegisterByID(Long id) {
		Register register=registerRepository.findById(id);
		return register;
	}

	@Override
	public List<Register> getRegisterByIDDesc(int page) {
		List<Register> register=registerRepository.findByOrderByIdDesc(new PageRequest(page,4));
		return register;
	}

	@Override
	public Register getSingleRegisterByID() {
		Register register=registerRepository.findTopByOrderByIdDesc();
		return register;
	}
	
	
	@Override
	public List<Register> getRegisterByClass(Stclass schclass,int page) {
//		List<Register> register=registerRepository.findBySchclass(schclass,new PageRequest(page,4));
		List<Register> register=registerRepository.findByStclass(schclass, new PageRequest(page,4));
		return register;
	}

	@Override
	public List<Register> getRegisterByIDDesc() {
		List<Register> register=registerRepository.findByOrderByIdDesc();
		return register;
	}

	@Override
	public List<Register> getRegisterByClass(Stclass schclass) {
		// TODO Auto-generated method stub
		List<Register> register=registerRepository.findByStclass(schclass);
		return register;
	}
}
