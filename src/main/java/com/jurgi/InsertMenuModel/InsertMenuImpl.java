package com.jurgi.InsertMenuModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.jurgi.InsertMenuController.InsertMenuBean;

@Repository
public class InsertMenuImpl implements InsertMenuInter{

	@Autowired
	private InsertMenuAnnointer inter;
	
	@Override
	public boolean InsertDataProcess(InsertMenuBean bean) throws DataAccessException {
		int a = inter.InsertDataProcess(bean);
		if (a > 0) {
			return true;
		} else {
			return false;

		}
	}
	
	@Override
	public String InsertMenuSelectProcess(InsertMenuBean bean) throws DataAccessException {
		return inter.InsertMenuSelect(bean);
	}
	
	@Override
	public List<InsertMenuBean> SelectDataAllProcess(int master_market) throws DataAccessException {
		return inter.SelectDataALLMenu(master_market);
	}
	
	@Override
	public boolean UpdateMenuDataProcess(InsertMenuBean bean) throws DataAccessException {
		int a = inter.UpdateMenuData(bean);
		if (a > 0) {
			return true;
		} else {
			return false;

		}
	}
	
	@Override
	public int CountMenuData() throws DataAccessException{
		return inter.CountMenu();
	}
	
	@Override
	public boolean DeleteMenuDataProcess(String menu_no) throws DataAccessException {
		int a = inter.DeleteMenuData(menu_no);
		if (a > 0) {
			return true;
		} else {
			return false;

		}
	}
	
	@Override
	public String MasterMenuSelect(InsertMenuBean bean) throws DataAccessException {
		return inter.MasterMenuSelect(bean);
	}
}

