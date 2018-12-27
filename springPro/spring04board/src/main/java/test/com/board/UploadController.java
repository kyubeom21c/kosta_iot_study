package test.com.board;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UploadController {
	
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/uploadForm.do", method = RequestMethod.GET)
	public String uploadForm() {
		logger.info("Welcome uploadForm!");
		
		return "uploadForm";
	}
	@RequestMapping(value = "/uploadImageView.do", method = RequestMethod.GET)
	public String uploadImageView() {
		logger.info("Welcome uploadImageView!");
		
		
		
		return "uploadImageView";
	}
	
	@RequestMapping(value = "/uploadOK.do", 
			method = RequestMethod.POST)
	public String uploadOK(@RequestParam(value = "key01") String name,
			@RequestParam("key02") String tel,
			@RequestParam("key03") MultipartFile multipartFile,
			HttpServletRequest request) throws IllegalStateException, IOException {
		logger.info("Welcome uploadOK!");
		logger.info("name = {}", name);
		logger.info("tel = {}", tel);
		String imgName="";
		if (null != multipartFile) {
			imgName = multipartFile.getOriginalFilename();
			logger.info("OriginalFilename = {}", imgName);
			
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
		
		return "redirect:uploadImageView.do?img="+imgName;
	}
	
	
}
