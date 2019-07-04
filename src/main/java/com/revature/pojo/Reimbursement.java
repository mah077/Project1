package com.revature.pojo;

public class Reimbursement {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(course_cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((course_date == null) ? 0 : course_date.hashCode());
		result = prime * result + ((course_discripton == null) ? 0 : course_discripton.hashCode());
		result = prime * result + ((course_location == null) ? 0 : course_location.hashCode());
		result = prime * result + ((course_time == null) ? 0 : course_time.hashCode());
		result = prime * result + ((course_type == null) ? 0 : course_type.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((grade_format == null) ? 0 : grade_format.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((passing_grade == null) ? 0 : passing_grade.hashCode());
		result = prime * result + rbf_id;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((work_related_justification == null) ? 0 : work_related_justification.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(course_cost) != Double.doubleToLongBits(other.course_cost)) {
			return false;
		}
		if (course_date == null) {
			if (other.course_date != null) {
				return false;
			}
		} else if (!course_date.equals(other.course_date)) {
			return false;
		}
		if (course_discripton == null) {
			if (other.course_discripton != null) {
				return false;
			}
		} else if (!course_discripton.equals(other.course_discripton)) {
			return false;
		}
		if (course_location == null) {
			if (other.course_location != null) {
				return false;
			}
		} else if (!course_location.equals(other.course_location)) {
			return false;
		}
		if (course_time == null) {
			if (other.course_time != null) {
				return false;
			}
		} else if (!course_time.equals(other.course_time)) {
			return false;
		}
		if (course_type == null) {
			if (other.course_type != null) {
				return false;
			}
		} else if (!course_type.equals(other.course_type)) {
			return false;
		}
		if (firstname == null) {
			if (other.firstname != null) {
				return false;
			}
		} else if (!firstname.equals(other.firstname)) {
			return false;
		}
		if (grade_format == null) {
			if (other.grade_format != null) {
				return false;
			}
		} else if (!grade_format.equals(other.grade_format)) {
			return false;
		}
		if (lastname == null) {
			if (other.lastname != null) {
				return false;
			}
		} else if (!lastname.equals(other.lastname)) {
			return false;
		}
		if (passing_grade == null) {
			if (other.passing_grade != null) {
				return false;
			}
		} else if (!passing_grade.equals(other.passing_grade)) {
			return false;
		}
		if (rbf_id != other.rbf_id) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		if (work_related_justification == null) {
			if (other.work_related_justification != null) {
				return false;
			}
		} else if (!work_related_justification.equals(other.work_related_justification)) {
			return false;
		}
		return true;
	}

	public int rbf_id;
	public String firstname;
	public String lastname;
	public String username;
	public String course_type;
	public String course_location;
	public String course_date;
	public String course_time;
	public String grade_format;
	public String passing_grade;
	public String work_related_justification;
	public String course_discripton;
	public double course_cost;
	

	public Reimbursement(int rbf_id, String firstname, String lastname, String username, String course_type,
			String course_location, String course_date, String course_time, String grade_format, String passing_grade,
			String work_related_justification, String course_discripton, double course_cost) {
		this.rbf_id = rbf_id;
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.course_type = course_type;
		this.course_location = course_location;
		this.course_date = course_date;
		this.course_time = course_time;
		this.grade_format = grade_format;
		this.passing_grade = passing_grade;
		this.work_related_justification = work_related_justification;
		this.course_discripton = course_discripton;
		this.course_cost = course_cost;
	}

	public Reimbursement() {
	}
	
	public Reimbursement(String firstname, String lastname, String username, String course_type, String course_location,
			String course_date, String course_time, String grade_format, String passing_grade,	
			String work_related_justification, String course_discripton, double course_cost) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.course_type = course_type;
		this.course_location = course_location;
		this.course_date = course_date;
		this.course_time = course_time;
		this.grade_format = grade_format;
		this.passing_grade = passing_grade;
		this.work_related_justification = work_related_justification;
		this.course_discripton = course_discripton;
		this.course_cost = course_cost;
	}
	
	public int getRbf_id() {
		return rbf_id;
	}
	public void setRbf_id(int rbf_id) {
		this.rbf_id = rbf_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCourse_type() {
		return course_type;
	}
	public void setCourse_type(String course_type) {
		this.course_type = course_type;
	}
	public String getCourse_location() {
		return course_location;
	}
	public void setCourse_location(String course_location) {
		this.course_location = course_location;
	}
	public String getCourse_date() {
		return course_date;
	}
	public void setCourse_date(String course_date) {
		this.course_date = course_date;
	}
	public String getCourse_time() {
		return course_time;
	}
	public void setCourse_time(String course_time) {
		this.course_time = course_time;
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
	public String getWork_related_justification() {
		return work_related_justification;
	}
	public void setWork_related_justification(String work_related_justification) {
		this.work_related_justification = work_related_justification;
	}
	public String getCourse_discripton() {
		return course_discripton;
	}
	public void setCourse_discripton(String course_discripton) {
		this.course_discripton = course_discripton;
	}
	public double getCourse_cost() {
		return course_cost;
	}
	public void setCourse_cost(double course_cost) {
		this.course_cost = course_cost;
	}

	@Override
	public String toString() {
		return "ReEmbursement [rbf_id=" + rbf_id + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username + ", course_type=" + course_type + ", course_location=" + course_location + ", course_date="
				+ course_date + ", course_time=" + course_time + ", grade_format=" + grade_format + ", passing_grade="
				+ passing_grade + ", work_related_justification="
				+ work_related_justification + ", course_discripton=" + course_discripton + ", course_cost="
				+ course_cost + "]\n\n\n";
	}

	

}
