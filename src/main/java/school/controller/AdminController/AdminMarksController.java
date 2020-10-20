package school.controller.AdminController;


import java.util.List;

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
import school.model.school.CourseExam;
import school.model.school.Exam;
import school.model.school.Marks;
import school.model.school.Marksheet;
import school.model.school.Register;
import school.model.school.Student;
import school.model.school.TakeCourse;
import school.model.school.enumvalue.Stclass;
import school.repository.school.CourseExamRepository;
import school.repository.school.ExamRepository;
import school.repository.school.MarksRepository;
import school.repository.school.MarksheetRepository;
import school.repository.school.RegisterRepository;
import school.repository.school.StudentRepository;
import school.repository.school.TakeCourseRepository;
import school.services.MarksService;
import school.services.StudentService;

@Controller
@RequestMapping("/adminmarks")
public class AdminMarksController {

	@Autowired
	MarksRepository marksRepository;
	@Autowired
	MarksService marksService;
	@Autowired
	MarksheetRepository marksheetRepository;
	@Autowired
	StudentService studentService;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	TakeCourseRepository takeCourseRepository;
	@Autowired
	ExamRepository examRepository;
	@Autowired
	RegisterRepository registerRepository;
	@Autowired
	CourseExamRepository courseExamRepository;




	
	
	
	@RequestMapping(value = { "/", "/index" })
	public String home(Model model) {
		
		return "dashboards/marks/index";
	}

	
	
	
	
	
	
	@RequestMapping(value = "/exam/{stclass}")
	public String exam(Model model, @PathVariable("stclass") Stclass stclass) {
		model.addAttribute("exam", examRepository.findByOrderByIdDesc());
		model.addAttribute("stclass", stclass);
		return "dashboards/marks/exam";
	}

	
	
	
	
	
	@RequestMapping(value = "/student/{stclass}/{examid}")
	public String student(Model model
			, @PathVariable("stclass") Stclass stclass
			, @PathVariable("examid") Long examid) {
		model.addAttribute("student", studentService.getStudentByPresentClass(stclass));
		model.addAttribute("exam", examRepository.findById(examid));
		model.addAttribute("stclass", stclass);
		return "dashboards/marks/students";
	}

	
	
	
	
//	@RequestMapping(value = "/add-exam/{id}")
//	public String addexam(Model model, @PathVariable("id") long id) {
//		model.addAttribute("takeCourse", takeCourseRepository.findByStudentId(id));
//		model.addAttribute("student", studentRepository.findById(id));
//		model.addAttribute("exam", examRepository.findAll());
//		model.addAttribute("marks", new Marks());
//		return "dashboards/marks/exam";
//	}

	
	
	
	
	
	
	@RequestMapping(value = "/add-marks/{stclass}/{examid}/{stid}")
	public String addmarks(Model model
			, @PathVariable("stid") long stid
			, @PathVariable("stclass") Stclass stclass
			, @PathVariable("examid") Long examid
			) {
		Student student=studentRepository.findById(stid);
		Register register= registerRepository.findTopByStudentAndStclass(student,stclass);
		TakeCourse takeCourse=takeCourseRepository.findByRegisterId(register.getId());
		List<Course> course=takeCourse.getCourse();
		List<CourseExam> courseExam = courseExamRepository.findByCourseIn(course);
		model.addAttribute("takeCourse", takeCourseRepository.findByRegisterId(register.getId()));
		model.addAttribute("register", register);
		model.addAttribute("courseExam", courseExam);
		model.addAttribute("student", student);
		model.addAttribute("exam", examRepository.findById(examid));
		model.addAttribute("marks", new Marks());
		return "dashboards/marks/addmarks";
	}

	
	
	
//	
//	@RequestMapping(value = { "/studentsmarks" })
//	public String studentsmarks(Model model) {
//		model.addAttribute("student", studentRepository.findAll());
//		return "dashboards/marks/index";
//	}
//
//	
	
	
	
	
	
	
	
