package com.revature.dto;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Objects;

import com.revature.model.Users;

public class ReimbursementDTO {


	private int reimbAmount;
	private Timestamp reimbSubmitted;
	private String reimbDescription;
	private Blob reimbReceipt;
	private int reimbType;
	private Users reimbAuthor;
	
	public ReimbursementDTO() {
		super();
	}

	public ReimbursementDTO(int reimAmount, String reimDescription, Blob reimReceipt, int reimType) {
		super();
		this.reimbAmount = reimAmount;
		this.reimbDescription = reimDescription;
		this.reimbReceipt = reimReceipt;
		this.reimbType = reimType;

	}

	public int getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(int reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public Timestamp getReimbSubmitted() {
		return reimbSubmitted;
	}

	public void setReimbSubmitted(Timestamp reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}

	public String getReimbDescription() {
		return reimbDescription;
	}

	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}

	public Blob getReimbReceipt() {
		return reimbReceipt;
	}

	public void setReimbReceipt(Blob reimbReceipt) {
		this.reimbReceipt = reimbReceipt;
	}

	public int getReimbType() {
		return reimbType;
	}

	public void setReimbType(int reimbType) {
		this.reimbType = reimbType;
	}

	public Users getReimbAuthor() {
		return reimbAuthor;
	}

	public void setReimbAuthor(Users reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(reimbAmount, reimbAuthor, reimbDescription, reimbReceipt, reimbSubmitted, reimbType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementDTO other = (ReimbursementDTO) obj;
		return reimbAmount == other.reimbAmount && Objects.equals(reimbAuthor, other.reimbAuthor)
				&& Objects.equals(reimbDescription, other.reimbDescription)
				&& Objects.equals(reimbReceipt, other.reimbReceipt)
				&& Objects.equals(reimbSubmitted, other.reimbSubmitted) && reimbType == other.reimbType;
	}

	@Override
	public String toString() {
		return "ReimbursementDTO [reimbAmount=" + reimbAmount + ", reimbSubmitted=" + reimbSubmitted
				+ ", reimbDescription=" + reimbDescription + ", reimbReceipt=" + reimbReceipt + ", reimbType="
				+ reimbType + ", reimbAuthor=" + reimbAuthor + "]";
	}
	
	
	
}
