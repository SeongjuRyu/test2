package com.jurgi.orderlist.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jurgi.orderlist.controller.orderlistBean;

public interface oderlistAnnointer {
	@Select("select * from orderlist where user_number=#{user_number}")
	public List<orderlistBean> Userorderlistselect(orderlistBean bean);
	
	@Select("select * from orderlist where master_number=#{master_number}")
	public List<orderlistBean> Masterorderlistselect(orderlistBean bean);
	
	@Update("update orderlist set orderlist_state=#{orderlist_state} where orderlist_no=#{orderlist_no}")
	public boolean UpdateOrderState(orderlistBean bean);
		

}