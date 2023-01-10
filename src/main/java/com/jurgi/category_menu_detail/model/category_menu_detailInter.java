package com.jurgi.category_menu_detail.model;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.jurgi.category_menu_detail.controller.category_menuBean;
import com.jurgi.category_menu_detail.controller.category_menu_detailBean;
import com.jurgi.category_menu_detail.controller.readsentBean;

public interface category_menu_detailInter {

	public category_menuBean SelMarketPro(String market_no)throws DataAccessException;
	public List<category_menu_detailBean> SelMarket_menuPro(String market_no)throws DataAccessException;
	public String SelMenuPricePro(String menu_name)throws DataAccessException;
	public boolean InsertreadSent(readsentBean bean) throws DataAccessException;
	public String MaxreadSent() throws DataAccessException;
	public List<readsentBean> readSentAllList(String readsent_market) throws DataAccessException;
}
