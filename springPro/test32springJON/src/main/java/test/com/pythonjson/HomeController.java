package test.com.pythonjson;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.util.JSONPObject;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	
	//연동소스
	//pythonPro/test33json_urllib_request.py
	@ResponseBody
	@RequestMapping(value = "/json_insertOK.do", method = RequestMethod.POST)
	public Map<String, Integer> json_insertOK(HttpServletRequest request) {
		logger.info("Welcome json_insertOK");
		try {
			String data = request.getReader().readLine();
			logger.info("data : "+data);
			JSONObject obj = new JSONObject(data);
			logger.info("id : "+obj.getString("id"));
			logger.info("pw : "+obj.getString("pw"));
			logger.info("name : "+obj.getString("name"));
			logger.info("tel : "+obj.getString("tel"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

		
		//int result = ms.insert(vo);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("result", 1);
		return map;
	}
	
	
	//연동소스
	//pythonPro/test33json_urllib_request.py
	@ResponseBody
	@RequestMapping(value = "/json_selectAll.do", method = RequestMethod.GET)
	public List<MemberVO> json_selectAll() {
		logger.info("Welcome json_selectAll");
		
		//List<MemberVO> vos = ms.selectAll();
		List<MemberVO> vos = new ArrayList<MemberVO>();
		MemberVO vo = new MemberVO();
		vo.setNum(99);
		vo.setId("admin");
		vo.setPw("hi123456");
		vo.setName("yangssem");
		vo.setTel("02");
		vos.add(vo);
		vos.add(vo);
		vos.add(vo);
		return vos;
	}
	
	
	
	//연동소스
	//pythonPro/test35socket_urllib.py
	//pythonPro/test35socketClient.py
	@ResponseBody
	@RequestMapping(value = "/json_sensorStatus.do", method = RequestMethod.GET)
	public SensorVO json_senorStatus(int num) {
		logger.info("Welcome json_sensorStatus...num:"+num);
		
		SensorVO vo = new SensorVO();
		vo.setNum(num);
		vo.setLed(num%2==0?"on":"off");
		return vo;
	}
	
	
	
	
	
	//연동소스
	//pythonPro/test37socket_urllib.py
	//pythonPro/test37socketClientSerial.py
	
	@ResponseBody
	@RequestMapping(value = "/json_ledStatus.do", method = RequestMethod.GET)
	public Map<String,String> json_ledStatus(int num) {
		//http://192.168.0.191:8090/pythonjson/json_ledStatus.do?num=2
		logger.info("Welcome json_ledStatus...num:"+num);
		Map<String,String> map = new HashMap<String, String>();
		if(num==1) {
			map.put("led1", "on");
			map.put("led2", "on");
		}else if(num==2) {
			map.put("led1", "on");
			map.put("led2", "off");
		}else if(num==3) {
			map.put("led1", "off");
			map.put("led2", "on");
		}else if(num==4) {
			map.put("led1", "off");
			map.put("led2", "off");
		}
		
		return map;
	}
	
}
