package com.example.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myapp.entity.NuserVO;
import com.example.myapp.repository.NuserRepository;

@Service
public class NuserService {
	
	@Autowired
	NuserRepository nuserRepository;
	
	public List<NuserVO> findAll(){
		return nuserRepository.findAll();
	}
	
	public NuserVO save(NuserVO vo) {
		return nuserRepository.save(vo);
	}

	public NuserVO findByNorIdAndNorPassword(String userId, String userPw) {
		return nuserRepository.findByNorIdAndNorPassword(userId, userPw);
	}
	
}
