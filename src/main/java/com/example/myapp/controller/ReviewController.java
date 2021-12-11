package com.example.myapp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.myapp.entity.ReviewVO;
import com.example.myapp.service.ReviewService;
import com.example.myapp.service.StationService;

@Controller
@RequestMapping("review")	//지하철 서비스 하단의 리뷰 controller
public class ReviewController {

	@Autowired
	ReviewService reviewService;
	@Autowired
	StationService stationService;

	@RequestMapping("/list")		//review 테이블에서 rv_status=true 인 것만 가져와서 리스트로 보냄
	public String reviewGet(Model model, @RequestParam long stId) {
		model.addAttribute("stId", stId);	//station_id
		model.addAttribute("station", stationService.findById(stId).getStationName());	//station_name
		List<ReviewVO> list = reviewService.findByStationId(stId);
		model.addAttribute("list", list);
		return "review/list";
	}

	@GetMapping("/add")
	public String reviewAddGet(Model model) {
		return "review/add";
	}
	
	@PostMapping("/add")			//add페이지에서 받아온 내용 review 테이블에 저장
	public String reviewAddPost(
			@RequestParam String rvContent, 
			@RequestParam long stId, 
			@RequestParam String rvWriter) {
		Date rvDate = new Date();
		ReviewVO vo = ReviewVO.builder()
				.rvContent(rvContent)
				.rvWriter(rvWriter)
				.rvStatus(true)		//처음에 글쓸때는 rvStatus=true 가 디폴트 (삭제하면 false로)
				.rvDate(rvDate)
				.station(stationService.findById(stId))
				.build();
		reviewService.save(vo);
		return "redirect:/review/list?stId="+stId;
	}
	
	@GetMapping("/delete")			//id값 받아와서 rvStatus=false 로 바꿔서 저장하기
	public String reviewDeleteGet(
			@RequestParam Long rvId,
			@RequestParam long stId) {
		if (rvId!=null) {
			ReviewVO vo = reviewService.findById(rvId);
			vo.setRvStatus(false);
			reviewService.save(vo);
		}
		return "redirect:/review/list?stId="+stId;
	}
	
}
