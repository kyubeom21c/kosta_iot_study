package test.com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestController
 */
@WebServlet({ "/test.do", "/test2.do" ,"/selectOne.do"})
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()....");
		String sPath = request.getServletPath();
		System.out.println("sPath:"+sPath);
		
		if(sPath.equals("/test.do")) {
			RequestDispatcher rd = 
					request.getRequestDispatcher("test.jsp");
			rd.forward(request, response);
			
			
		}else if(sPath.equals("/test2.do")) {
			PrintWriter out = response.getWriter();
			out.append("[{\"num\":1,\"kor\":11,\"eng\":22,\"math\":33},");
			out.append("{\"num\":2,\"kor\":11,\"eng\":22,\"math\":33},");
			out.append("{\"num\":3,\"kor\":11,\"eng\":22,\"math\":33}]");
		
		
		}else if(sPath.equals("/selectOne.do")) {
			PrintWriter out = response.getWriter();
			String num = request.getParameter("num");
			if(num.equals("1")) {
				out.append("{\"num\":1,\"kor\":11,\"eng\":22,\"math\":33}");
			}else if(num.equals("2")) {
				out.append("{\"num\":2,\"kor\":22,\"eng\":22,\"math\":33}");
			}else if(num.equals("3")) {
				out.append("{\"num\":3,\"kor\":33,\"eng\":22,\"math\":33}");
			}
		}
		
		
	}//end doGet()

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()....");
		doGet(request, response);
	}

}
