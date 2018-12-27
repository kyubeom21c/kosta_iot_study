package test.com.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(MemberInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("preHandle().....");
		String sPath = request.getServletPath();

		logger.info("sPath : " + sPath);

		HttpSession session = request.getSession();
		
		String user_id = 
				(String) session.getAttribute("user_id");
		
		logger.info("user_id : " + user_id);
		
		if(sPath.compareTo("/insert.do")==0 
				|| sPath.compareTo("/selectAll.do")==0
						|| sPath.compareTo("/update.do")==0
								|| sPath.compareTo("/deleteOK.do")==0){
			
			if(user_id==null){
				response.sendRedirect("login.do");
				return false;
			}

		}
		if(sPath.compareTo("/logout.do")==0){
			session.removeAttribute("user_id");
		}
		if(sPath.compareTo("/loginOK.do")==0){
			session.setAttribute("user_id", "yangssem");
		}
		
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("postHandle().....");
		super.postHandle(request, response, handler, modelAndView);
	}

}