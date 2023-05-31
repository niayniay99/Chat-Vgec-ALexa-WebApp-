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
import com.demo.model.EventtypeinfoVO;
import com.demo.service.EventtypeService;
import com.demo.service.EventtypeinfoService;

@Controller
public class EventtypeinfoController {
	@Autowired
	private EventtypeService eventtypeService;
	
	@Autowired
	private EventtypeinfoService eventtypeinfoService;
	
	@GetMapping(value = "admin/addEventtypeinfo")
	public ModelAndView addEventtypeinfo() {
		List<EventtypeVO> eventtypeList = this.eventtypeService.getEventtype();
		return new ModelAndView("admin/addEventtypeinfo","EventtypeinfoVO",new EventtypeinfoVO()).addObject("eventtypeList", eventtypeList);
	}

	@GetMapping(value = "admin/viewEventtypeinfo")
	public ModelAndView viewEventtypeinfo() {
		List<EventtypeinfoVO> eventtypeinfoList = this.eventtypeinfoService.getEventtypeinfo();
		
		return new ModelAndView("admin/viewEventtypeinfo","eventtypeinfoList",eventtypeinfoList);
	}
	
	@PostMapping(value = "admin/saveEventtypeinfo")
	public ModelAndView saveEventtypeinfo(@ModelAttribute EventtypeinfoVO eventtypeinfoVO) {
		this.eventtypeinfoService.save(eventtypeinfoVO);
		return new ModelAndView("redirect:viewEventtypeinfo");
	}

	@GetMapping(value = "admin/deleteEventtypeinfo")
	public ModelAndView deleteEventtypeinfo(@RequestParam int eventtypeinfoid) {
		List<EventtypeinfoVO> eventtypeinfoList = this.eventtypeinfoService.getEventtypeinfoById(eventtypeinfoid);

		EventtypeinfoVO eventtypeinfoVO = eventtypeinfoList.get(0);
		
		eventtypeinfoVO.setStatus(false);

		eventtypeinfoService.save(eventtypeinfoVO);

		return new ModelAndView("redirect:viewEventtypeinfo");
	}

	@GetMapping(value = "admin/editEventtypeinfo")
	public ModelAndView editEventtypeinfo(@RequestParam int eventtypeinfoid) {
		List<EventtypeinfoVO> eventtypeinfoList = this.eventtypeinfoService.getEventtypeinfoById(eventtypeinfoid);
		List<EventtypeVO> eventtypeList = this.eventtypeService.getEventtype();
		return new ModelAndView("admin/addEventtypeinfo", "EventtypeinfoVO", eventtypeinfoList.get(0)).addObject("eventtypeList", eventtypeList);
	}


}
