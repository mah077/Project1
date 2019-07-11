package com.revature.driver;

import com.revature.dao.LoginDao;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementProcedureDao;
import com.revature.pojo.Employee;
import com.revature.pojo.UpDateGrade;
import com.revature.services.CheckLoginService;
import com.revature.services.RBFormService;
import com.revature.services.RBProcedureService;
import com.revature.servlets.LoginServlet;

public class Driver {
	public static ReimbursementDao rd = new ReimbursementDao();
	public static ReimbursementProcedureDao rd1= new ReimbursementProcedureDao();
	public static RBProcedureService rs =new RBProcedureService();
	public static UpDateGrade udg= new UpDateGrade();

	public static void main(String[] args) {
	
		/*
		 * rd.FillReEmbursement(new Reimbursement("mohamad", "hijazi", "mah@emp.com",
		 * "uni", "tampa", "20/2/15", "11:10"," a"," b", "to be good in java",
		 * "studyhard", 8000)); rd.viewAllReimbursement();
		 */

		/*
		 * RBProcedureService rs1 = new RBProcedureService(); rs1.EmployeeUpdateGrade(1,
		 * "100");
		 */
		
		//System.out.println(rd1.getAllResult());
		
		/*
		 * RBProcedureService rs3 = new RBProcedureService(); rd1.final_result(30);
		 */
	//System.out.println(rd1.getAllResult());
	//rd1.final_result(30);
		//  ReimbursementProcedureDao rd = new ReimbursementProcedureDao();
		 // rs.SecndBenCoApproval(1,true);
		
		/*
		 * CheckLoginService cl= new CheckLoginService();
		 * System.out.println(cl.CheckAuth("mah@emp.com", "123"));
		 * 
		 * 
		 * System.out.println( rd.getReimbursement());
		 */
		/*
		 * ReimbursementProcedureDao rd = new ReimbursementProcedureDao();
		 * rd.SupervisorApproval(true, "mah@emp.com","uni");
		 * rd.HeadDepApproval(true,"mah@emp.com","uni");
		 * rd.BenCoApproval(true,"mah@emp.com","uni"); rd.EmployeeUpdateGrade(1, "A");
		 * rd.SecndBenCoApproval(1, true); System.out.println(rd.FinalDecision());
		 * System.out.println("add success");
		 */
		
		/*
		 * RBFormService f=new RBFormService(); System.out.println(f.GetForm());
		 */
		
		  CheckLoginService cl= new CheckLoginService();
		  System.out.println(cl.CheckAuth("mah@emp.com", "123"));
		  
		  System.out.println(rd1.getAllResult());
		 
		/*
		 * System.out.println(udg); System.out.println(rs.Calculate_RBF());
		 */
		
	}

}
