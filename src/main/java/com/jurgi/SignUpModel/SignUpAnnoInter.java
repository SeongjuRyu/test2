package com.jurgi.SignUpModel;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.jurgi.SignUpController.SignUp_MasterBean;
import com.jurgi.SignUpController.SignUp_UserBean;


public interface SignUpAnnoInter {

	@Select("select max(id_no) from idpwd")
	public String IdPwdNoMax();
	@Select("select max(user_no) from user")
	public String UserNoMax();
	@Select("select max(master_no) from master")
	public String MasterNoMax();
	@Insert("insert into idpwd values(#{id_no},#{e_id},#{e_passwd},#{gubun})")
	public int insIdpwd(Login_IdPwdBean bean);
	
	@Insert("insert into user "
			+ " values(#{user_no},#{user_id},#{user_passwd},#{user_name},#{user_phone},#{user_address},#{user_gubun})")
	public int insUserSignUp(SignUp_UserBean bean);
	@Insert("insert into master(master_no,master_id,master_passwd,master_name,master_phone,master_address,master_gubun)"
			+ " values(#{master_no},#{master_id},#{master_passwd},#{master_name},#{master_phone} ,#{master_address},#{master_gubun})")
	public int insMasterSignUp(SignUp_MasterBean bean);
	
	@Select("select count(e_id) from idpwd where e_id=#{e_id}")
	public int idcheck(String e_id);
	
}
