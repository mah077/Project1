package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.pojo.Reimbursement;
		
		
public class RBFormService implements RBFormContract {
	ReimbursementDao rb= new ReimbursementDao(); 

	@Override
	public boolean CheckGrade(Reimbursement re) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double CalculateAmount(Reimbursement re) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Reimbursement> GetForm() {
		
	   List<Reimbursement> list= new ArrayList<Reimbursement>();
	   
			 list =  rb.viewAllReimbursement();
			 
			 return list;
	}

}
