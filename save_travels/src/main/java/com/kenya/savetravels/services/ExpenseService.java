package com.kenya.savetravels.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenya.savetravels.models.Expense;
import com.kenya.savetravels.repositories.ExpenseRepo;

@Service
public class ExpenseService {
	
	@Autowired 
	private ExpenseRepo expenseRepo;

	// Get all entries 
	   public List<Expense> allEntries() {
	        return expenseRepo.findAll();
	    }
	   
	   // Create a new entry
	   public Expense createEntry(Expense e) {
	        return expenseRepo.save(e);
	    }

}
