package com.coderbar.emp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.coderbar.emp.model.LoginUser;
@Mapper
public interface LoginMapper {
	@Select("select account_id as accountId,password from loginuser where account_id = #{accountId} and password = #{password};")
	LoginUser Login(LoginUser lu);

}
