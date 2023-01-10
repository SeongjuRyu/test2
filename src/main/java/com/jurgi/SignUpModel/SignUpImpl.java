package com.jurgi.SignUpModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.jurgi.SignUpController.SignUp_MasterBean;
import com.jurgi.SignUpController.SignUp_UserBean;

@Repository
public class SignUpImpl implements SignUpInter{

	@Autowired
	SignUpAnnoInter inter;
	@Override
	public int idcheckProc(String e_id) throws DataAccessException{ 
		int a=inter.idcheck(e_id);
		return a; 
				
	}
	@Override
	public String IdPwdNoMaxProc() throws DataAccessException {
		return inter.IdPwdNoMax();
	}
	@Override
	public boolean insIdpwdProc(Login_IdPwdBean bean) throws DataAccessException {
		int b =inter.insIdpwd(bean);
		if(b>0) 
			return true;
		else
			return false;
		
	}
	@Override
	public String MasterNoMaxProc() throws DataAccessException {
		return inter.MasterNoMax();
	}
	@Override
	public boolean insMasterSignUp(SignUp_MasterBean bean) throws DataAccessException {
		int a=inter.insMasterSignUp(bean);
		if(a>0)
			return true;
		else
			return false;
		
	}
	@Override
	public String UserNoMaxProc() throws DataAccessException {
		return inter.UserNoMax();
	}
	@Override
	public boolean insUserSignUp(SignUp_UserBean bean) throws DataAccessException {
		int a=inter.insUserSignUp(bean);
		if(a>0)
			return true;
		else 
			return false;
	
	}
	
}
