package com.ten.user;

public class Teacher {
	private int TNo;
	private String Tname;
	private String Tpassword;
	public int getTNo() {
		return TNo;
	}
	public void setTNo(int tNo) {
		TNo = tNo;
	}
	public String getTname() {
		return Tname;
	}
	public void setTname(String tname) {
		Tname = tname;
	}
	public String getTpassword() {
		return Tpassword;
	}
	public void setTpassword(String tpassword) {
		Tpassword = tpassword;
	}
	/**
	 * @param tNo
	 * @param tname
	 * @param tpassword
	 */
	public Teacher(int tNo, String tname, String tpassword) {
		TNo = tNo;
		Tname = tname;
		Tpassword = tpassword;
	}
	public Teacher( String tname, String tpassword) {
		Tname = tname;
		Tpassword = tpassword;
	}

}
