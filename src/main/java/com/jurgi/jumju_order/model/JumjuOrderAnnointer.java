package com.jurgi.jumju_order.model;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.jurgi.jumju_order.controller.orderlistBean;

public interface JumjuOrderAnnointer {

	@Select("select COALESCE(MAX(orderlist_no),0) from orderlist")
	public int MaxNo();
	@Insert("insert into orderlist(orderlist_no,orderlist_title,orderlist_content,orderlist_address,master_number,user_number,orderlist_pricetotal) "
			+ " values(#{orderlist_no},now(),#{orderlist_content},#{orderlist_address},#{master_number},#{user_number},#{orderlist_pricetotal})")
	public int insertOrder(orderlistBean bean);
	@Select("select *from orderlist where user_number=#{user_no}")
	public List<orderlistBean> SelUser(String user_no);
	@Select("select *from orderlist where master_number=#{master_no} and user_number !=0")
	public List<orderlistBean> SelMaster(String master_no);
	
}