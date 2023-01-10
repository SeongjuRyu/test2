package com.jurgi.category_menu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jurgi.MarketCreateController.MarketCreateBean;
import com.jurgi.category_menu.model.category_menuInter;

@Controller
public class category_menuController {
	
	@Autowired
	private category_menuInter inter;
	
	String referer="";
	private String categoryvalue;
	private String inputvalue;
	
	@RequestMapping(value="category_handler",method=RequestMethod.GET)
	public String startcategory(@RequestParam("value") String category_value) {
		categoryvalue=category_value;
		inputvalue=category_value;
		
		return "category_menu";
	}
	
	//category 누른 곳으로 돌아가기
	@RequestMapping(value="menu_back",method=RequestMethod.GET)
	public String myFunction(HttpServletRequest request) {

		//취소 버튼을 누르면 눌렀던 곳의 주소로 이동한다.
		return "redirect:" + referer;
	}
	
	@RequestMapping(value="category_output",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> OutputList(HttpServletRequest request ,
			@RequestParam(value="menu", required=false)String menu,
			@RequestParam(value="start", required=false)String start,
			@RequestParam(value="end", required=false)String end,
			@RequestParam(value="flag3", required=false)String flag) {
		List<Map<String,String>> dataList = new ArrayList<Map<String,String>>();
		List <category_menuBean> boardlist=null;
		Map<String, String> data =null;
		referer = request.getHeader("Referer");
		System.out.println(referer);
		//System.out.println(menu);
	     Map<String,Object> parameters = new HashMap<String,Object>();   

		
		if(menu==null) {
			categoryvalue=inputvalue;
		}else {
			categoryvalue=menu;
		}
		String cnt="";
		
		parameters.put("no",categoryvalue);//몇번째 개시글
		cnt=inter.SelectListCnt(categoryvalue);
		
		if(start==null) {
		    parameters.put("start",0);//로그인한 아이디
			parameters.put("end",8);
		}else {
		    parameters.put("start",Integer.parseInt(start));//로그인한 아이디
			parameters.put("end",2);
		}

		
		System.out.println("작동중확인용");
		if(Integer.parseInt(categoryvalue)!=0) {//전체가 아니면
			
			if(flag==null&&menu!=null) {
				boardlist = inter.SelectList2(categoryvalue);
				
				if(boardlist.isEmpty()&&end==null)//목록이 아무 것도 없으면
				{
					System.out.println("이값은 널입니다.");
					data = new HashMap<String,String>();
					data.put("market_no","no");
					data.put("market_category",categoryvalue);
					dataList.add(data);
					Map<String,Object> boards = new HashMap<String,Object>();
					boards.put("category_menu",dataList);
					return boards;
				}
			}else {
				boardlist = inter.SelectList(parameters);
				
				if(boardlist.isEmpty()&&end==null)//목록이 아무 것도 없으면
				{
					System.out.println("이값은 널입니다.");
					data = new HashMap<String,String>();
					data.put("market_no","no");
					data.put("market_category",categoryvalue);
					dataList.add(data);
					Map<String,Object> boards = new HashMap<String,Object>();
					boards.put("category_menu",dataList);
					return boards;
				}
			}

			
		}else {
			if(flag==null&&menu!=null) {
				boardlist = inter.SelectAllList2();
				
				if(boardlist.isEmpty()&&end==null)//목록이 아무 것도 없으면
				{
					System.out.println("이값은 널입니다.");
					data = new HashMap<String,String>();
					data.put("market_no","no");
					data.put("market_category",categoryvalue);
					dataList.add(data);
					Map<String,Object> boards = new HashMap<String,Object>();
					boards.put("category_menu",dataList);
					return boards;
				}
			}else {
			boardlist = inter.SelectAllList(parameters);//전체면 모두 출력
			cnt=inter.SelectAllListCnt();
			}
		}
		
		//int count=0;
		for(category_menuBean s:boardlist) {
			//count++;
			data = new HashMap<String,String>();
			data.put("market_no",s.getMarket_no());
			data.put("market_name",s.getMarket_name());
			data.put("market_tel",s.getMarket_tel());
			data.put("market_address",s.getMarket_address());
			data.put("market_content",s.getMarket_content());
			data.put("market_star",s.getMarket_star());
			data.put("market_readsent",s.getMarket_readsent());
			data.put("market_image",s.getMarket_image());
			data.put("cnt",cnt);
			//data.put("count",String.valueOf(count));
			if(Integer.parseInt(categoryvalue)==0) {
				//전체를 나타낼때
				data.put("market_no2","0");
			}else {
				data.put("market_no2","1");
				data.put("market_category",s.getMarket_category());
			}
			
			dataList.add(data);
		}
		Map<String,Object> boards = new HashMap<String,Object>();
		boards.put("category_menu",dataList);
		return boards;
	}
	
	@RequestMapping(value="category_Mappingout",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> MapOutputList(HttpServletRequest request ,MarketCreateBean bean) {
		List<Map<String,String>> dataList = new ArrayList<Map<String,String>>();
		List<MarketCreateBean> boardlist=null;
		Map<String, String> data =null;
		String str = bean.getMarket_address();
		for(int i = 0 ; i < str.length() ; i++)
	    {
	        if(str.charAt(i) == ' ') {
	        	String[] array = str.split(" ");
	        	bean.setMarket_address(array[0]+" "+array[1]);
	        }
	    }
//		String[] array = str.split(" ");
//		if(array.length<=1) {
//	    bean.setMarket_address("'%"+array[0]+" "+array[1]+"%'");
//		}else {
//		bean.setMarket_address("'%"+array[0]+"%'");
//		}
	    System.out.println("----------------여기다 멍청아!!!!!!!!!!!!!"+bean.getMarket_address()+bean.getMarket_category());
		if(Integer.parseInt(bean.getMarket_category())!=0) {//목록에서 전체를 제외하고 아무것도 입력 안했을 경우와 조건을 입력했을때
			boardlist = inter.SelectMapLocationList(bean);
			
			if(boardlist.isEmpty()) {
				System.out.println("이거 생성됨");
				data = new HashMap<String,String>();
				data.put("market_no","no");
				data.put("market_category",bean.getMarket_category());
				dataList.add(data);
				Map<String,Object> boards = new HashMap<String,Object>();
				boards.put("category_menu",dataList);
				return boards;
	
			}
			System.out.println("카테고리 적용");
			for(int i=0; i<boardlist.size(); i++) {
				System.out.println(i);
			}
		}else {//전체에서의 입력했을때(getMarket_category가 0이기 떄문에 sql문에 category조건이 들어가지 않는다)
			boardlist = inter.SelectMapLocationAllList(bean);
			System.out.println(boardlist.size());
			if(boardlist.isEmpty()) {
				System.out.println("이거 생성됨");
				data = new HashMap<String,String>();
				data.put("market_no","no");
				data.put("market_category",bean.getMarket_category());
				dataList.add(data);
				Map<String,Object> boards = new HashMap<String,Object>();
				boards.put("category_menu",dataList);
				System.out.println(boards);
				return boards;
	
			}
			for(int i=0; i<boardlist.size(); i++) {
				System.out.println(i);
			}
		System.out.println("전체 리스트 출력");
		}
		
		for(MarketCreateBean s:boardlist) {

			data = new HashMap<String,String>();
			data.put("market_no",s.getMarket_no());
			data.put("market_name",s.getMarket_name());
			data.put("market_tel",s.getMarket_tel());
			data.put("market_address",s.getMarket_address());
			data.put("market_content",s.getMarket_content());
			data.put("market_star",s.getMarket_star());
			data.put("market_readsent",s.getMarket_readsent());
			data.put("market_image",s.getMarket_image());
			data.put("market_category",s.getMarket_category());
			dataList.add(data);
			
		}
		Map<String,Object> boards = new HashMap<String,Object>();
		boards.put("category_menu",dataList);
		return boards;
	}
	//메뉴 검색
	@RequestMapping(value="category_Searchout",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> SearchOutputList(HttpServletRequest request ,MarketCreateBean bean) {
		List<Map<String,String>> dataList = new ArrayList<Map<String,String>>();
		List<MarketCreateBean> boardlist=null;
		Map<String, String> data =null;
		System.out.println(bean.getMarket_category());
		if(Integer.parseInt(bean.getMarket_category())!=0) {
			boardlist = inter.SearchMapLocationList(bean);
			System.out.println("카테고리 적용");
			for(int i=0; i<boardlist.size(); i++) {
				System.out.println(i);
			}
			if(boardlist.isEmpty()) {
				System.out.println("이거 생성됨");
				data = new HashMap<String,String>();
				data.put("market_no","no");
				data.put("market_category",bean.getMarket_category());
				dataList.add(data);
				Map<String,Object> boards = new HashMap<String,Object>();
				boards.put("category_menu",dataList);
				System.out.println(boards);
				return boards;
	
			}
			
		}else {
			boardlist = inter.SearchMapLocationAllList(bean);
			System.out.println(boardlist.size());
			
			if(boardlist.isEmpty()) {
				System.out.println("이거 생성됨");
				data = new HashMap<String,String>();
				data.put("market_no","no");
				data.put("market_category",bean.getMarket_category());
				dataList.add(data);
				Map<String,Object> boards = new HashMap<String,Object>();
				boards.put("category_menu",dataList);
				System.out.println(boards);
				return boards;
	
			}
			for(int i=0; i<boardlist.size(); i++) {
				System.out.println(i);
			}
		System.out.println("전체 리스트 출력");
		}
		
		for(MarketCreateBean s:boardlist) {
			
			data = new HashMap<String,String>();
			data.put("market_no",s.getMarket_no());
			data.put("market_name",s.getMarket_name());
			data.put("market_tel",s.getMarket_tel());
			data.put("market_address",s.getMarket_address());
			data.put("market_content",s.getMarket_content());
			data.put("market_star",s.getMarket_star());
			data.put("market_readsent",s.getMarket_readsent());
			data.put("market_image",s.getMarket_image());
			data.put("market_category",s.getMarket_category());
			dataList.add(data);
			
		}
		Map<String,Object> boards = new HashMap<String,Object>();
		boards.put("category_menu",dataList);
		return boards;
	}
}
