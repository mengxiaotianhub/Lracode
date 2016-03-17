package com.mengxiaotian.learn.spring.web.controller;


import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mengxiaotian.learn.spring.meta.User;
import com.mengxiaotian.learn.spring.service.impi.SelectUserImpi;

@Controller
public class HelloController {
	
	@Autowired
	private  SelectUserImpi impi;
	
	@RequestMapping(value="/spring/login")
	public String spring(@RequestParam("name") String name,@RequestParam("password") String password,ModelMap map) throws IOException{
		map.addAttribute("name",name);
		map.addAttribute("password",password);
		return "user";
	}
	
	@RequestMapping(value="/spring/write")
	public void table(@RequestHeader("Accept") String accept,Writer writer){
		List<User> userlist = impi.Select();
		for(User user:userlist){
		try {
			writer.write(user.getId()+ "--"+ user.getUserName()+ "<p />");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	@RequestMapping(value="/spring/table.json",headers="Accept=application/json")
	public List<User> json(){
		List<User> userlist = impi.Select();
		return userlist;
		}
	
	@RequestMapping(value="/spring/table.html",headers="Accept=text/html")
	public String freemarker(Model map){
		List<User> userlist = impi.Select();
		map.addAttribute("userlist",userlist);
		return "user1";
		}
	
}

