package test.com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestController
 */
@WebServlet({ "/index.do", "/next.do", "/loginOK.do", "/info.do", "/js01var_const_let.do", "/js01var_const_let2.do",
		"/js01var_const_let3.do", "/js02id.do",
		"/js05jsonArray.do","/js05jsonObjects.do",
		"/js06Ajax.do"})
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet()...");
		String sPath = request.getServletPath();
		System.out.println("sPath:" + sPath);
		if (sPath.equals("/index.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);

		} else if (sPath.equals("/next.do")) {
			request.setAttribute("name", "yangssem");

			String msg = request.getParameter("msg");

			RequestDispatcher rd = request.getRequestDispatcher("next.jsp");
			rd.forward(request, response);

		} else if (sPath.equals("/loginOK.do")) {
			HttpSession session = request.getSession();
			session.setAttribute("user_name", "kim");

			RequestDispatcher rd = request.getRequestDispatcher("next.jsp");
			rd.forward(request, response);

		} else if (sPath.equals("/info.do")) {
			ServletContext context = request.getServletContext();
			context.setAttribute("info", "127.0.0.1");

			System.out.println(context.getRealPath("images"));

			RequestDispatcher rd = request.getRequestDispatcher("next.jsp");
			rd.forward(request, response);

		} else if (sPath.equals("/js01var_const_let.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("js01var_const_let.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/js01var_const_let2.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("js01var_const_let2.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/js01var_const_let3.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("js01var_const_let3.jsp");
			rd.forward(request, response);
		}else if (sPath.equals("/js02id.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("js02id.jsp");
			rd.forward(request, response);
		}else if (sPath.equals("/js05jsonArray.do")) {
			PrintWriter out = response.getWriter();
			out.append("[\"aaa\",\"bbb\",\"ccc\",\"ddd\"]");
		}else if (sPath.equals("/js05jsonObjects.do")) {
			PrintWriter out = response.getWriter();
			out.append("[{\"name\":\"kim\",\"age\":33},{\"name\":\"kim2\",\"age\":22}]");
		}else if (sPath.equals("/js06Ajax.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("js06Ajax.jsp");
			rd.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
