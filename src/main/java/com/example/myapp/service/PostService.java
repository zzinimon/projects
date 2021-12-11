package com.example.myapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myapp.entity.PostVO;
import com.example.myapp.repository.PostRepository;


@Service
public class PostService {
	
	@Autowired
	PostRepository postRepository;
	
	public List<PostVO> findAll(){
		return postRepository.findAll();
	}
	
	public PostVO findById(Long id) {
		try {
			Optional<PostVO> vo = postRepository.findById(id);
			return vo.get();
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<PostVO> findByCom(String comName) {
		return postRepository.findByComName(comName);
	}
	
	
	public PostVO save(PostVO vo) {
		return postRepository.save(vo);
	}

	public void delete(long postid) {
		postRepository.deleteById(postid);
	}
	
}
