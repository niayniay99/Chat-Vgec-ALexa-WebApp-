package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.HostelVO;
import com.demo.service.HostelService;

@Controller
public class HostelController {

	@Autowired
	private HostelService hostelService;

	@GetMapping(value = "admin/addHostel")
	public ModelAndView addHostel() {
		return new ModelAndView("admin/addHostel", "HostelVO", new HostelVO());
	}

	@GetMapping(value = "admin/viewHostel")
	public ModelAndView viewHostel() {
		List<HostelVO> hostelList = this.hostelService.getHostel();

		return new ModelAndView("admin/viewHostel", "hostelList", hostelList);
	}

	@PostMapping(value = "admin/saveHostel")
	public ModelAndView saveHostel(@ModelAttribute HostelVO hostelVO) {

		this.hostelService.save(hostelVO);
		return new ModelAndView("redirect:admin/viewHostel");
	}

	@GetMapping(value = "admin/deleteHostel")
	public ModelAndView deleteHostel(@RequestParam int id) {
		List<HostelVO> hostelList = this.hostelService.getHostelById(id);

		HostelVO hostelVO = hostelList.get(0);
		hostelVO.setStatus(false);

		hostelService.save(hostelVO);

		return new ModelAndView("redirect:admin/viewHostel");
	}

	@GetMapping(value = "admin/editHostel")
	public ModelAndView editHostel(@RequestParam int id) {
		List<HostelVO> hostelList = this.hostelService.getHostelById(id);
		return new ModelAndView("admin/addHostel", "HostelVO", hostelList.get(0));
	}

}
