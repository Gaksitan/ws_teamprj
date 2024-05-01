package com.example.teamprj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.teamprj.dao.IUserDao;
import com.example.teamprj.dto.User;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class MyController {
	
	@Autowired
	private IUserDao dao;
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	@RequestMapping("/list")
	public void list(Model model) {
		log.info("list 실행");
		model.addAttribute("list", dao.getUserList());

	}
	
	
	@RequestMapping("/writeForm")
	public void writeForm() {
		log.info("writeForm..");
	}
	
	
	@RequestMapping("/write")
	public String write(Model model, @RequestParam("id") String id, @RequestParam("pw") String pw) {
		log.info("write");
		User user = new User(id,pw);
		dao.saveUser(user);
		return "redirect:list";
	}
	
	
	@RequestMapping("/detail")
	public void detail(@RequestParam("uno") String uno, Model model) {
		int uno_ = Integer.parseInt(uno);
		model.addAttribute("list", dao.getUser(uno_));
	}
	
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("uno") String uno) {
		log.info("delete...");
		int uno_ = Integer.parseInt(uno);
		int result = dao.deleteUser(uno_);
		
		if(result==1) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
		
		
		return "redirect:list";
	}
	
	
}
