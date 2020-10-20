package school.controller.AdminController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import school.model.school.Stsession;
import school.model.school.Student;
import school.model.school.enumvalue.Epoch;
import school.model.school.enumvalue.Stclass;
import school.repository.school.SectionRepository;
import school.repository.school.StsessionRepository;
import school.repository.school.StudentRepository;

@Controller
@RequestMapping("/adminadmission")
public class AdminAdmissionController {

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	SectionRepository sectionRepository;	
	@Autowired
	StsessionRepository stsessionRepository;		
	
	
	
	@RequestMapping(value = { "/", "/index" })
	public String home(Model model) {
        return "dashboards/admission/index";
	}


	
	
	@RequestMapping(value = "/insert/{stclass}")
	public String insert(Model model, @PathVariable("stclass") Stclass stclass) { 
		Stsession currsession=stsessionRepository.findTopByEpoch(Epoch.Current);
		int totlastudent=studentRepository.findByPresentclass(stclass).size();
    	model.addAttribute("recent",studentRepository.findTop5ByOrderByIdDesc()); 
    	model.addAttribute("stsession", stsessionRepository.findByOrderByIdDesc());
		model.addAttribute("student", new Student());
		model.addAttribute("stclass", stclass);
		model.addAttribute("currsession", currsession);
		model.addAttribute("roll", totlastudent+1);
		return "dashboards/admission/insert";
	}

	
	
	
	
	
	
	@PostMapping("/save-student")
	public String save(Model model, @Valid @ModelAttribute("student") Student student, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
 	Stclass stclass=student.getPresentclass();

		if (bindingResult.hasErrors()) {
     model.addAttribute("errorstudent", "Something wrong...");
		        model.addAttribute("student",student);
		    	model.addAttribute("recent",studentRepository.findByOrderByIdDesc()); 
				model.addAttribute("stclass", stclass);
		        return "dashboards/admission/insert";
		}

		studentRepository.save(student);
	 	model.addAttribute("Success", "Student successfully admitted");
    	model.addAttribute("stsession",stsessionRepository.findByOrderByIdDesc());  
    	model.addAttribute("recent",studentRepository.findTop5ByOrderByIdDesc()); 
		model.addAttribute("student", new Student());
		model.addAttribute("stclass", stclass);
		return "dashboards/admission/insert";
	}

}
