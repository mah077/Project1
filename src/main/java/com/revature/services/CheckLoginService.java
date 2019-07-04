package com.revature.services;

import com.revature.dao.LoginDao;
import com.revature.pojo.Employee;
import com.revature.pojo.Person;

public class CheckLoginService implements CheckLoginContract {
	Person user= new Employee();
	@Override
	public boolean CheckAuth(String usern, String pass) {
		LoginDao ld= new LoginDao();
		ld.getUserByUsername(usern);
	
		
		if(usern.equals (user.getUsername()) &&  pass.equals (user.getPassword() ) )
					return true;
		else
			
					return false;
	}

	

}
