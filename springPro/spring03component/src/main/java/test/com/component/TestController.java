package test.com.component;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	TestService ts;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String insert(TestVO vo) {
		logger.info("Welcome insert! ");
		
		return "insert";
	}
	@RequestMapping(value = "/insertOK.do", method = RequestMethod.POST)
	public String insertOK(TestVO vo) {
		logger.info("Welcome insertOK! ");
		logger.info("num : "+vo.getNum());
		logger.info("name : "+vo.getName());
		logger.info("age : "+vo.getAge());
		
		int result = ts.insert(vo);
		logger.info("result : "+result);
		return "redirect:selectAll.do";
	}
	@RequestMapping(value = "/updateOK.do", method = RequestMethod.POST)
	public String updateOK(TestVO vo) {
		logger.info("Welcome updateOK! ");
		logger.info("num : "+vo.getNum());
		logger.info("name : "+vo.getName());
		logger.info("age : "+vo.getAge());
		
		int result = ts.update(vo);
		logger.info("result : "+result);
		return "redirect:selectAll.do";
	}
	@RequestMapping(value = "/deleteOK.do", method = RequestMethod.GET)
	public String deleteOK(TestVO vo) {
		logger.info("Welcome deleteOK! ");
		logger.info("num : "+vo.getNum());
		logger.info("name : "+vo.getName());
		logger.info("age : "+vo.getAge());
		
		int result = ts.delete(vo);
		logger.info("result : "+result);
		return "redirect:home.do";
	}
	@RequestMapping(value = "/selectOne.do", method = RequestMethod.GET)
	public String selectOne(Model model,TestVO vo) {
		logger.info("Welcome selectOne! ");
		logger.info("num : "+vo.getNum());
		logger.info("name : "+vo.getName());
		logger.info("age : "+vo.getAge());
		
		TestVO vo2 = ts.selectOne(vo);
		logger.info("vo2 : "+vo2);
		
		model.addAttribute("vo2",vo2);
		return "selectOne";
	}
	@RequestMapping(value = "/selectAll.do", method = RequestMethod.GET)
	public String selectAll(Model model) {
		logger.info("Welcome selectAll! ");
		
		List<TestVO> vos = ts.selectAll();
		logger.info("result : "+vos);
		for (TestVO vo : vos) {
			logger.info("num : "+vo.getNum());
			logger.info("name : "+vo.getName());
			logger.info("age : "+vo.getAge());
		}
		
		model.addAttribute("vos",vos);
		return "selectAll";
	}
	
}
