package com.coderbar.emp.service.impl;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.coderbar.emp.mapper.EmpMapper;
import com.coderbar.emp.model.EmpData;
@SpringBootTest
public class LoginServiceImplTest3 {
	@Resource
	EmpMapper empMapper;
	@Test
	public int testAddEmp(EmpData emp) {
		//EmpData selectByEmpCd = empMapper.selectByEmpCd(emp.getEmpCd());
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
		return 0;
	}

}
