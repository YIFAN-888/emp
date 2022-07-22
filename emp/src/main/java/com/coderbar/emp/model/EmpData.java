package com.coderbar.emp.model;

public class EmpData {
	private String empCd;
	private String name;
	private String genderCd;
	private String birthday;
	private String nationalityCd;
	//引入
	private Gender gender;
	
	private Nationality nationality;
	
	public String getEmpCd() {
		return empCd;
	}
	public void setEmpCd(String empCd) {
		this.empCd = empCd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenderCd() {
		return genderCd;
	}
	public void setGenderCd(String genderCd) {
		this.genderCd = genderCd;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getNationalityCd() {
		return nationalityCd;
	}
	public void setNationalityCd(String nationalityCd) {
		this.nationalityCd = nationalityCd;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Nationality getNationality() {
		return nationality;
	}
	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}
	
	@Override
	public String toString() {
		return "EmpData [empCd=" + empCd + ", name=" + name + ", genderCd=" + genderCd + ", birthday=" + birthday
				+ ", nationalityCd=" + nationalityCd + ", gender=" + gender + ", nationality=" + nationality + "]";
	}
	
	
	
	
	
	
	
}
