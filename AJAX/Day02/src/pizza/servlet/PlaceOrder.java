package pizza.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PlaceOrder extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		String order = req.getParameter("order");
		String addr = req.getParameter("addr");
		
		Date orderDate = new Date();
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
		writer.write("<html>");
		writer.write("<body>");
		writer.write("<h1>주문 완료</h1>");
		writer.write("주문자: " + name + "<br/>");
		writer.write("주문내역: " + order + "<br/>");
		writer.write("배달주소: " + addr + "<br/>");
		writer.write("주문시각: " + orderDate);
		writer.write("</body>");
		writer.write("</html>");
	}
	
}
