package com.jurgi.category_menu.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.jurgi.MarketCreateController.MarketCreateBean;
import com.jurgi.category_menu.controller.category_menuBean;

@Repository
public class category_menuImpl implements category_menuInter{
	
	@Autowired
	private category_menuAnnoInter inter;
	
	@Override
	public List<category_menuBean> SelectList(Map<String,Object> parameters) throws DataAccessException {
		return inter.SelectList(parameters);
	}
	
	@Override
	public List<category_menuBean> SelectAllList(Map<String,Object> parameters) throws DataAccessException {
		return inter.SelectAllList(parameters);
	}
	
	@Override
	public List<MarketCreateBean> SelectMapLocationAllList(MarketCreateBean bean) throws DataAccessException {
		return inter.SelectMapLocationAllList(bean);
	}
	
	@Override
	public List<MarketCreateBean> SelectMapLocationList(MarketCreateBean bean) throws DataAccessException {
		return inter.SelectMapLocationList(bean);
	}
	
	@Override
	public List<MarketCreateBean> SearchMapLocationAllList(MarketCreateBean bean) throws DataAccessException {
		return inter.SearchMapLocationAllList(bean);
	}
	
	@Override
	public List<MarketCreateBean> SearchMapLocationList(MarketCreateBean bean) throws DataAccessException {
		return inter.SearchMapLocationList(bean);
	}
	@Override
	public String SelectListCnt(String no) throws DataAccessException {
		// TODO Auto-generated method stub
		return inter.SelectListCnt(no);
	}
	@Override
	public String SelectAllListCnt() throws DataAccessException {
		// TODO Auto-generated method stub
		return inter.SelectAllListCnt();
	}
	@Override
	public List<category_menuBean> SelectAllList2() throws DataAccessException {
		// TODO Auto-generated method stub
		return inter.SelectAllList2();
	}
	@Override
	public List<category_menuBean> SelectList2(String no) throws DataAccessException {
		// TODO Auto-generated method stub
		return inter.SelectList2(no);
	}
}
