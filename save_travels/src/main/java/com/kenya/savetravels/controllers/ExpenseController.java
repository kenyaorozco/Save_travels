package com.kenya.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kenya.savetravels.models.Expense;
import com.kenya.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	// home route redirects to the expense route
	@GetMapping("/")
	public String home() {
		return "redirect:expenses";
	}

	
	@GetMapping("/expenses")
	public String createEntry(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> allDaEntries = expenseService.allEntries();
		model.addAttribute("allDaEntries", allDaEntries);
		return "index.jsp";
	}
	
	
	@PostMapping("/expenses")
	public String create(@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Expense> allDaEntries = expenseService.allEntries();
			model.addAttribute("allDaEntries", allDaEntries);
			return "index.jsp";
		} else {
			expenseService.createEntry(expense);
			return "redirect:/expenses";
		}
		
	}

}
