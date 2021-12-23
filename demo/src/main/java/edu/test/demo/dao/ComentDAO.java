package edu.test.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import edu.test.demo.vo.CocomentVO;
import edu.test.demo.vo.ComentVO;

@Repository
@Mapper
public interface ComentDAO {
	public ComentVO selectComentByComentId(int coment_id);			//��� ���̵�� Ư�� ��� 1���� �޾ƿ�
	public List<ComentVO> selectComentByUserId(int user_id);		//���� ���̵�� ��� ����� ������
	public List<ComentVO> selectComentByComentIdTo(int coment_id_to);//����� �޴� ��� ���̵�� ��� ����� ������
	public int insertComent(ComentVO comentVO);						//��� �Է�
}
