package com.jurgi.category_menu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.jurgi.MarketCreateController.MarketCreateBean;
import com.jurgi.category_menu.controller.category_menuBean;

public interface category_menuAnnoInter {
	@Select("select * from market where market_category=#{no} Limit #{start},#{end}")
	public List<category_menuBean>  SelectList(Map<String,Object> parameters);
	
	@Select("select * from market where market_category=#{no}")
	public List<category_menuBean>  SelectList2(String no);
	
	
	@Select("select * from market Limit #{start},#{end}")
	public List<category_menuBean>  SelectAllList(Map<String,Object> parameters);
	
	@Select("select * from market")
	public List<category_menuBean>  SelectAllList2();
	
	@Select("select count(*) from market")
	public String SelectAllListCnt();
	
	@Select("select count(*) from market where market_category=#{no}")
	public String SelectListCnt(String no);
	
	@Select("select * from market where market_address like concat('%',#{market_address},'%') and market_category=#{market_category}")
	public List<MarketCreateBean> SelectMapLocationList(MarketCreateBean bean);
	
	@Select("select * from market where market_address like concat('%',#{market_address},'%')")
	public List<MarketCreateBean> SelectMapLocationAllList(MarketCreateBean bean);
	
	@Select("select * from market where market_name like concat('%',#{market_name},'%') and market_category=#{market_category}")
	public List<MarketCreateBean> SearchMapLocationList(MarketCreateBean bean);
	
	@Select("select * from market where market_name like concat('%',#{market_name},'%')")
	public List<MarketCreateBean> SearchMapLocationAllList(MarketCreateBean bean);

}
