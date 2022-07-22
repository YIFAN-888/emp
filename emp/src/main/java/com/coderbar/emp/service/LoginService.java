package com.coderbar.emp.service;

import com.coderbar.emp.model.EmpData;
import com.github.pagehelper.PageInfo;

public interface LoginService {
	/**
	 * loginメソッドは登録の確認
	 * @param username:ユーザー名
	 * @param password：パスワード
	 * @return:戻り値（true-成功,false-失敗）
	 */
	int login(String username,String password);
	
	//添加员工
	int addEmp(EmpData emp);
	
	//完成分页查询抽象方法
	 PageInfo<EmpData> selectEmpBypage(Integer currentPage, String empCd, String name, String birthday, String genderName, String nationalityName);
	

}
