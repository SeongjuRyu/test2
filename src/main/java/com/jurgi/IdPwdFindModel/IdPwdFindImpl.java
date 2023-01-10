package com.jurgi.IdPwdFindModel;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.jurgi.IdPwdFindController.IdPwdFind_MasterBean;
import com.jurgi.IdPwdFindController.IdPwdFind_UserBean;

@Repository
public class IdPwdFindImpl implements IdPwdFindInter{

	@Autowired
	private IdPwdFindAnnoInter inter;
	
	@Override
	public String IdMasterSelCntProc(Map<String, Object> parameters) throws DataAccessException {
		// TODO Auto-generated method stub
		return inter.IdMasterSelCnt(parameters);
	}
	@Override
	public String IdUserSelCntProc(Map<String, Object> parameters) throws DataAccessException {
		// TODO Auto-generated method stub
		return inter.IdUserSelCnt(parameters);
	}
	
	@Override
	public String IdMasterSelProc(IdPwdFind_MasterBean Bean) throws DataAccessException {
		// TODO Auto-generated method stub
		return inter.IdMasterSel(Bean);
	}
	@Override
	public String IdUserSelProc(IdPwdFind_UserBean Bean) throws DataAccessException {
		// TODO Auto-generated method stub
		return inter.IdUserSel(Bean);
	}
	@Override
	public String PwdMasterSelCntProc(Map<String, Object> parameters) throws DataAccessException {
		return inter.PwdMasterSelCnt(parameters);
	}
	@Override
	public String PwdUserSelCntProc(Map<String, Object> parameters) throws DataAccessException {
		return inter.PwdUserSelCnt(parameters);
	}
	
	@Override
	public String PwdMasterSelProc(IdPwdFind_MasterBean Bean) throws DataAccessException {
		// TODO Auto-generated method stub
		return inter.PwdMasterSel(Bean);
	}
	@Override
	public String PwdUserSelProc(IdPwdFind_UserBean Bean) throws DataAccessException {
		// TODO Auto-generated method stub
		return inter.PwdUserSel(Bean);
	}

}
