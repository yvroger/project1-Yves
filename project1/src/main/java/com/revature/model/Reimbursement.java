package com.revature.model;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reimbursement")
public class Reimbursement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reimbID")
	private int id;
	
	@Column(name = "amount", precision = 10, scale = 2, nullable = false, unique = false)
	private double amount;	

	@Column(name = "submitted")
	private Timestamp submitted;
	
	@Column(name = "resolved")
	private Timestamp resolved;	
	
	@Column(name = "description", length = 250)
	private String description;	
	
	@Column( name = "receipt" )
	private Blob receipt;	
	
	
	@ManyToOne
	@JoinColumn(name = "author", nullable = false) // foreign key column to Users table - user who is initiating the reimbursement request
	// @JsonManagedReference
	private Users author;
	
	@ManyToOne
	@JoinColumn(name = "resolver") // foreign key column to Users table - user who is approving/rejecting of the reimbursement request
	private Users resolver;
	
	@ManyToOne
	@JoinColumn(name = "status_id") // foreign key column to Reimbursement_Status table
	private ReimbursementStatus reimb_status;
	
	@ManyToOne
	@JoinColumn(name = "type_id") // foreign key column to Reimbursement_Type table
	private ReimbursementType reimb_type;

	

	public Reimbursement() {
		super();
	}



	public Reimbursement(double amount, Timestamp submitted, Timestamp resolved, String description, Blob receipt) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public Timestamp getSubmitted() {
		return submitted;
	}



	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}



	public Timestamp getResolved() {
		return resolved;
	}



	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Blob getReceipt() {
		return receipt;
	}



	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
	}



	public Users getAuthor() {
		return author;
	}



	public void setAuthor(Users iUser) {
		this.author = iUser;
	}



	public Users getResolver() {
		return resolver;
	}



	public void setResolver(Users resolver) {
		this.resolver = resolver;
	}



	public ReimbursementStatus getReimb_status() {
		return reimb_status;
	}



	public void setReimb_status(ReimbursementStatus reimb_status) {
		this.reimb_status = reimb_status;
	}



	public ReimbursementType getReimb_type() {
		return reimb_type;
	}



	public void setReimb_type(ReimbursementType lodging) {
		this.reimb_type = lodging;
	}



	@Override
	public int hashCode() {
		return Objects.hash(amount, author, description, id, receipt, reimb_status, reimb_type, resolved, resolver,
				submitted);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(author, other.author) && Objects.equals(description, other.description)
				&& id == other.id && Objects.equals(receipt, other.receipt)
				&& Objects.equals(reimb_status, other.reimb_status) && Objects.equals(reimb_type, other.reimb_type)
				&& Objects.equals(resolved, other.resolved) && Objects.equals(resolver, other.resolver)
				&& Objects.equals(submitted, other.submitted);
	}



	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved="
				+ resolved + ", description=" + description + ", receipt=" + receipt + ", author=" + author
				+ ", resolver=" + resolver + ", reimb_status=" + reimb_status + ", reimb_type=" + reimb_type + "]";
	}


}
 