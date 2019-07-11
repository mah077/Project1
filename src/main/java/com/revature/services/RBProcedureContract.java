package com.revature.services;


public interface RBProcedureContract {

 
	public void SupervisorApproval(int b, boolean d	);	
	public void HeadDepApproval(int i , boolean b);
	public void BenCoApproval(int a , boolean b);
	public void SecndBenCoApproval(int i,boolean b);
	public void EmployeeUpdateGrade(int i, String s);
	public double Calculate_RBF();
}
