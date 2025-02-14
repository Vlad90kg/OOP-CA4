package DAO;

import Models.Expense;

import java.util.List;

public interface ExpenseDAOInterface {
    List<Expense> getExpenses();
    void addExpense(Expense expense);
    void deleteExpense(int id);

}
