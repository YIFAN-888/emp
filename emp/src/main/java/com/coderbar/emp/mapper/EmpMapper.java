package com.coderbar.emp.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.coderbar.emp.model.EmpData;

@Mapper
public interface EmpMapper {
	//对所有的员工进行查询
	//@Select("select emp_cd as empCd, name, gender_cd as genderCd, birthday, nationality_cd as nationalityCd from empdata;")
	List<EmpData> selectAllEmp();
	//插入
	@Insert("insert into empdata values(#{empCd},#{name},#{genderCd},to_date(#{birthday},'yyyy-MM-dd'),#{nationalityCd});")
	boolean addEmp(EmpData emp);
	
	//通过员工号码搜索
	//@Select("select emp_cd as empCd, name, gender_cd as genderCd, birthday, nationality_cd as nationalityCd from empdata where emp_cd = #{value};")
	EmpData selectByEmpCd(String empCd);
	//更改
	@Update("update empdata set name = #{name}, gender_cd = #{genderCd}, birthday = to_date(#{birthday}, 'yyyy-MM-dd'), nationality_cd = #{nationalityCd} where emp_cd = #{empCd};")
	boolean updateEmp(EmpData emp);
	//削除
	@Delete("delete from empdata where emp_cd=#{value};")
	boolean deleteEmp(String empCd);
	
	List<EmpData> selectDynamic(
								@Param("empCd")String empCd, 
								@Param("name")String name,
								@Param("birthday")String birthday,
								@Param("genderName")String genderName,
								@Param("nationalityName")String nationalityName);
	


	
}
