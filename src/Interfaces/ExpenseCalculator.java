package Interfaces;

import Utilities.Expense;

public interface ExpenseCalculator {
    double calculateExpense(Expense expenses);
    double calculateTotalExpenses(Expense[] expenses);
}
