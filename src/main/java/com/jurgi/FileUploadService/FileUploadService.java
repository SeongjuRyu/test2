package com.jurgi.FileUploadService;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jurgi.InsertMenuModel.InsertMenuDto;
import com.jurgi.InsertMenuModel.InsertMenuInter;

@Service
public class FileUploadService {
	private static final String SAVE_PATH = "C:/upload";
	private static final String PREFIX_URL = "/upload/";

	
	public String restore(MultipartFile multipartFile) {
		String url = null;
		
		try {
			String originFilename = multipartFile.getOriginalFilename();
			String extName = originFilename.substring(originFilename.lastIndexOf("."), originFilename.length());
			Long size = multipartFile.getSize();
			
			String saveFileName = genSaveFileName(originFilename);
			
			System.out.println("originFilename : " + originFilename);
			System.out.println("extensionName : " + extName);
			System.out.println("size : " + size);
			System.out.println("saveFileName : " + saveFileName);
			
			writeFile(multipartFile, saveFileName);
			url = PREFIX_URL + saveFileName;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return url;
	}
	
	private String genSaveFileName(String originFilename) {
	      String fileName = "";
	    
	      fileName += originFilename;
	       
	      return fileName;
	   }
	   
	   
	   // 파일을 실제로 write 하는 메서드
	   private boolean writeFile(MultipartFile multipartFile, String saveFileName)throws IOException{
	      boolean result = false;

	      byte[] data = multipartFile.getBytes();
	      FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
	      fos.write(data);
	      fos.close();
	      
	      return result;
	   }
}
