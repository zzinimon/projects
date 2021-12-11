package com.example.myapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myapp.entity.ReviewVO;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewVO, Long>{

	List<ReviewVO> findByRvStatusTrue();

	List<ReviewVO> findByStationId(long stId);
	
}
