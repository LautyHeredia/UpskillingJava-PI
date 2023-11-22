package Interfaces;

import Exceptions.InvalidExpenseException;

public class ExpenseAmountValidatorImpl implements ExpenseAmountValidator {
    @Override
    public boolean amountValidator(double amount) throws InvalidExpenseException {
        if(amount < 0){
            throw new InvalidExpenseException("El monto ingresado ingresado debe ser igual o mayor a 0");
        }

        return false;
    }
}
