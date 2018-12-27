package test.com.board.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import test.com.board.model.BoardVO;
import test.com.board.service.BoardService;


@Controller
public class BoardJSONController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardJSONController.class);
	
	@Autowired
	private BoardService bs;
	
	@ResponseBody
	@RequestMapping(value = "/json_text.do", method = RequestMethod.GET)
	public String json_text() {
		logger.info("Welcome json_text!");
		return "insert";
	}
	
	@ResponseBody
	@RequestMapping(value = "/json_object.do", method = RequestMethod.GET)
	public Map<String, String> json_object() {
		logger.info("Welcome json_object!");
		Map<String, String> map = new HashMap<String, String>();
		map.put("name1", "lee1");
		map.put("name2", "lee2");
		map.put("name3", "lee3");
		map.put("name4", "lee4");
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/json_array.do", method = RequestMethod.GET)
	public List<String> json_array() {
		logger.info("Welcome json_array!");
		List<String> list = new ArrayList<String>();
		list.add("kim1");
		list.add("kim2");
		list.add("kim3");
		list.add("kim4");
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/json_arrayVO.do", method = RequestMethod.GET)
	public List<BoardVO> json_arrayVO() {
		logger.info("Welcome json_arrayVO!");
		List<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo = new BoardVO();
		vo.setNum(1);
		vo.setTitle("title");
		vo.setContent("content");
		vo.setWriter("writer");
		vo.setWdate(new Date(System.currentTimeMillis()));
		
		list.add(vo);
		list.add(vo);
		list.add(vo);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/json_selectAll.do", method = RequestMethod.GET)
	public List<BoardVO> json_selectAll() {
		logger.info("Welcome json_selectAll!");
		List<BoardVO> list = bs.selectAll();
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/json_selectOne.do", method = RequestMethod.GET)
	public BoardVO json_selectOne(BoardVO vo) {
		logger.info("Welcome json_selectOne!");
		BoardVO vo2 = bs.selectOne(vo);
		
		return vo2;
	}
	
	@ResponseBody
	@RequestMapping(value = "/json_search.do", method = RequestMethod.GET)
	public List<BoardVO> json_search(String searchKey,String searchWord) {
		logger.info("Welcome json_search!");
		List<BoardVO> vos = bs.search(searchKey, searchWord);
		
		return vos;
	}
	
	@ResponseBody
	@RequestMapping(value = "/json_insert.do", method = RequestMethod.GET)
	public Map<String, Integer> json_insert(BoardVO vo) {
		logger.info("Welcome json_insert!");
		int result = bs.insert(vo);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("result", result);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/json_update.do", method = RequestMethod.GET)
	public Map<String, Integer> json_update(BoardVO vo) {
		logger.info("Welcome json_update!");
		int result = bs.update(vo);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("result", result);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/json_delete.do", method = RequestMethod.GET)
	public Map<String, Integer> json_delete(BoardVO vo) {
		logger.info("Welcome json_delete!");
		int result = bs.delete(vo);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("result", result);
		return map;
	}
	
	
	
}
