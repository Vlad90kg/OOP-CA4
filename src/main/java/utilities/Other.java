package utilities;

import DAO.DAOInterface;
import DAO.ExpenseDao;
import DAO.IncomeDao;
import Exceptions.DaoException;
import Models.Expense;
import Models.Income;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Other {
    static DAOInterface<Expense> expenseDao = new ExpenseDao();
    static DAOInterface<Income> incomeDao = new IncomeDao();

    public static void incomeExpenseForMonth(int month) throws DaoException {
        List<Expense> expenses = expenseDao.getList();
        List<Income> incomes = incomeDao.getList();
        List<Expense> expenseListForMonth = new ArrayList<>();
        List<Income> incomeListForMonth = new ArrayList<>();

        expenses.forEach(expense -> {
            LocalDate localDate = expense.getDateIncurred().toLocalDate();
            if(localDate.getMonthValue() == month){
                expenseListForMonth.add(expense);
            }
        });
        incomes.forEach(income -> {
           LocalDate localDate = income.getDateIncurred().toLocalDate();
           if(localDate.getMonthValue() == month){
               incomeListForMonth.add(income);
           }
        });
        double incomeSum = 0;
        double expenseSum = 0;
        System.out.println("Expenses for month: " + month);
        for (Expense expense : expenseListForMonth) {
            System.out.println(expense);
            expenseSum += expense.getAmount();

        }
        System.out.println("Incomes for month: " + month);
        for (Income income : incomeListForMonth) {
            System.out.println(income);
            incomeSum += income.getAmount();
        }

        double budget = incomeSum-expenseSum;

        System.out.println("Total expenses for month: " + expenseSum);
        System.out.println("Total incomes for month: " + incomeSum);
        System.out.println("Budget: " + budget);
    }
}
