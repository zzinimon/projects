package com.example.myapp.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myapp.entity.ReviewVO;
import com.example.myapp.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	ReviewRepository reviewRepository;

	public List<ReviewVO> findByRvStatusTrue(){
		List<ReviewVO> list = reviewRepository.findByRvStatusTrue();
		return list;
	}
	
	public List<ReviewVO> findByStationId(long stId){
		List<ReviewVO> list = reviewRepository.findByStationId(stId);
		for (Iterator<ReviewVO> iterator = list.iterator(); iterator.hasNext();) {
			ReviewVO reviewVO = (ReviewVO) iterator.next();
			if (!(reviewVO.isRvStatus())) {
				iterator.remove();
			}
		}
		return list;
	}
	
	public void save(ReviewVO vo) {
		reviewRepository.save(vo);
	}

	public ReviewVO findById(Long rvId) {
		ReviewVO vo = reviewRepository.findById(rvId).get();
		return vo;
	}
	
	
	
}
