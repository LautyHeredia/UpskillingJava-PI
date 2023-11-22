import Exceptions.InvalidExpenseException;
import Interfaces.ExpenseAmountValidator;
import Interfaces.ExpenseAmountValidatorImpl;
import Interfaces.ExpenseCalculator;
import Interfaces.ExpenseCalculatorImpl;
import Utilities.Expense;
import Utilities.ExpenseCategory;

import java.util.Scanner;

public class Main {
    public static int counter = 0;

    public static void main(String[] args) throws InvalidExpenseException {

        Scanner scanner = new Scanner(System.in);
        boolean isWrongType = false;
        Double amount;
        int cantMountIn = 0;
        int index = 0;

        ExpenseAmountValidator expenseValidator = new ExpenseAmountValidatorImpl();
        ExpenseCalculator calculator = new ExpenseCalculatorImpl();

        do {
            System.out.print("Ingrese cantidad de gastos a ingresar : ");
            if (scanner.hasNextInt()) {
                cantMountIn = scanner.nextInt();
            } else {
                System.out.println("Ha ingresado un dato erroneo");
                scanner.next();
            }
        }while(isWrongType);

        Expense[] expenses = new Expense[cantMountIn];

        do {
            Expense expense = new Expense();
            ExpenseCategory category = new ExpenseCategory();

            System.out.print("Ingrese Monto del gasto " + (index + 1) + " : ");
            amount = scanner.nextDouble();

            if(!expenseValidator.amountValidator(amount)){
                System.out.println("Monto valido");
            }

            scanner.nextLine();

            System.out.print("Ingrese categoria del gasto: ");
            String name;
            name = scanner.nextLine().toLowerCase().trim();
            category.setName(name);

            System.out.print("Ingrese fecha del gasto (dd/mm/yyyy): ");
            String date = scanner.nextLine();

            expense.setId(counter);
            expense.setAmount(amount);
            expense.setCategory(category);
            expense.setDate(date);

            expenses[index] = expense;

            counter++;
            index++;
        }while(index < cantMountIn);

        System.out.println("Gastos totales: " + calculator.calculateTotalExpenses(expenses));

        System.out.println("Detalles de gastos: ");
         for(Expense expense : expenses){
            System.out.println(expense.toString());
         }
    }
}