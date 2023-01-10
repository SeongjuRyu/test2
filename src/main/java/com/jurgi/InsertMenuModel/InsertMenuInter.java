package com.jurgi.InsertMenuModel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import com.jurgi.InsertMenuController.InsertMenuBean;
import com.jurgi.logincontroller.Login_IdPwdBean;

public interface InsertMenuInter {

	public boolean InsertDataProcess(InsertMenuBean bean) throws DataAccessException;
	public String InsertMenuSelectProcess(InsertMenuBean bean)throws DataAccessException;
	public List<InsertMenuBean> SelectDataAllProcess(int master_market)throws DataAccessException;
	public boolean UpdateMenuDataProcess(InsertMenuBean bean)throws DataAccessException;
	public int CountMenuData() throws DataAccessException;
	public boolean DeleteMenuDataProcess(String menu_no)throws DataAccessException;
	public String MasterMenuSelect(InsertMenuBean bean) throws DataAccessException;
	
}
