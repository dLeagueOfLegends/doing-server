package com.heros.doing.server;

public class Test {
	
	private String aa;
	private String bb;
	public String getAa() {
		return aa;
	}
	public void setAa(String aa) {
		System.out.println("------, " + aa);
		this.aa = aa;
	}
	public String getBb() {
		return bb;
	}
	public void setBb(String bb) {
		this.bb = bb;
	}
	
	public Test(){
		System.out.println("==========>, " + aa + ", " + bb);
	}
}
