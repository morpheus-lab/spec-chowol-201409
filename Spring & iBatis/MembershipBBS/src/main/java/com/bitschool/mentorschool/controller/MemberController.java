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
public class MemberController {
	
	@Inject
	private MemberService service;
	
	@RequestMapping(value="/check")
	public void injectionTest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/plain");
		
		PrintWriter writer = res.getWriter();
		writer.append("service = " + service);
		service.checkLogin(null);
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String showSignUpForm() {
		return "member/signUpForm";
		// => /WEB-INF/view/membership/signUpForm.jsp
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String register(HttpServletRequest req, HttpServletResponse res,
			@ModelAttribute MemberVO member
			) {
		
		try {
			service.registerMember(member);
			return "member/registerSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("failMessage", e.getMessage());
			return "member/registerFailure";
		}
		
	}
	
}
