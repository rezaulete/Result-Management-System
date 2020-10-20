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

import school.model.school.CourseExam;
import school.model.school.enumvalue.Stclass;
import school.repository.school.CourseExamRepository;
import school.repository.school.ExamRepository;
import school.services.CourseExamService;
import school.services.CourseService;

@Controller
@RequestMapping("/admincourseExam")
public class AdminCourseExamController {

	@Autowired
	CourseExamRepository courseExamRepository;
	@Autowired
	CourseExamService courseExamService;
	@Autowired
	ExamRepository examRepository;	
	@Autowired
	CourseService courseService;	


	
	
	
	@RequestMapping(value = "/courseExam/{exid}")
	public String home(Model model
			, @PathVariable("exid") Long exid) {
		model.addAttribute("exam", examRepository.findById(exid));
		return "dashboards/courseExams/index";
	}

	
	
	
	
	
	@RequestMapping(value = "/courseExam/{stclass}/{exid}")
	public String courseExam(Model model
			, @PathVariable("stclass") Stclass stclass
			, @PathVariable("exid") Long exid) {
		model.addAttribute("courseExam", courseExamService.getCourseExamByExamIdAndClass(stclass,exid));
		model.addAttribute("exam", examRepository.findById(exid));
		model.addAttribute("stclass", stclass);
		return "dashboards/courseExams/courseExam";
	}

	
	
	
	
//	@RequestMapping("/view-courseExam")
//	public String view(Model model, @RequestParam Long id) {
//		model.addAttribute("courseExam", courseExamRepository.findById(id));
//		return "dashboards/courseExams/view";
//	}

	
	
	
	
	
	
	@RequestMapping(value = "/insert/{stclass}/{exid}")
	public String insert(Model model, @PathVariable("stclass") Stclass stclass
			, @PathVariable("exid") Long exid) {
		model.addAttribute("courseExam", new CourseExam());
		model.addAttribute("exam", examRepository.findById(exid));
    	model.addAttribute("course",courseService.getCourseByStclass(stclass));   
		model.addAttribute("recent", courseExamRepository.findTop10ByOrderByIdDesc());
        model.addAttribute("stclass", stclass);
		return "dashboards/courseExams/insert";
	}



	
	
	
	
	
	@PostMapping("/save-courseExam")
	public String save(Model model, @Valid @ModelAttribute("courseExam") CourseExam courseExam, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		Stclass stclass=courseExam.getStclass();
		Long exid=courseExam.getExam().getId();
		// If there are some error...
		if (bindingResult.hasErrors()) {
			
			model.addAttribute("errorcourseExam", "Something wrong...");
			model.addAttribute("courseExam", courseExam);
			
			model.addAttribute("courseExam", new CourseExam());
			model.addAttribute("exam", examRepository.findById(exid));
	    	model.addAttribute("course",courseService.getCourseByStclass(stclass));   
			model.addAttribute("recent", courseExamRepository.findTop10ByOrderByIdDesc());
	        model.addAttribute("stclass", stclass);
			return "dashboards/courseExams/insert";
		}

		courseExamRepository.save(courseExam);
		model.addAttribute("Success", "Student successfully admitted");
		model.addAttribute("courseExam", new CourseExam());
		model.addAttribute("exam", examRepository.findById(exid));
    	model.addAttribute("course",courseService.getCourseByStclass(stclass));   
		model.addAttribute("recent", courseExamRepository.findTop10ByOrderByIdDesc());
        model.addAttribute("stclass", stclass);
		return "dashboards/courseExams/insert";
	}



	
	
	
	
	
	
	@RequestMapping("/delete-courseExam")
	public String delete(Model model, @RequestParam Long id, RedirectAttributes redirectAttributes) {
		CourseExam courseExam = courseExamRepository.findById(id);
		Stclass stclass = courseExam.getStclass();
		try {
			courseExamRepository.delete(id);

		} catch (Exception e) {
			model.addAttribute("errormessage", "Can't delete this data.");
			model.addAttribute("error", e.getMessage());
			model.addAttribute("courseExam", courseExamService.getCourseExamByClass(stclass));
			return "dashboards/courseExams/courseExam";
		}

		redirectAttributes.addAttribute("stclass", courseExam.getStclass());
		redirectAttributes.addAttribute("exid", courseExam.getExam().getId());
		return "redirect:/admincourseExam/courseExam/{stclass}/{exid}";
	}

	
	
	
	
	
	
	@RequestMapping("/edit-courseExam")
	public String edit(Model model, @RequestParam Long id) {
		CourseExam courseExam = courseExamRepository.findById(id);
		Stclass stclass = courseExam.getStclass();

		model.addAttribute("courseExam", courseExamRepository.findById(id));

    	model.addAttribute("course",courseService.getCourseByStclass(stclass));  
		model.addAttribute("recent", courseExamRepository.findByOrderByIdDesc());
		model.addAttribute("stclass", stclass);
		return "dashboards/courseExams/edit";
	}

	
	
	
	
	
	
	@PostMapping("/update-courseExam")
	public String Update(Model model, @ModelAttribute CourseExam courseExam, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		Stclass stclass = courseExam.getStclass();
		// If there are some error...
		if (bindingResult.hasErrors()) {
			model.addAttribute("errorcourseExam", "Something wrong...");
			model.addAttribute("courseExam", courseExam);
			model.addAttribute("recent", courseExamRepository.findByOrderByIdDesc());
			model.addAttribute("stclass", stclass);
			return "dashboards/courseExams/edit";
		}
		courseExamRepository.save(courseExam);
		redirectAttributes.addAttribute("stclass", courseExam.getStclass());
		redirectAttributes.addAttribute("exid", courseExam.getExam().getId());
		return "redirect:/admincourseExam/courseExam/{stclass}/{exid}";
	}

}
