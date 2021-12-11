package com.example.myapp.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myapp.entity.PostVO;

@Repository
public interface PostRepository extends JpaRepository<PostVO, Long>{
	
	Optional<PostVO> findById(Long id);
	List<PostVO> findByComName(String comName);
	

}
