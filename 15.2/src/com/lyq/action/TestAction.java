package com.lyq.action;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
    public String execute() throws Exception{
    	//�߳�˯��1��
    	Thread.sleep(1000);
    	return SUCCESS;
    }

}
