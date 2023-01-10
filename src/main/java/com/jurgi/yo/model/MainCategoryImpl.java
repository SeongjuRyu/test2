package com.jurgi.yo.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class MainCategoryImpl implements MainMenuCategoryInter {

	@Autowired
	private MainCategoryAnnoInter inter;

	public List<MainMenu_CategoryDto> SelectDataAllProcess() throws DataAccessException {
		// TODO Auto-generated method stub
		return inter.SelectDataALL();
	}

	

}
