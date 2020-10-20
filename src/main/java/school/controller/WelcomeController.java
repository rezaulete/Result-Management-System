package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import school.services.HomeSlideService;

@Controller
@EnableAutoConfiguration
public class WelcomeController {

	@Autowired
	HomeSlideService homeSlideService;


    @RequestMapping("/")
    public String index(Model model) {
    	model.addAttribute("homeSlide", homeSlideService.getSingleHomeSlider());
        return "welcome";   
    }

    
    
}
