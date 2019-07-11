package com.revature.pojo;

public class UpDateGrade {
	
	private  int rbf_id;
	private  String username;
	private static String course_type;
	private static String grade_format;
	private  String passing_grade;
	private static String update_grade;
	private static double course_cost;
	private  boolean final_result;
	private  double final_cost;
	
	

	


	 

	public UpDateGrade(int int1, String string, String string2, String string3, String string4, String string5,
			String string6, String string7, String string8, String string9, String string10, String string11,
			double double1) {

		// TODO Auto-generated constructor stub
	}

	public int getRbf_id() {
		return rbf_id;
	}


	public String getCourse_type() {
		return course_type;
	}

	public void setCourse_type(String course_type) {
		this.course_type = course_type;
	}

	public String getGrade_format() {
		return grade_format;
	}

	public void setGrade_format(String grade_format) {
		this.grade_format = grade_format;
	}

	public String getPassing_grade() {
		return passing_grade;
	}

	public void setPassing_grade(String passing_grade) {
		this.passing_grade = passing_grade;
	}

	public String getUpdate_grade() {
		return update_grade;
	}

	public void setUpdate_grade(String update_grade) {
		this.update_grade = update_grade;
	}

	public double getCourse_cost() {
		return course_cost;
	}

	public void setCourse_cost(double course_cost) {
		this.course_cost = course_cost;
	}

	public boolean isFinal_result() {
		return final_result;
	}

	public void setFinal_result(boolean final_result) {
		this.final_result = final_result;
	}

	public void setRbf_id(int rbf_id) {
		this.rbf_id = rbf_id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setFinal_cost(double final_cost) {
		this.final_cost = final_cost;
	}

	public UpDateGrade(int rbf_id, String username, String course_type, String grade_format, String passing_grade,
			String update_grade, double course_cost, boolean final_result, double final_cost) {
		this.rbf_id = rbf_id;
		this.username = username;
		this.course_type = course_type;
		this.grade_format = grade_format;
		this.passing_grade = passing_grade;
		this.update_grade = update_grade;
		this.course_cost = course_cost;
		this.final_result = final_result;
		this.final_cost = final_cost;
	}

	@Override
	public String toString() {
		return "UpDateGrade [rbf_id=" + rbf_id + ", username=" + username + ", course_type=" + course_type
				+ ", grade_format=" + grade_format + ", passing_grade=" + passing_grade + ", update_grade="
				+ update_grade + ", course_cost=" + course_cost + ", final_result=" + final_result + ", final_cost="
				+ final_cost + "]\n";
	}

	public double getFinal_cost() {
		return final_cost;
	}

	public UpDateGrade() {
		// TODO Auto-generated constructor stub
	}



	public  String getUsername() {
		return username;
	}




	
	
	
	
	
}
