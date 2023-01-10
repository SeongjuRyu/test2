package com.jurgi.IdPwdFindModel;

import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.jurgi.IdPwdFindController.IdPwdFind_MasterBean;
import com.jurgi.IdPwdFindController.IdPwdFind_UserBean;

public interface IdPwdFindAnnoInter {

	//아이디 있는지 확인
	@Select("select count(*) from master where master_name=#{name} and master_phone=#{phone}")
	public String IdMasterSelCnt(Map<String, Object> parameters);
	
	@Select("select count(*) from user where user_name=#{name} and user_phone=#{phone}")
	public String IdUserSelCnt(Map<String, Object> parameters);
	
	
	//아이디 출력
	@Select("select master_id from master where master_name=#{master_name} and master_phone=#{master_phone}")
	public String IdMasterSel(IdPwdFind_MasterBean Bean);

	@Select("select user_id from user where user_name=#{user_name} and user_phone=#{user_phone}")
	public String IdUserSel(IdPwdFind_UserBean Bean);
	
	
	//비밀번호 확인
	@Select("select count(*) from master where master_id=#{id} and master_name=#{name}")
	public String PwdMasterSelCnt(Map<String, Object> parameters);

	@Select("select count(*) from user where user_id=#{id} and user_name=#{name}")
	public String PwdUserSelCnt(Map<String, Object> parameters);
	
	
	//비밀번호 출력
	@Select("select master_passwd from master where master_id=#{master_id} and master_name=#{master_name}")
	public String PwdMasterSel(IdPwdFind_MasterBean Bean);

	@Select("select user_passwd from user where user_id=#{user_id} and user_name=#{user_name}")
	public String PwdUserSel(IdPwdFind_UserBean Bean);
}
