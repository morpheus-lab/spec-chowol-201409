package com.bitschool.mentorschool.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitschool.mentorschool.service.BoardService;
import com.bitschool.mentorschool.vo.BoardVO;
import com.bitschool.mentorschool.vo.MemberVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView showList() {
		
		return null;
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String showWriteForm() {
		return "board/writeForm";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public void write(@ModelAttribute BoardVO board,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		boolean isSuccess = false;
		String alertMessage = null;
		
		if (!ControlUtils.authAndRedirect(request, response)) {
			return;
		}
		
		HttpSession session = request.getSession(false);
		MemberVO member = (MemberVO) session.getAttribute("member");
		String userName = member.getName();
		
		if (board == null) {
			isSuccess = false;
			alertMessage = "잘못된 접근!";
		}
		else {
			board.setWriter(userName);
			
			int writeResult = 0;
			
			try {
				writeResult = service.write(board);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (writeResult > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
				alertMessage = "게시판 모듈 오류! 글 쓰기 실패!";
			}
		}
		
		if (isSuccess) {
			response.sendRedirect(request.getContextPath() + "/board/");
		} else {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			
			PrintWriter writer = response.getWriter();
			writer.append("<!DOCTYPE html>\n");
			writer.append("<html>");
			writer.append("<head>");
			writer.append("<script type='text/javascript'>");
			writer.append("window.onload = function() { alert('" + alertMessage + "'); }");
			writer.append("</script>");
			writer.append("</head>");
			writer.append("<body>");
			writer.append("<a href='" + request.getContextPath() + "/board/'>목록으로</a>");
			writer.append("</body>");
			writer.append("</html>");
		}
	}
	
}
