package com.jurgi.orderlist.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.jurgi.orderlist.controller.orderlistBean;

@Repository
public class orderlistImpl implements orderlistInter{
	
	@Autowired
	oderlistAnnointer inter;
	
	@Override
	public List<orderlistBean> Masterorderlistselect(orderlistBean bean) throws DataAccessException {
		return inter.Masterorderlistselect(bean);
	}
	
	@Override
	public List<orderlistBean> Userorderlistselect(orderlistBean bean) throws DataAccessException {
		return inter.Userorderlistselect(bean);
	}
	
	@Override
	public boolean UpdateOrderState(orderlistBean bean) throws DataAccessException {
		return inter.UpdateOrderState(bean);
	}
}
