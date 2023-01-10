package com.jurgi.category_menu.model;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.jurgi.MarketCreateController.MarketCreateBean;
import com.jurgi.category_menu.controller.category_menuBean;

public interface category_menuInter {
	public List<category_menuBean> SelectList(Map<String,Object> parameters) throws DataAccessException;
	public List<category_menuBean> SelectAllList(Map<String,Object> parameters) throws DataAccessException;
	public List<category_menuBean> SelectList2(String no) throws DataAccessException;
	public List<category_menuBean>  SelectAllList2()throws DataAccessException;
	public String SelectAllListCnt()throws DataAccessException;
	public String SelectListCnt(String no)throws DataAccessException;
	public List<MarketCreateBean> SelectMapLocationList(MarketCreateBean bean) throws DataAccessException;
	public List<MarketCreateBean> SelectMapLocationAllList(MarketCreateBean bean) throws DataAccessException;
	public List<MarketCreateBean> SearchMapLocationList(MarketCreateBean bean) throws DataAccessException;
	public List<MarketCreateBean> SearchMapLocationAllList(MarketCreateBean bean) throws DataAccessException;
}