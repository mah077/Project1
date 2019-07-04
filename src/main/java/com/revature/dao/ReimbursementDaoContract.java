	package com.revature.dao;

import java.util.List;

import com.revature.pojo.Reimbursement;

public interface ReimbursementDaoContract {
	
	public void FillReEmbursement(Reimbursement re);
	public List<Reimbursement> viewAllReimbursement();
	public void RemoveReimbursement(int i);

}
