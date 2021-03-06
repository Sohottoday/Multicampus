package my.spring.springedu;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vo.FileVO;
@Controller
public class UploadController1 {
	@RequestMapping("/uploadForm1")
	public void formFile() {	   
	}
	@RequestMapping("/upload")
	public ModelAndView saveFile(FileVO vo) {	//modelattribute를 쓰지 않았으므로 fileVO를 알아서 찾아간다.	    
	     String fileName =  vo.getUploadFile().getOriginalFilename();
	     byte[] content = null;
	     ModelAndView mav = new ModelAndView();
	     mav.setViewName("uploadForm1");
	     try {
	    	 content =  vo.getUploadFile().getBytes();
	    	 File f = new File("c:/uploadtest/"+fileName);
	    	 if ( f.exists() ) {
	    		 mav.addObject("msg", fileName + " : 파일이 이미 존재해요!!");
	    	 } else {
	    		 FileOutputStream fos = new FileOutputStream(f);
	    		 fos.write(content);
	    		 fos.close();
	    		 mav.addObject("msg", fileName + ": 파일이 저장되었어요!!");
	    	 }
	     } catch (IOException e) {
	    	 e.printStackTrace();
	    	 mav.addObject("msg", "오류가 발생했어요!!");
	     }	    
	    return mav;
	}
}

