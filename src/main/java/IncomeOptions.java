import DAO.DAOInterface;
import DAO.IncomeDao;
import Exceptions.DaoException;
import Models.Income;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class IncomeOptions {

    static DAOInterface<Income> incomeDao = new IncomeDao();

    public static void getListOpt() throws DaoException {
        System.out.println("List of incomes");
        List<Income> incomes = incomeDao.getList();
        incomes.forEach(System.out::println);
        System.out.println("Total incomes: " + incomeDao.getTotal());
    }

    public static void addIncomeOpt() throws DaoException {
        boolean valid;
        String title;
        Date dateIncurred = null;
        double amount = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            valid = true;
            System.out.println("Enter income title:");
            title = scanner.nextLine();

            System.out.println("Enter income amount:");
            if(scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
            } else {
                System.out.println("Entered amount is not a number");
                valid = false;
            }

            scanner.nextLine();
            if(valid) {
                System.out.println("Enter income date(YYYY-MM-DD):");
                String dateInput = scanner.nextLine();


                try {
                    dateIncurred = Date.valueOf(dateInput);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid date format. Please enter in format YYYY-MM-DD.");
                    valid = false;
                }
            }


        }while (!valid);

        Income income = new Income(title, amount, dateIncurred);
        try{
            incomeDao.add(income);
            System.out.println("Income added successfully");
        } catch (DaoException e) {
            throw new DaoException("Error adding income");
        }
        scanner.close();
    }

    public static void deleteIncomeOpt() throws DaoException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter income id to delete:");
        int incomeId = scanner.nextInt();
        incomeDao.deleteByID(incomeId);
        System.out.println();
        System.out.println("Income deleted successfully");
        scanner.close();
    }
}
