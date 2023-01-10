package com.jurgi.MarketCreateModel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jurgi.InsertMenuController.InsertMenuBean;
import com.jurgi.MarketCreateController.MarketCreateBean;


public interface MarketCreateAnnointer {

	@Insert("insert into market(market_no,market_name,market_tel,market_address,market_content,market_image,market_time, market_rowprice,market_category) values(#{market_no},#{market_name},#{market_tel},#{market_address},#{market_content},#{market_image},#{market_time}, #{market_rowprice},#{market_category})")
	public int InsertMarketProcess(MarketCreateBean bean);
	
	@Select("select market_category, master_market from market inner join category on market_category=category_no inner join master on master_market=market_no")
	public MarketCreateBean MarketCreateSelect(MarketCreateBean bean);
		
	@Select("select * from market inner join menu on menu_market = market_no inner join master on master_market = market_no where master_market = #{master_market}")
	public List<MarketCreateBean> SelectDataMarket(int market_master);
	
	@Update("update market set market_image=#{market_image},market_name=#{market_name},market_tel=#{market_tel},market_address=#{market_address}, market_content=#{market_content},market_time = #{market_time}, market_rowprice = #{market_rowprice}, market_category=#{market_category} where market_no=#{market_no}")
	public int UpdateMarketData(MarketCreateBean bean);
	
	@Update("update master set master_market=#{master_market} where master_no=#{master_no}")
	public int UpdateMasterMarket(MarketCreateBean bean);
	
	@Delete("delete from market where market_no=#{market_no}")
	public int DeleteMarketData(String market_no);
}
