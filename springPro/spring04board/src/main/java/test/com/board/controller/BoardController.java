package test.com.board.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import test.com.board.model.BoardVO;
import test.com.board.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService bs;
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String insert() {
		logger.info("Welcome insert!");
		return "insert";
	}
	
	@RequestMapping(value = "/insertOK.do", method = RequestMethod.POST)
	public String insertOK(BoardVO vo) {
		logger.info("Welcome insertOK!");
		logger.info("title : "+vo.getTitle());
		logger.info("content : "+vo.getContent());
		logger.info("writer : "+vo.getWriter());
		int result = bs.insert(vo);
		if(result==1) {
			return "redirect:selectAll.do";
		}else {
			return "redirect:insert.do";
		}
	}
	
	@RequestMapping(value = "/insertOK2.do", 
			method = RequestMethod.POST)
	public String insertOK2(@RequestParam(value = "key01") String title,
			@RequestParam("key02") String content,
			@RequestParam("key03") String writer,
			@RequestParam("key04") MultipartFile multipartFile,
			HttpServletRequest request) throws IllegalStateException, IOException {
		logger.info("Welcome insertOK2!");
		logger.info("title = {}", title);
		logger.info("content = {}", content);
		logger.info("writer = {}", writer);
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		
		
		String imgName="";
		if (null != multipartFile) {
			imgName = multipartFile.getOriginalFilename();
			logger.info("OriginalFilename = {}", imgName);
			vo.setImgName(imgName);
			
			String realPath = request.getRealPath("resources/uploadimg");
			logger.info("realPath = {}", realPath);
			
			File origin_img = new File(realPath+"/"+imgName);
			multipartFile.transferTo(origin_img);

			////create thumbnail image/////////
			BufferedImage original_buffer_img = 
					ImageIO.read(origin_img);			
			BufferedImage thumb_buffer_img = 
					new BufferedImage(100, 100, BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D graphic = thumb_buffer_img.createGraphics();
			graphic.drawImage(original_buffer_img, 0, 0, 100,100, null);
			
			File thumb_file = new File(realPath+"/thumb_"+imgName);
			ImageIO.write(thumb_buffer_img, "jpg", thumb_file);
		}
		int result = bs.insert(vo);
		if(result==1) {
			return "redirect:selectAll.do";
		}else {
			return "redirect:insert.do";
		}
	}
	
	@RequestMapping(value = "/selectAll.do", method = RequestMethod.GET)
	public String selectAll(Model model) {
		logger.info("Welcome selectAll!");
		
		List<BoardVO> vos = bs.selectAll();
		
		for (BoardVO vo : vos) {
			logger.info(vo.getNum()+"");
			logger.info(vo.getTitle());
			logger.info(vo.getContent());
			logger.info(vo.getWriter());
			logger.info(vo.getImgName());
			logger.info(vo.getWdate().toString());
		}
		
		model.addAttribute("vos",vos);
		
		return "selectAll";
	}
	
	
	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public String update(Model model,BoardVO vo) {
		logger.info("Welcome update!");
		logger.info("num : "+vo.getNum());
		
		BoardVO vo2 = bs.selectOne(vo);
		logger.info(vo2.getNum()+"");
		logger.info(vo2.getTitle());
		logger.info(vo2.getContent());
		logger.info(vo2.getWriter());
		logger.info(vo2.getWdate().toString());
		
		model.addAttribute("vo2",vo2);
		
		return "update";
	}
	
	@RequestMapping(value = "/updateOK.do", method = RequestMethod.POST)
	public String updateOK(BoardVO vo) {
		logger.info("Welcome updateOK!");
		logger.info("num : "+vo.getNum());
		logger.info("title : "+vo.getTitle());
		logger.info("content : "+vo.getContent());
		logger.info("writer : "+vo.getWriter());
		int result = bs.update(vo);
		if(result==1) {
			return "redirect:selectAll.do";
		}else {
			return "redirect:update.do?num="+vo.getNum();
		}
	}
	
	@RequestMapping(value = "/deleteOK.do", method = RequestMethod.GET)
	public String deleteOK(BoardVO vo) {
		logger.info("Welcome deleteOK!");
		logger.info("num : "+vo.getNum());
		int result = bs.delete(vo);
		return "redirect:selectAll.do";
	}
	
	@RequestMapping(value = "/search.do", method = RequestMethod.GET)
	public String search(Model model,String searchKey,String searchWord) {
		logger.info("Welcome search!");
		logger.info("searchKey : "+searchKey);
		logger.info("searchWord : "+searchWord);
		
		List<BoardVO> vos = bs.search(searchKey,searchWord);
		
		model.addAttribute("vos",vos);
		
		return "selectAll";
	}
	
	
}
