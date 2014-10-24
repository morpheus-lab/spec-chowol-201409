package com.bitschool.mentorschool.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bitschool.mentorschool.service.AdminService;
import com.bitschool.mentorschool.vo.MemberVO;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Inject
	AdminService service;
	
	@RequestMapping("/members")
	public ModelAndView showMembers(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// 로그인 여부 체크
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("member") == null) {
			response.sendRedirect(request.getContextPath() + "/login?redirect=/admin/members");
			return null;
		}
		// 관리자 여부 체크
		MemberVO loggedInMember = (MemberVO) session.getAttribute("member");
		if (loggedInMember.getLevel() < 9) {
			// 관리자가 아님
			response.sendRedirect(request.getContextPath() + "/");
			return null;
		}
		// service layer로부터 회원목록 조회
		List<MemberVO> memberList = null;
		try {
			memberList = service.getMemberList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 조회한 회원목록을 modelObject에 넣어서
		// ModelAndView 객체 리턴
		return new ModelAndView("admin/members", "members", memberList);
	}
	
}
