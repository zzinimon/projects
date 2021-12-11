package com.example.myapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myapp.entity.StationVO;
import com.example.myapp.repository.StationRepository;

@Service
public class StationService{

	@Autowired
	StationRepository stationRepository;

	public void save(StationVO vo) {
		stationRepository.save(vo);
	}

	public StationVO findById(long stationID) {
		try {
			Optional<StationVO> vo = stationRepository.findById(stationID);
			return vo.get();
		} catch (Exception e) {
			return null;
		}
	}

	public List<StationVO> findAll() {
		List<StationVO> list = stationRepository.findAll();
		
		list = list.stream().sorted( (st1, st2) -> st1.getId() <= st2.getId() ? 1 : -1).collect(Collectors.toList());
		//list = list.stream().sorted((StationVO e1, StationVO e2) -> e2.getId().compareTo(e1.getId())).collect(Collectors.toList());
		
		return list;
	}

}
