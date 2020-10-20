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

import school.model.school.Section;
import school.model.school.enumvalue.Stclass;
import school.repository.school.SectionRepository;

@Controller
@RequestMapping("/adminsection")
public class AdminSectionController {
	
	@Autowired
	SectionRepository sectionRepository;	
		


	
	
	
    @RequestMapping(value= {"/","/index"})
    public String home(Model model) {
    	 return "dashboards/sections/index";
    }
    
    
    
    
    
    
    @RequestMapping(value="/section/{stclass}")
    public String section(Model model,@PathVariable("stclass") Stclass stclass) {
    	model.addAttribute("section",sectionRepository.findByStclass(stclass));   
        model.addAttribute("stclass", stclass);    
        return "dashboards/sections/section";
    }
    


    
    
    
    
    
    @RequestMapping("/insert/{stclass}")
    public String insert(Model model
    		,@PathVariable("stclass") Stclass stclass) {
        model.addAttribute("section",new Section());
        model.addAttribute("stclass", stclass);   
        return "dashboards/sections/insert";
    }
    
    


    
    
    
    
    
    
    
    @PostMapping("/save-section")
    public String save(Model model,@Valid @ModelAttribute("section") Section section
    		,BindingResult bindingResult
    		,RedirectAttributes redirectAttributes
    		) {

    if (bindingResult.hasErrors()) {			
		       
		        model.addAttribute("errorsection", "Something wrong...");
		        model.addAttribute("section",section);
		        return "dashboards/sections/insert";
       }	 
		    	
                sectionRepository.save(section);
                redirectAttributes.addAttribute("stclass",section.getStclass());
                return "redirect:/adminsection/section/{stclass}";
    }

    


    
    
    
    
    
    
    
	@RequestMapping("/delete-section") 
    public String delete(Model model
    		,@RequestParam Long id
    		,RedirectAttributes redirectAttributes) {
		Section section=sectionRepository.findById(id);
		      sectionRepository.delete(id); 
		      redirectAttributes.addAttribute("stclass",section.getStclass());
              return "redirect:/adminsection/section/{stclass}";
    }
	
	
	
	
	
	
	
	@RequestMapping("/edit-section") 
	public String edit(Model model,@RequestParam Long id) {        
        model.addAttribute("section",sectionRepository.findById(id)); 
        return "dashboards/sections/edit";
	}
	
	
	
	
	
	
 
	@PostMapping("/update-section") 
    public String Update(Model model,@ModelAttribute Section section
    		, BindingResult bindingResult
    		,RedirectAttributes redirectAttributes
    		) {	

    
         if (bindingResult.hasErrors()) {	
 		        model.addAttribute("errorsection", "Something wrong...");		 
 		        model.addAttribute("section",section);
 		        return "dashboards/sections/edit";
        }	         		    	
                 sectionRepository.save(section);
                 redirectAttributes.addAttribute("stclass",section.getStclass());
                 return "redirect:/adminsection/section/{stclass}";
    }
    

}
