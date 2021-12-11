package com.example.myapp.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.myapp.entity.BuserVO;
import com.example.myapp.entity.NuserVO;
import com.example.myapp.entity.StationVO;
import com.example.myapp.service.BuserService;
import com.example.myapp.service.NuserService;
import com.example.myapp.service.StationService;

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	NuserService nuserService;
	
	@Autowired
	BuserService buserService;
	
	@Autowired
	StationService stationService;
	
	@GetMapping("login")		//로그인 페이지 이동
	public String loginGet() {
		return "login";
	}
	
	@PostMapping("login")		//로그인 처리 (session : nuser/buser)생성
	public String loginPost(HttpSession session, 
			@RequestParam String userId, 
			@RequestParam String userPw, 
			@RequestParam String logType) {
		if (logType.equals("nuser")) {
			NuserVO nuser = nuserService.findByNorIdAndNorPassword(userId, userPw);
			if (nuser!=null) {
				session.setAttribute("nuser", nuser);
				System.out.println(nuser);
			}
		} else if(logType.equals("buser")) {
			BuserVO buser = buserService.findByComIdAndComPassword(userId, userPw);
			if (buser!=null) {
				session.setAttribute("buser", buser);
				System.out.println(buser);
			}
		}
		return "redirect:/main";
	}
	
	@RequestMapping("logout")	//로그아웃처리 후 메인페이지 이동
	public String logout(HttpSession session) {
		if (session.getAttribute("nuser")!=null) {
			session.removeAttribute("nuser");
		} else if(session.getAttribute("buser")!=null) {
			session.removeAttribute("buser");
		}
		return "redirect:/main";
	}

	@RequestMapping("main")	//메인페이지 이동
	public String jspTest1() {
		return "main";
	}
	
	@GetMapping("SignUp")	//회원가입 페이지로 이동
	public String singUpGet() {
		return "SignUp";
	}
	
	@RequestMapping("BZ")	//회원가입 페이지에 포함된 기업회원 가입폼 이동
	public String jspTest2(Model model) {
		List<StationVO> list = stationService.findAll();
		model.addAttribute("stList", list);
		return "BZ";
	}
	
	@RequestMapping("Indi")	//회원가입 페이지에 포함된 일반회원 가입폼 이동
	public String jspTest3() {
		return "Indi";
	}
	
	@PostMapping("indiSignUp")	//일반회원 가입하기
	public String indiSingUpPost(
				@RequestParam String norId,
				@RequestParam String nickname, 
				@RequestParam String norEmail, 
				@RequestParam String norPassword ) {
		NuserVO vo = NuserVO.builder()
				.norId(norId)
				.nickname(nickname)
				.norEmail(norEmail)
				.norPassword(norPassword)
				.build();
		nuserService.save(vo);
		
		return "main";
	}	
	
	@PostMapping("BZSignUp")	//기업회원 가입하기
	public String BZSignUpPost(HttpServletRequest request,
				@RequestParam Long station,
				@RequestParam String comId,
				@RequestParam String comName,
				@RequestParam String comNum,
				@RequestParam String comPassword,
				@RequestParam MultipartFile comLogo) {
		BuserVO ori = buserService.findByComNum(comNum);
		if (ori!=null) {
			return "redirect:/SignUp";
		}
		BuserVO vo = BuserVO.builder()
				.comId(comId)
				.comName(comName)
				.comNum(comNum)
				.comLogo(null)
				.comPassword(comPassword)
				.station(stationService.findById(station))
				.build();
		if (!comLogo.isEmpty()) {
			try {
				String baseDir = request.getServletContext().getRealPath("logos");
				String fileName = comLogo.getOriginalFilename();
				String onlyName = fileName.substring(0, fileName.lastIndexOf("."));
				String onlyType = fileName.substring(fileName.lastIndexOf(".")+1);
				String finalFileName = onlyName+"_"+comName+"."+onlyType;
				vo.setComLogo(finalFileName);
				String filePath = baseDir + "\\" + finalFileName;
				comLogo.transferTo(new File(filePath));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		buserService.save(vo);
		return "redirect:/main";
	}

}
