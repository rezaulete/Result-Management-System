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

import school.model.school.Course;
import school.model.school.enumvalue.Stclass;
import school.repository.school.CourseRepository;
import school.services.CourseService;

@Controller
@RequestMapping("/admincourse")
public class AdminCourseController {
	
	@Autowired
	CourseRepository courseRepository;	
	@Autowired
	CourseService courseService;
	 // Open about us table 
    @RequestMapping(value= {"/","/index"})
    public String home(Model model) {
        model.addAttribute("course",courseRepository.findAll());    
        return "dashboards/courses/index";
    }
    
    @RequestMapping(value="/course/{stclass}")
    public String course(Model model,@PathVariable("stclass") Stclass stclass) {
    	model.addAttribute("course",courseService.getCourseByStclass(stclass));   
        model.addAttribute("stclass", stclass);    
        return "dashboards/courses/course";
    }
    
    // Open course Insert Form  
    @RequestMapping("/insert/{stclass}")
    public String insert(Model model
    		,@PathVariable("stclass") Stclass stclass) {
        model.addAttribute("course",new Course());
        model.addAttribute("stclass", stclass);   
        return "dashboards/courses/insert";
    }
    
    
    // Save about us Information  
    @PostMapping("/save-course")
    public String save(Model model,@Valid @ModelAttribute("course") Course course
    		,BindingResult bindingResult
    		,RedirectAttributes redirectAttributes
    		) {
   //If there are some error...	
    if (bindingResult.hasErrors()) {			
		       
		        model.addAttribute("errorcourse", "Something wrong...");
		        model.addAttribute("course",course);
		        return "dashboards/courses/insert";
       }	 
		    	
                courseRepository.save(course);
                redirectAttributes.addAttribute("stclass",course.getStclass());
                return "redirect:/admincourse/course/{stclass}";
    }

    
    // Delete about us file by id 
	@RequestMapping("/delete-course") 
    public String delete(Model model
    		,@RequestParam Long id
    		,RedirectAttributes redirectAttributes) {
		 Course course=courseRepository.findById(id);
		 courseRepository.delete(id); 
		 redirectAttributes.addAttribute("stclass",course.getStclass());
         return "redirect:/admincourse/course/{stclass}";
    }
	
	
	@RequestMapping("/edit-course") 
	public String edit(Model model,@RequestParam Long id) {        
        model.addAttribute("course",courseRepository.findById(id));
        return "dashboards/courses/edit";
	}
	
	
	@PostMapping("/update-course") 
    public String Update(Model model,@ModelAttribute Course course
    		, BindingResult bindingResult
    		,RedirectAttributes redirectAttributes
    		) {	

           //If there are some error...	
         if (bindingResult.hasErrors()) {	
 		        model.addAttribute("errorcourse", "Something wrong...");		 
 		        model.addAttribute("course",course);
 		        return "dashboards/courses/edit";
        }	         		    	
                 courseRepository.save(course);
                 redirectAttributes.addAttribute("stclass",course.getStclass());
                 return "redirect:/admincourse/course/{stclass}";
    }
    
	@RequestMapping("/copy-course") 
	public String copy(Model model,@RequestParam Long id) {        
        model.addAttribute("course",courseRepository.findById(id));
        return "dashboards/courses/copy";
	}
	
	
	@PostMapping("/paste-course") 
    public String paste(Model model,@ModelAttribute Course course
    		, BindingResult bindingResult
    		,RedirectAttributes redirectAttributes
    		) {	

           //If there are some error...	
         if (bindingResult.hasErrors()) {	
 		        model.addAttribute("errorcourse", "Something wrong...");		 
 		        model.addAttribute("course",course);
 		        return "dashboards/courses/edit";
        }	         		    	
                 courseRepository.save(course);
                 redirectAttributes.addAttribute("stclass",course.getStclass());
                 return "redirect:/admincourse/course/{stclass}";
    }
}
