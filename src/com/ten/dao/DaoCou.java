package com.ten.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ten.conn.Conn;
import com.ten.user.Course;
import com.ten.user.SC;
import com.ten.user.Student;

public class DaoCou {
	
	public static final String sql_select = "select * from course;";//查询所有的sql语句
	public static final String sql_selectfuz = "select * from course where CNo=? or....";//fuzzy query模糊查询
	public static final String sql_selectone = "select * from course where CNo=?";//查询某一条课程
	public static final String sql_update = "update course set Cname=?,Ccredit=? where CNo=?;";//修改一条课程信息
	public static final String sql_delete = "delete from course where Cno=?;";//删除一条课程信息
	public static final String sql_insert = "insert into course(Cname,Ccredit) values(?,?);";//添加一条课程信息
	
	
	/*
	 * 查询所有课程信息
	 * */
	public Iterator<Course> selectCou(){
		List<Course> list = null;
		Iterator<Course> listall = null;
		try{
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql_select);
			ResultSet rs = pst.executeQuery();
			list = new ArrayList<Course>();
			while(rs.next()){				
				Course cou = new Course(rs.getInt("CNo"),rs.getString("Cname"),rs.getString("Ccredit"));
				list.add(cou);
			}
			listall = list.iterator();
		}catch(Exception e){e.printStackTrace();}
		return listall;
	}
	/*
	 * 查询某条课程信息
	 * */
	public Course selectCou(int id){
		Course cou = null;
		try{
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql_selectone);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				cou = new Course(rs.getInt("CNo"),rs.getString("Cname"),rs.getString("Ccredit"));
			}
		}catch(Exception e){e.printStackTrace();}
		return cou;
	}
	/*
	 * 查询某条课程信息（模糊查询）
	 * */
	public Iterator<Course> selectCou(String aa){//aa作为模糊查询的关键字
		List<Course> list = null;
		Iterator<Course> listall = null;
		try{
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql_selectone);
			ResultSet rs = pst.executeQuery();
			list = new ArrayList<Course>();
			while(rs.next()){
				Course cou = new Course(rs.getInt("CNo"),rs.getString("Cname"),rs.getString("Ccredit"));
				list.add(cou);
			}
			listall = list.iterator();
		}catch(Exception e){e.printStackTrace();}
		return listall;
	}
	/*
	 * 修改某条课程信息
	 * */
	public int updateCou(Course cou){
		int rs = 0;
		try{
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql_update);
			pst.setString(1, cou.getCname());
			pst.setString(2, cou.getCcredit());
			pst.setInt(3, cou.getCNo());
			rs = pst.executeUpdate();
			if(rs!=0){
				System.out.println("course_id"+cou.getCNo()+"update over!");
			}
		}catch(Exception e){e.printStackTrace();}
		return rs;
	}
	/*
	 * 删除某条课程信息
	 * */
	public int deleteCou(int id){
		int rs = 0;
		try{
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql_delete);
			pst.setInt(1, id);
			rs = pst.executeUpdate();
			if(rs!=0){
				System.out.println("course_id"+id+"delete over!");
			}
		}catch(Exception e){e.printStackTrace();}
		return rs;
	}
	/*
	 * 添加一条课程信息
	 * */
	public int insertCou(Course cou){
		int rs = 0;
		try{
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql_insert);
			pst.setString(1,cou.getCname());
			pst.setString(2, cou.getCcredit());
			rs = pst.executeUpdate();
			if(rs!=0){
				System.out.println("course_id"+cou.getCname()+"insert over!");
			}
		}catch(Exception e){e.printStackTrace();}
		return rs;
	}
	/*
	 * 根据选课数组的课程号，查询求和得到全部待选课程的总学分**********************方法无用******************************************
	 * *
	public float selectScre(SC sc[]){
		float sum = 0;
		try{
			String sql = "select ccredit from course where cno=?;";
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = null;
			for(int i=0;i<sc.length;i++){
				pst.setInt(1, sc[i].getCNo());
				rs = pst.executeQuery();
				sum += rs.getFloat("ccredit");
			}
		}catch(Exception e){e.printStackTrace();}
		return sum;
	}*/
	/*
	 * 根据学号，查询学生总学分
	 * */
	public float selectScre(int sno){
		float sum = 0;
		try{
			String sql = "select sc.sno,sum(ccredit) as scredit from sc,course where sc.cno=course.cno and sno=?;";
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, sno);
			ResultSet rs = null;
			rs = pst.executeQuery();
			if(rs.next()){
				sum = rs.getFloat("scredit");
			}
		}catch(Exception e){e.printStackTrace();}
		return sum;
	}
}
