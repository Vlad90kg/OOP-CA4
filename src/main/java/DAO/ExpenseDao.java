package DAO;

import Exceptions.DaoException;
import Models.Expense;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class ExpenseDao extends MySQLDao implements ExpenseDAOInterface {


    @Override
    public List<Expense> getExpenses() throws DaoException {
        String sql = "select * from expense";
        List<Expense> expenses = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                Date date = rs.getDate("dateIncurred");
                double amount = rs.getDouble("amount");
                String category = rs.getString("category");
                String title = rs.getString("title");
                Expense expense = new Expense(id,title,category,amount,date);
                expenses.add(expense);
            }
        } catch (SQLException e) {
            throw new DaoException("Error fetching expenses: " + e.getMessage());
        }
        return expenses;
    }

    @Override
    public Expense getExpense(int id) throws DaoException {
        String sql = "select * from expense where id = ?";
        Expense expense = null;
        try (Connection conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs= preparedStatement.executeQuery()) {
                if (rs.next()) {
                    Date date = rs.getDate("dateIncurred");
                    double amount = rs.getDouble("amount");
                    String category = rs.getString("category");
                    String title = rs.getString("title");
                    expense = new Expense(id,title,category,amount,date);
                }
            }

        } catch (SQLException e) {
            throw new DaoException("Error fetching expenses: " + e.getMessage());
        }
        return expense;
    }

    @Override
    public void addExpense(String title, String category, double amount, Date date) throws DaoException {
        String sql = "INSERT INTO expense (title,category,amount,dateIncurred) VALUES (?,?,?,?)";
        try (Connection conn = getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, category);
            preparedStatement.setDouble(3, amount);
            preparedStatement.setDate(4, date);
            int rowInserted = preparedStatement.executeUpdate();
            if (rowInserted == 0) {
                throw new DaoException("Error inserting expense, no rows affected");
            }
        } catch (SQLException e) {
            throw new DaoException("Error adding expenses: " + e.getMessage());
        }

    }

    @Override
    public void deleteExpense(int id) {

    }
}
