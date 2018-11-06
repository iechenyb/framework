package com.cyb.pc.bean;

public class Stock {
	private String name;
	private String code;
	private String code_;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode_() {
		return code_;
	}
	public void setCode_(String code_) {
		this.code_ = code_;
	}
	public String toString(){
		return this.getName()+","+this.code+","+this.code_;
	}
}
