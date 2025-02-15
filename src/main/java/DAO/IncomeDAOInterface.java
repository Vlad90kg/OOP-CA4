package DAO;

import Exceptions.DaoException;
import Models.Income;

import java.sql.Date;
import java.util.List;

public interface IncomeDAOInterface {
    List<Income> getIncomes();
    void addIncome(String title, double amount, Date dateIncurred) throws DaoException;
    void deleteIncome(int id) throws DaoException;

}
