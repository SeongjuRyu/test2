package com.jurgi.yo.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface MainCategoryAnnoInter {
	@Select("select * from category")
	public List<MainMenu_CategoryDto> SelectDataALL();
}
