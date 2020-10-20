package school.services;

import java.util.List;


import school.model.school.Register;
import school.model.school.enumvalue.Stclass;

public interface RegisterService {

	public List<Register> findAll();

	public Register getRegisterByID(Long id);

	public List<Register> getRegisterByIDDesc();
	
	public List<Register> getRegisterByIDDesc(int page);

	public Register getSingleRegisterByID();

	public List<Register> getRegisterByClass(Stclass schclass);
	
	public List<Register> getRegisterByClass(Stclass schclass, int page);

}
