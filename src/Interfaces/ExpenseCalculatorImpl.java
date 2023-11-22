package Interfaces;

import Utilities.Expense;

public class ExpenseCalculatorImpl implements ExpenseCalculator {
    @Override
    public double calculateExpense(Expense expenses) {
        return expenses.getAmount();
    }

    @Override
    public double calculateTotalExpenses(Expense[] expenses) {
        double getAmountTotal = 0;

        for(Expense expense : expenses){
            getAmountTotal = getAmountTotal + expense.getAmount();
        }
        return getAmountTotal;
    }
}
