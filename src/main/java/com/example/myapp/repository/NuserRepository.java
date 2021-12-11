package com.example.myapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myapp.entity.NuserVO;

public interface NuserRepository extends JpaRepository<NuserVO, Long>{
	
	NuserVO findByNorIdAndNorPassword(String norId, String norPassword);
	
	List<NuserVO> findAll();
	
}
