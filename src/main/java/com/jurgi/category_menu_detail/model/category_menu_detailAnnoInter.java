package com.jurgi.category_menu_detail.model;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.jurgi.category_menu_detail.controller.category_menuBean;
import com.jurgi.category_menu_detail.controller.category_menu_detailBean;
import com.jurgi.category_menu_detail.controller.readsentBean;

public interface category_menu_detailAnnoInter {

	@Select("select *from market where market_no=#{market_no}")
	public category_menuBean SelMarket(String market_no);
	@Select("select *from menu a where exists(select*from market b where b.market_no=a.menu_market and b.market_no=#{market_no})")
	public List<category_menu_detailBean> SelMarket_menu(String market_no);
	@Select("select menu_price from menu where menu_name=#{menu_name}")
	public String SelMenuPrice(String menu_name);
	@Insert("insert into readsent values(#{readsent_no},#{readsent_content},now(),#{readsent_market},#{readsent_id},#{readsent_star})")
	public boolean InsertreadSent(readsentBean bean);
	@Select("select max(readsent_no) from readsent")
	public String MaxreadSent();
	@Select("select * from readsent where readsent_market=#{readsent_market}")
	public List<readsentBean> readSentAllList(String readsent_market);
}
