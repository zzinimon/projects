package edu.test.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.test.demo.dao.ImageDAO;
import edu.test.demo.vo.ImageVO;

@Service
public class ImageService {
	@Autowired
	ImageDAO imageDAO;
	
	public ImageVO selectImageByImageId(int image_id) {
		return imageDAO.selectImageByImageId(image_id);
	}
	
}
