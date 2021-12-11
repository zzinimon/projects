package com.example.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myapp.entity.AlphaServiceVO;

@Repository
public interface AlphaServiceRepository extends JpaRepository<AlphaServiceVO, Long>{
	
}
