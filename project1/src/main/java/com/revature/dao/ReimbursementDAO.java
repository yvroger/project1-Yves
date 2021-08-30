package com.revature.dao;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.dto.ReimbursementDTO;
import com.revature.model.Reimbursement;
import com.revature.model.ReimbursementStatus;
import com.revature.model.ReimbursementType;
import com.revature.model.Users;
import com.revature.util.SessionFactorySingleton;

public class ReimbursementDAO {

	public List<Reimbursement> getAllReimbursementsFromUserId(int id) {
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		List<Reimbursement> reimbursements = session.createQuery("SELECT r FROM Reimbursement r JOIN r.author u WHERE u.id = :userid").setParameter("userid", id).getResultList();
	
		return reimbursements;
	}

	public Reimbursement addReimbursement(ReimbursementDTO regularReimbursement, int id) {
		Date date = new Date(id);
		Timestamp timestamp = new Timestamp(date.getTime());
		Blob receipt = null;
		
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Reimbursement addedReimbursement = new Reimbursement();
		addedReimbursement.setAuthor(session.get(Users.class, id));
		addedReimbursement.setDescription(regularReimbursement.getReimbDescription());
		addedReimbursement.setReimb_status(session.get(ReimbursementStatus.class, 1));
		addedReimbursement.setAmount(regularReimbursement.getReimbAmount());
		addedReimbursement.setResolver(null);
		addedReimbursement.setSubmitted(timestamp);
		addedReimbursement.setResolved(null);
		addedReimbursement.setReceipt(receipt);
		addedReimbursement.setReimb_type(session.get(ReimbursementType.class, regularReimbursement.getReimbType()));
		session.persist(addedReimbursement);
		
		
		tx.commit();
		session.close();
		
		return addedReimbursement;
	}

	public List<Reimbursement> getAllReimbursements() {
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		List<Reimbursement> reimbursements = session.createQuery("SELECT s FROM Reimbursement s").getResultList();
		return reimbursements;
	}

	public List<Reimbursement> getAllReimbursementsByStatus(String reimbStatus) {
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		List<Reimbursement> reimbursements = session.createQuery("SELECT s FROM Reimbursement s JOIN s.status u WHERE u.status = :reimbStatus").setParameter("reimbStatus", reimbStatus).getResultList();
	
		return reimbursements;
	}

	public Reimbursement editReimbursement(Users currentUser, int id, int reimbStatus) {
		
		Date date = new Date();
		Timestamp resolved = new Timestamp(date.getTime());
		
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Reimbursement editedReimbursement = session.get(Reimbursement.class, id);
		editedReimbursement.setResolver(currentUser);
		editedReimbursement.setResolved(resolved);
		editedReimbursement.setReimb_status(session.get(ReimbursementStatus.class, reimbStatus));
		session.saveOrUpdate(editedReimbursement);
		
		tx.commit();
		session.close();		
	
		return editedReimbursement;
	}


}
