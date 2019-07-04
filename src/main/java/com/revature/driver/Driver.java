package com.revature.driver;

import com.revature.dao.LoginDao;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementProcedureDao;
import com.revature.services.CheckLoginService;
import com.revature.services.RBFormService;
import com.revature.servlets.LoginServlet;

public class Driver {
	public static ReimbursementDao rd = new ReimbursementDao();

	public static void main(String[] args) {

		/*
		 * rd.FillReEmbursement(new Reimbursement("mohamad", "hijazi", "mah@emp.com",
		 * "uni", "tampa", "20/2/15", "11:10"," a"," b", "to be good in java",
		 * "studyhard", 8000)); rd.viewAllReimbursement();
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

	}

}
