package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.demo.model.EventtypeVO;
import com.demo.service.EventtypeService;

@Controller
public class EventtypeController {

	@Autowired
	private EventtypeService eventtypeService;
	
	@GetMapping(value = "admin/addEventtype")
	public ModelAndView addEventtype() {
		
		return new ModelAndView("admin/addEventtype", "EventtypeVO", new EventtypeVO());
	}
	
	@GetMapping(value = "admin/viewEventtype")
	public ModelAndView viewEventtype() {
		List<EventtypeVO> eventtypeList = this.eventtypeService.getEventtype();
		return new ModelAndView("admin/viewEventtype", "eventtypeList", eventtypeList);
	}

	@PostMapping(value = "admin/saveEventtype")
	public ModelAndView saveEventtype(@ModelAttribute EventtypeVO eventtypeVO) {
		this.eventtypeService.save(eventtypeVO);
		return new ModelAndView("redirect:viewEventtype");
	}
	
	@GetMapping(value = "admin/deleteEventtype")
	public ModelAndView deleteEventtype(@RequestParam int id) {
		List<EventtypeVO> eventtypeList = this.eventtypeService.getEventtypeById(id);

		EventtypeVO eventtypeVO = eventtypeList.get(0);
		eventtypeVO.setStatus(false);

		eventtypeService.save(eventtypeVO);

		return new ModelAndView("redirect:viewEventtype");
	}
	
	@GetMapping(value = "admin/editEventtype")
	public ModelAndView editEventtype(@RequestParam int id) {
		List<EventtypeVO> eventtypeList = this.eventtypeService.getEventtypeById(id);
		return new ModelAndView("admin/addEventtype", "EventtypeVO", eventtypeList.get(0));
	}

		
}
