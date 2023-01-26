package com.learn.expensetracker.repository;

import com.learn.expensetracker.model.Expense;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface ExpenseRepository extends JpaRepository<Expense, String> {
    Optional<Expense> findByexpenseName(String name);
}