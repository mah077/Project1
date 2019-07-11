package com.revature.dao;


public interface ReimbursementProcedureContract {
	
	
	public void SupervisorApproval(int i, boolean re);	
	public void HeadDepApproval(int i, boolean re);
	public void BenCoApproval(int i, boolean re);
	public void EmployeeUpdateGrade(int i,String grade);
	public void SecndBenCoApproval(int i,boolean bre);
	public boolean FinalDecision(int i,boolean benco2);
	public void addFincalDecision_DB(int i,boolean b);
	
	//To Calcualte the final reimbr
	//public boolean Projected_Decision()
	
	
	

}
