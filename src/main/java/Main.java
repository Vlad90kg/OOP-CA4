import DAO.DAOInterface;
import DAO.ExpenseDao;
import DAO.IncomeDao;
import DAO.MySQLDao;
import Exceptions.DaoException;
import Models.Expense;
import Models.Income;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DAOInterface<Expense> expenseDao = new ExpenseDao();
        DAOInterface<Income> incomeDao = new IncomeDao();
        Scanner scanner = new Scanner(System.in);
        int option;
        try {
            System.out.println("Welcome to budget keeper! Choose a submenu:");
            System.out.println("1. Expenses");
            System.out.println("2. Incomes");
            System.out.println("3. Exit");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    boolean loop = true;
                    while (loop){
                        System.out.println("1. Add Expense");
                        System.out.println("2. Get list of expenses and total spend");
                        System.out.println("3. Delete an expense by ID");
                        System.out.println("4. Exit");
                        option = scanner.nextInt();
                        switch (option) {
                            case 1:
                                ExpenseOptions.addExpenseOpt();
                                loop = false;
                                break;
                            case 2:
                                ExpenseOptions.getListOpt();
                                loop = false;
                                break;
                            case 3:
                                ExpenseOptions.deleteExpenseOpt();
                                loop = false;
                                break;
                            case 4:
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Invalid option");
                                break;
                        }
                    }

                    break;
                case 2:
                    break;
                case 3:
                    break;
            }


            System.out.println("List of incomes");
            List<Income> incomes = incomeDao.getList();
            incomes.forEach(System.out::println);
            System.out.println("Total incomes: " + incomeDao.getTotal());
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }

    }
}
