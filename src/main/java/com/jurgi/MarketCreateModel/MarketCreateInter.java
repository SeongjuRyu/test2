package com.jurgi.MarketCreateModel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import com.jurgi.InsertMenuController.InsertMenuBean;
import com.jurgi.MarketCreateController.MarketCreateBean;
import com.jurgi.logincontroller.Login_IdPwdBean;


public interface MarketCreateInter {

	public boolean InsertMarketProcess(MarketCreateBean bean) throws DataAccessException;
	public MarketCreateBean MarketCreateSelect(MarketCreateBean bean)throws DataAccessException;
	public List<MarketCreateBean> SelectDataMarketProcess(int market_master)throws DataAccessException;
	public boolean UpdateMarketDataProcess(MarketCreateBean bean)throws DataAccessException;
	public boolean DeleteMarketDataProcess(String market_no)throws DataAccessException;
	public boolean UpdateMasterMarket(MarketCreateBean bean);
}
