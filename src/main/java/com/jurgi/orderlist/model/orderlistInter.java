package com.jurgi.orderlist.model;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.jurgi.orderlist.controller.orderlistBean;

public interface orderlistInter{
	public List<orderlistBean> Userorderlistselect(orderlistBean bean) throws DataAccessException;
	public List<orderlistBean> Masterorderlistselect(orderlistBean bean) throws DataAccessException;
	public boolean UpdateOrderState(orderlistBean bean) throws DataAccessException;
}
