package school.controller.AdminController;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import school.model.school.Exam;
import school.model.school.enumvalue.Gender;
import school.model.school.enumvalue.Stclass;
import school.model.school.enumvalue.Version;
import school.repository.school.ExamRepository;

@Controller
@RequestMapping("/adminexam")
public class AdminExamController {
	
	@Autowired
	ExamRepository examRepository;	
		
	 // Open about us table 
    @RequestMapping(value= {"/","/index"})
    public String home(Model model) {
        model.addAttribute("exam",examRepository.findAll());    
        return "dashboards/exams/index";
    }
    
	@RequestMapping("/view-exam") 
	public String view(Model model,@RequestParam Long id) {        
        model.addAttribute("exam",examRepository.findById(id)); 
        return "dashboards/exams/view";
	}
	
    // Open exam Insert Form  
    @RequestMapping("/insert")
    public String insert(Model model) {
        model.addAttribute("exam",new Exam());
        model.addAttribute("Grade", Stclass.values());  
        model.addAttribute("Version", Version.values());   
        model.addAttribute("Gender", Gender.values());   
        return "dashboards/exams/insert";
    }
    
    
    // Save about us Information  
    @PostMapping("/save-exam")
    public String save(Model model,@Valid @ModelAttribute("exam") Exam exam
    		,BindingResult bindingResult
    		,RedirectAttributes redirectAttributes
    		) {
   //If there are some error...	
    if (bindingResult.hasErrors()) {			
		       
		        model.addAttribute("errorexam", "Something wrong...");
		        model.addAttribute("exam",exam);
		        return "dashboards/exams/insert";
       }	 
		    	
                examRepository.save(exam);
                return "redirect:/adminexam/index";
    }

    
    // Delete about us file by id 
	@RequestMapping("/delete-exam") 
    public String delete(Model model
    		,@RequestParam Long id) {
		 examRepository.delete(id); 
		     return "redirect:/adminexam/index";
    }
	
	
	@RequestMapping("/edit-exam") 
	public String edit(Model model,@RequestParam Long id) {        
        model.addAttribute("exam",examRepository.findById(id));
        model.addAttribute("Grade", Stclass.values());  
        model.addAttribute("Version", Version.values());   
        model.addAttribute("Gender", Gender.values()); 
        return "dashboards/exams/edit";
	}
	
	
	@PostMapping("/update-exam") 
    public String Update(Model model,@ModelAttribute Exam exam
    		, BindingResult bindingResult
    		,RedirectAttributes redirectAttributes
    		) {	

           //If there are some error...	
         if (bindingResult.hasErrors()) {	
 		        model.addAttribute("errorexam", "Something wrong...");		 
 		        model.addAttribute("exam",exam);
 		        return "dashboards/exams/edit";
        }	         		    	
                 examRepository.save(exam);
                 return "redirect:/adminexam/index";
    }
    

}
