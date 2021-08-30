package com.revature.service;


import java.util.List;

import com.revature.dao.ReimbursementDAO;
import com.revature.dto.ReimbursementDTO;
import com.revature.model.Reimbursement;
import com.revature.model.Users;

public class ReimbursementService {

	private ReimbursementDAO reimbursementDao;
	
	public ReimbursementService() {
		this.reimbursementDao = new ReimbursementDAO();
	}
	
	public List<Reimbursement> getAllReimbursementsFromUserId(String userId) {
		int id = Integer.parseInt(userId);
		
		List<Reimbursement> reimbursements = reimbursementDao.getAllReimbursementsFromUserId(id);
		
		return reimbursements;
	}

	public Reimbursement addReimbursement(ReimbursementDTO reimbursement, String userId) {
		
		int id = Integer.parseInt(userId);
	
		Reimbursement addedReimbursement = reimbursementDao.addReimbursement(reimbursement,id);
		
		return addedReimbursement;
	
}

	public List<Reimbursement> getAllReimbursements() {

		List<Reimbursement> reimbursements = reimbursementDao.getAllReimbursements();
		
		return reimbursements;
	}

	public List<Reimbursement> getAllReimbursementsByStatus(String reimStatus) {
		
		List<Reimbursement> reimbursements = reimbursementDao.getAllReimbursementsByStatus(reimStatus);
		
		return reimbursements;
	}

	public Reimbursement editReimbursement(Users currentUser, String reimbId, String reimbStatus) {
		
		int id = Integer.parseInt(reimbId);
		int statusId = Integer.parseInt(reimbStatus);
	
		Reimbursement addedReimbursement = reimbursementDao.editReimbursement(currentUser, id, statusId);
		
		return addedReimbursement;
	}

}
