package edu.test.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.test.demo.dao.CocomentDAO;
import edu.test.demo.dao.ComentDAO;
import edu.test.demo.vo.CocomentVO;

@Service
public class CocomentService {
	@Autowired
	CocomentDAO cocomentDAO;
//���� ���̵�� Ư�� ���� 1���� �޾ƿ�
	public CocomentVO selectCocomentByCocomentId(int cocoment_id) {
		return cocomentDAO.selectCocomentByCocomentId(cocoment_id);
	}

//��� ���̵�� ���� ����Ʈ�� �޾ƿ�
	public List<CocomentVO> selectCocomentByComentId(int coment_id) {
		return cocomentDAO.selectCocomentByComentId(coment_id);
	}
}
