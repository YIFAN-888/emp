package com.coderbar.emp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.coderbar.emp.mapper.EmpMapper;
import com.coderbar.emp.model.EmpData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@SpringBootTest
public class LoginServiceImplTest {

		@Resource
		EmpMapper empMapper;
		@Test
		public void testSelectEmpByPage() {
//			List<EmpData> selectDynamic = empMapper.selectDynamic(null, null, null, null, null);
//			System.out.println(selectEmpDynamic);
			// PageHelper.startPage():开启分页拦截
			PageHelper.startPage(1, 5);
			// 第一个参数:表示当前所在页码
			// 第二个参数:表示每页显示的数据数量
			List<EmpData> selectDynamic = empMapper.selectDynamic(null, null, null, null, null);
			// PageInfo:可以根据分页结果自动获取分页的相关数据
			PageInfo<EmpData> pageInfo = new PageInfo<>(selectDynamic);
			// getList():获取当前页所有数据的集合信息
			System.out.println(pageInfo.getList());
			// getPageNum():获取当前页页码
			System.out.println(pageInfo.getPageNum());
			// getPages():获取总页数
			System.out.println(pageInfo.getPages());
		}
	}


