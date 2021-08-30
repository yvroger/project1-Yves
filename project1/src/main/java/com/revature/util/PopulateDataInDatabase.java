package com.revature.util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.model.Reimbursement;
import com.revature.model.ReimbursementStatus;
import com.revature.model.ReimbursementType;
import com.revature.model.UserRoles;
import com.revature.model.Users;

public class PopulateDataInDatabase {

	public static void main(String[] args) {
//		populateReimbursementStatus_Type_UserRoles();
//		addUsers();
		
//		addReimbursements_ByUserId(0);
//		addReimbursements();
	}

	private static void populateReimbursementStatus_Type_UserRoles() {
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		UserRoles admin = new UserRoles("Finance Manager");
		UserRoles user = new UserRoles("Employee");
		session.persist(admin);
		session.persist(user);
		
		ReimbursementStatus pending = new ReimbursementStatus("pending");
		ReimbursementStatus approved = new ReimbursementStatus("approved");
		ReimbursementStatus denied = new ReimbursementStatus("denied");
		session.persist(pending);
		session.persist(approved);
		session.persist(denied);
		
		ReimbursementType Lodging = new ReimbursementType("Lodging");
		ReimbursementType Travel = new ReimbursementType("Travel");
		ReimbursementType Food = new ReimbursementType("Food");
		ReimbursementType Other = new ReimbursementType("Other");
		session.persist(Lodging);
		session.persist(Travel);
		session.persist(Food);
		session.persist(Other);
		
		tx.commit();
		session.close();
	}
	
	private static void addUsers() {
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		//Pre-populate Finance Managers employees		
		UserRoles mgr = (UserRoles) session.createQuery("FROM UserRoles ur WHERE ur.userRole = 'Finance Manager'").getSingleResult();
		
		Users adminUser1 = new Users("Yves", "Bouele", "yves@reva.tur", "ybouele", "1234");
		adminUser1.setUserRole_id(mgr);
		Users adminUser2 = new Users("Anne", "Bouele", "anneb@reva.tur", "abouele", "myP@ss2");	
		adminUser2.setUserRole_id(mgr);
		
		session.persist(adminUser1);
		session.persist(adminUser2);

		//Pre-populate Regular employees	
		UserRoles emp = (UserRoles) session.createQuery("FROM UserRoles ur WHERE ur.userRole = 'Employee'").getSingleResult();

		Users iUser1 = new Users("First", "Employee", "emp1@mymail.com", "firstEmp", "emp1P@ss");
		Users iUser2 = new Users("Second", "Employee", "emp2@mymail.com", "secondEmp", "emp2P@ss");
		Users iUser3 = new Users("Third", "Employee", "emp3@mymail.com", "thirdEmp", "emp3P@ss");
		Users iUser4 = new Users("Fourth", "Employee", "emp4@mymail.com", "fourthEmp", "emp4P@ss");
		
		iUser1.setUserRole_id(emp);
		iUser2.setUserRole_id(emp);
		iUser3.setUserRole_id(emp);
		iUser4.setUserRole_id(emp);
		
		session.persist(iUser1);
		session.persist(iUser2);
		session.persist(iUser3);
		session.persist(iUser4);
		
		tx.commit();
		session.close();
	}
	
//	private static void addReimbursements_ByUserId(int id) {
		private static void addReimbursements() {
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Users iUser = (Users) session.createQuery("FROM Users u WHERE u.userName = 'firstEmp'").getSingleResult();
		System.out.println(iUser);

		Users iUser2 = (Users) session.createQuery("FROM Users u WHERE u.userName = 'thirdEmp'").getSingleResult();

		Users iUser3 = (Users) session.createQuery("FROM Users u WHERE u.userName = 'ybouele'").getSingleResult();
		
		ReimbursementStatus pending = (ReimbursementStatus) session.createQuery("FROM ReimbursementStatus s WHERE s.reimbStatus = 'pending'").getSingleResult();
		
		ReimbursementType lodging = (ReimbursementType) session.createQuery("FROM ReimbursementType t WHERE t.reimbType = 'Lodging'").getSingleResult();
		ReimbursementType travel = (ReimbursementType) session.createQuery("FROM ReimbursementType t WHERE t.reimbType = 'Travel'").getSingleResult();
		ReimbursementType food = (ReimbursementType) session.createQuery("FROM ReimbursementType t WHERE t.reimbType = 'Food'").getSingleResult();
		ReimbursementType other = (ReimbursementType) session.createQuery("FROM ReimbursementType t WHERE t.reimbType = 'Other'").getSingleResult();
		

		Reimbursement reimbursement1 = new Reimbursement();
		reimbursement1.setAmount(123.45);
		reimbursement1.setAuthor(iUser);
		reimbursement1.setReimb_status(pending);
		reimbursement1.setReimb_type(lodging);
		
		Reimbursement reimbursement2 = new Reimbursement();
		reimbursement2.setAmount(10.00);
		reimbursement2.setAuthor(iUser2);
		reimbursement2.setReimb_status(pending);
		reimbursement2.setReimb_type(travel);
		
		Reimbursement reimbursement3 = new Reimbursement();
		reimbursement3.setAmount(200.10);
		reimbursement3.setAuthor(iUser);
		reimbursement3.setReimb_status(pending);
		reimbursement3.setReimb_type(food);
		
		Reimbursement reimbursement4 = new Reimbursement();
		reimbursement4.setAmount(672.33);
		reimbursement4.setAuthor(iUser3);
		reimbursement4.setReimb_status(pending);
		reimbursement4.setReimb_type(other);
		
		session.persist(reimbursement1);
		session.persist(reimbursement2);
		session.persist(reimbursement3);
		session.persist(reimbursement4);
		
		tx.commit();
		session.close();
	}

}
