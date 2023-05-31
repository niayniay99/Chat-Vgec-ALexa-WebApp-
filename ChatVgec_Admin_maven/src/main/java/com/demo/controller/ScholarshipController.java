package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.demo.model.ScholarshipVO;
import com.demo.service.ScholarshipService;

@Controller
public class ScholarshipController {
	
	@Autowired
	private ScholarshipService scholarshipService;
	
	@GetMapping(value = "admin/addScholarship")
	public ModelAndView addScholarship() {
		return new ModelAndView("admin/addScholarship", "ScholarshipVO", new ScholarshipVO());
	}
	

	@GetMapping(value = "admin/viewScholarship")
	public ModelAndView viewScholarship() {
		List<ScholarshipVO> scholarshipList = this.scholarshipService.getScholarship();

		return new ModelAndView("admin/viewScholarship", "scholarshipList", scholarshipList);
	}

	@PostMapping(value = "admin/saveScholarship")
	public ModelAndView saveScholarship(@ModelAttribute ScholarshipVO scholarshipVO) {

		this.scholarshipService.save(scholarshipVO);
		return new ModelAndView("redirect:admin/viewScholarship");
	}

	@GetMapping(value = "admin/deleteScholarship")
	public ModelAndView deleteScholarship(@RequestParam int id) {
		List<ScholarshipVO> scholarshipList = this.scholarshipService.getScholarshipById(id);

		ScholarshipVO scholarshipVO = scholarshipList.get(0);
		scholarshipVO.setStatus(false);

		scholarshipService.save(scholarshipVO);

		return new ModelAndView("redirect:admin/viewScholarship");
	}

	@GetMapping(value = "admin/editScholarship")
	public ModelAndView editScholarship(@RequestParam int id) {
		List<ScholarshipVO> scholarshipList = this.scholarshipService.getScholarshipById(id);
		return new ModelAndView("admin/addScholarship", "ScholarshipVO", scholarshipList.get(0));
	}
	
}
