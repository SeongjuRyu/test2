package com.jurgi.jumju_order.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.jurgi.jumju_order.controller.orderlistBean;

@Repository
public class JumjuOrderImpl implements JumjuOrderInter{

	@Autowired
	JumjuOrderAnnointer inter;
	
	@Override
	public boolean insertOrderPro(orderlistBean bean) throws DataAccessException {
		if(inter.insertOrder(bean)>0) {
			return true;
		}else {
			
			return false;
		}
	}
	@Override
	public List<orderlistBean> SelMaster(String master_no) throws DataAccessException {
		// TODO Auto-generated method stub
		return inter.SelMaster(master_no);
	}
	@Override
	public List<orderlistBean> SelUser(String user_no) throws DataAccessException {
		// TODO Auto-generated method stub
		return inter.SelUser(user_no);
	}
	@Override
	public int MaxNo() throws DataAccessException {
		return inter.MaxNo();
	}
}
