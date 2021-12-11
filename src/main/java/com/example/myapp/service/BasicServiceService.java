package com.example.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myapp.entity.BasicServiceVO;
import com.example.myapp.repository.BasicServiceRepository;

@Service
public class BasicServiceService {

	@Autowired
	BasicServiceRepository basicServiceRepository;

	public BasicServiceVO findByStationId(int stationID) {
		return basicServiceRepository.findByStationId(stationID);
	}

	public void save(BasicServiceVO newBSvo) {
		basicServiceRepository.save(newBSvo);
	}
	
	
}
