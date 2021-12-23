package edu.test.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.test.demo.dao.UserCharacterDAO;
import edu.test.demo.vo.UserCharacterVO;

@Service
public class UserCharacterService {
	@Autowired
	UserCharacterDAO userCharacterDAO;
//���� ���̵�� Ư�� ���� 1���� �޾ƿ�
	public UserCharacterVO selectUserCharacterByUserId(int user_id) {
		return userCharacterDAO.selectUserCharacterByUserId(user_id);
	}
}
