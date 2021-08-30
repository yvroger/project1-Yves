package com.revature.dao;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.model.Users;
import com.revature.util.SessionFactorySingleton;

public class UserDAO {

	public Users getUserByUsernameAndPassword(String username, String password) {
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		
		try {
			Users user = (Users) session.createQuery("FROM Users u WHERE u.userName = :username AND u.userPassword = :password")
					.setParameter("username", username)
					.setParameter("password", password)
					.getSingleResult();
			
			return user;
		} catch(NoResultException e) {			
			return null;
		} finally {
			session.close();
		}

	}
	
}
