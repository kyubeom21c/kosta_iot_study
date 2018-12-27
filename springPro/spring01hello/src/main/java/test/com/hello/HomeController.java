package test.com.hello;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.com.hello.model.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/","/home.do"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("name", "yangssem" );
		
		return "home";
	}
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String insert() {
		logger.info("Welcome insert!");
		
		return "insert";
	}
	
	@RequestMapping(value = "/test2.do", method = RequestMethod.GET)
	public String test2(Model model,String fname) {
		logger.debug("Welcome test2!");
		logger.debug("fname : "+fname);
		
		model.addAttribute("employee_id", 100);
		
		return "test2";
	}
	@RequestMapping(value = "/insertOK.do", method = RequestMethod.POST)
	public String insertOK(String id,String pw,String name,String tel) {
		logger.debug("Welcome insertOK!");
		logger.debug("id : "+id);
		logger.debug("pw : "+pw);
		logger.debug("name : "+name);
		logger.debug("tel : "+tel);
		
		
		return "redirect:selectAll.do";
	}
	@RequestMapping(value = "/selectAll.do", method = RequestMethod.GET)
	public String selectAll(Model model) {
		logger.debug("Welcome selectAll!");
		
		List<MemberVO> vos = new ArrayList<MemberVO>();
		for (int i = 0; i < 3; i++) {
			MemberVO vo = new MemberVO();
			vo.setNum(i);
			vo.setId("id"+i);
			vo.setPw("pw"+i);
			vo.setName("name"+i);
			vo.setTel("tel"+i);
			vos.add(vo);
		}
		
		model.addAttribute("vos",vos);
		
		return "selectAll";
	}
	
}
