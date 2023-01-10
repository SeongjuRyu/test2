package com.jurgi.category_menu_detail.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.jurgi.category_menu_detail.controller.category_menuBean;
import com.jurgi.category_menu_detail.controller.category_menu_detailBean;
import com.jurgi.category_menu_detail.controller.readsentBean;

@Repository
public class category_menu_detailImpl implements category_menu_detailInter{

	@Autowired
	category_menu_detailAnnoInter inter;
	
	@Override
	public category_menuBean SelMarketPro(String market_no) throws DataAccessException {
		return inter.SelMarket(market_no);
	}
	@Override
	public List<category_menu_detailBean> SelMarket_menuPro(String market_no) throws DataAccessException {
		return inter.SelMarket_menu(market_no);
	}
	@Override
	public String SelMenuPricePro(String menu_name) throws DataAccessException {
		return inter.SelMenuPrice(menu_name);
	}
	
	@Override
	public boolean InsertreadSent(readsentBean bean) throws DataAccessException {
		return inter.InsertreadSent(bean);
	}
	
	@Override
	public String MaxreadSent() throws DataAccessException {
		return inter.MaxreadSent();
	}
	
	@Override
	public List<readsentBean> readSentAllList(String readsent_market) throws DataAccessException {
		return inter.readSentAllList(readsent_market);
	}
}
