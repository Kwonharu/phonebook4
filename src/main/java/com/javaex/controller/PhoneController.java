package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PersonDao;
import com.javaex.vo.PersonVo;

@Controller
public class PhoneController {
	
	@Autowired
	private PersonDao personDao;
	
	//리스트
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("PhoneController.list()");
		
		//db에서 리스트를 가져온다.
		List<PersonVo> personList = personDao.personSelect();
		
		//ds에게 데이터 보냄. 포워드 request.Attribute 영역에 넣어라.
		model.addAttribute("personList", personList);
		
		//forward 해라.
		return "list";
		//return이 null이면 list로 forward 하더라. 미친 ㅅ1ㄲ
	}
	
	//삭제
	@RequestMapping(value="/delete/{no}", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@PathVariable(value="no") int personId) {
		System.out.println("PhoneController.delete()");
		System.out.println("/delete/{no}: "+personId);
		
		//dao를 통해서 삭제한다
		int count = personDao.personDelete(personId);
		//System.out.println("delete 여부: "+count);
		
		return "redirect:/list";
	}
	
	//등록폼
	@RequestMapping(value="/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("PhoneController.writeForm()");
		
		return "writeForm";
	}
	
	//등록
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController.write()");
		
		int count = personDao.personInsert(personVo);
		//System.out.println("write count: "+count);
		//여기서 count 또 받는 이유: 나중에 js에서 event 파라미터 등으로 써먹을려고

		return "redirect:/list";
	}
	
	//수정폼
	@RequestMapping(value="/updateForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String updateForm(@RequestParam(value="no") int personId,
							 Model model) {
		System.out.println("PhoneController.updateForm()");
		//System.out.println("updateForm personId: "+personId);
		
		//1명 데이터 가져오기
		PersonVo personVo = personDao.personSelectOne(personId);
		
		//ds 포워드 시킨다
		model.addAttribute("personVo", personVo);
		
		return "updateForm";
	}
	
	//수정
	@RequestMapping(value="/update", method= {RequestMethod.GET, RequestMethod.POST})
	public String update(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController.update()");
		
		int count = personDao.personUpdate(personVo);
		
		return "redirect:/list";
	}
	
}






