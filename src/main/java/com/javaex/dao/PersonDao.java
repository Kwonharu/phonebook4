package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PersonDao {
	
	//필드
	@Autowired
	private SqlSession sqlSession;
	
	//생성자
	
	//메소드gs
	
	//메소드일반
	
	//전체 리스트 가져오기
	public List<PersonVo> personSelect(){
		System.out.println("PersonDao.personSelect()");
		
		//db에서 리스트 가져온다
		List<PersonVo> personList = sqlSession.selectList("phonebook.select");
													//phonebook.xml의 "namespace.id"
		//System.out.println(personList);
		
		return personList;
	}
	
	//1명 삭제하기
	public int personDelete(int personId) {
		System.out.println("PersonDao.personDelete()");
		System.out.println("personId: "+personId);
		
		int count = sqlSession.delete("phonebook.delete", personId);
			//얘도 결과 나올 때 숫자를 넘겨줌.					
		System.out.println("delete count: "+count);
		
		return count;
	}
	
	//등록
	public int personInsert(PersonVo personVo) {
		System.out.println("PersonDao.personInsert()");
		System.out.println("personVo: "+personVo);
	
		int count = sqlSession.insert("phonebook.insert", personVo);
												//여기로 줄 수 있는 건 딱 하나. 묶어서 보내야 함.
		System.out.println("personInsert count: "+count);
		
		return count;
	}
	
	//수정폼 -> 1명 데이터 가져오기
	public PersonVo personSelectOne(int personId) {
		System.out.println("PersonDao.personSelectOne()");
		//System.out.println("personId: "+personId);
		
		PersonVo personVo = sqlSession.selectOne("phonebook.selectByNo", personId);
		
		return personVo;
	}
	
	//수정
	public int personUpdate(PersonVo personVo) {
		System.out.println("PersonDao.personUpdate()");
		
		int count = sqlSession.insert("phonebook.update", personVo);
		
		return count;
	}
}






