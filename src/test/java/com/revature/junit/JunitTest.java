package com.revature.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.dao.LoginDao;
import com.revature.dao.ReimbursementProcedureDao;
import com.revature.services.CheckLoginService;
import com.revature.services.RBProcedureService;

public class JunitTest {
	/*
	 * CheckLoginService s2= new CheckLoginService(); ReimbursementProcedureDao
	 * s1=new ReimbursementProcedureDao(); LoginDao s = new LoginDao();
	 * RBProcedureService ld = new RBProcedureService();
	 */
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/*
	 * @Test public void testCustomerLogIn() {// check Login for the customer
	 * 
	 * assertEquals(true, s.isCorrectAuth("mah@emp.com", "123"));
	 * 
	 * }
	 * 
	 * @Test public void testisApprvoved() { assertEquals(true,
	 * s1.FinalDecision(1,true));
	 * 
	 * 
	 * }
	 */
	
	
}
