package com.coderbar.emp.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.coderbar.emp.mapper.EmpMapper;
import com.coderbar.emp.model.EmpData;

public class test {

	public static void main(String[] args) throws Exception {
		// (1).加载配置文件
				InputStream is = Resources.getResourceAsStream("EmpMapper.xml");
				// (2).获取会话工厂对象
				SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
				// (3).打开会化工厂取得会话
				SqlSession ss = ssf.openSession();
				// (4).通过会话对象获取接口的代理对象
				EmpMapper dm = ss.getMapper(EmpMapper.class);
				// (5).调用查询方法
				List<EmpData> selectDeptAndEmp = dm.selectAllEmp();
				for (int i = 0; i < selectDeptAndEmp.size(); i++) {
					
					System.out.println(selectDeptAndEmp.get(i).getEmpCd());
					
				}
				// (6).关闭资源
				ss.close();

	}

}
