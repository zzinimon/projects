package com.example.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myapp.entity.LineVO;
import com.example.myapp.repository.LineRepository;

@Service
public class LineService {

	@Autowired
	LineRepository lineRepository;

	public LineVO findById(Integer type) {
		try {
			LineVO vo = lineRepository.findById(type).get();
			return vo;
		} catch (Exception e) {
			return null;
		}
	}
	
}
