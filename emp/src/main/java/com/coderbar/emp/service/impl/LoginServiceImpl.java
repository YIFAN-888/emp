package com.coderbar.emp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coderbar.emp.mapper.EmpMapper;
import com.coderbar.emp.mapper.LoginMapper;
import com.coderbar.emp.model.EmpData;
import com.coderbar.emp.model.LoginUser;
import com.coderbar.emp.service.LoginService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class LoginServiceImpl implements LoginService{
	//用于业务逻辑
	@Autowired
	LoginMapper loginMapper;
	
	@Autowired
	EmpMapper empMapper;
	@Override
	public int login(String username, String password) {
		if (username == null || username.equals("")) {
			return 1;
		}
		if (password == null || password.equals("")) {
			return 2;
		}
		//需要将账号密码作为条件从数据库中进行查询
		//想要调用持久层方法，直接从Sping容器中取出对象即可
		LoginUser lu = new LoginUser();
		lu.setAccountId(username);
		lu.setPassword(password);
		LoginUser login = loginMapper.Login(lu);
		
		if (login != null) {
			return 4;			
		}else {
			return 3;
		}
	
	}
	//addEmp的实现类
	@Override
	public int addEmp(EmpData emp) {
		if (emp.getEmpCd() == null || emp.getEmpCd().equals("")) {
			return 1;
		}
		if (emp.getName() == null || emp.getName().equals("")) {
			return 2;
		}
		if (emp.getBirthday() == null || emp.getBirthday().equals("")) {
			return 3;
		}
		if (emp.getGenderCd() == null || emp.getGenderCd().equals("")) {
			return 4;
		}
		if (emp.getNationalityCd() == null || emp.getNationalityCd().equals("")) {
			return 5;
		}
		
		//判断员工编号不能重复		
		EmpData selectByEmpCd = empMapper.selectByEmpCd(emp.getEmpCd());
		  if (selectByEmpCd != null){
			  return 6; 
		  }
		 	
			 
						
		boolean addEmp = empMapper.addEmp(emp);
		if (addEmp) {
			return 8;
		}else {
			return 7;
		}		
	}

	@Override
	public PageInfo<EmpData> selectEmpBypage(Integer currentPage, String empCd, String name, String birthday, String genderName,
			String nationalityName) {
		//不需要改动持久层代码	
		// PageHelper.startPage():开启分页拦截
			PageHelper.startPage(currentPage, 5);
		// 第一个参数:表示当前所在页码
		// 第二个参数:表示每页显示的数据数量
			List<EmpData> selectDynamic = empMapper.selectDynamic(empCd,name,birthday,genderName,nationalityName);
		// PageInfo:可以根据分页结果自动获取分页的相关数据
			PageInfo<EmpData> pageInfo = new PageInfo<>(selectDynamic);
			return pageInfo;
	}
		
}
