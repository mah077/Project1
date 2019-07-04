package com.revature.dao;


public interface ReimbursementProcedureContract {
	
	
	public void SupervisorApproval(boolean re, String i,String c);	
	public void HeadDepApproval(boolean re, String i,String c);
	public void BenCoApproval(boolean re, String i,String c);
	public void EmployeeUpdateGrade(int i,String grade);
	public void SecndBenCoApproval(int i,boolean bre);
	public boolean FinalDecision();
	//To Calcualte the final grade
	public String GetGradeFormat();
	public String PassingGrade();
	public double CoursePrice();
	public String CourseType();
	
	
	
	

}
