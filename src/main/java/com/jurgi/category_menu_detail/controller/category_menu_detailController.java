package com.jurgi.category_menu_detail.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.jurgi.category_menu_detail.model.category_menu_detailInter;


@Controller
public class category_menu_detailController {

	private String value;
	
	@Autowired
	private category_menu_detailInter inter;
	
	@RequestMapping(value="test1",method=RequestMethod.GET)
	public ModelAndView ss2(@RequestParam(value="str1",required=false)String str1,
			@RequestParam(value="str2",required=false)String str2) {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("test1");
		view.addObject("str1", str1);
		view.addObject("str2", str2);
		return view;
	}
	
	//가게에서 파는 메뉴의 정보
	@RequestMapping(value="category_detail_menu",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> menu(@RequestParam("value") String category_value) {
		String market_no=category_value;
		List<Map<String,String>> dataList = new ArrayList<Map<String,String>>();
		List <category_menu_detailBean> menulist=null;
		Map<String, String> data =null;
		
		menulist=inter.SelMarket_menuPro(market_no);
		 //market_no ,menu_market 연결
		for(category_menu_detailBean s:menulist) {

			data = new HashMap<String,String>();
			data.put("menu_no",s.getMenu_no());
			data.put("menu_name",s.getMenu_name());
			data.put("menu_price",s.getMenu_price());
			data.put("menu_image",s.getMenu_image());
			data.put("menu_content",s.getMenu_content());
			dataList.add(data);
		}
		Map<String,Object> boards = new HashMap<String,Object>();
		boards.put("category_menu_detail",dataList);
		return boards; 
	}
	
	//가게정보 띄우기
	@RequestMapping(value="category_detail",method=RequestMethod.GET)
	public ModelAndView startcategory(@RequestParam("value") String category_value) {
		String market_no=category_value;
		String menu_market=market_no;
		ModelAndView view= new ModelAndView();
		category_menuBean MarketList = new category_menuBean();
		MarketList=inter.SelMarketPro(market_no);
		view.setViewName("category_detail");
		view.addObject("SelMarket", MarketList);
		return view;
	}
	
	//가게에서 파는 메뉴 주문할 때 몇인분 인지 계산
	@RequestMapping(value="MenuPrice", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> MenuPrice(@RequestParam(value="name") String menu_name)
	{
		List<Map<String,String>> dataList = new ArrayList<Map<String,String>>();
		String menuprice=null;
		Map<String, String> data =null;
		menuprice=inter.SelMenuPricePro(menu_name);

			data = new HashMap<String,String>();
			data.put("menu_price",menuprice);
			dataList.add(data);
			
		Map<String,Object> boards = new HashMap<String,Object>();
		boards.put("menu",dataList);
		return boards; 
	}

	@RequestMapping(value="readsentInput",method=RequestMethod.POST)
	public String readsentInsert(readsentBean bean) {
		//System.out.println(bean.getReadsent_content()+"------------------"+bean.getReadsent_market()+"-------------"+bean.getReadsent_id());
		int maxcode=Integer.parseInt(inter.MaxreadSent());
		boolean b;
		if(maxcode==0) {
			maxcode+=1;
			bean.setReadsent_no(String.valueOf(maxcode));
			b=inter.InsertreadSent(bean);
		}else {
			maxcode+=1;
			bean.setReadsent_no(String.valueOf(maxcode));
			b=inter.InsertreadSent(bean);
		}
		
		if(b) {
			return "main_menu";
		}else {
			return "main_menu";
		}
	}
	
	@RequestMapping(value="readsent_show",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> menu(HttpServletRequest request ,@RequestParam(value="readsent_market",required=false)String readsent_market) {
		System.out.println(readsent_market+"-----------------------------------------------------");
		List<Map<String,String>> dataList = new ArrayList<Map<String,String>>();
		List <readsentBean> menulist=null;
		Map<String, String> data =null;
		
		menulist=inter.readSentAllList(readsent_market);
		for(readsentBean s:menulist) {

			data = new HashMap<String,String>();
			data.put("readsent_no",s.getReadsent_no());
			data.put("readsent_content",s.getReadsent_content());
			data.put("readsent_day",s.getReadsent_day());
			data.put("readsent_market",s.getReadsent_market());
			data.put("readsent_id",s.getReadsent_id());
			data.put("readsent_star",s.getReadsent_star());
			dataList.add(data);
		}
		Map<String,Object> boards = new HashMap<String,Object>();
		boards.put("readsent_data",dataList);
		return boards; 
	}
}
