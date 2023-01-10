package com.jurgi.loginmodel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import com.jurgi.InsertMenuController.InsertMenuBean;
import com.jurgi.logincontroller.Login_IdPwdBean;

public interface LoginInter {

	public Login_IdPwdDto loginProc(Map<String,Object> parameters)throws DataAccessException;
	public Login_UserDto userSelProc(String e_id)throws DataAccessException;
	public Login_MasterDto masterSelProc(String e_id)throws DataAccessException;
	public List<Login_IdPwdDto> IdPwdListProc(Login_IdPwdDto dto) throws DataAccessException;
	public boolean UpdateMasterInfoProcess(Login_MasterDto dto)throws DataAccessException;
	public boolean UpdateUserInfoProcess(Login_UserDto udto)throws DataAccessException;
	public boolean UpdateMasterPwdProcess(Login_MasterDto dto)throws DataAccessException;
	public boolean UpdateUserPwdProcess(Login_UserDto udto)throws DataAccessException;
	public boolean UpdateIdPwdProcess(Login_IdPwdDto idto)throws DataAccessException;
}
