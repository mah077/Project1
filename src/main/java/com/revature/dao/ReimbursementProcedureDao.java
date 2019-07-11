package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Employee;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.UpDateGrade;
import com.revature.services.RBProcedureService;
import com.revature.util.ConnectionFactory;
import com.revature.util.LoggingUtil;


public class ReimbursementProcedureDao implements ReimbursementProcedureContract {
	Connection conn = ConnectionFactory.getConnection();
	public static UpDateGrade udg= new UpDateGrade();
	public static RBProcedureService rs =new RBProcedureService();
	public static Employee emp=new Employee();
	
	@Override
	public void SupervisorApproval(int i, boolean re) {

		String sql="update isApproved set super_status = ?  where rbf_id = ?";
		PreparedStatement stmt;
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setBoolean(1,re);
			stmt.setInt(2, i);
			
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	
	}
	@Override
	public void HeadDepApproval(int i, boolean re) {
		
		String sql="update isApproved set headdep_status = ?  where rbf_id= ?";
		
		PreparedStatement stmt;
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setBoolean(1,re);
			stmt.setInt(2, i);
		
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	@Override
	public void BenCoApproval(int i, boolean re) {
		
		String sql="update isApproved set benco_status = ?  where rbf_id= ?";
		PreparedStatement stmt;
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setBoolean(1,re);
			stmt.setInt(2, i);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	@Override
	public void EmployeeUpdateGrade(int i, String grade) {
		String sql="update updateGrade set update_Grade= ?  where rbf_id= ? " ;
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
		String sql="update updateGrade set update_benco_update= ?  where rbf_id= ? " ;
		PreparedStatement stmt;
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setBoolean(1,bre);
			stmt.setInt(2, i);
		
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		FinalDecision(i,bre);
	}
	@Override
	public boolean FinalDecision(int i,boolean bnco2) {
	
	   String sql = "select super_status, headdep_status, benco_status from isApproved where rbf_id = ?";	
	// String sql1= "select update_benco_update from updateGrade where rbf_id = ? "; //i take the approvment direvtly from the prev mehtod
		
		 PreparedStatement stmt;
		// PreparedStatement stmt1;
		 
		 
		 	boolean sp = false;
			boolean hd=false;
			boolean bnco1=false;
			
			//boolean bnco2=false;
			
			boolean fdic=false;
		
			try {
			stmt = conn.prepareStatement(sql);
			//stmt1=conn.prepareStatement(sql1);
			
			stmt.setInt(1, i);
			//stmt1.setInt(1, i);
			
			ResultSet rs    = stmt.executeQuery();
		//	ResultSet rs1   = stmt1.executeQuery();
			
			while(rs.next()) {
				sp=rs.getBoolean(1);
				hd=rs.getBoolean(2);
				bnco1=rs.getBoolean(3);
			 
			
		}
		//	if(rs1.next()) {
		//		bnco2=rs.getBoolean(1);
		//}
		
			
		
		}catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
			System.out.println("no Query");
			e.printStackTrace();
		}
	
			
			System.out.println(sp+ ""+hd +bnco1+bnco2);
		 if(sp==true && hd==true && bnco1==true && bnco2==true) {
			 fdic=true;
				addFincalDecision_DB(i, fdic);
				return true;
		 }
			else {
				fdic=false;
			addFincalDecision_DB(i, fdic);
				return false;	
			}
		 			
			
	}
	@Override
	public void addFincalDecision_DB(int i, boolean b) {
		
		 String sql2="update updateGrade set final_status_result= ?  where rbf_id= ? ";
		 
		 PreparedStatement stmt;
		 
		 		 
		 try {
			stmt=conn.prepareStatement(sql2);
			stmt.setBoolean(1,b);
			stmt.setInt(2, i);
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 getResult(i);
		 final_result(i);
		
	}

		
	public UpDateGrade getResult(int i) {
		
String sql="Select reimbursement_form.course_type, reimbursement_form.course_cost, updategrade.update_grade,   updategrade.final_status_result,  updategrade.final_reimb from reimbursement_form inner join updategrade on reimbursement_form.rbf_id=updategrade.rbf_id where reimbursement_form.rbf_id= ?;";
		
		PreparedStatement stmt;
		int rbf_id = 0;
		String course_type = null;
		String update_grade = null;
		double course_cost = 0;
		boolean final_result = false;
		double final_cost=0;
		
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, i);
			
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				rbf_id=i;
				course_type=rs.getString(1);
				update_grade=rs.getString(2);
				course_cost=rs.getDouble(3);
				final_result= rs.getBoolean(4);
				final_cost=rs.getDouble(5);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		udg.setRbf_id(rbf_id);
		udg.setCourse_type(course_type);
		udg.setUpdate_grade(update_grade);
		udg.setCourse_cost(course_cost);
		udg.setFinal_result(final_result);
		udg.setFinal_cost(final_cost);
		
		
		
		
		return udg;		
	}	
		
	public void final_result(int i) {
		
 String sql2="update updateGrade set final_reimb= ?  where rbf_id= ? ";
		 double b=rs.Calculate_RBF();
		 PreparedStatement stmt;
		 System.out.println("finaaaaal"+b);
		 		 
		 try {
			stmt=conn.prepareStatement(sql2);
			stmt.setDouble(1,b);
			stmt.setInt(2, i);
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		getResult(i);
		 
		
	}

	
public List<UpDateGrade> getAllResult() {
	
	 List<UpDateGrade> ug= new  ArrayList<UpDateGrade>();
String sql="Select  reimbursement_form.rbf_id,  reimbursement_form.username, reimbursement_form.grade_format, "
		+ "reimbursement_form.course_type, reimbursement_form.course_cost,reimbursement_form.passing_grade, updategrade.update_grade, "
		+ "  updategrade.final_status_result,  updategrade.final_reimb "
		+ "from reimbursement_form inner join updategrade on reimbursement_form.rbf_id=updategrade.rbf_id where reimbursement_form.username = ?;";
		
		String s=emp.getUsername();
		
		PreparedStatement stmt;
		int rbf_id = 0;
		String username=null;
		String grade_format=null;
		String course_type = null;
		double course_cost = 0;
		String passing_grade=null;
		String update_grade = null;		
		boolean final_result = false;
		double final_reimb=0;
	
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, s);
			ResultSet rs=stmt.executeQuery();
			
			
			while(rs.next()) {
				rbf_id=rs.getInt(1);
				username=rs.getString(2);
				grade_format=rs.getString(3);
				course_type=rs.getString(4);
				course_cost=rs.getDouble(5);
				passing_grade=rs.getString(6);
				update_grade=rs.getString(7);
				final_result= rs.getBoolean(8);
				final_reimb=rs.getDouble(9);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		udg.setRbf_id(rbf_id);
		udg.setCourse_type(course_type);
		udg.setUpdate_grade(update_grade);
		udg.setCourse_cost(course_cost);
		udg.setFinal_result(final_result);
		udg.setFinal_cost(final_reimb);
		udg.setUsername(username);
		udg.setPassing_grade(passing_grade);
		udg.setGrade_format(grade_format);
		
		ug.add(udg);
		
		
		return ug;		
	}	
	
public List<UpDateGrade> getAllResult1() {

	
	 List<UpDateGrade> ug= new  ArrayList<UpDateGrade>();
	 
String sql="Select  reimbursement_form.rbf_id,  reimbursement_form.username, reimbursement_form.grade_format, reimbursement_form.course_type, reimbursement_form.course_cost,reimbursement_form.passing_grade, updategrade.update_grade,updategrade.final_status_result,  updategrade.final_reimb	from reimbursement_form inner join updategrade on reimbursement_form.rbf_id = updategrade.rbf_id ;"; 
	


		Statement stmt;
		int rbf_id = 0;
		String username=null;
		String grade_format=null;
		String course_type = null;
		double course_cost = 0;
		String passing_grade=null;
		String update_grade = null;		
		boolean final_result = false;
		double final_reimb=0;

		
		try {
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
		
			while(rs.next()) {
				
				rbf_id=rs.getInt(1);
				username=rs.getString(2);
				grade_format=rs.getString(3);
				course_type=rs.getString(4);
				course_cost=rs.getDouble(5);
				passing_grade=rs.getString(6);
				update_grade=rs.getString(7);
				final_result= rs.getBoolean(8);
				final_reimb=rs.getDouble(9);
				udg.setRbf_id(rbf_id);
				udg.setCourse_type(course_type);
				udg.setUpdate_grade(update_grade);
				udg.setCourse_cost(course_cost);
				udg.setFinal_result(final_result);
				udg.setFinal_cost(final_reimb);
				udg.setUsername(username);
				udg.setPassing_grade(passing_grade);
				udg.setGrade_format(grade_format);

				ug.add(udg);
				
					
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

		
		
		return ug;		
	}	
}
