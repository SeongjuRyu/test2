package com.jurgi.MarketCreateModel;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.jurgi.InsertMenuController.InsertMenuBean;
import com.jurgi.MarketCreateController.MarketCreateBean;



@Repository
public class MarketCreateImpl implements MarketCreateInter{

	@Autowired
	private MarketCreateAnnointer inter;
	
	@Override
	public boolean InsertMarketProcess(MarketCreateBean bean) throws DataAccessException {
		int a = inter.InsertMarketProcess(bean);
		if (a > 0) {
			return true;
		} else {
			return false;

		}
	}
	
	@Override
	public MarketCreateBean MarketCreateSelect(MarketCreateBean bean) throws DataAccessException {
		return inter.MarketCreateSelect(bean);
	}
	
	@Override
	public List<MarketCreateBean> SelectDataMarketProcess(int market_master) throws DataAccessException {
		return inter.SelectDataMarket(market_master);
	}
	
	@Override
	public boolean UpdateMarketDataProcess(MarketCreateBean bean) throws DataAccessException {
		int a = inter.UpdateMarketData(bean);
		if (a > 0) {
			return true;
		} else {
			return false;

		}
	}

	@Override
	public boolean DeleteMarketDataProcess(String market_no) throws DataAccessException {
		int a = inter.DeleteMarketData(market_no);
		if (a > 0) {
			return true;
		} else {
			return false;

		}
	}
	
	@Override
	public boolean UpdateMasterMarket(MarketCreateBean bean) {
		int a = inter.UpdateMasterMarket(bean);
		if (a > 0) {
			return true;
		} else {
			return false;

		}
	}
}

