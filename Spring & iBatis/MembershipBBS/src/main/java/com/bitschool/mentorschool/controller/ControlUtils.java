package com.bitschool.mentorschool.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControlUtils {
	
	/**
	 * 로그인을 체크하고 로그인이 되지 않은 상태라면,
	 * 현재 요청 URI를 redirect 파라미터에 담아
	 * 로그인 페이지로 이동(리디렉트)시킨다.
	 * @param request 서블릿 요청 객체
	 * @param response 서블릿 응답 객체
	 * @return 로그인 여부를 boolean 값으로 리턴
	 * @throws IOException sendRedirect 과정에서 발생하는 IOException을 던짐.
	 */
	public static boolean authAndRedirect(
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// 로그인 체크
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("member.id") == null) {
			// 로그인 되지 않은 상태
			response.sendRedirect(request.getContextPath() + "/login?redirect="
					+ request.getRequestURI());
			return false;
		}
		return true;
	}
	
	public static boolean authAndRedirect(
			HttpServletRequest request,
			HttpServletResponse response,
			String redirectUrl) throws IOException {
		// 로그인 체크
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("member.id") == null) {
			// 로그인 되지 않은 상태
			response.sendRedirect(request.getContextPath() + "/login?redirect="
					+ redirectUrl);
			return false;
		}
		return true;
	}
	
}
