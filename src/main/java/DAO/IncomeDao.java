package DAO;

import Exceptions.DaoException;
import Models.Income;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class IncomeDao extends  MySQLDao implements IncomeDAOInterface {
    @Override
    public List<Income> getIncomes() {
        List<Income> incomes = new ArrayList<>();
        String query = "SELECT * FROM Income";
        try(Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                int incomeID = rs.getInt("incomeID");
                String title = rs.getString("title");
                double amount = rs.getDouble("amount");
                Date dateIncurred  = rs.getDate("dateIncurred");
                Income income = new Income(incomeID,title,amount,dateIncurred);
                incomes.add(income);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return incomes;
    }

    @Override
    public void addIncome(String title, double amount, Date dateIncurred) throws DaoException {
        String sql = "INSERT INTO Income (title,amount,dateIncurred) VALUES (?,?,?)";
        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, title);
            preparedStatement.setDouble(2, amount);
            preparedStatement.setDate(3, dateIncurred);
            int rowInserted = preparedStatement.executeUpdate();
            if (rowInserted == 0) {
                throw new DaoException("Error inserting expense, no rows affected");
            }
        } catch (SQLException e) {
            throw new DaoException("Error adding expenses: " + e.getMessage());
        }
    }

    @Override
    public void deleteIncome(int id) throws DaoException {
        String sql = "DELETE FROM Income WHERE Income.incomeID = ?";

        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            int rowDeleted = preparedStatement.executeUpdate();
            if (rowDeleted == 0) {
                throw new DaoException("Error deleting expense, no rows affected");
            }
        } catch (SQLException e) {
            throw new DaoException("Error deleting expenses: " + e.getMessage());
        }
    }
}