	@RequestMapping("/view-marks/{examid}/{regid}")
	public String view(Model model, @PathVariable("examid") long examid
			, @PathVariable("regid") long regid) {
		Register register = registerRepository.findById(regid);
		Exam exam = examRepository.findById(examid);
		model.addAttribute("marks", marksRepository.findByRegisterAndExam(register, exam));
		return "dashboards/marks/view";
	}

	
	
	
	
	
	
	
	// // Open marks Insert Form
	// @RequestMapping("/insert")
	// public String insert(Model model) {
	// model.addAttribute("marks",new Marks());
	// model.addAttribute("Grade", Schclass.values());
	// model.addAttribute("Version", Version.values());
	// model.addAttribute("Gender", Gender.values());
	// return "dashboards/marks/insert";
	// }



	
	
	
	
	
	@PostMapping("/save-marks")
	public String save(Model model
			, @Valid @ModelAttribute("marks") Marks marks,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		if (bindingResult.hasErrors()) {
            model.addAttribute("errormarks", "Something wrong...");
			model.addAttribute("marks", new Marks());
			model.addAttribute("marksheet", new Marksheet());
			return "dashboards/marks/addmarks";
		}
        Double written=marks.getWrittenmark();
        Double mcq=marks.getObjectivemark();
        Double lab=marks.getLabmark();
        Double obtainmark=written+mcq+lab;
		
		marks.setObtainmark(obtainmark);
	    marksRepository.save(marks);
	    
	    
	   String grade= marksService.GradeCalculator(marks.getCourseExam().getHighestmark(), marks.getCourseExam().getPassmark(), obtainmark);
	    
	    Student student=marks.getStudent();
		Register register= marks.getRegister();
		TakeCourse takeCourse=takeCourseRepository.findByRegisterId(register.getId());
		List<Course> course=takeCourse.getCourse();
		List<CourseExam> courseExam = courseExamRepository.findByCourseIn(course);
		model.addAttribute("takeCourse", takeCourseRepository.findByRegisterId(register.getId()));
		model.addAttribute("register", register);
		model.addAttribute("courseExam", courseExam);
		model.addAttribute("student", student);
		model.addAttribute("exam", marks.getExam());
		model.addAttribute("marks", new Marks());
		model.addAttribute("succcess", "Mark added succesfully.");
		model.addAttribute("grade", grade);
		return "dashboards/marks/addmarks";
	

	}

	
	
	
	
	@RequestMapping("/delete-marks")
	public String delete(Model model, @RequestParam Long id
			, RedirectAttributes redirectAttributes) {
		
		Marks marks = marksRepository.findById(id);
		marksRepository.delete(id);
		redirectAttributes.addAttribute("regid", marks.getRegister().getId());
		redirectAttributes.addAttribute("examid", marks.getExam().getId());
		return "redirect:/adminmarks/view-marks/{examid}/{regid}";
	}
	
	
	

	
	

	@RequestMapping("/edit-marks")
	public String edit(Model model, @RequestParam Long id) {
		model.addAttribute("marks", marksRepository.findById(id));

		return "dashboards/marks/edit";
	}
	
	
	
	
	
	
	

	@PostMapping("/update-marks")
	public String Update(Model model, @ModelAttribute Marks marks, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

		// If there are some error...
		if (bindingResult.hasErrors()) {
			model.addAttribute("errormarks", "Something wrong...");
			model.addAttribute("marks", marks);
			return "dashboards/markss/edit";
		}
		
		Double written=marks.getWrittenmark();
        Double mcq=marks.getObjectivemark();
        Double lab=marks.getLabmark();
        Double obtainmark=written+mcq+lab;
		marks.setObtainmark(obtainmark);
		marksRepository.save(marks);
		
		
		redirectAttributes.addAttribute("regid", marks.getRegister().getId());
		redirectAttributes.addAttribute("examid", marks.getExam().getId());
		return "redirect:/adminmarks/view-marks/{examid}/{regid}";
	}

}
