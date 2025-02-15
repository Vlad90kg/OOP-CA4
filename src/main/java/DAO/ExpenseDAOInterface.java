package DAO;

import Exceptions.DaoException;
import Models.Expense;

import java.sql.Date;
import java.util.List;

public interface ExpenseDAOInterface {
    List<Expense> getExpenses() throws DaoException;
    Expense getExpense(int id) throws DaoException;
    void addExpense(String title, String category, double amount, Date date) throws DaoException;
    void deleteExpense(int id) throws DaoException;

}
