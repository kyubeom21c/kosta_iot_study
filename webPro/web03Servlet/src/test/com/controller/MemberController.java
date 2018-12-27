package test.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.model.MemberDAO;
import test.com.model.MemberDAOimpl;
import test.com.model.MemberVO;

/**
 * Servlet implementation class MemberController
 */
@WebServlet({ "/index.do", "/insert.do","/insertOK.do" })
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()....");
		String sPath = request.getServletPath();
		System.out.println(sPath);
		if(sPath.equals("/index.do")) {
			RequestDispatcher rd = 
					request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}else if(sPath.equals("/insert.do")) {
			RequestDispatcher rd = 
					request.getRequestDispatcher("insert.jsp");
			rd.forward(request, response);
		}else if(sPath.equals("/insertOK.do")) {
			System.out.println(request.getParameter("num"));
			System.out.println(request.getParameter("id"));
			
			String num = request.getParameter("num");
			String id = request.getParameter("id");
			MemberVO vo = new MemberVO();
			vo.setNum(Integer.parseInt(num));
			vo.setId(id);
			
			MemberDAO dao = new MemberDAOimpl();
			
			int result = dao.insert(vo);
			
			if(result==1){
				System.out.println("insert successed...");
				response.sendRedirect("selectAll.do");
			}else{
				System.out.println("insert failed...");
				response.sendRedirect("insert.do");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
