package com.jurgi.MarketCreateController;

import java.net.InetAddress;
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jurgi.FileUploadService.FileUploadService;
import com.jurgi.InsertMenuController.InsertMenuBean;
import com.jurgi.MarketCreateModel.MarketCreateInter;


@Controller
public class MarketCreateController {
	private int master_market;
	private String market_Img, update_market_Img;
	private int market_no, d_market_no;
	private String time1, time2, time3, time4;
	private String ftype;
	
	@Autowired
	FileUploadService fileUploadService;
	
	@Autowired
	private MarketCreateInter inter;
	
	@RequestMapping(value="market_create",method=RequestMethod.GET)
	public String MainMove(ServletRequest request) {
		//market_Img = request.getParameter("market_Img");
		return "market_create";
	}
	
	
	@RequestMapping(value="market_createdata",method=RequestMethod.POST)
	public String marketcreate(MarketCreateBean bean,ServletRequest request, Model model, @RequestParam("aa") MultipartFile file) throws UnknownHostException {
		String url = fileUploadService.restore(file);
		model.addAttribute("url", url);
		
		String str = request.getParameter("market_Img");
		String[] marketimg = str.split("\\\\");
		
		MarketCreateBean data = bean;
		data.setMarket_no(request.getParameter("master_no"));
		data.setMaster_market(request.getParameter("master_no"));
		data.setMarket_image(marketimg[2]);
		inter.UpdateMasterMarket(bean);

		
		if(data.getMarket_image()==null) {
			data.setMarket_image("ready.jpg");
		}
		if(data.getMarket_category()==null) {
			data.setMarket_category("0");
		}
//		System.out.println(data.getMarket_image());
//		System.out.println("----------------------------------end----------------------------------------");
		boolean b = inter.InsertMarketProcess(bean);
		
		if(b) {
			return "main_menu"; 
		}else {
			return "food";
		}
	}
	
	
	
	@RequestMapping(value="marketgo",method=RequestMethod.GET)
	public String moving(MarketCreateBean bean, ServletRequest request) {
		System.out.println("왜 안되냐고 시발아" +bean.getMaster_market());
		master_market=Integer.parseInt(bean.getMaster_market());

		return "InfoUpdate";
	}
	
	@RequestMapping(value="market",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> market(MarketCreateBean bean) {
		System.out.println("확인중 market");
		List<Map<String,String>> marketList = new ArrayList<Map<String,String>>();
		Map<String, String> data =null;
		
		List <MarketCreateBean> marketlist = inter.SelectDataMarketProcess(Integer.parseInt(bean.getMaster_market()));
		System.out.println("에러 market");
		for(MarketCreateBean m:marketlist) {
			data = new HashMap<String,String>();
			data.put("market_no",m.getMarket_no());
			data.put("market_name",m.getMarket_name());
			data.put("market_address",m.getMarket_address());
			data.put("market_image", m.getMarket_image());
			data.put("market_category",m.getMarket_category());
			data.put("market_content", m.getMarket_content());
			data.put("market_readsent", m.getMarket_readsent());
			data.put("market_star", m.getMarket_star());
			data.put("market_tel", m.getMarket_tel());
			data.put("market_time", m.getMarket_time());
			data.put("market_rowprice", m.getMarket_rowprice());
			marketList.add(data);
		}
		
		Map<String,Object> marketlists = new HashMap<String,Object>();
		marketlists.put("marketlists",marketList);
		return marketlists;
	}
	
	@RequestMapping(value="update_market",method=RequestMethod.GET)
	public String grooving(@RequestParam("no") String master_no) {
		return "update_market";
	}
	
	@RequestMapping(value="update_marketdata",method=RequestMethod.POST)
	public String updatemarket(MarketCreateBean bean, ServletRequest request,  Model model, @RequestParam("Update_market_img") MultipartFile file) throws UnknownHostException {
		
		String url = fileUploadService.restore(file);
		model.addAttribute("url", url);
		
		String str = request.getParameter("update_market_Img");
		String[] umarketimg = str.split("\\\\");
		
		
		MarketCreateBean data = bean;
		//data.setMarket_category(ftype);
		data.setMarket_no(request.getParameter("market_no"));	
		data.setMarket_image(umarketimg[2]);
		
		if(data.getMarket_image()==null) {
			data.setMarket_image("ready.jpg");
		}
		if(data.getMarket_category()==null) {
			data.setMarket_category("0");
		}
		
		boolean b = inter.UpdateMarketDataProcess(data);
		
		if(b) {
			return "main_menu"; 
		}else {
			return "food";
		}

	}
	
	@RequestMapping(value="delete_marketdata", method=RequestMethod.GET)
	public String delete(@RequestParam("no") String market_no) {

		boolean b = inter.DeleteMarketDataProcess(market_no);

		if(b) {
			return "main_menu"; 
		}else {
			return "food";
		}

	}
}
