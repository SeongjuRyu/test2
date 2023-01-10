package com.jurgi.logincontroller;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jurgi.loginmodel.Login_IdPwdDto;
import com.jurgi.loginmodel.Login_MasterDto;
import com.jurgi.loginmodel.Login_UserDto;
import com.jurgi.InsertMenuController.InsertMenuBean;
import com.jurgi.loginmodel.LoginInter;

@Controller
public class LoginController {
   String id,pwd;
   String master_no, user_no;
   
   @Autowired
   private LoginInter inter;
   String referer="";
   
   @RequestMapping(value="login",method=RequestMethod.GET)
   public String loginMove(HttpServletRequest request) {
      
      return "login";
   }
   @RequestMapping(value="main_menu",method=RequestMethod.GET)
   public String MainMove() {
      return "main_menu";
   }
   
   
   @RequestMapping(value="login",method=RequestMethod.POST)
   @ResponseBody
   public Map<String,Object> LoginProc(@RequestParam("email") String e_id,
         @RequestParam("password") String e_passwd,
         HttpSession session) {
      List<Map<String,String>> dataList = new ArrayList<Map<String,String>>();
      Map<String, String> data =null;
      
      //로그인 확인
      Map<String, Object> parameters = new HashMap<String, Object>();
      parameters.put("e_id", e_id);
      parameters.put("e_passwd", e_passwd);
      Login_IdPwdDto loginDto= new Login_IdPwdDto();
      loginDto = inter.loginProc(parameters);
      
      //점주,고객 분류
      if(loginDto!=null) {
         List <Login_IdPwdDto> IdPwdlist = inter.IdPwdListProc(loginDto);
      
         for(Login_IdPwdDto s:IdPwdlist) {
            data = new HashMap<String,String>();
            data.put("e_no",s.getE_id());
            data.put("e_id",s.getE_passwd());
            dataList.add(data);
         }
         
         if(loginDto.getGubun().equals("0")) {
            Login_UserDto userDto = inter.userSelProc(e_id);
            session.setAttribute("user",userDto);
            
         }else if(loginDto.getGubun().equals("1"))
         {
            Login_MasterDto masterDto = inter.masterSelProc(e_id);
            session.setAttribute("master", masterDto);
            
         }   
      }else if(loginDto==null) {
         List <Login_IdPwdDto> IdPwdlist = inter.IdPwdListProc(loginDto);
         
         for(Login_IdPwdDto s:IdPwdlist) {
            data = new HashMap<String,String>();
            data.put("e_no",s.getE_id());
            data.put("e_id",s.getE_passwd());
            dataList.add(data);
         }
      }
      

      Map<String,Object> list = new HashMap<String,Object>();
      list.put("datas",dataList);
      return list;
                  
   }
   @RequestMapping(value="logout",method=RequestMethod.GET)
   public String logoutProc(HttpSession session) {
      if(session.getAttribute("user")!=null) {
         session.removeAttribute("user");
         return "redirect:/";
      }else if(session.getAttribute("master")!=null) {
         
         session.removeAttribute("master");
         return "redirect:/";
      }else {
         return "redirect:/";
      }   
   }
   public void checkLogin(Map<String,Object> Para) {
      
   }
   
   @RequestMapping(value="infochange",method=RequestMethod.GET)
   public String update(Login_MasterDto dto, Login_UserDto udto, ServletRequest request) throws UnknownHostException {
      master_no = request.getParameter("master_no");
      user_no = request.getParameter("user_no");
      if(master_no!=null && request.getParameter("Update_pwd").equals(dto.getMaster_passwd())) {
         dto.setMaster_name(request.getParameter("Update_name"));
         dto.setMaster_phone(request.getParameter("Update_phone"));
         dto.setMaster_address(request.getParameter("Update_address"));
         dto.setMaster_no(master_no);
         
         boolean b = inter.UpdateMasterInfoProcess(dto);
         System.out.println("첫번째 문제");
         if(b) {
            return "main_menu"; 
         }else {
            return "food";
         }
      }else if(user_no!=null && request.getParameter("Update_pwd").equals(udto.getUser_passwd())) {
         udto.setUser_name(request.getParameter("Update_name"));
         udto.setUser_phone(request.getParameter("Update_phone"));
         udto.setUser_address(request.getParameter("Update_address"));
         udto.setUser_no(user_no);
      
         boolean b = inter.UpdateUserInfoProcess(udto);
      
         if(b) {
            return "main_menu"; 
         }else {
            return "food";
         }
      }else {
         return "InfoUpdate";
      }
   }
   
   @RequestMapping(value="passwdchange",method=RequestMethod.GET)
   public String updatepwd(Login_MasterDto dto, Login_UserDto udto, Login_IdPwdDto idto, ServletRequest request) throws UnknownHostException {
      master_no = request.getParameter("master_no");
      user_no = request.getParameter("user_no");
      if(master_no!=null && request.getParameter("npassword").equals(dto.getMaster_passwd()) && request.getParameter("cpassword").equals(request.getParameter("rpassword"))) {
         dto.setMaster_passwd(request.getParameter("rpassword"));
         dto.setMaster_no(master_no);
         
         idto.setE_passwd(request.getParameter("rpassword"));
         idto.setE_id(request.getParameter("master_id"));
         
         boolean b = inter.UpdateMasterPwdProcess(dto);
         boolean c = inter.UpdateIdPwdProcess(idto);
         
         if(b == true && c == true) {
            return "main_menu"; 
         }else {
            return "food";
         }
      }else if(user_no!=null && request.getParameter("npassword").equals(udto.getUser_passwd()) && request.getParameter("cpassword").equals(request.getParameter("rpassword"))) {
    	 System.out.println("user_no");
    	 udto.setUser_passwd(request.getParameter("rpassword"));
         udto.setUser_no(user_no);
      
         idto.setE_passwd(request.getParameter("rpassword"));
         idto.setE_id(request.getParameter("user_id"));
        
         boolean b = inter.UpdateUserPwdProcess(udto);
         boolean c = inter.UpdateIdPwdProcess(idto);
         
         if(b == true && c == true) {
            return "main_menu"; 
         }else {
            return "food";
         }
      }else {
         return "InfoUpdate";
      }
   }
}