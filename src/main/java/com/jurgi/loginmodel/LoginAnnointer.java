package com.jurgi.loginmodel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;



public interface LoginAnnointer {

	//로그인 정보
	@Select("select * from IDpwd where e_id=#{e_id} and e_passwd=#{e_passwd}")
	public Login_IdPwdDto loginUser(Map<String,Object> parameters);
	
	@Select("select * from IDpwd where e_id=#{e_id} and e_passwd=#{e_passwd}") 
	public List<Login_IdPwdDto> IdPwdList(Login_IdPwdDto dto);
	
	//고객 정보
	@Select("select *from master a where "
			+ " exists(select e_id from IDpwd b where a.master_id=b.e_id and b.e_id=#{e_id})")
	public Login_MasterDto masterSel(String e_id);
	
	@Select("select *from user a where "
			+ " exists(select e_id from IDpwd b where a.user_id=b.e_id and b.e_id=#{e_id})")
	public Login_UserDto userSel(String e_id);
	
	//점주 정보 수정
	@Update("update master set master_name=#{master_name}, master_phone=#{master_phone}, master_address=#{master_address} where master_no=#{master_no}")
	public int UpdateMasterInfo(Login_MasterDto dto);
	
	//고객 정보 수정
	@Update("update user set user_name=#{user_name}, user_phone=#{user_phone}, user_address=#{user_address} where user_no=#{user_no}")
	public int UpdateUserInfo(Login_UserDto udto);
	
	@Update("update master set master_passwd=#{master_passwd} where master_no=#{master_no}")
	public int UpdateMasterPwd(Login_MasterDto dto);
	
	@Update("update user set user_passwd=#{user_passwd} where user_no=#{user_no}")
	public int UpdateUserPwd(Login_UserDto udto);
	
	@Update("update idpwd set e_passwd=#{e_passwd} where e_id=#{e_id}")
	public int UpdateIdPwd(Login_IdPwdDto idto);
}
