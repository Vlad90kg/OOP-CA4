import DAO.DAOInterface;
import DAO.ExpenseDao;
import DAO.IncomeDao;
import Exceptions.DaoException;
import Models.Expense;
import Models.Income;
import utilities.ExpenseOptions;
import utilities.IncomeOptions;
import utilities.Other;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        String option;
        try {
            System.out.println("Welcome to budget keeper! Choose a submenu:");
            System.out.println("1. Expenses");
            System.out.println("2. Incomes");
            System.out.println("3. List all income and expenses for a particular month and display the total income, expenditure, and how much money they should have left over.");
            System.out.println("4. Exit");
            option = scanner.nextLine();
            switch (option) {
                case "1":
                    submenu("Expenses");
                    break;
                case "2":
                    submenu("Incomes");
                    break;
                case "3":
                    System.out.println("Enter the month:");
                    int month = scanner.nextInt();
                    Other.incomeExpenseForMonth(month);
                    break;
                case "4":
                    System.exit(0);
                    break;
            }
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    static void submenu(String submenu) throws DaoException {
        String option;
        if (submenu.equals("Expenses")) {
            boolean loop = true;
            while (loop) {
                System.out.println("1. Add Expense");
                System.out.println("2. Get list of expenses and total spend");
                System.out.println("3. Delete an expense by ID");
                System.out.println("4. Exit");
                option = scanner.nextLine();
                switch (option) {
                    case "1":
                        ExpenseOptions.addExpenseOpt();
                        loop = false;
                        break;
                    case "2":
                        ExpenseOptions.getListOpt();
                        loop = false;
                        break;
                    case "3":
                        ExpenseOptions.deleteExpenseOpt();
                        loop = false;
                        break;
                    case "4":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
            }
        } else if (submenu.equals("Incomes")) {
            boolean loop = true;
            while (loop) {
                System.out.println("1. Add Income");
                System.out.println("2. Get list of incomes and total income");
                System.out.println("3. Delete an income by ID");
                System.out.println("4. Exit");
                option = scanner.nextLine();
                switch (option) {
                    case "1":
                        IncomeOptions.addIncomeOpt();
                        loop = false;
                        break;
                    case "2":
                        IncomeOptions.getListOpt();
                        loop = false;
                        break;
                    case "3":
                        IncomeOptions.deleteIncomeOpt();
                        loop = false;
                        break;
                    case "4":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
            }
        }
    }

}
