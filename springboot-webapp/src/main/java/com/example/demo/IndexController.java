package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@RequestMapping("index")
//	public String home(@RequestParam("name") String name, HttpSession session) {
////		public String home(HttpServletRequest req) {
////		String name=req.getParameter("name");
////		HttpSession session= req.getSession();
//		session.setAttribute("name", name);
//		return "index";
//	}
	
//	public ModelAndView home(@RequestParam("name") String name, HttpSession session) {
//		ModelAndView mv= new ModelAndView();
//		mv.addObject("name",name);
//		mv.setViewName("index");
//		return mv;
//	}
	
	public ModelAndView home(Alien a, HttpSession session) {
	ModelAndView mv= new ModelAndView();
	mv.addObject("obj",a);
	mv.setViewName("index");

	return mv;
}
}
