package com.jurgi.IdPwdFindController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jurgi.IdPwdFindModel.IdPwdFindInter;

@Controller
public class IdPwdFindController {

	@Autowired
	private IdPwdFindInter inter;
	
	@RequestMapping(value="IdPwd_Find",method=RequestMethod.GET)
	public String IdPwdFindMove() {
		return "idpwd_find";
	}
	
	@RequestMapping(value="Id_find",method=RequestMethod.POST)
	public ModelAndView Id_Find(@RequestParam("IdFind_Name") String name,
			@RequestParam("IdFind_Phone") String phone ) {
		IdPwdFind_MasterBean Mbean = new IdPwdFind_MasterBean();
		IdPwdFind_UserBean Ubean = new IdPwdFind_UserBean();
		
		Mbean.setMaster_name(name);
		Mbean.setMaster_phone(phone);
		Ubean.setUser_name(name);
		Ubean.setUser_phone(phone);
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("name",name);
		parameters.put("phone",phone);
		
		ModelAndView view = new ModelAndView();
		
		System.out.println("점주"+inter.IdMasterSelCntProc(parameters)+""+"유저"+inter.IdUserSelCntProc(parameters));
		if(inter.IdMasterSelCntProc(parameters).equals("0")&&inter.IdUserSelCntProc(parameters).equals("0")) {

			String msg="해당 아이디가 존재하지 않습니다";
			view.addObject("sel_id",msg);
			view.setViewName("idpwd_find");
			return view;

			
		}else if(inter.IdUserSelCntProc(parameters).equals("1")&&inter.IdMasterSelCntProc(parameters).equals("0")) {
			
			String user_id=inter.IdUserSelProc(Ubean);
			view.addObject("sel_id",user_id);
			view.setViewName("idpwd_find");
			return view;
		}else if(inter.IdMasterSelCntProc(parameters).equals("1")&&inter.IdUserSelCntProc(parameters).equals("0")) {
			
		
			String master_id=inter.IdMasterSelProc(Mbean);
			view.addObject("sel_id",master_id);
			view.setViewName("idpwd_find");
			return view;
		}
		
			return view;
		
	}
	
	@RequestMapping(value="Pwd_find",method=RequestMethod.POST)
	public ModelAndView Pwd_Find(@RequestParam("PwdFind_Id") String id,
			@RequestParam("PwdFind_Name") String name ) {
		IdPwdFind_MasterBean Mbean = new IdPwdFind_MasterBean();
		IdPwdFind_UserBean Ubean = new IdPwdFind_UserBean();
		
		Mbean.setMaster_id(id);
		Mbean.setMaster_name(name);
		Ubean.setUser_id(id);
		Ubean.setUser_name(name);
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("name",name);
		parameters.put("id",id);
		
		ModelAndView view = new ModelAndView();
		
		if(inter.PwdMasterSelCntProc(parameters).equals("0")&&inter.PwdUserSelCntProc(parameters).equals("0")) {

			String msg="해당하는 아이디의 비밀번호를 찾을 수 없습니다";
			view.addObject("sel_pwd",msg);
			view.setViewName("idpwd_find");
			return view;

			
		}else if(inter.PwdUserSelCntProc(parameters).equals("1")&&inter.PwdMasterSelCntProc(parameters).equals("0")) {
			
			String user_pwd=inter.PwdUserSelProc(Ubean);
			view.addObject("sel_pwd",user_pwd);
			view.setViewName("idpwd_find");
			return view;
		}else if(inter.PwdMasterSelCntProc(parameters).equals("1")&&inter.PwdUserSelCntProc(parameters).equals("0")) {
			
		
			String master_pwd=inter.PwdMasterSelProc(Mbean);
			view.addObject("sel_pwd",master_pwd);
			view.setViewName("idpwd_find");
			return view;
		}
		
			return view;
	}
	
}
