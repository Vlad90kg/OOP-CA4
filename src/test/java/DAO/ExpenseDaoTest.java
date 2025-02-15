package DAO;

import Exceptions.DaoException;
import Models.Expense;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseDaoTest {

    DAOInterface<Expense> DAOInterface = null;
    @BeforeEach
    void setUp() throws DaoException {
        DAOInterface = new ExpenseDao();
    }

    @org.junit.jupiter.api.Test
    void getExpenses() {
        List<Expense> expenses = new ArrayList<>();


    }

    @org.junit.jupiter.api.Test
    void addExpense() throws DaoException {
        LocalDate localDate = LocalDate.of(2020, 1, 1);
        Date date = Date.valueOf(localDate);
        Expense expense = new Expense("Cockpany", "baxpenses", 700.66, date);
        DAOInterface.add(expense);
        Expense expense2 = DAOInterface.getByID(6);
        assertEquals(expense.getTitle(), expense2.getTitle());

    }

    @org.junit.jupiter.api.Test
    void deleteExpense() {
    }
}