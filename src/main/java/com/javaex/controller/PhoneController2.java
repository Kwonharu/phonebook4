package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.PersonDao2;
import com.javaex.vo.PersonVo;


//@RequestMapping("/user")
public class PhoneController2 {
	//필드
	@Autowired
	private PersonDao2 personDao;
	
	//생성자
	//메소드gs
	
	
	//메소드일반
	//localhost:8000/phonebook4/list
	@RequestMapping(value="/list", method={RequestMethod.POST, RequestMethod.GET})
	public String list(Model model) {
		
		System.out.println("PhoneController.list()");
			
		//personDao.personSelect() 리스트 가져온다
		
		//@Autowired 사용
		//PersonDao personDao = new PersonDao();
		
		List<PersonVo> personList = personDao.personSelect("");
		System.out.println(personList);
		
		//model 주소를 받고 메소드를 이용해서 담는다
		// --> DS request.setAttribute("personList", personList)
		model.addAttribute("personList", personList);
		
		return "list";
		
		//request의 attribute에 넣는다
		//list.jsp에 포워드
	}
	
	//주소록 등록 폼
	@RequestMapping(value="/writeform", method={RequestMethod.POST, RequestMethod.GET})
	public String writeform() {
		
		System.out.println("PhoneController.writeform()");

		return "writeForm";

	}
	
	//주소록 등록
	@RequestMapping(value="/write", method={RequestMethod.POST, RequestMethod.GET})
	public String write(@ModelAttribute PersonVo personVo) {
		
		System.out.println("PhoneController.write()");

		//vo로 묶기	ds
		/*
		PersonVo personVo = new PersonVo();
		personVo.setName(name);
		personVo.setHp(hp);
		personVo.setCompany(company);
		*/
		
		System.out.println(personVo);
		
		//dao를 통해 저장
		//@Autowired 사용
		//PersonDao personDao = new PersonDao();
		int count = personDao.personInsert(personVo);		
		System.out.println("personInsert count: "+count);
		
		return "redirect:/list";

	}
	
	/*
	//주소록 등록
	@RequestMapping(value="/write", method={RequestMethod.POST, RequestMethod.GET})
	public String write(@RequestParam("name") String name,
						@RequestParam("hp") String hp,
						@RequestParam("dompany") String company) {
		
		System.out.println("PhoneController.write()");

		//vo로 묶기	ds
		PersonVo personVo = new PersonVo();
		personVo.setName(name);
		personVo.setHp(hp);
		personVo.setCompany(company);
		
		System.out.println(personVo);
		
		//dao를 통해 저장
		PersonDao personDao = new PersonDao();
		int count = personDao.personInsert(personVo);		
		System.out.println("personInsert count: "+count);
		
		return "redirect:/list";
	}
	*/
	
	//person 삭제
	@RequestMapping(value="/delete/{no}", method={RequestMethod.POST, RequestMethod.GET})
	public String delete(@PathVariable(value="no") int personId) {
		
		System.out.println("PhoneController.delete()");
		System.out.println("no: "+personId);
		
		//@Autowired 사용
		//PersonDao personDao = new PersonDao();
		int count = personDao.personDelete(personId);		
		System.out.println("personInsert count: "+count);
		
		return "redirect:/list";
	}
	/*
	@RequestMapping(value="/delete", method={RequestMethod.POST, RequestMethod.GET})
	public String delete(@RequestParam("no") int personId) {
		
		System.out.println("PhoneController.delete()");
		System.out.println("no: "+personId);
		
		PersonDao personDao = new PersonDao();
		int count = personDao.personDelete(personId);		
		System.out.println("personInsert count: "+count);
		
		return "redirect:/list";
	}
	*/
	
	//주소록 수정 폼
	@RequestMapping(value="/updateform/{no}", method={RequestMethod.POST, RequestMethod.GET})
	public String updateform(Model model,
							 @PathVariable(value="no") int personId) {
		
		System.out.println("PhoneController.updateform()");

		//@Autowired 사용
		//PersonDao personDao = new PersonDao();
		PersonVo personVo = personDao.getPerson(personId);
		
		model.addAttribute("personVo", personVo);
		
		return "updateForm";

	}
	
	//person 수정
	@RequestMapping(value={"/update"}, method={RequestMethod.POST, RequestMethod.GET})
	public String update(@ModelAttribute PersonVo personVo) {
		
		System.out.println("PhoneController.update()");
		System.out.println("personVo: "+personVo);
		
		//@Autowired 사용
		//PersonDao personDao = new PersonDao();	
		int count = personDao.personUpdate(personVo);		
		System.out.println("personUpdate count: "+count);
		
		return "redirect:/list";
	}
}



