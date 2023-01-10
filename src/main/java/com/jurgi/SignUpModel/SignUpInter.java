package com.jurgi.SignUpModel;

import org.springframework.dao.DataAccessException;

import com.jurgi.SignUpController.SignUp_MasterBean;
import com.jurgi.SignUpController.SignUp_UserBean;

public interface SignUpInter {

	
	public int idcheckProc(String e_id)throws DataAccessException;
	public String IdPwdNoMaxProc()throws DataAccessException;
	public String UserNoMaxProc()throws DataAccessException;
	public String MasterNoMaxProc()throws DataAccessException;
	public boolean insUserSignUp(SignUp_UserBean bean)throws DataAccessException;
	public boolean insMasterSignUp(SignUp_MasterBean bean)throws DataAccessException;
	public boolean insIdpwdProc(Login_IdPwdBean bean) throws DataAccessException;
}
