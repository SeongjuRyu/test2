package com.jurgi.jumju_order.model;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.jurgi.jumju_order.controller.orderlistBean;

public interface JumjuOrderInter {
	public boolean insertOrderPro(orderlistBean bean)throws DataAccessException;
	public List<orderlistBean> SelUser(String user_no)throws DataAccessException;
	public List<orderlistBean> SelMaster(String master_no)throws DataAccessException;
	public int MaxNo() throws DataAccessException;
}
