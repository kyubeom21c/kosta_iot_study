package test.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import test.com.model.MemberDAO;
import test.com.model.MemberDAOimpl;
import test.com.model.MemberVO;

/**
 * Servlet implementation class MemberController
 */
@WebServlet({ "/json_selectAll.do","/json_selectAll2.do","/json_selectAll3.do", "/json_selectOne.do", "/json_selectOne2.do","/json_insertOK.do" })
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet()....");
		String sPath = request.getServletPath();
		response.setContentType("text/html; charset=UTF-8");
		if (sPath.compareTo("/json_selectAll.do") == 0) {
			PrintWriter out = response.getWriter();
			
			out.append("[");
			out.append("{\"num\":1,\"id\":\"admin\",\"pw\":\"hi1234\",\"name\":\"kim\",\"tel\":\"010\"},");
			out.append("{\"num\":2,\"id\":\"admin\",\"pw\":\"hi1234\",\"name\":\"김군\",\"tel\":\"010\"}");
			out.append("]");
		}else if (sPath.compareTo("/json_selectAll2.do") == 0) {
			PrintWriter out = response.getWriter();
			MemberDAO dao = new MemberDAOimpl();
			List<MemberVO> vos = dao.selectAll();
			out.append("[");
			for (int i = 0; i < vos.size(); i++) {
				out.append("{\"num\":"+vos.get(i).getNum()+",\"id\":\""+vos.get(i).getId()+"\",\"pw\":\""+vos.get(i).getPw()+"\",\"name\":\""+vos.get(i).getName()+"\",\"tel\":\""+vos.get(i).getTel()+"\"}");
				if(i!=vos.size()-1)out.append(",");
			}
			out.append("]");
		}else if (sPath.compareTo("/json_selectAll3.do") == 0) {
			PrintWriter out = response.getWriter();
			MemberDAO dao = new MemberDAOimpl();
			List<MemberVO> vos = dao.selectAll();
			JSONArray array = new JSONArray(vos);
			out.print(array);
		} else if (sPath.compareTo("/json_selectOne.do") == 0) {
			
			MemberVO vo = new MemberVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			PrintWriter out = response.getWriter();
			MemberDAO dao = new MemberDAOimpl();
			MemberVO vo2 = dao.selectOne(vo);
			out.append("{\"num\":"+vo2.getNum()+",\"id\":\""+vo2.getId()+"\",\"pw\":\""+vo2.getPw()+"\",\"name\":\""+vo2.getName()+"\",\"tel\":\""+vo2.getTel()+"\"}");
		}else if (sPath.compareTo("/json_selectOne2.do") == 0) {
			
			MemberVO vo = new MemberVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			PrintWriter out = response.getWriter();
			MemberDAO dao = new MemberDAOimpl();
			MemberVO vo2 = dao.selectOne(vo);
			
			JSONObject obj = new JSONObject(vo2);
			out.print(obj.toString());
		}else if (sPath.compareTo("/json_insertOK.do") == 0) {
			//http://localhost:8090/web04json/json_insertOK.do?id=aaa&pw=bbb&name=ccc&tel=080
			//{"result":"successed"}
			System.out.println(request.getParameter("id"));
			System.out.println(request.getParameter("pw"));
			System.out.println(request.getParameter("name"));
			System.out.println(request.getParameter("tel"));
			
			PrintWriter out = response.getWriter();
			
			MemberDAO dao = new MemberDAOimpl();
			MemberVO vo = new MemberVO();
			vo.setId(request.getParameter("id"));
			vo.setPw(request.getParameter("pw"));
			vo.setName(request.getParameter("name"));
			vo.setTel(request.getParameter("tel"));
			int result = dao.insert(vo);
			if(result==1) {
				out.append("{\"result\":\"successed\"}");
			}else {
				out.append("{\"result\":\"failed\"}");
			}
			
		}
		//http://localhost:8090/web04json/json_updateOK.do?num=1&id=aaa&pw=bbb&name=ccc&tel=080
		//http://localhost:8090/web04json/json_deleteOK.do?num=1
		//{"result":"successed"}
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
