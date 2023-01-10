package com.jurgi.jumju_order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jurgi.jumju_order.model.JumjuOrderInter;
import com.jurgi.loginmodel.Login_MasterDto;
import com.jurgi.loginmodel.Login_UserDto;


@Controller
public class jumju_order_Controller {

	@Autowired
	JumjuOrderInter inter;
	
	@RequestMapping(value="order",method=RequestMethod.POST)
	public ModelAndView jumju_orderMove(Login_UserDto U_dto,Login_MasterDto M_dto,
			orderlistBean Or_bean,@RequestParam(value="market_no" ,required=false) String market_no) {
		String orderlist_content="";
		String content=Or_bean.getOrderlist_content();
		String[] contentArr=content.split("/");
		for(int i=0;i<contentArr.length;i++) {
			orderlist_content = contentArr[i]+" "+orderlist_content;
		}
		int MaxNo=0;
		MaxNo=inter.MaxNo();
		System.out.println(MaxNo);
		ModelAndView view = new ModelAndView();
		//유저가 주문했을 경우
		if(M_dto.getMaster_id()==null) {
			System.out.println("내가 들어오는걸 봐줘");
			if(MaxNo==0) {
				MaxNo=1;
				
				Or_bean.setOrderlist_no(String.valueOf(MaxNo));
				Or_bean.setOrderlist_content(orderlist_content);
				Or_bean.setUser_number(U_dto.getUser_no());
				Or_bean.setMaster_number(market_no);
				inter.insertOrderPro(Or_bean);
				List<orderlistBean> userlist =inter.SelUser(U_dto.getUser_no());
				view.setViewName("gogek_order");
				view.addObject("orderlist", userlist);
			}else {
				Or_bean.setOrderlist_no(String.valueOf(MaxNo+1));
				Or_bean.setOrderlist_content(orderlist_content);
				Or_bean.setUser_number(U_dto.getUser_no());
				Or_bean.setMaster_number(market_no);
				inter.insertOrderPro(Or_bean);
				List<orderlistBean> userlist =inter.SelUser(U_dto.getUser_no());
				view.setViewName("main_menu");
				view.addObject("orderlist", userlist);
				
			}
			//점주가 주문했을 경우
		}else if(U_dto.getUser_id()==null){
			System.out.println("니가 들어오는걸 봐줘");
			if(MaxNo==0) {
				MaxNo=1;
				
				Or_bean.setOrderlist_no(String.valueOf(MaxNo));
				Or_bean.setOrderlist_content(orderlist_content);
				Or_bean.setUser_number("0");
				Or_bean.setMaster_number(M_dto.getMaster_no());
				inter.insertOrderPro(Or_bean);
				List<orderlistBean> masterlist =inter.SelMaster(M_dto.getMaster_no());
				
				view.setViewName("main_menu");
				view.addObject("orderlist", masterlist);
			}else {
				Or_bean.setOrderlist_no(String.valueOf(MaxNo+1));
				Or_bean.setOrderlist_content(orderlist_content);
				Or_bean.setUser_number("0");
				Or_bean.setMaster_number(M_dto.getMaster_no());
				inter.insertOrderPro(Or_bean);
				List<orderlistBean> masterlist =inter.SelMaster(M_dto.getMaster_no());
				
				view.setViewName("main_menu");
				view.addObject("orderlist", masterlist);
				
				
			}
			
		}
		return view;
	}
	
	
}
