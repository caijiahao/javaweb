package com.gc.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class Login extends SimpleFormController{
	
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	public ModelAndView onSubmit(Object command,BindException errors) throws Exception{
		User user = (User)command;
		Map model = errors.getModel();
		model.put("user", user);
		return new ModelAndView(getSuccessView(),model);
		
	}

}
