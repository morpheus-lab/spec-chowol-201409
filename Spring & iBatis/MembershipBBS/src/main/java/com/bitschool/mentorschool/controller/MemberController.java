package com.bitschool.mentorschool.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginForm() {
		return "member/loginForm";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String doLogin(@ModelAttribute MemberVO member,
			@RequestParam(required=false) String saveId,
			@RequestParam(required=false) String redirect,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		MemberVO storedMember = null;
		try {
			storedMember = service.checkLogin(member);
			if (storedMember != null) {	// 로그인 성공시
				// 세션에 id와 name 저장
				HttpSession session = request.getSession();
				session.setAttribute("member.id", storedMember.getId());
				session.setAttribute("member.name", storedMember.getName());
				session.setAttribute("member", storedMember);
				
				if (saveId != null) {	// "아이디 저장" 선택시
					// 쿠키에 아이디 저장
					Cookie cookie = new Cookie("loginID", storedMember.getId());
					response.addCookie(cookie);
				} else {
					Cookie cookie = new Cookie("loginID", "");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
				if (redirect != null && !redirect.trim().equals("")) {
					response.sendRedirect(request.getContextPath() + redirect);
				} else {
					response.sendRedirect(request.getContextPath() + "/");
				}
				return null;
			}
			
			request.setAttribute("loginMessage", "로그인 실패");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("loginMessage", "로그인 처리과정에서 오류가 발생");
		}
		
		return "member/loginForm";
	}
	
	@RequestMapping("/logout")
	public void logout(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		
		response.sendRedirect(request.getContextPath() + "/");
		
	}
	
	@RequestMapping(value="/member/mypage", method=RequestMethod.GET)
	public ModelAndView showMyPage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("member.id") != null) {	// 로그인 상태
			
			return new ModelAndView("member/mypage", "member", session.getAttribute("member"));
			
		} else {	// 로그아웃 상태
			
			response.sendRedirect(request.getContextPath() + "/login?redirect=/member/mypage");
			
			return null;
			
		}
		
	}
	
}



























