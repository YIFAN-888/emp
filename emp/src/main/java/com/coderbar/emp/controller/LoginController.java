package com.coderbar.emp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coderbar.emp.mapper.EmpMapper;
import com.coderbar.emp.model.EmpData;
import com.coderbar.emp.service.LoginService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/emp") // (一级路径)
public class LoginController {
	
	//引入接口对象
	@Autowired
	LoginService loginService;
	
	@Autowired
	EmpMapper empMapper;

	@RequestMapping("/goLogin")
	public String goLogin() {
		return "login";
	}
	//跳转到社員情報一覧
	@RequestMapping("/doLogin")
	public String doLogin(String username,String password,Model model) {
		int login = loginService.login(username, password);
		if (login==4) {
			//需要调用service层
			PageInfo<EmpData> selectEmpBypage = loginService.selectEmpBypage(1, null, null, null, null, null);
			model.addAttribute("emps",selectEmpBypage);
			return "emplist";
			
		}else if(login==1){
			model.addAttribute("error","ユーザーをご入力ください。");
			return "login";
		}else if (login==2) {
			model.addAttribute("error","パスワードをご入力ください");
			return "login";
		}else if(login==3){
			model.addAttribute("error","ユーザーIDかパスワードが存在しません");
			return "login";
		}else {
			return "login";
		}
	}
	//跳转到添加画面
	@RequestMapping("/goAdd")
	public String goAdd() {
		
		return "addEmp";	
	}
	
	@RequestMapping("/doAdd")
	
	public String doAdd(EmpData emp,Model model) {
		int addEmp = loginService.addEmp(emp);
		if (addEmp==8) {
			PageInfo<EmpData> selectEmpBypage = loginService.selectEmpBypage(1, null, null, null, null, null);
			model.addAttribute("emps",selectEmpBypage);
			return "emplist";			
		}
		
		if(addEmp==6){
		model.addAttribute("error","この社員番号が既に登録しました、別の社員番号を入力してください");
		return "addEmp";
		
		}else {
			return "addEmp";
		}
	}
	//変更
	@RequestMapping("/goUpdate")
	public String goUpdate(String empCd,Model model) {
		EmpData selectByEmpCd = empMapper.selectByEmpCd(empCd);
		model.addAttribute("emp",selectByEmpCd);
		return "update";		
	}
	@RequestMapping("/doUpdate")
	public String doUpdate(EmpData emp,Model model) {
		boolean updateEmp = empMapper.updateEmp(emp);
		if (updateEmp) {
			PageInfo<EmpData> selectEmpBypage = loginService.selectEmpBypage(1, null, null, null, null, null);
			model.addAttribute("emps",selectEmpBypage);
			return "emplist";
		}else {
			model.addAttribute("error","変更失敗");
			return "update";
		}	
	}

	//删除
	@RequestMapping("/doDelete")
	public String doDelete(String empCd,Model model) {
		boolean deleteEmp = empMapper.deleteEmp(empCd);
		if (deleteEmp) {
			/*
			 * List<EmpData> selectAllEmp = empMapper.selectAllEmp();
			 * model.addAttribute("emps",selectAllEmp);
			 */	
			PageInfo<EmpData> selectEmpBypage = loginService.selectEmpBypage(1, null, null, null, null, null);
			model.addAttribute("emps",selectEmpBypage);
		}else {
			/*
			 * List<EmpData> selectAllEmp = empMapper.selectAllEmp();
			 * model.addAttribute("emps",selectAllEmp);
			 */
			PageInfo<EmpData> selectEmpBypage = loginService.selectEmpBypage(1, null, null, null, null, null);
			model.addAttribute("emps",selectEmpBypage);
		}
		return "emplist";
		
	}
	
	//搜索
	@RequestMapping("/doSelect")
	public String doSelect(String empCd,String name,String birthday,String genderName ,String nationalityName,Model model) {
		PageInfo<EmpData> selectEmpBypage = loginService.selectEmpBypage(1, empCd,name,birthday,genderName,nationalityName);
		model.addAttribute("emps",selectEmpBypage);
		model.addAttribute("empCd",empCd);
		model.addAttribute("name",name);
		model.addAttribute("birthday",birthday);
		model.addAttribute("genderName",genderName);
		model.addAttribute("nationalityName",nationalityName);
		return "emplist";	
	}
	@RequestMapping("/goEmp")
	public String goEmp(String empCd,Model model) {
		EmpData selectByEmpCd = empMapper.selectByEmpCd(empCd);
		model.addAttribute("emp",selectByEmpCd);
		
		return "empDetails";
		
	}
	@RequestMapping("/goempList")
	public String goempList(Model model) {
		PageInfo<EmpData> selectEmpBypage = loginService.selectEmpBypage(1, null, null, null, null, null);
		model.addAttribute("emps",selectEmpBypage);
		return "emplist";	
	}
	@RequestMapping("/lastPage")
	public String lastPage(String page,String empCd,String name,String birthday,String genderName,String nationalityName, Model model) {
		PageInfo<EmpData> selectEmpByPage = loginService.selectEmpBypage(Integer.parseInt(page), empCd, name, birthday, genderName, nationalityName);
		model.addAttribute("emps", selectEmpByPage);
		model.addAttribute("empCd", empCd);
		model.addAttribute("name", name);
		model.addAttribute("birthday", birthday);
		model.addAttribute("genderName", genderName);
		model.addAttribute("nationalityName", nationalityName);
		return "emplist";
	}
	
	
	@RequestMapping("/nextPage")
	public String nextPage(String page,String empCd,String name,String birthday,String genderName,String nationalityName, Model model) {
		PageInfo<EmpData> selectEmpBypage = loginService.selectEmpBypage(Integer.parseInt(page), empCd, name, birthday, genderName, nationalityName);
		model.addAttribute("emps",selectEmpBypage);
		model.addAttribute("empCd",empCd);
		model.addAttribute("name",name);
		model.addAttribute("birthday",birthday);
		model.addAttribute("genderName",genderName);
		model.addAttribute("nationalityName",nationalityName);
		return "emplist";
	}
	
	
	
}
	
