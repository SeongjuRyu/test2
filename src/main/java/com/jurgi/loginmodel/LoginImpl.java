package com.jurgi.loginmodel;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.jurgi.logincontroller.Login_IdPwdBean;

@Repository
public class LoginImpl implements LoginInter{

	@Autowired
	private LoginAnnointer inter;
	
	@Override
	public Login_IdPwdDto loginProc(Map<String,Object> parameters)throws DataAccessException {
		return inter.loginUser(parameters);
	}
	@Override
	public Login_MasterDto masterSelProc(String e_id) throws DataAccessException {
		return inter.masterSel(e_id);
	}
	@Override
	public Login_UserDto userSelProc(String e_id) throws DataAccessException {
		return inter.userSel(e_id);
	}
	@Override
	public List<Login_IdPwdDto> IdPwdListProc(Login_IdPwdDto dto) throws DataAccessException {
		// TODO Auto-generated method stub
		return inter.IdPwdList(dto);
	}
	
	@Override
	public boolean UpdateMasterInfoProcess(Login_MasterDto dto)throws DataAccessException{
		int a = inter.UpdateMasterInfo(dto);
		if (a > 0) {
			return true;
		} else {
			return false;

		}
	}
	
	@Override
	public boolean UpdateUserInfoProcess(Login_UserDto udto)throws DataAccessException{
		int a = inter.UpdateUserInfo(udto);
		if (a > 0) {
			return true;
		} else {
			return false;

		}
	}
	
	@Override
	public boolean UpdateMasterPwdProcess(Login_MasterDto dto)throws DataAccessException{
		int a = inter.UpdateMasterPwd(dto);
		if (a > 0) {
			return true;
		} else {
			return false;

		}
	}
	
	@Override
	public boolean UpdateUserPwdProcess(Login_UserDto udto)throws DataAccessException{
		int a = inter.UpdateUserPwd(udto);
		if (a > 0) {
			return true;
		} else {
			return false;

		}
	}
	
	@Override
	public boolean UpdateIdPwdProcess(Login_IdPwdDto idto)throws DataAccessException{
		int a = inter.UpdateIdPwd(idto);
		if (a > 0) {
			return true;
		} else {
			return false;

		}
	}
}

