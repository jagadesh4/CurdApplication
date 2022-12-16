package com.nucleus.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nucleus.service.AddService;

@Controller
public class AddController 
{
	@RequestMapping("/add")
	public ModelAndView Add(HttpServletRequest request, HttpServletResponse response)
	{
		int i = Integer.parseInt(request.getParameter("t1"));
		int j = Integer.parseInt(request.getParameter("t2"));
		AddService as = new AddService();
		ModelAndView mv =new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("result",as.add(i, j));
		return mv;
	}

}
