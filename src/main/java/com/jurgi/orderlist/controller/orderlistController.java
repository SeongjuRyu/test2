package com.jurgi.orderlist.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jurgi.orderlist.model.orderlistInter;



@Controller
public class orderlistController {
	
	@Autowired
	private orderlistInter inter;
	
	@RequestMapping(value="orderlist_master",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> Masterorderlist(HttpServletRequest request ,orderlistBean bean) {
		System.out.println(bean.getMaster_number());
		List<Map<String,String>> dataList = new ArrayList<Map<String,String>>();
		List <orderlistBean> boardlist=null;
		Map<String, String> data =null;
		boardlist=inter.Masterorderlistselect(bean);
		
		for(orderlistBean s:boardlist) {

			data = new HashMap<String,String>();
			data.put("orderlist_no",s.getOrderlist_no());
			data.put("orderlist_title",s.getOrderlist_title());
			data.put("orderlist_content",s.getOrderlist_content());
			data.put("orderlist_address",s.getOrderlist_address());
			data.put("master_number",s.getMaster_number());
			data.put("user_number",s.getUser_number());
			data.put("orderlist_pricetotal",s.getOrderlist_pricetotal());
			data.put("orderlist_state",s.getOrderlist_state());
			dataList.add(data);
		
		}
		Map<String,Object> boards = new HashMap<String,Object>();
		boards.put("master_list",dataList);
		return boards;
	}
	
	@RequestMapping(value="orderlist_user",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> Userorderlist(HttpServletRequest request ,orderlistBean bean) {
		System.out.println(bean.getUser_number());
		List<Map<String,String>> dataList = new ArrayList<Map<String,String>>();
		List <orderlistBean> boardlist=null;
		Map<String, String> data =null;
		boardlist=inter.Userorderlistselect(bean);
		
		for(orderlistBean s:boardlist) {

			data = new HashMap<String,String>();
			data.put("orderlist_no",s.getOrderlist_no());
			data.put("orderlist_title",s.getOrderlist_title());
			data.put("orderlist_content",s.getOrderlist_content());
			data.put("orderlist_address",s.getOrderlist_address());
			data.put("master_number",s.getMaster_number());
			data.put("user_number",s.getUser_number());
			data.put("orderlist_pricetotal",s.getOrderlist_pricetotal());
			data.put("orderlist_state",s.getOrderlist_state());
			dataList.add(data);
		
		}
		Map<String,Object> boards = new HashMap<String,Object>();
		boards.put("master_list",dataList);
		return boards;
	}
	
	@RequestMapping(value="statehandle",method=RequestMethod.GET)
	public String myFunction(HttpServletRequest request,@RequestParam("orderlist_no") String orderlist_no,@RequestParam("state_value") String state_value) {
		orderlistBean bean = new orderlistBean();
		if(Integer.parseInt(state_value)==3) {
			bean.setOrderlist_state(String.valueOf(4));
			bean.setOrderlist_no(orderlist_no);			
		}else {
			bean.setOrderlist_state(String.valueOf(state_value));
			bean.setOrderlist_no(orderlist_no);
		}
		
		if(inter.UpdateOrderState(bean)) {
			return "InfoUpdate";
		}else {
			return "/";
		}
	}
	
}
	
