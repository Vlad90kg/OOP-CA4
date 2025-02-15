import DAO.DAOInterface;
import DAO.ExpenseDao;
import Exceptions.DaoException;
import Models.Expense;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class ExpenseOptions {

    static DAOInterface<Expense> expenseDao = new ExpenseDao();

    public static void getListOpt() throws DaoException {
        System.out.println("List of expenses");
        List<Expense> expenses = expenseDao.getList();
        expenses.forEach(System.out::println);
        System.out.println("Total expenses: " + expenseDao.getTotal());
    }

    public static void addExpenseOpt() throws DaoException {
        boolean valid;
        String category, title;
        Date dateIncurred = null;
        double amount = 0;
        Scanner scanner = new Scanner(System.in);
         do {
             valid = true;
            System.out.println("Enter expense title:");
            title = scanner.nextLine();

            System.out.println("Enter expense category:");
            category = scanner.nextLine();

            System.out.println("Enter expense amount:");
            if(scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
            } else {
                System.out.println("Entered amount is not a number");
                valid = false;
            }

            scanner.nextLine();
            if(valid) {
            System.out.println("Enter expense date(YYYY-MM-DD):");
            String dateInput = scanner.nextLine();


                try {
                    dateIncurred = Date.valueOf(dateInput);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid date format. Please enter in format YYYY-MM-DD.");
                    valid = false;
                }
            }


        }while (!valid);

        Expense expense = new Expense(title, category, amount, dateIncurred);
        try{
            expenseDao.add(expense);
            System.out.println("Expense added successfully");
        } catch (DaoException e) {
            throw new DaoException("Error adding expense");
        }
        scanner.close();
    }

    public static void deleteExpenseOpt() throws DaoException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter expense id to delete:");
        int expenseId = scanner.nextInt();
        expenseDao.deleteByID(expenseId);
        System.out.println();
        System.out.println("Expense deleted successfully");
        scanner.close();
    }

}
