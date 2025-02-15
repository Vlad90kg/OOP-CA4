package DAO;

import Exceptions.DaoException;
import Models.Expense;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseDaoTest {

    ExpenseDAOInterface expenseDAOInterface = null;
    @BeforeEach
    void setUp() throws DaoException {
        expenseDAOInterface = new ExpenseDao();
    }

    @org.junit.jupiter.api.Test
    void getExpenses() {

    }

    @org.junit.jupiter.api.Test
    void addExpense() throws DaoException {
        LocalDate localDate = LocalDate.of(2020, 1, 1);
        Date date = Date.valueOf(localDate);
        expenseDAOInterface.addExpense("Cockpany", "baxpenses", 700.66, date);
        Expense expense = expenseDAOInterface.getExpense(1);
        assertNotNull(expense);

    }

    @org.junit.jupiter.api.Test
    void deleteExpense() {
    }
}