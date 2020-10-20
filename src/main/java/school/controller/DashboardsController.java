/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import school.model.school.enumvalue.Epoch;
import school.repository.school.StsessionRepository;
import school.services.CourseService;
import school.services.StudentService;

@Controller
@RequestMapping("/dashboards")
public class DashboardsController {
	
	@Autowired
	StudentService studentService;
	@Autowired
	StsessionRepository stsessionRepository;
	@Autowired
	CourseService courseService;
	
    
	@RequestMapping(value= {"/","/index"})
    public String index(Model model) {
        int totalstudent=studentService.findAll().size();
        int Currentstudent=studentService.getStudentByCurrentSession(stsessionRepository.findTopByEpoch(Epoch.Current)).size();
		
		model.addAttribute("totalstudent",totalstudent); 
		model.addAttribute("Currentstudent",Currentstudent); 
		model.addAttribute("Paststudent",totalstudent-Currentstudent); 
		model.addAttribute("totlacourse",courseService.findAll().size()); 
		
		
        return "dashboards/index";
    }
 
}
