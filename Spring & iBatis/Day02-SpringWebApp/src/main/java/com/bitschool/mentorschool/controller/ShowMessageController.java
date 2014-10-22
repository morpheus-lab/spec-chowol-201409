package com.bitschool.mentorschool.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShowMessageController {
	
	@RequestMapping(value={"/showMessage.html", "/showHello"}, method={RequestMethod.GET})
	public String showMessage(HttpServletRequest req, HttpServletResponse res) {
		req.setAttribute("message", "Welcome to the Spring World~!!");
		return "showMessage";
	}
	
}
