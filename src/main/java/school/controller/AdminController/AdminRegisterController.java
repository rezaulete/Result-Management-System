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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import school.model.school.Register;
import school.model.school.Student;
import school.model.school.enumvalue.Epoch;
import school.model.school.enumvalue.Stclass;
import school.repository.school.RegisterRepository;
import school.repository.school.SectionRepository;
import school.repository.school.StsessionRepository;
import school.repository.school.StudentRepository;
import school.services.RegisterService;
import school.services.StudentService;

@Controller
@RequestMapping("/adminregister")
public class AdminRegisterController {

	@Autowired
	RegisterRepository registerRepository;
	@Autowired
	RegisterService registerService;
	@Autowired
	StsessionRepository stsessionRepository;
	@Autowired
	SectionRepository sectionRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	StudentService studentService;

	
	
	
	
	@RequestMapping(value = "/index/{id}")
	public String home(Model model, @PathVariable("id") long id) {
		Student student=studentRepository.findById(id);
		model.addAttribute("register", registerRepository.findByStudent(student));
		model.addAttribute("student", student);
		return "dashboards/registration/index";
	}
	
	
	
//
//	@RequestMapping(value = "/register/{id}")
//	public String register(Model model, @PathVariable("id") long id) {
//		model.addAttribute("register", new Register());
//		model.addAttribute("student", studentRepository.findById(id));
//		return "dashboards/registers/register";
//	}

//	@RequestMapping("/view-register")
//	public String view(Model model, @RequestParam Long id) {
//		model.addAttribute("register", registerRepository.findById(id));
//		return "dashboards/registers/view";
//	}

	
	
	
	
	
	@RequestMapping(value = "/insert/{id}/{stclass}")
	public String insert(Model model
			, @PathVariable("id") long id
			, @PathVariable("stclass") Stclass stclass) {
		model.addAttribute("section", sectionRepository.findByStclass(stclass));
		model.addAttribute("currsession", stsessionRepository.findTopByEpoch(Epoch.Current));
		model.addAttribute("stsession", stsessionRepository.findByOrderByIdDesc());
		model.addAttribute("register", new Register());
		model.addAttribute("student", studentRepository.findById(id));
	    model.addAttribute("stclass", stclass);
		return "dashboards/registration/insert";
	}

	
	
	
	
	
	
	
	@PostMapping("/save-register")
	public String save(Model model, @Valid @ModelAttribute("register") Register register, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		// If there are some error...
		if (bindingResult.hasErrors()) {

			model.addAttribute("errorregister", "Something wrong...");
			model.addAttribute("register", register);
			return "dashboards/registration/insert";
		}

		registerRepository.save(register);
		redirectAttributes.addAttribute("stclass", register.getStclass());
		redirectAttributes.addAttribute("id", register.getStudent().getId());
		return "redirect:/adminregister/index/{id}";
	}

	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/delete-register")
	public String delete(Model model, @RequestParam Long id, RedirectAttributes redirectAttributes) {
		Register register = registerRepository.findById(id);
		Stclass stclass = register.getStclass();
		try {
			registerRepository.delete(id);

		} catch (Exception e) {
			model.addAttribute("stsession", stsessionRepository.findAll());
			model.addAttribute("errormessage", "Can't delete this data.");
			model.addAttribute("error", e.getMessage());
			model.addAttribute("register", registerService.getRegisterByClass(stclass));
			return "dashboards/registration/register";
		}

		redirectAttributes.addAttribute("stclass", register.getStclass());
		redirectAttributes.addAttribute("id", register.getStudent().getId());
		return "redirect:/adminregister/index/{id}";
	}

	
	
	
	
	
	
	
	
	
	@RequestMapping("/edit-register")
	public String edit(Model model, @RequestParam Long id) {
		Register register = registerRepository.findById(id);
		Stclass stclass = register.getStclass();

		model.addAttribute("register", registerRepository.findById(id));
		model.addAttribute("section", sectionRepository.findByStclass(stclass));
		model.addAttribute("stsession", stsessionRepository.findByOrderByIdDesc());
		model.addAttribute("recent", registerRepository.findByOrderByIdDesc());
		model.addAttribute("stclass", stclass);
		return "dashboards/registration/edit";
	}

	@PostMapping("/update-register")
	public String Update(Model model, @ModelAttribute Register register, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		Stclass stclass = register.getStclass();
		// If there are some error...
		if (bindingResult.hasErrors()) {
			model.addAttribute("errorregister", "Something wrong...");
			model.addAttribute("register", register);
			model.addAttribute("section", sectionRepository.findByStclass(stclass));
			model.addAttribute("stsession", stsessionRepository.findByOrderByIdDesc());
			model.addAttribute("recent", registerRepository.findByOrderByIdDesc());
			model.addAttribute("stclass", stclass);
			return "dashboards/registration/edit";
		}
		registerRepository.save(register);
		redirectAttributes.addAttribute("stclass", register.getStclass());
		redirectAttributes.addAttribute("id", register.getStudent().getId());
		return "redirect:/adminregister/index/{id}";
	}

}
