package com.revature.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reimbursementStatus")
public class ReimbursementStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reimbStatusID")
	private int id;
	
	@Column(name = "reimbStatus", nullable = false, unique = true)
	private String reimbStatus;	 // "pending", "approved", "denied"

	public ReimbursementStatus() {
		super();
	}

	public ReimbursementStatus(String reimbStatus) {
		super();
		this.reimbStatus = reimbStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReimbStatus() {
		return reimbStatus;
	}

	public void setReimbStatus(String reimbStatus) {
		this.reimbStatus = reimbStatus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, reimbStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementStatus other = (ReimbursementStatus) obj;
		return id == other.id && Objects.equals(reimbStatus, other.reimbStatus);
	}

	@Override
	public String toString() {
		return "ReimbursementStatus [id=" + id + ", reimbStatus=" + reimbStatus + "]";
	}

	
	
}
