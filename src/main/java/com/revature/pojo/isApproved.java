package com.revature.pojo;

public class isApproved {

	int rbf_id;
	boolean super_status;
	boolean headdep_status;
	boolean benco_status;
	
	
	
	public isApproved(boolean super_status, boolean headdep_status, boolean benco_status) {
		
		this.super_status = super_status;
		this.headdep_status = headdep_status;
		this.benco_status = benco_status;
	}
	
	
	public int getRbf_id() {
		return rbf_id;
	}
	public void setRbf_id(int rbf_id) {
		this.rbf_id = rbf_id;
	}
	public boolean isSuper_status() {
		return super_status;
	}
	public void setSuper_status(boolean super_status) {
		this.super_status = super_status;
	}
	public boolean isHeaddep_status() {
		return headdep_status;
	}
	public void setHeaddep_status(boolean headdep_status) {
		this.headdep_status = headdep_status;
	}
	public boolean isBenco_status() {
		return benco_status;
	}
	public void setBenco_status(boolean benco_status) {
		this.benco_status = benco_status;
	}


	@Override
	public String toString() {
		return "isApproved [rbf_id=" + rbf_id + ", super_status=" + super_status + ", headdep_status=" + headdep_status
				+ ", benco_status=" + benco_status + "]\n";
	}
	
	
}
