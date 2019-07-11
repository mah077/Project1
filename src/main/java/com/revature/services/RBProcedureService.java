package com.revature.services;

import com.revature.dao.ReimbursementProcedureDao;
import com.revature.pojo.UpDateGrade;

public class RBProcedureService implements RBProcedureContract {
	
	public static ReimbursementProcedureDao rd= new ReimbursementProcedureDao();

	

	@Override
	public void SupervisorApproval(int i, boolean b) {
	
		rd.SupervisorApproval(i, b);
	}

	@Override
	public void HeadDepApproval(int i, boolean b) {
		rd.HeadDepApproval(i,b);
		
	}

	@Override
	public void BenCoApproval(int i, boolean b) {
		rd.BenCoApproval(i, b);
		
	}
	
	@Override
	public void SecndBenCoApproval(int i, boolean b) {
		rd.SecndBenCoApproval( i, b);
		
		Calculate_RBF();
	}

	@Override
	public void EmployeeUpdateGrade(int i, String s) {
		rd.EmployeeUpdateGrade(i,s);
		
	}
	@Override
	public double Calculate_RBF()
	{	UpDateGrade up= new UpDateGrade();
		String status = up.getCourse_type();
		double price=up.getCourse_cost();
		double amount =0;
			if(up.isFinal_result()==true)
				{
				switch(status) {
				case "University Course: 80%":
					amount= (price*(80))/100;
					break;
				case "Seminar: 60%":
					amount= (price*(60))/100;
					break;
				case "Certification Prep Course: 75%":
					amount= (price*(75))/100;
					break;
				case "Certification: 100%":
					amount= (price*(100))/100;
					break;
				case "Technical Training: 90%":
					amount= (price*(90))/100;
					break;
				case "Other: 30%":
					amount= (price*(30))/100;
					break;
				default : amount =0;	
				return amount;

				}	
			return amount;	
				}	
				
			else
				return 0;
		
		
	}

}
