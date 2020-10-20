package school.controller.AdminController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import school.model.school.Stsession;
import school.model.school.Student;
import school.model.school.enumvalue.Epoch;
import school.model.school.enumvalue.Stclass;
import school.repository.school.StsessionRepository;
import school.repository.school.StudentRepository;
import school.services.StudentService;


@Controller
@RequestMapping("/adminstudent")
public class AdminStudentController {

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	StudentService studentService;
	@Autowired
	StsessionRepository stsessionRepository;

	@RequestMapping(value = { "/", "/index" })
	public String home(Model model) {
		model.addAttribute("student", studentRepository.findAll());
		return "dashboards/students/index";
	}

	
	@RequestMapping(value = "/student/{stclass}")
	public String student(Model model, @PathVariable("stclass") Stclass stclass
			,@RequestParam (defaultValue="0") int page
			) {
		Pageable page1=new PageRequest(page, 10);
		int totalpage= (studentRepository.findByPresentclass(stclass).size())/10;
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("currentpage", page);
		
		model.addAttribute("student", studentRepository.findByPresentclass(stclass,page1));
		model.addAttribute("stclass", stclass);
		
		return "dashboards/students/student";
	}

	
	
	
	
	
	
	@RequestMapping("/view-student")
	public String view(Model model, @RequestParam Long id) {
		model.addAttribute("student", studentRepository.findById(id));
		return "dashboards/students/view";
	}

	
	
	
	
	
	
	@RequestMapping(value = "/insert/{stclass}")
	public String insert(Model model, @PathVariable("stclass") Stclass stclass) {
		Stsession currsession=stsessionRepository.findTopByEpoch(Epoch.Current);
		int totlastudent=studentRepository.findByPresentclass(stclass).size();
		model.addAttribute("recent", studentRepository.findByOrderByIdDesc());
        model.addAttribute("stsession", stsessionRepository.findByOrderByIdDesc());
		model.addAttribute("student", new Student());
		model.addAttribute("stclass", stclass);
		model.addAttribute("currsession", currsession);
		model.addAttribute("roll", totlastudent+1);
		return "dashboards/students/insert";
	}

	
	
	
	
	
	
	@PostMapping("/save-student")
	public String save(Model model, @Valid @ModelAttribute("student") Student student, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {

			model.addAttribute("errorstudent", "Something wrong...");
			model.addAttribute("student", student);
			return "dashboards/students/insert";
		}

		studentRepository.save(student);
		redirectAttributes.addAttribute("stclass", student.getPresentclass());
		return "redirect:/adminstudent/student/{stclass}";
	}

	
	
	
	
	
	
	
	@RequestMapping("/delete-student")
	public String delete(Model model, @RequestParam Long id, RedirectAttributes redirectAttributes) {
		Student student = studentRepository.findById(id);
		Stclass stclass = student.getPresentclass();
		try {
			studentRepository.delete(id);

		} catch (Exception e) {
			model.addAttribute("errormessage", "Can't delete this data.");
			model.addAttribute("error", e.getMessage());
			model.addAttribute("student", studentService.getStudentByPresentClass(stclass));
			return "dashboards/students/student";
		}
		model.addAttribute("success", "Data has been deleted.");
		redirectAttributes.addAttribute("stclass", student.getPresentclass());
		return "redirect:/adminstudent/student/{stclass}";
	}

	
	
	
	
	
	
	
	@RequestMapping("/edit-student")
	public String edit(Model model, @RequestParam Long id) {
		Student student = studentRepository.findById(id);
		Stclass stclass = student.getPresentclass();

		model.addAttribute("student", studentRepository.findById(id));
		model.addAttribute("recent", studentRepository.findByOrderByIdDesc());
        model.addAttribute("stsession", stsessionRepository.findByOrderByIdDesc());
		model.addAttribute("stclass", stclass);
		return "dashboards/students/edit";
	}

	
	
	
	
	
	
	@PostMapping("/update-student")
	public String Update(Model model, @ModelAttribute Student student, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		Stclass stclass = student.getPresentclass();
		if (bindingResult.hasErrors()) {
			model.addAttribute("errorstudent", "Something wrong...");
			model.addAttribute("student", student);
			model.addAttribute("recent", studentRepository.findByOrderByIdDesc());
			model.addAttribute("stclass", stclass);
			return "dashboards/students/edit";
		}
		studentRepository.save(student);
		redirectAttributes.addAttribute("stclass", student.getPresentclass());
		return "redirect:/adminstudent/student/{stclass}";
	}
	
	
	

}
