package com.jurgi.yo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jurgi.yo.model.MainMenu_CategoryDto;
import com.jurgi.yo.model.MainMenuCategoryInter;

@Controller
public class MainMenu_CategoryController {
	
	@Autowired
	MainMenuCategoryInter inter;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

	
		return "main_menu";
	}
	
	
	@RequestMapping(value="MainMenu_Category",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> category_menu(){
		List<Map<String,String>> dataList = new ArrayList<Map<String,String>>();
		Map<String, String> data =null;
		List <MainMenu_CategoryDto> categorylist = inter.SelectDataAllProcess();
		for(MainMenu_CategoryDto m:categorylist) {
			data = new HashMap<String,String>();
			data.put("category_no",m.getCategory_no());
			data.put("category_name",m.getCategory_name());
			data.put("category_num", m.getCategory_num());
			data.put("category_image",m.getCategory_image());
			data.put("category_readcent", m.getCategory_readcent());
			dataList.add(data);
		}
		Map<String,Object> categories = new HashMap<String,Object>();
		categories.put("categories",dataList);
		return categories;
	}
}
