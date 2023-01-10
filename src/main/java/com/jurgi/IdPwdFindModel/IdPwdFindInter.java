package com.jurgi.IdPwdFindModel;

import java.util.Map;


import org.springframework.dao.DataAccessException;

import com.jurgi.IdPwdFindController.IdPwdFind_MasterBean;
import com.jurgi.IdPwdFindController.IdPwdFind_UserBean;

public interface IdPwdFindInter {

	public String IdMasterSelProc(IdPwdFind_MasterBean Bean)throws DataAccessException;
	public String IdUserSelProc(IdPwdFind_UserBean Bean)throws DataAccessException;
	public String PwdMasterSelProc(IdPwdFind_MasterBean Bean)throws DataAccessException;
	public String PwdUserSelProc(IdPwdFind_UserBean Bean)throws DataAccessException;
	
	public String IdMasterSelCntProc(Map<String, Object> parameters)throws DataAccessException;
	public String IdUserSelCntProc(Map<String, Object> parameters)throws DataAccessException;
	public String PwdMasterSelCntProc(Map<String, Object> parameters)throws DataAccessException;
	public String PwdUserSelCntProc(Map<String, Object> parameters)throws DataAccessException;
}
