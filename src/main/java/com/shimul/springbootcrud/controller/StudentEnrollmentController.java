package com.shimul.springbootcrud.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shimul.springbootcrud.dao.StudentDAO;
import com.shimul.springbootcrud.model.Student;

@Controller
public class StudentEnrollmentController {
	
	@Autowired
	private StudentDAO studentDao;
	
	@RequestMapping(value="/enroll",method=RequestMethod.GET)
	public String newRgistration(ModelMap model) {
		Student student=new Student();
		model.addAttribute("student", student);
		return "enroll";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveRegistration(@Valid Student student, BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			return "enroll";
		}
		studentDao.save(student);
		return "redirect:/viewstudents/1";
	}
	
	@RequestMapping(value="/viewstudents/{pageid}")
	public ModelAndView edit(@PathVariable int pageid) {
		int total=2;
		if(pageid==1) {
			
		}else {
			pageid=(pageid-1)*total+1;
		}
		
		List<Student> lists = studentDao.getStudentsByPage(pageid, total);
		return new ModelAndView("viewstudents","lists",lists);
	}
	
	@RequestMapping(value="/editsave", method=RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("student") Student p) {
		studentDao.update(p);
		return new ModelAndView("redirect:/viewstudents/1");
	}
	
	@RequestMapping(value="/deletestudent/{id}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		studentDao.delete(id);
		return new ModelAndView("redirect:/viewstudents/1");
	}
	

	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public ModelAndView delete() {
		studentDao.delete();
		return new ModelAndView("redirect:/viewstudents/1");
	}
	
	@ModelAttribute("sections")
	public List<String> initializeSections(){
		List<String> sections=new ArrayList<String>();
		sections.add("Graduate");
		sections.add("PostGraduate");
		sections.add("Research");
		return sections;
	}
	
	/* 
	 * Method used to populate the country list in view. Note that here you can call
	 * call external system to provide real data
     */
	@ModelAttribute("countries")
	public List<String> initilizeCountries(){
		List<String> countries=new ArrayList<String>();
		countries.add("Bangladesh");
		countries.add("India");
		countries.add("Pakistan");
		countries.add("Srilanka");
		countries.add("Nepal");
		countries.add("Afganstan");
		countries.add("Others");
		return countries;
		
	}
	
	
	
	/* 
	 * Method used to populate the subjects list in view. Note that here you can call
	 * call external system to provide real data
     */
	@ModelAttribute("subjects")
	public List<String> initilizeSubjects(){
		List<String> subjects=new ArrayList<String>();
		subjects.add("APECE");
		subjects.add("EEE");
		subjects.add("CSE");
		subjects.add("ETE");
		subjects.add("IT");
		subjects.add("ACCE");
		subjects.add("Others");
		return subjects;
	}
	
	/* 
	 * Method used to populate the sections list in view. Note that here you can call
	 * call external system to provide real data
     */
	@ModelAttribute("pageCount")
	public List<String> initializePageCount(){
		int total=2;
		List<String> pageCount=new ArrayList<String>();
		int count=studentDao.count();
		int result= ((count/total)+(count%total));
		for(int k=2;k<result;k++) {
			pageCount.add(new Integer(k).toString());
		}
		return pageCount;
	}
	
	
	

}
