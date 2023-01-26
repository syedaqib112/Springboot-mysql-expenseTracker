package com.learn.expensetracker.service;

import com.learn.expensetracker.model.Expense;
import com.learn.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    public void addExpense(Expense expense){
        expenseRepository.save(expense);
    }

    public void updateExpense(Expense expense){
        Expense savedExpense = expenseRepository.findById(expense.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot Find Expense by ID %s", expense.getId())));

        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());

        expenseRepository.save(savedExpense);

    }

    public List<Expense> getAllExpense(){
        return expenseRepository.findAll();
    }

    public Expense getExpenseByName(String name) {
        return expenseRepository.findByexpenseName(name)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot Find Expense by Name %s", name)));
    }

    public void deleteExpense(String id){
        expenseRepository.deleteById(id);
    }
}