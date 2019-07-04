package com.revature.pojo;

public class Employee extends Person {


	private static boolean isSupervisor;
	private static boolean isHeadDept;
	private static boolean isBenCo;

	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (isBenCo ? 1231 : 1237);
		result = prime * result + (isHeadDept ? 1231 : 1237);
		result = prime * result + (isSupervisor ? 1231 : 1237);
		return result;
	}



	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	// const without id
	public Employee(String firstname, String lastname, String username, String password, boolean isSupervisor,
			boolean isHeadDept, boolean isBenCo) {
		super(firstname, lastname, username, password);
		Employee.isSupervisor = isSupervisor;
		Employee.isHeadDept = isHeadDept;
		Employee.isBenCo = isBenCo;
	}


	@Override
	public String toString() {
		return "Employee [isSupervisor=" + isSupervisor + ", isHeadDept=" + isHeadDept + ", isBenCo=" + isBenCo + "]";
	}

	// const with id
	public Employee(int id, String firstname, String lastname, String username, String password, boolean isSupervisor,
			boolean isHeadDept, boolean isBenCo) {
		super(id, firstname, lastname, username, password);
		Employee.isSupervisor = isSupervisor;
		Employee.isHeadDept = isHeadDept;
		Employee.isBenCo = isBenCo;
	}

	

	public boolean isSupervisor() {
		return isSupervisor;
	}

	public void setSupervisor(boolean isSupervisor) {
		Employee.isSupervisor = isSupervisor;
	}

	public boolean isHeadDept() {
		return isHeadDept;
	}

	public void setHeadDept(boolean isHeadDept) {
		Employee.isHeadDept = isHeadDept;
	}

	public boolean isBenCo() {
		return isBenCo;
	}

	public void setBenCo(boolean isBenCo) {
		Employee.isBenCo = isBenCo;
	}

}
