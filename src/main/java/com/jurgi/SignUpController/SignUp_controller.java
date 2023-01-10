package com.jurgi.SignUpController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.jurgi.SignUpModel.Login_IdPwdBean;
import com.jurgi.SignUpModel.SignUpInter;

@Controller
public class SignUp_controller {

	String referer="";
	@Autowired
	private SignUpInter inter;
	
	//회원가입을 눌렀을때
	@RequestMapping(value="sign_up" ,method=RequestMethod.GET)
	public String SignUpMove(HttpServletRequest request)
	{
		//회원가입을 누르기 전의 주소를 가져온다.
		referer = request.getHeader("Referer");

		return "sign_up";
	}
	
	//회원가입 취소
	@RequestMapping(value="sign_cancel",method=RequestMethod.GET)
	public String myFunction(HttpServletRequest request) {

		//취소 버튼을 누르면 눌렀던 곳의 주소로 이동한다.
		return "redirect:" + referer;
	}
	@RequestMapping(value="check",method =RequestMethod.POST)
	@ResponseBody
	public String idcheckfunc(Login_IdPwdBean bean) {
		System.out.println(bean.getE_id());
		int cnt=inter.idcheckProc(bean.getE_id());
		System.out.println(cnt);
		
		return String.valueOf(cnt);
		
	}
	
	@RequestMapping(value="Sign_up_User",method=RequestMethod.POST)
	public String Userfunc(SignUp_UserBean bean) {
		String UserMax=inter.UserNoMaxProc();
		if(UserMax==null) {
			bean.setUser_no("0");
		}else {
			bean.setUser_no(Integer.toString(Integer.parseInt(UserMax)+1));			
		}
		boolean b=inter.insUserSignUp(bean);
		if(b==true) {
			Login_IdPwdBean idPwdBean=new Login_IdPwdBean();
			String IdPwdMax =inter.IdPwdNoMaxProc();
			if(IdPwdMax==null) {
				idPwdBean.setId_no("0");
			}else {
				idPwdBean.setId_no(Integer.toString(Integer.parseInt(IdPwdMax)+1));
				idPwdBean.setE_passwd(bean.getUser_passwd());
				idPwdBean.setE_id(bean.getUser_id());
				idPwdBean.setGubun(bean.getUser_gubun());
			}
			inter.insIdpwdProc(idPwdBean);
			return "redirect:/";
		}else {
			return "sign_up";
		}
		
		
		
	}
	@RequestMapping(value="Sign_up_Master",method=RequestMethod.POST)
	public String Masterfunc(SignUp_MasterBean bean) {
		String MasterMax=inter.MasterNoMaxProc();
		if(MasterMax==null) {
			bean.setMaster_no("0");
		}else {
			bean.setMaster_no(Integer.toString(Integer.parseInt(MasterMax)+1));			
		}
		
		boolean b=inter.insMasterSignUp(bean);
		if(b==true) {
			Login_IdPwdBean idPwdBean=new Login_IdPwdBean();
			String IdPwdMax =inter.IdPwdNoMaxProc();
			if(IdPwdMax==null) {
				idPwdBean.setId_no("0");
			}else {
				idPwdBean.setId_no(Integer.toString(Integer.parseInt(IdPwdMax)+1));
				idPwdBean.setE_passwd(bean.getMaster_passwd());
				idPwdBean.setE_id(bean.getMaster_id());
				idPwdBean.setGubun(bean.getMaster_gubun());
			}
			inter.insIdpwdProc(idPwdBean);
			
			return "redirect:/";
		}else {
			return "sign_up";
		}
	}

}
