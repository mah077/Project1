package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.pojo.Employee;
import com.revature.util.ConnectionFactory;
import com.revature.util.LoggingUtil;

public class LoginDao implements LoginDaoContract{
	public static Connection conn = ConnectionFactory.getConnection();

	
	@Override
	public boolean isCorrectAuth(String username, String password) {
		LoggingUtil.trace("Checking Authentication form employee");
		
		String sql = "select username, password from employee_trms where username = ?";
		PreparedStatement stmt=null;
		
		if(username.equals("") && password.equals(""))
			return false;
			else {
				
		int flag =0;
		
		try {
			stmt=conn.prepareStatement(sql);	
			stmt.setString(1, username);
			ResultSet rs =stmt.executeQuery();
			String cp="";
			
			while(rs.next()) {
				 cp =rs.getString("password");
			}	
				if(cp.equals(password))
				{
					flag=2;	
				}			
			
		} catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
			e.printStackTrace();
		}
		
		if(flag==2)
			return true; 
		else
		
		return false;
			}
	}

	public Employee getUserByUsername(String username) {
		String pass = null;
		String usernam = null;
		boolean issuper=false;
		boolean ishead=false;
		boolean isbenco=false;
		String sql= "select username, password ,supervisor,headdep,benco from employee_trms where username = ?";
		
		PreparedStatement stmt ;
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				
		     usernam =rs.getString(1);
			 pass =rs.getString(2);
			 issuper=rs.getBoolean(3);
			 ishead=rs.getBoolean(4);
			 isbenco=rs.getBoolean(5);
			 
				
			}
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
			Employee user=new Employee();
			user.setUsername(usernam);
			user.setPassword(pass);
			user.setSupervisor(issuper);
			user.setBenCo(isbenco);
			user.setHeadDept(ishead);
			
			
				return user;
	}
}
