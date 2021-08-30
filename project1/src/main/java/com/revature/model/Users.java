package com.revature.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usersID")
	private int id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "username", nullable = false, unique = true)
	private String userName;

	@Column(name = "password", nullable = false)
	private String userPassword;

	@ManyToOne
	@JoinColumn(name = "role_id") // foreign key column of the Reimbursement_Roles in the Users table
	private UserRoles userRole_id;

//	@OneToMany
//	private List<Reimbursement> reimbursements;

	public Users() {
		super();
	}

public Users(String firstName, String lastName, String email, String userName, String userPassword) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.userName = userName;
	this.userPassword = userPassword;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getUserPassword() {
	return userPassword;
}

public void setUserPassword(String userPassword) {
	this.userPassword = userPassword;
}

public UserRoles getUserRole_id() {
	return userRole_id;
}

public void setUserRole_id(UserRoles userRole_id) {
	this.userRole_id = userRole_id;
}

@Override
public int hashCode() {
	return Objects.hash(email, firstName, id, lastName, userName, userPassword, userRole_id);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Users other = (Users) obj;
	return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName) && id == other.id
			&& Objects.equals(lastName, other.lastName) && Objects.equals(userName, other.userName)
			&& Objects.equals(userPassword, other.userPassword) && Objects.equals(userRole_id, other.userRole_id);
}

@Override
public String toString() {
	return "Users [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
			+ ", userName=" + userName + ", userPassword=" + userPassword + ", userRole_id=" + userRole_id + "]";
}
	

	
	
}
