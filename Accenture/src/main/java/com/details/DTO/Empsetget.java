package com.details.DTO;

public class Empsetget {
	private int ID;
	private String name;
	private String pwd;
	private String ctry;
	public String getName() {
		return name;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getCtry() {
		return ctry;
	}
	public void setCtry(String ctry) {
		this.ctry = ctry;
	}

}
