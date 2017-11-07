package com.accenture.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VerifyController {
	ArrayList<Integer> list=new ArrayList<>();
	
	@RequestMapping("/verify")
	public ModelAndView verifyPin(HttpServletRequest request,HttpServletResponse response){
		String pin= request.getParameter("pincode");
		int pincode=0;
		if(pin!=null)
			pincode=Integer.parseInt(pin);
	
		//list=new ArrayList<>();
		list.add(560024);
		list.add(560016);
		boolean flag=false;
		for(int i=0;i<list.size();i++){
			if(list.get(i)==pincode){
				flag=true;
				break;
			}
			else{
				list.add(pincode);
			}
		}
		ModelAndView model;
		if(flag)
		model=	new ModelAndView("CheckPin.jsp","msg","We have Service");
		else
			model= new ModelAndView("notification.jsp","msg","We don't have Service");
		
		return model;
	}
}
