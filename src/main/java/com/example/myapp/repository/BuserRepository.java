package com.example.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myapp.entity.BuserVO;

@Repository
public interface BuserRepository extends JpaRepository<BuserVO, Long>{

	BuserVO findByComIdAndComPassword(String userId, String userPw);

	BuserVO findByComNum(String comNum);

	BuserVO findByComLogo(String comLogo);
	
}
