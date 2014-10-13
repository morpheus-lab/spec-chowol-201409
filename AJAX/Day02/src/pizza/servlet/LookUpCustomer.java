package pizza.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizza.CustomerInfo;

public class LookUpCustomer extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		String addr = null;
		if ("james".equals(name)) {
			addr = CustomerInfo.james;
		} else if ("thomas".equals(name)) {
			addr = CustomerInfo.thomas;
		} else if ("edward".equals(name)) {
			addr = CustomerInfo.edward;
		} else {
			addr = "There is no record.";
		}
		
		resp.getWriter().write(addr);
	}
	
}
