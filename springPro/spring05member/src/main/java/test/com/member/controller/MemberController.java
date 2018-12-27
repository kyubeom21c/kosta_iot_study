package test.com.member.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.com.member.model.MemberVO;
import test.com.member.service.MemberService;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	
	@Autowired
	private MemberService ms;
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String insert() {
		logger.info("Welcome insert");
		
		return "insert";
	}
	
	@RequestMapping(value = "/insertOK.do", method = RequestMethod.POST)
	public String insertOK(MemberVO vo) {
		logger.info("Welcome insertOK");
		logger.info("id : "+vo.getId());
		logger.info("pw : "+vo.getPw());
		logger.info("name : "+vo.getName());
		logger.info("tel : "+vo.getTel());
		
		int result = ms.insert(vo);
		
		if(result==1) {
			return "redirect:selectAll.do";
		}else {
			return "redirect:insert.do";
		}
	}
	
	
	@RequestMapping(value = "/selectAll.do", method = RequestMethod.GET)
	public String selectAll(Model model) {
		logger.info("Welcome selectAll");
		
		List<MemberVO> vos = ms.selectAll();
		model.addAttribute("vos",vos);
		
		return "selectAll";
	}
	@RequestMapping(value = "/search.do", method = RequestMethod.GET)
	public String search(Model model,String searchKey,String searchWord) {
		logger.info("Welcome search");
		logger.info("searchKey : "+searchKey);
		logger.info("searchWord : "+searchWord);
		
		List<MemberVO> vos = ms.search(searchKey, searchWord);
		model.addAttribute("vos",vos);
		
		return "selectAll";
	}
	
	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public String update(Model model,MemberVO vo) {
		logger.info("Welcome update");
		logger.info("num : "+vo.getNum());
		
		
		MemberVO vo2 = ms.selectOne(vo);
				
		model.addAttribute("vo2",vo2);
		
		return "update";
	}
	
	@RequestMapping(value = "/updateOK.do", method = RequestMethod.POST)
	public String updateOK(MemberVO vo) {
		logger.info("Welcome updateOK");
		logger.info("num : "+vo.getNum());
		logger.info("id : "+vo.getId());
		logger.info("pw : "+vo.getPw());
		logger.info("name : "+vo.getName());
		logger.info("tel : "+vo.getTel());
		
		int result = ms.update(vo);
		if(result==1) {
			return "redirect:selectAll.do";
		}else {
			return "redirect:update.do?num="+vo.getNum();
		}
		
		
	}
	
	@RequestMapping(value = "/deleteOK.do", method = RequestMethod.GET)
	public String deleteOK(MemberVO vo) {
		logger.info("Welcome deleteOK");
		logger.info("num : "+vo.getNum());
		
		ms.delete(vo);
		
		return "redirect:selectAll.do";
	}
	
}
