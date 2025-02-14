package DAO;

import Models.Income;

import java.util.List;

public interface IncomeDAOInterface {
    List<Income> getIncomes();
    void addIncome(Income income);
    void deleteIncome(int id);

}
