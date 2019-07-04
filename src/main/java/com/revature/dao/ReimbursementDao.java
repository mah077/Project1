package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.pojo.Reimbursement;
import com.revature.util.ConnectionFactory;
import com.revature.util.LoggingUtil;

public class ReimbursementDao implements ReimbursementDaoContract {
	Connection conn = ConnectionFactory.getConnection();
	public static Reimbursement re = new Reimbursement();
	
	@Override
	public void FillReEmbursement(Reimbursement re) {
		String fn=re.getFirstname();
		String ln=re.getLastname();
		String username=re.getUsername();
		String cd=re.getCourse_date();
		String ct=re.getCourse_time();
		String cl=re.getCourse_location();
		String cdis=re.getCourse_discripton();
		double cc=re.getCourse_cost();
		String gf=re.getGrade_format();
		String pg=re.getPassing_grade();
		String wrj=re.getWork_related_justification();
		String ctype=re.getCourse_type();
		
		
		String sql="INSERT INTO public.reimbursement_form" + 
				"(firstname, lastname, username, course_type, course_location, course_date, course_time, grade_format,"
				+ " passing_grade,  work_related_justification, course_discripton, course_cost)" + 
				"VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
		String sql1="INSERT into public.isApproved (username,couse_type) values(?,?)";
		
		String sql2="INSERT into public.updateGrade (first_name,last_name, course_type,passing_grade) values(?,?,?,?)";
	
			
		PreparedStatement stmt;
		PreparedStatement stmt1;
		PreparedStatement stmt2;
		
		try {
			
			
			stmt = conn.prepareStatement(sql);
			stmt1 = conn.prepareStatement(sql1);
			stmt2 = conn.prepareStatement(sql2);
			
			
			stmt.setString(1, fn);
			stmt.setString(2, ln);
			stmt.setString(3, username);
			stmt.setString(4, ctype);
			stmt.setString(5, cl);
			stmt.setString(6, cd);
			stmt.setString(7, ct);
			stmt.setString(8, gf);
			stmt.setString(9, pg);
			stmt.setString(10, wrj);
			stmt.setString(11, cdis);
			stmt.setDouble(12, cc);
			stmt.executeUpdate();
			
			stmt1.setString(1, username);
			stmt1.setString(2, ctype);
			stmt1.executeUpdate();
			
			stmt2.setString(1, fn);
			stmt2.setString(2, ln);
			stmt2.setString(3, ctype);
			stmt2.setString(4, pg);
			stmt2.executeUpdate();
		}
		catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
			e.printStackTrace();
		}	
		
	}


	

	@Override
	public void RemoveReimbursement(int i) {
		String sql="delete from reimbursement_form where id="+i;
		Statement stmt;
		
		try {
			stmt=conn.createStatement();
			stmt.execute(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}




	@Override
	public List<Reimbursement> viewAllReimbursement() {
		
		List<Reimbursement> rblist = new ArrayList<Reimbursement>();	
		 String sql = "select * from reimbursement_form ";	
		 Statement stmt;
	
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
		
			
		if(rs.next()==false) {	}else
			do { rblist.add(new Reimbursement(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
					rs.getString(7),rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getDouble(13)));
			
		//System.out.println(rs.getInt(1)+"  "+ rs.getString(2)+"\t\t"+ rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5)+ "\t\t"+rs.getString(6)+"\t\t"+
					//	rs.getString(7)+"\t\t"+rs.getString(8)+"\t\t"+ rs.getString(9)+"\t\t"+ rs.getString(10)+"\t\t"+ rs.getString(11)+"\t\t"+ rs.getString(12)+"\t\t"+ rs.getDouble(13)+"\n\n\n");
			}	while(rs.next());
		} catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
			System.out.println("no Query");
			e.printStackTrace();
		}	
		return rblist;
	}
	
	 
	
}
