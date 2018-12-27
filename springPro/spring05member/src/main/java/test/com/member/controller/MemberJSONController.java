package test.com.member.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import test.com.member.model.MemberVO;
import test.com.member.service.MemberService;

@Controller
public class MemberJSONController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberJSONController.class);
	
	
	@Autowired
	private MemberService ms;
	
	@ResponseBody
	@RequestMapping(value = "/json_insertOK.do", method = RequestMethod.GET)
	public Map<String, Integer> json_insertOK(MemberVO vo) {
		logger.info("Welcome json_insertOK");
		logger.info("id : "+vo.getId());
		logger.info("pw : "+vo.getPw());
		logger.info("name : "+vo.getName());
		logger.info("tel : "+vo.getTel());
		
		int result = ms.insert(vo);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("result", result);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/json_selectAll.do", method = RequestMethod.GET)
	public List<MemberVO> json_selectAll() {
		logger.info("Welcome json_selectAll");
		
		List<MemberVO> vos = ms.selectAll();
		
		return vos;
	}
	
	@ResponseBody
	@RequestMapping(value = "/json_selectOne.do", method = RequestMethod.GET)
	public MemberVO json_selectOne(MemberVO vo) {
		logger.info("Welcome json_selectOne");
		logger.info("num : "+vo.getNum());
		
		MemberVO vo2 = ms.selectOne(vo);
		
		return vo2;
	}
	
	@ResponseBody
	@RequestMapping(value = "/json_search.do", method = RequestMethod.GET)
	public List<MemberVO> json_search(String searchKey,String searchWord) {
		logger.info("Welcome json_search");
		logger.info("searchKey : "+searchKey);
		logger.info("searchWord : "+searchWord);
		
		List<MemberVO> vos = ms.search(searchKey, searchWord);
		
		return vos;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/json_updateOK.do", method = RequestMethod.GET)
	public Map<String, Integer> json_updateOK(MemberVO vo) {
		logger.info("Welcome json_updateOK");
		logger.info("num : "+vo.getNum());
		logger.info("id : "+vo.getId());
		logger.info("pw : "+vo.getPw());
		logger.info("name : "+vo.getName());
		logger.info("tel : "+vo.getTel());
		
		int result = ms.update(vo);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("result", result);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/json_deleteOK.do", method = RequestMethod.GET)
	public Map<String, Integer> json_deleteOK(MemberVO vo) {
		logger.info("Welcome json_deleteOK");
		logger.info("num : "+vo.getNum());
		
		int result = ms.delete(vo);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("result", result);
		return map;
	}
	
}
