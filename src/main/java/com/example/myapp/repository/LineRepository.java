package com.example.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myapp.entity.LineVO;

public interface LineRepository extends JpaRepository<LineVO, Integer>{
	
}
