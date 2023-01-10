package com.jurgi.InsertMenuModel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jurgi.InsertMenuController.InsertMenuBean;

public interface InsertMenuAnnointer {

	@Insert("insert into menu(menu_no,menu_name,menu_price,menu_image,menu_market,menu_category,menu_content) values(#{menu_no},#{menu_name},#{menu_price},#{menu_image},#{menu_market},#{menu_category},#{menu_content})")
	public int InsertDataProcess(InsertMenuBean bean);
	
	@Select("select market_category from market inner join category on market_category=category_no inner join master on master_market=market_no where master_no=#{master_no}")
	public String InsertMenuSelect(InsertMenuBean bean);
	
	@Select("select master_no from market inner join master on market_no=master_no where master_no=#{master_no}")
	public String MasterMenuSelect(InsertMenuBean bean);
	
	@Select("select * from market inner join menu on menu_market = market_no inner join master on master_market = market_no where master_market = #{master_market}")
	public List<InsertMenuBean> SelectDataALLMenu(int master_market);
	
	@Update("update menu set menu_image=#{menu_image},menu_name=#{menu_name},menu_price=#{menu_price},menu_content=#{menu_content} where menu_no=#{menu_no}")
	public int UpdateMenuData(InsertMenuBean bean);
	
	@Select("select count(menu_no) from menu")
	public int CountMenu();
	
	@Delete("delete from menu where menu_no=#{menu_no}")
	public int DeleteMenuData(String menu_no);
}
