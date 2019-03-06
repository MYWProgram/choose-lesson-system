package com.ten.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ten.conn.Conn;
import com.ten.user.Student;

public class DaoStu {
	/**
	 * 学生登录
	 * **/
	public Student loginStu(Student stu){
		Student stu1 = null;
		String sql_loginS="select * from student where SNo=? and Spassword=?;";
		try{
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql_loginS);
			pst.setInt(1, stu.getSNo());
			pst.setString(2,stu.getSpassword());
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				stu1 = new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),0);
				System.out.println("student login select over");
			}
		}catch(Exception e){e.printStackTrace();}
		return stu1;
	}
	/*
	 * 学生所有选课
	 * 
	public Iterator<Course> selectSC(){
		List<Course> list = null;
		Iterator<Course> listall = null;
		String sql_selectsc="select * from sc,course where Sname=? and Spassword=?;";
		try{
			list = new ArrayList<Course>();
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql_selectsc);
			pst.setString(1, null);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Course cou = new Course(rs.getInt(""),,);
			}
		}catch(Exception e){e.printStackTrace();}
		return listall;
	}
	*/
	
	
	/*
	 * 查询所有学生
	 * */
	public List<Student> selectStu1(){
		List<Student> list = null;
		try{
			String sql_select = "select student.sno as SNo,Sname,Spassword,Sclass,Ssex,sum(course.ccredit) as Scredit from student,sc,course" +
								"	where student.sno=sc.sno" +
								"		and sc.cno=course.cno" +
								"		 group by student.sno;";//查询全部学生信息+学分学分;//查询所有的sql语句
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql_select);
			ResultSet rs = pst.executeQuery();
			list = new ArrayList<Student>();
			while(rs.next()){				
				Student stu = new Student(rs.getInt("SNo"),rs.getString("Sname"),rs.getString("Spassword"),rs.getString("Sclass")
						,rs.getString("Ssex"),rs.getFloat("Scredit"));
				list.add(stu);
			}
		}catch(Exception e){e.printStackTrace();}
		return list;
	}
	/*
	 * 查询所有学生
	 * */
	public List<Student> selectStu(){
		List<Student> list = null;
		try{
			String sql_select = "select SNo,Sname,Spassword,Sclass,Ssex from student;";//查询全部学生信息+学分学分;//查询所有的sql语句
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql_select);
			ResultSet rs = pst.executeQuery();
			list = new ArrayList<Student>();
			DaoCou scredit = new DaoCou();
			while(rs.next()){				
				Student stu = new Student(rs.getInt("SNo"),rs.getString("Sname"),rs.getString("Spassword"),rs.getString("Sclass")
						,rs.getString("Ssex"), scredit.selectScre(rs.getInt("SNo")));
				list.add(stu);
			}
		}catch(Exception e){e.printStackTrace();}
		return list;
	}
	/*
	 * 查询学分总数不足的学生
	 * */
	public Iterator<Student> selectSum(){
		List<Student> list = null;
		Iterator<Student> listall = null;
		try{
			String sql_select = "select student.sno as SNo,Sname,Spassword,Sclass,Ssex,sum(course.ccredit) as Scredit from student,sc,course" +
								"	where student.sno=sc.sno" +
								"		and sc.cno=course.cno" +
								"		 group by student.sno;";//查询全部学生信息+学分学分筛选其中学分不足的
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql_select);
			ResultSet rs = pst.executeQuery();
			list = new ArrayList<Student>();
			while(rs.next()){				
				Student stu = new Student(rs.getInt("SNo"),rs.getString("Sname"),rs.getString("Spassword"),rs.getString("Sclass")
						,rs.getString("Ssex"),rs.getFloat("Scredit"));
				list.add(stu);
			}
			listall = list.iterator();
		}catch(Exception e){e.printStackTrace();}
		return listall;
	}
	/*
	 * 查询学生总学分_某位学生
	 * */
	public Student selectScre(Student stu){
		ResultSet rs = null;
		try{
			String sql_insert = "select student.sno as sno,sum(course.ccredit) as scredit from student,sc,course" +
			"	where student.sno=sc.sno" +
			"		and sc.cno=course.cno" +
			"		 and student.sno=?";//查询某位同学学分
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql_insert);
			pst.setInt(1,stu.getSNo());
			rs = pst.executeQuery();
			if(rs.next()){
				System.out.println("Student_id"+stu.getSNo()+"select one over!");
				stu = new Student(rs.getInt("sno"),null,null,null,null,rs.getFloat("scredit"));	
			}
		}catch(Exception e){e.printStackTrace();}
		return stu;
	}
	/*
	 * 查询某条个学生
	 * */
	public Student selectStu(int id){
		Student Stu = null;
		try{
			String sql_selectone = "select * from student where SNo=?";//查询某一条课程
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql_selectone);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				Stu = new Student(rs.getInt("SNo"),rs.getString("Sname"),rs.getString("Spassword"),rs.getString("Sclass")
						,rs.getString("Ssex"),0);
			}
		}catch(Exception e){e.printStackTrace();}
		return Stu;
	}
	/*
	 * 查询某个学生信息（模糊查询）
	 * */
	public Iterator<Student> selectStu(String aa){//aa作为模糊查询的关键字
		List<Student> list = null;
		Iterator<Student> listall = null;
		try{
			String sql_selectfuz = "select * from student where CNo=? or....";//fuzzy query模糊查询
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql_selectfuz);
			ResultSet rs = pst.executeQuery();
			list = new ArrayList<Student>();
			while(rs.next()){
				Student stu = new Student(rs.getInt("SNo"),rs.getString("Sname"),rs.getString("Spassword"),rs.getString("Sclass")
						,rs.getString("Ssex"),0);
				list.add(stu);
			}
			listall = list.iterator();
		}catch(Exception e){e.printStackTrace();}
		return listall;
	}
	/*
	 * 修改某个学生信息
	 * */
	public int updateStu(Student stu){
		int rs = 0;
		try{
			String sql_update = "update Student set Sname=?,Spassword=?,Sclass=?,Ssex=? where SNo=?;";//修改一条学生信息
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql_update);
			pst.setString(1, stu.getSname());
			pst.setString(2, stu.getSpassword());
			pst.setString(3, stu.getSclass());
			pst.setString(4, stu.getSsex());
			pst.setInt(5, stu.getSNo());
			rs = pst.executeUpdate();
			if(rs!=0){
				System.out.println("Student_id"+stu.getSNo()+"update over!");
			}
		}catch(Exception e){e.printStackTrace();}
		return rs;
	}
	/*
	 * 删除某个学生信息
	 * */
	public int deleteStu(int id){
		int rs = 0;
		try{
			String sql_delete = "delete from student where SNo=?;";//删除一条课程信息
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql_delete);
			pst.setInt(1, id);
			rs = pst.executeUpdate();
			if(rs!=0){
				System.out.println("Student_id"+id+"delete over!");
			}
		}catch(Exception e){e.printStackTrace();}
		return rs;
	}
	/*
	 * 添加一位学生信息
	 * */
	public int insertStu(Student stu){
		int rs = 0;
		try{
			String sql_insert = "insert into student(Sname,Spassword,Sclass,Ssex) values(?,?,?,?);";//添加一条课程信息
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql_insert);
			pst.setString(1,stu.getSname());
			pst.setString(2, stu.getSpassword());
			pst.setString(3, stu.getSclass());
			pst.setString(4, stu.getSsex());
			rs = pst.executeUpdate();
			if(rs!=0){
				System.out.println("Student_id"+stu.getSNo()+"insert over!");
			}
		}catch(Exception e){e.printStackTrace();}
		return rs;
	}
	
	
}


