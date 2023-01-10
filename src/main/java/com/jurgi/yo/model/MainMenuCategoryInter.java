package com.jurgi.yo.model;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface MainMenuCategoryInter {

	public List<MainMenu_CategoryDto> SelectDataAllProcess()throws DataAccessException;
	
}
