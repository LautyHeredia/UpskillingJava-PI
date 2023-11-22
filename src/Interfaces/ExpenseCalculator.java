package Interfaces;

import Utilities.Expense;

import java.util.List;

public interface ExpenseCalculator {
    double calculateExpense(Expense expenses);
    double calculateTotalExpenses(List<Expense> expenses);
}
