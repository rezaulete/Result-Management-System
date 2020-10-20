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

import school.model.school.TakeCourse;
import school.model.school.enumvalue.Coursetype;
import school.model.school.enumvalue.Stclass;
import school.repository.school.RegisterRepository;
import school.repository.school.TakeCourseRepository;
import school.services.CourseService;

@Controller
@RequestMapping("/admintakeCourse")
public class AdminTakeCourseController {

	@Autowired
	TakeCourseRepository takeCourseRepository;
	@Autowired
	CourseService courseService;
	@Autowired
	RegisterRepository registerRepository;


	
	
	
	
	
	@RequestMapping(value = "/view-course/{id}")
	public String home(Model model, @PathVariable("id") long id) {
		model.addAttribute("takeCourse", takeCourseRepository.findByRegisterIdOrderByCourseIdDesc(id));
		model.addAttribute("register", registerRepository.findById(id));
		return "dashboards/takeCourses/index";
	}

	
	
	
	
	
	


	@RequestMapping(value = "/insert-course/{id}/{stclass}")
	public String insert(Model model, @PathVariable("id") long id, @PathVariable("stclass") Stclass stclass,
			TakeCourse takeCourse) {
		model.addAttribute("takeCourse", takeCourseRepository.findByRegisterId(id));
		model.addAttribute("register", registerRepository.findById(id));
		model.addAttribute("subject", courseService.getCourseByStclass(stclass));
		model.addAttribute("mandetorysubject", courseService.getCourseByClassAndType(stclass, Coursetype.Mandatory));
		model.addAttribute("optionalsubject", courseService.getCourseByClassAndType(stclass, Coursetype.Optional));
		model.addAttribute("fourthsubject", courseService.getCourseByClassAndType(stclass, Coursetype.Fourth));
		model.addAttribute("religioussubject", courseService.getCourseByClassAndType(stclass, Coursetype.Religious));
		return "dashboards/takeCourses/insert";
	}

	
	
	
	
	
	
	// Open takeCourse Insert Form
	// @RequestMapping("/insert")
	// public String insert(Model model) {
	// model.addAttribute("takeCourse",new TakeCourse());
	// model.addAttribute("Grade", Schclass.values());
	// model.addAttribute("Version", Version.values());
	// model.addAttribute("Gender", Gender.values());
	// return "dashboards/takeCourses/insert";
	// }
	//

	
	


	
	


	@PostMapping("/save-takeCourse")
	public String save(Model model, @Valid @ModelAttribute("takeCourse") TakeCourse takeCourse,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		// If there are some error...
		if (bindingResult.hasErrors()) {

			model.addAttribute("errortakeCourse", "Something wrong...");
			model.addAttribute("takeCourse", takeCourse);
			return "dashboards/takeCourses/insert";
		}
		redirectAttributes.addAttribute("takecourseid", ((TakeCourse) takeCourse).getRegister().getId());
		takeCourseRepository.save(takeCourse);
		return "redirect:/admintakeCourse/view-course/{takecourseid}";
	}



	
	
	
	
	
	
	
	@RequestMapping("/delete-takeCourse")
	public String delete(Model model, @RequestParam Long id) {

		takeCourseRepository.delete(id);
		return "redirect:/admintakeCourse/index";
	}

	
	
	
	
	
	
	@RequestMapping("/remove-takeCourse/{id}")
	public String remove(Model model, @PathVariable("id") long id, RedirectAttributes redirectAttributes) {
		TakeCourse takeCourse = takeCourseRepository.findById(id);
		takeCourseRepository.delete(id);
		redirectAttributes.addAttribute("id", takeCourse.getRegister().getId());
		return "redirect:/admintakeCourse/view-course/{id}";
	}
	
	
	
	
	
	
	

	@RequestMapping(value = "/edit-course/{id}/{stid}/{stclass}")
	public String edit(Model model, @PathVariable("id") long id, @PathVariable("stid") long stid,
			@PathVariable("stclass") Stclass stclass, TakeCourse takeCourse) {
		model.addAttribute("takeCourse", takeCourseRepository.findById(id));
		model.addAttribute("register", registerRepository.findById(stid));
		model.addAttribute("course", courseService.getCourseByStclass(stclass));
		model.addAttribute("mandetorysubject", courseService.getCourseByClassAndType(stclass, Coursetype.Mandatory));
		model.addAttribute("optionalsubject", courseService.getCourseByClassAndType(stclass, Coursetype.Optional));
		model.addAttribute("fourthsubject", courseService.getCourseByClassAndType(stclass, Coursetype.Fourth));
		model.addAttribute("religioussubject", courseService.getCourseByClassAndType(stclass, Coursetype.Religious));
		return "dashboards/takeCourses/edit";
	}

	
	
	
	// @RequestMapping("/edit/{id}")
	// public String edssit(Model model, @PathVariable Long id, Role role) {
	// model.addAttribute("role", roleRepository.findById(id));
	//
	// model.addAttribute("list", roleRepository.findAll());
	//
	// model.addAttribute("privilegelist", privilegeRepository.findAll());
	//
	// return "user/role";
	//
	
	
	
	
	
	
	
	@PostMapping("/update-takeCourse")
	public String Update(Model model, @ModelAttribute TakeCourse takeCourse, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {


		if (bindingResult.hasErrors()) {
			model.addAttribute("errortakeCourse", "Something wrong...");
			model.addAttribute("takeCourse", takeCourse);
			return "dashboards/takeCourses/edit";
		}
		redirectAttributes.addAttribute("takecourseid", ((TakeCourse) takeCourse).getRegister().getId());
		takeCourseRepository.save(takeCourse);
		return "redirect:/admintakeCourse/view-course/{takecourseid}";
	}

}
