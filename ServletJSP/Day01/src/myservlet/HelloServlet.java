package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		System.out.println("HelloServlet.init() 메서드 호출~!!");
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		// 한글 처리
		response.setCharacterEncoding("UTF-8");
		
		// GET 요청 담당하는 부분
		PrintWriter writer = response.getWriter();
		writer.write("<html>");
		writer.write("<head>");
		writer.write("<title>GET 요청 처리</title>");
		writer.write("</head>");
		writer.write("<body>");
		writer.write("GET 요청을 받아 응답합니다.");
		writer.write("</body>");
		writer.write("</html>");
		writer.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		// 한글 처리
		response.setCharacterEncoding("UTF-8");
		
		// POST 요청 담당하는 부분
		PrintWriter writer = response.getWriter();
		writer.write("<html>");
		writer.write("<head>");
		writer.write("<title>POST 요청 처리</title>");
		writer.write("</head>");
		writer.write("<body>");
		writer.write("POST 요청을 받아 응답합니다.");
		writer.write("</body>");
		writer.write("</html>");
		writer.flush();
	}

}
