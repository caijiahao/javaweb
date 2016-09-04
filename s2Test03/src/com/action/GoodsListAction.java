package com.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.po.Goods;
import com.service.IGoodsService;
import com.service.impl.GoodsService;

public class GoodsListAction extends ActionSupport{

	/**
	 * 
	 */
	private List<Goods> glist;
	private HttpServletRequest request;
	private HttpSession session;
	public List<Goods> getGlist() {
		return glist;
	}

	public void setGlist(List<Goods> glist) {
		this.glist = glist;
	}

	public GoodsListAction(){
		request=ServletActionContext.getRequest();
    	session=request.getSession();
	}
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("deprecation")
	@Override
	public String execute(){
		IGoodsService gService = new GoodsService();
		glist = gService.getAllGoods();
		session.putValue("goodslist", glist);
		return "success";
	}
    
}
