package com.bitschool.mentorschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView showList() {
		
		return null;
	}
	
}
