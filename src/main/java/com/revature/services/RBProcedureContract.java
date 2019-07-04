package com.revature.services;

import com.revature.pojo.Reimbursement;

public interface RBProcedureContract {


	public Reimbursement SupervisorApproval(Reimbursement re);	
	public Reimbursement HeadDepApproval(Reimbursement re);
	public Reimbursement BenCoApproval(Reimbursement re);
	public Reimbursement SecndBenCoApproval(Reimbursement re);
	public Reimbursement EmployeeUpdateGrade(Reimbursement re);

}
