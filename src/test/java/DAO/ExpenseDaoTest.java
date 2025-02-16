package DAO;

import Exceptions.DaoException;
import Models.Expense;
import org.junit.jupiter.api.BeforeEach;
import java.sql.Date;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseDaoTest {

    DAOInterface<Expense> DAOInterface = null;
    @BeforeEach
    void setUp() throws DaoException {
        DAOInterface = new ExpenseDao();


    }

    @org.junit.jupiter.api.Test
    void getExpenses() throws DaoException {
        LocalDate localDate = LocalDate.of(2020, 1, 1);
        Date date = Date.valueOf(localDate);
        Expense expense = new Expense("title", "category", 700.66, date);
        DAOInterface.add(expense);
        List<Expense> expenses = DAOInterface.getList();
        assertNotNull(expenses);
        assertEquals(1, expenses.size());

    }



    @org.junit.jupiter.api.Test
    void addExpense() throws DaoException {

        LocalDate localDate = LocalDate.of(2020, 1, 1);
        Date date = Date.valueOf(localDate);
        Expense expense = new Expense("title", "category", 700.66, date);
        DAOInterface.add(expense);
        Expense expense2 = DAOInterface.getList().getLast();
        assertEquals(expense.getTitle(), expense2.getTitle());

    }

    @org.junit.jupiter.api.Test
    void deleteExpense() throws DaoException {
        int id = 0;
        List<Expense> expenses = DAOInterface.getList();
        for (Expense expense : expenses) {
            id = expense.getExpenseID();
            DAOInterface.deleteByID(id);
        }
        List<Expense> expenses2 = DAOInterface.getList();
        assertTrue(expenses2.isEmpty());
    }
}