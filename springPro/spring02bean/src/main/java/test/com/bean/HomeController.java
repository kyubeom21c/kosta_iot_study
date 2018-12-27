package test.com.bean;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	TestBean tb;
	
	@Autowired
	TestBean2 tb2;
	
	@Autowired
	TestBean3 tb3;
	
	@Autowired
	TestBean4 tb4;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		logger.info(tb.toString());
		logger.info(tb.name);
		
		logger.info(tb2.toString());
		logger.info(tb2.kor+"");
		logger.info(tb2.eng+"");
		logger.info(tb2.math+"");
		logger.info(tb2.tb.toString());
		logger.info(tb2.tb.name);
		
		logger.info(tb3.toString());
		logger.info(tb3.kor+"");
		logger.info(tb3.eng+"");
		logger.info(tb3.math+"");
		
		
		logger.info(tb4.toString());
		logger.info(tb4.getId());
		logger.info(tb4.getPw());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
