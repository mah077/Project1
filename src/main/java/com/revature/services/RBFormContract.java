package com.revature.services;

import java.util.List;

import com.revature.pojo.Reimbursement;

public interface RBFormContract {

	public boolean CheckGrade(Reimbursement re);
	public double CalculateAmount(Reimbursement re);
	public List<Reimbursement> GetForm();
	
}
