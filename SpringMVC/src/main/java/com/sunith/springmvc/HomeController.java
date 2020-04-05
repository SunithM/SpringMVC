package com.sunith.springmvc;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.sunith.model.Alien;
import com.sunith.springmvc.doa.AlienDao;



@Controller
public class HomeController
{
	@Autowired
	private AlienDao dao;
	
	@ModelAttribute
	public void modelData(Model m) 
	{
	m.addAttribute("name","Aliens");
	}
	
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	
	@GetMapping("getAliens")
	public String getAliens(Model m)
	{
		m.addAttribute("result", dao.getAliens());
		return "showAlien";
		
	}
	@RequestMapping("add")
	public String add(@RequestParam("num1")int i ,@RequestParam("num2") int j, Model m)
	{
		
	
		int num3 = i + j;
		
		m.addAttribute("num3",num3);
		
		return  "result";
		
	}
	
	@GetMapping("getAlienSearch")
	public String getAlienSearch(@RequestParam int aid,Model m)
	{
		m.addAttribute("result", dao.getAlien(aid));
		return "showAlien";
	}
	
	
	@RequestMapping("addAlien")
	public String addAlien(@ModelAttribute("result") Alien a)
	{
		dao.addAlien(a);
		return "showAlien";
		
	}
	
}