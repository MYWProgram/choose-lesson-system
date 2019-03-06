package com.ten.user;

public class Course {
	private int CNo;
	private String Cname;
	private String Ccredit;
	public int getCNo() {
		return CNo;
	}
	public void setCNo(int cNo) {
		CNo = cNo;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public String getCcredit() {
		return Ccredit;
	}
	public void setClassroom(String Ccredit) {
		this.Ccredit = Ccredit;
	}

	
	/**
	 * @param cNo
	 * @param cname
	 * @param classroom
	 */
	public Course(int cNo, String cname, String Ccredit) {
		this.CNo = cNo;
		this.Cname = cname;
		this.Ccredit = Ccredit;
	}
	public Course( String cname, String Ccredit) {
		this.Cname = cname;
		this.Ccredit = Ccredit;
	}
	
	

}
