package test.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.model.TestDAO;
import test.com.model.TestDAOimpl;
import test.com.model.TestVO;

/**
 * Servlet implementation class TestController
 */
@WebServlet({ "/index.do", "/insert.do", "/insertOK.do", "/update.do", "/updateOK.do", "/deleteOK.do",
		"/selectAll.do" })
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
		System.out.println("doGet()....");

		String sPath = request.getServletPath();
		System.out.println("sPath:"+sPath);
		if (sPath.equals("/index.do")) {
			RequestDispatcher rd = 
					request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}else if(sPath.equals("/insert.do")) {
			RequestDispatcher rd = 
					request.getRequestDispatcher("test/insert.jsp");
			rd.forward(request, response);
		}else if(sPath.equals("/insertOK.do")) {
			TestDAO dao = new TestDAOimpl();
			TestVO vo = new TestVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			vo.setId(request.getParameter("id"));
			int result = dao.insert(vo);
			if(result==1) {
				System.out.println("successed..");
				response.sendRedirect("selectAll.do");
			}else {
				System.out.println("failed..");
				response.sendRedirect("insert.do");
			}
		}else if(sPath.equals("/selectAll.do")) {
			TestDAO dao = new TestDAOimpl();
			List<TestVO> vos = dao.selectAll();
			for (TestVO vo : vos) {
				System.out.print(vo.getNum()+" ");
				System.out.println(vo.getId());
			}
			request.setAttribute("vos", vos);
			RequestDispatcher rd = 
					request.getRequestDispatcher("test/selectAll.jsp");
			rd.forward(request, response);
		}else if(sPath.equals("/update.do")) {
			
			TestDAO dao = new TestDAOimpl();
			TestVO vo = new TestVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			
			TestVO vo2 = dao.selectOne(vo);
			System.out.print(vo2.getNum()+" ");
			System.out.println(vo2.getId());
			
			request.setAttribute("vo2", vo2);
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("test/update.jsp");
			rd.forward(request, response);
		}else if(sPath.equals("/updateOK.do")) {
			TestDAO dao = new TestDAOimpl();
			TestVO vo = new TestVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			vo.setId(request.getParameter("id"));
			int result = dao.update(vo);
			if(result==1) {
				System.out.println("successed..");
				response.sendRedirect("selectAll.do");
			}else {
				System.out.println("failed..");
				response.sendRedirect("update.do");
			}
		}else if(sPath.equals("/deleteOK.do")) {
			TestDAO dao = new TestDAOimpl();
			TestVO vo = new TestVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			int result = dao.delete(vo);
			if(result==1) {
				System.out.println("successed..");
				response.sendRedirect("selectAll.do");
			}else {
				System.out.println("failed..");
				response.sendRedirect("selectAll.do");
			}
		}
		
		
		
	}//end doGet()...

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost()...");
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
