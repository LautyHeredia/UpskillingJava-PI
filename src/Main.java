import Exceptions.InvalidExpenseException;
import Interfaces.ExpenseAmountValidator;
import Interfaces.ExpenseAmountValidatorImpl;
import Interfaces.ExpenseCalculator;
import Interfaces.ExpenseCalculatorImpl;
import Utilities.Expense;
import Utilities.ExpenseCategory;
import Utilities.Util;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static int counter = 0;

    public static void main(String[] args) throws InvalidExpenseException {

        Scanner scanner = new Scanner(System.in);
        //boolean isWrongType = false;
        Double amount;
        int index = 0;
        //int cantMountIn = 0;

        ExpenseAmountValidator expenseValidator = new ExpenseAmountValidatorImpl();
        ExpenseCalculator calculator = new ExpenseCalculatorImpl();

        /*do {
            System.out.print("Ingrese cantidad de gastos a ingresar : ");
            if (scanner.hasNextInt()) {
                cantMountIn = scanner.nextInt();
            } else {
                System.out.println("Ha ingresado un dato erroneo");
                scanner.next();
            }
        }while(isWrongType);*/

        boolean cutLogicVar;

        System.out.println("Desea cargar un gasto?: (True or False)");
        cutLogicVar = scanner.nextBoolean();

        List<Expense> expenses = new ArrayList<>();
        Map<String, Integer> countCategoryMap = new HashMap<>();

        while(cutLogicVar) {
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

            countCategoryMap.put(name, countCategoryMap.getOrDefault(name, 0) + 1);

            expense.setId(counter);
            expense.setAmount(amount);
            expense.setCategory(category);
            expense.setDate(date);

            expenses.add(expense);

            counter++;
            index++;

            System.out.println("Desea hacer otra carga? (True or False)");
            cutLogicVar = scanner.nextBoolean();
        };


        System.out.println("Gastos totales: " + calculator.calculateTotalExpenses(expenses));

        System.out.println("Top 3 de gastos: ");
        List<Double> amounts = expenses.stream()
                .map(e -> e.getAmount())
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());

        amounts.forEach(e -> System.out.println(e));

        System.out.println("Contador por categoria: ");
        countCategoryMap.forEach((category, count) -> System.out.println(category + ": " + count));

        System.out.println("Detalles de gastos: ");
        Util.printElements(expenses);
    }
}