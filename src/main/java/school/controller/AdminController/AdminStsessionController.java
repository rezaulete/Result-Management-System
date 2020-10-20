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


import school.model.school.Stsession;
import school.repository.school.StsessionRepository;
import school.services.StsessionService;

@Controller
@RequestMapping("/adminstsession")
public class AdminStsessionController {

	@Autowired
	StsessionRepository stsessionRepository;
	@Autowired
	StsessionService stsessionService;

	
	
	
	
	@RequestMapping(value = { "/", "/index" })
	public String home(Model model
			,@RequestParam (defaultValue="0") int page) {
		
		int totalpage= (stsessionService.getStsessionByIDDesc().size())/10;
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("currentpage", page);
		
		model.addAttribute("stsession", stsessionService.getStsessionByIDDesc(page));
		return "dashboards/stsession/index";
	}

	
	
	
	
	
	
	@RequestMapping("/insert")
	public String insert(Model model) {
		model.addAttribute("stsession", new Stsession());
		return "dashboards/stsession/insert";
	}
 
	
	
	
	
	
	
	@PostMapping("/save-stsession")
	public String save(Model model, @Valid @ModelAttribute("stsession") Stsession stsession,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		 
		if (bindingResult.hasErrors()) {

			model.addAttribute("errorstsession", "Something wrong...");
			model.addAttribute("stsession", stsession);
			return "dashboards/stsession/insert";
		}

		stsessionRepository.save(stsession);
		return "redirect:/adminstsession/index";
	}
 
	
	
	
	
	
	
	
	
	@RequestMapping("/delete-stsession")
	public String delete(Model model, @RequestParam Long id) {

		try {
			stsessionRepository.delete(id);

		} catch (Exception e) {
			model.addAttribute("stsession", stsessionRepository.findAll());
			model.addAttribute("errormessage", "Can't delete this data.");
			model.addAttribute("error", e.getMessage());
			return "dashboards/stsession/index";
		}
		return "redirect:/adminstsession/index";
	}

	
	
	
	
	
	
	
	
	@RequestMapping("/edit-stsession")
	public String edit(Model model, @RequestParam Long id) {
		model.addAttribute("stsession", stsessionRepository.findById(id));
		return "dashboards/stsession/edit";
	}

	
	
	
	
	
	
	
	
	
	@PostMapping("/update-stsession")
	public String Update(Model model, @ModelAttribute Stsession stsession, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

	 
		if (bindingResult.hasErrors()) {
			model.addAttribute("errorstsession", "Something wrong...");
			model.addAttribute("stsession", stsession);
			return "dashboards/stsession/edit";
		}
		stsessionRepository.save(stsession);
		return "redirect:/adminstsession/index";
	}

	
	
	
	
	
	
	
	

	@RequestMapping("/make-current/{id}")
	public String Currnet(Model model, @PathVariable("id") long id) {
		
		stsessionService.makecurrent(id);
		return "redirect:/adminstsession/index";
	}
 	
}
