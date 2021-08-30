package com.revature.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reimbursementTypes")
public class ReimbursementType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reimbTypeID")
	private int id;
	
	@Column(name = "reimbType", nullable = false, unique = true)
	private String reimbType;

	public ReimbursementType() {
		super();
	}

	public ReimbursementType(String reimbType) {
		super();
		this.reimbType = reimbType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReimbType() {
		return reimbType;
	}

	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, reimbType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementType other = (ReimbursementType) obj;
		return id == other.id && Objects.equals(reimbType, other.reimbType);
	}

	@Override
	public String toString() {
		return "ReimbursementType [id=" + id + ", reimbType=" + reimbType + "]";
	}
	

}
