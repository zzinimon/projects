package com.example.myapp.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.myapp.entity.PostVO;
import com.example.myapp.service.PostService;
import com.example.myapp.service.ReviewService;
import com.example.myapp.service.StationService;

@Controller
@RequestMapping("test")
public class TestController {
	
	@Autowired
	ReviewService reviewService;
	@Autowired
	PostService postService;
	@Autowired
	StationService stationService; 	
	
	@RequestMapping("")
	public String MainPage() {
		return "testindex";
	}
	@RequestMapping("main")
	public String subwayPage() {
		return "main";
	}
	
	@RequestMapping("map")
	public String mapPage() {
		return "TestMap";
	}
	@RequestMapping("ad")
	public String businessPage(Model model, @RequestParam String com) {
		model.addAttribute("evtlist", postService.findByCom(com));
		return "ComHome";
	}
	@GetMapping("ad/insert")
	public String evtInsertGet(Model model, String comName) {
		model.addAttribute("evt", PostVO.builder().build());
		System.out.println(comName);
		return "EvtInsert";
	}
	@PostMapping("ad/insert")
	public String evtInsertPost(Model model, PostVO post) {
		post.setDate(new Date(new java.util.Date().getTime()));
		postService.save(post);
		return "redirect:/test/ad";
	}
	@RequestMapping("ad/delete")
	public String evtdelete(Model model,@RequestParam Long post,@RequestParam String com) {
		
		if (post!=null) {
			System.out.println(post);
			postService.delete(post);
		}
		return "redirect:/test/ad?com="+com;
	}
	@RequestMapping("ad/modify")
	public String modifypost(Model model, @RequestParam long id) {
		PostVO post= postService.findById(id);
		model.addAttribute("evt", post);
		return "EvtModify";
	}
	@RequestMapping("ad/evt")
	public String evtPage(Model model, @RequestParam long post) {
		model.addAttribute("evt", postService.findById(post));
		return "EvtDetail";
	}
	
	@GetMapping("/station")
	public String stationPage(Model model, @RequestParam long id) {
		model.addAttribute("id", id);
		return"station";
	}
	@RequestMapping("/sdetail")
	public String DetailPage(Model model, 
			@RequestParam(required = false) Long id) {
		if (id!=null) {
			System.out.println(id);
			model.addAttribute("bs", stationService.findById(id));
			System.out.println(stationService.findById(id));
			return "sdetail";
		}
		return "sdetail";
	}
	@RequestMapping("/rvlist")
	public String rvlist(Model model) {
		//model.addAttribute("reviewList",reviewService.findAll());
		return "rvlist";
	}
	@RequestMapping("/shoplist")
	public String shoplist() {
		return "shoplist";
	}
	
	
	
	@RequestMapping("/login")
	public String LoginPage() {
		return "login";
	}
	
	
	@RequestMapping("/sign")
	public String SignUpPage() {
		return "SignUp";
	}
	@RequestMapping("/bzsign")
	public String BZSignUp() {
		return "BZ";
	}
	@RequestMapping("/indisign")
	public String IndiSignUp() {
		return "Indi";
	}
	
	
	@RequestMapping("/getLineData.do")
	public String getLineTest() {
		return "getLineData";
	}
	
}
