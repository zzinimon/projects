package com.example.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myapp.entity.BuserVO;
import com.example.myapp.repository.BuserRepository;

@Service
public class BuserService {

	@Autowired
	BuserRepository buserRepository;

	public BuserVO findByComIdAndComPassword(String userId, String userPw) {
		return buserRepository.findByComIdAndComPassword(userId, userPw);
	}

	public void save(BuserVO vo) {
		buserRepository.save(vo);
	}

	public BuserVO findByComNum(String comNum) {
		return buserRepository.findByComNum(comNum); // 유저존재
	}

	public BuserVO findByComLogo(String comLogo) {
		return buserRepository.findByComLogo(comLogo);
	}

}
