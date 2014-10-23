package com.bitschool.mentorschool.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitschool.mentorschool.service.MemberService;
import com.bitschool.mentorschool.vo.MemberVO;

@Controller
public class MembershipController {
	
	@Inject
	private MemberService service;
	
	@RequestMapping(value="/check")
	public void injectionTest(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/plain");
		
		PrintWriter writer = res.getWriter();
		writer.append("service = " + service);
		service.checkLogin(null);
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String showSignUpForm() {
		return "membership/signUpForm";
		// => /WEB-INF/view/membership/signUpForm.jsp
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String register(HttpServletRequest req, HttpServletResponse res,
			@ModelAttribute MemberVO member
			) {
		
		System.out.println(member);
		
		return null;
	}
	
}
