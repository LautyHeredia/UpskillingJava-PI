package Interfaces;

import Exceptions.InvalidExpenseException;

@FunctionalInterface
public interface ExpenseAmountValidator {
    boolean amountValidator(double amount) throws InvalidExpenseException;
}
