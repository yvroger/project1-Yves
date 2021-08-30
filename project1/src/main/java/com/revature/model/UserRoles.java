package com.revature.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
public class UserRoles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userRoleID")
	private int id;
	
	@Column(name = "userRole", nullable = false) //"finance manager" or "employee"
	private String userRole;
	

//	@OneToMany(mappedBy = "userRole_id", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
//	private List<Users> iUsers;


	public UserRoles() {
		super();
	}

	public UserRoles(String userRole) {
		super();
		this.userRole = userRole;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, userRole);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRoles other = (UserRoles) obj;
		return id == other.id && Objects.equals(userRole, other.userRole);
	}

	@Override
	public String toString() {
		return "UserRoles [id=" + id + ", userRole=" + userRole + "]";
	}


	
}
