package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.revature.util.ConnectionFactory;
import com.revature.util.LoggingUtil;


public class ReimbursementProcedureDao implements ReimbursementProcedureContract {
	Connection conn = ConnectionFactory.getConnection();
	@Override
	public void SupervisorApproval(boolean re, String i, String c) {

		String sql="update isApproved set super_status = ?  where username = ? and couse_type= ?";
		PreparedStatement stmt;
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setBoolean(1,re);
			stmt.setString(2, i);
			stmt.setString(3, c);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	
	}
	@Override
	public void HeadDepApproval(boolean re, String i, String c) {
		
		String sql="update isApproved set headdep_status = ?  where username = ? and couse_type= ?";
		
		PreparedStatement stmt;
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setBoolean(1,re);
			stmt.setString(2, i);
			stmt.setString(3, c);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	@Override
	public void BenCoApproval(boolean re, String i, String c) {
		
		String sql="update isApproved set benco_status = ?  where username = ? and couse_type= ?";
		PreparedStatement stmt;
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setBoolean(1,re);
			stmt.setString(2, i);
			stmt.setString(3, c);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	@Override
	public void EmployeeUpdateGrade(int i, String grade) {
		String sql="update updateGrade set update_Grade= ?  where ipdate_id= ? " ;
		PreparedStatement stmt;
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1,grade);
			stmt.setInt(2, i);
		
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void SecndBenCoApproval(int i, boolean bre) {
		String sql="update updateGrade set update_benco_update= ?  where ipdate_id= ? " ;
		PreparedStatement stmt;
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setBoolean(1,bre);
			stmt.setInt(2, i);
		
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	@Override
	public boolean FinalDecision() {
	
		 String sql = "select super_status, headdep_status, benco_status from isApproved ";	
		 String sql1="select update_benco_update from updateGrade";
		 Statement stmt;
		 Statement stmt1;
		 	boolean sp = false;
			boolean hd=false;
			boolean bnco1=false;
			boolean bnco2=false;
		try {
			stmt = conn.createStatement();
			stmt1=conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ResultSet rs1 = stmt1.executeQuery(sql1);
		if(rs.next()) {
			 sp=rs.getBoolean(1);
			 hd=rs.getBoolean(2);
			 bnco1=rs.getBoolean(3);
			
		}
			if(rs1.next()) {
		bnco2=rs.getBoolean(1);
		}
		
		
		}catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
			System.out.println("no Query");
			e.printStackTrace();
		}
	
			
		 if(sp==true && hd==true && bnco1==true && bnco2==true)
				return true;
			else 
				return false;	
	}
	
	
	@Override
	public String GetGradeFormat() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String PassingGrade() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public double CoursePrice() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String CourseType() {
		// TODO Auto-generated method stub
		return null;
	}




}
