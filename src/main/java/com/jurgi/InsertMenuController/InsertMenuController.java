package com.jurgi.InsertMenuController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jurgi.FileUploadService.FileUploadService;
import com.jurgi.InsertMenuModel.InsertMenuDto;
import com.jurgi.InsertMenuModel.InsertMenuInter;

@Controller
public class InsertMenuController {
	private int master_market;
	private String menu_num;
	private int menu_no, d_menu_no;
	private String menu_Img, update_menu_Img;
	
	String master_no, user_no;
	@Autowired
	FileUploadService fileUploadService;
	
	
	@Autowired
	private InsertMenuInter inter;
	
	@RequestMapping(value="insert_menu",method=RequestMethod.GET)
	public String MainMove(ServletRequest request) {
		//menu_Img = request.getParameter("menu_Img");
		return "insert_menu";
	}
	
	
	@RequestMapping(value="insert_menudata",method=RequestMethod.POST)
	public String insertmenu(InsertMenuBean bean, ServletRequest request, Model model, @RequestParam("aa") MultipartFile file) throws UnknownHostException {
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------"+file);
		
		String url = fileUploadService.restore(file);
		model.addAttribute("url", url);
		InsertMenuBean data = bean;
		data.setMarket_category(inter.InsertMenuSelectProcess(bean));
		data.setMenu_market(inter.MasterMenuSelect(bean));
		
		String count = String.valueOf(inter.CountMenuData() + 1);
		
		String str = request.getParameter("menu_Img");
		String[] menuimg = str.split("\\\\");
	
		data.setMenu_no(count);
		data.setMenu_name(request.getParameter("menu_name"));
		data.setMenu_price(request.getParameter("menu_price"));
		data.setMenu_image(menuimg[2]);
		data.setMenu_category(data.getMarket_category());
		data.setMenu_content(request.getParameter("menu_content"));

		boolean b = inter.InsertDataProcess(bean);
		
		if(b) {
			return "main_menu"; 
		}else {
			return "food";
		}

	}
	
	@RequestMapping(value="InfoUpdate",method=RequestMethod.GET)
	public String InfoUpdate(ServletRequest request) {
		return "InfoUpdate";
	}
	
	@RequestMapping(value="menugo",method=RequestMethod.GET)
	public String moving(InsertMenuBean bean, ServletRequest request) {
		master_market=Integer.parseInt(request.getParameter("master_market"));
		return "InfoUpdate";
	}
	
	
	@RequestMapping(value="InfoUpdate",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> menu(InsertMenuBean bean) {

		List<Map<String,String>> menuList = new ArrayList<Map<String,String>>();
		Map<String, String> data =null;
		List <InsertMenuBean> menulist = inter.SelectDataAllProcess(Integer.parseInt(bean.getMaster_market()));
		System.out.println(menulist);
		for(InsertMenuBean m:menulist) {
			data = new HashMap<String,String>();
			data.put("menu_no",m.getMenu_no());
			data.put("menu_name",m.getMenu_name());
			data.put("menu_price",m.getMenu_price());
			data.put("menu_image", m.getMenu_image());
			data.put("menu_market",m.getMenu_market());
			data.put("menu_category", m.getMenu_category());
			data.put("menu_content", m.getMenu_content());
			menuList.add(data);
		}
		
		Map<String,Object> menulists = new HashMap<String,Object>();
		menulists.put("menulists",menuList);
		
		return menulists;
	}
	
	@RequestMapping(value="update_menu",method=RequestMethod.GET)
	public String grooving(@RequestParam("no") String master_no) {
		menu_num=master_no;
		return "update_menu";
	}
	
	@RequestMapping(value="update_menudata",method=RequestMethod.POST)
	public String updatemenu(InsertMenuBean bean, ServletRequest request, Model model, @RequestParam("Update_menu_img") MultipartFile file) throws UnknownHostException {
		String url = fileUploadService.restore(file);
		model.addAttribute("url", url);
		
		String str = request.getParameter("update_menu_Img");
		String[] menuimg = str.split("\\\\");
		
		InsertMenuBean data = new InsertMenuBean();
		data.setMarket_category(inter.InsertMenuSelectProcess(bean));
		
		bean.setMenu_no(menu_num);
		bean.setMenu_name(request.getParameter("Update_menu_irum"));
		bean.setMenu_price(request.getParameter("Update_menu_price"));
		bean.setMenu_image(menuimg[2]);
		bean.setMenu_market(request.getParameter("Update_menu_market"));
		bean.setMenu_category(data.getMarket_category());
		bean.setMenu_content(request.getParameter("Update_menu_content"));

		
		boolean b = inter.UpdateMenuDataProcess(bean);
		
		if(b) {
			return "main_menu"; 
		}else {
			return "food";
		}

	}
	
	@RequestMapping(value="delete_menudata", method=RequestMethod.GET)
	public String delete(@RequestParam("no") String menu_no) {

		boolean b = inter.DeleteMenuDataProcess(menu_no);

		if(b) {
			return "menulist"; 
		}else {
			return "food";
		}

	}

	
}
