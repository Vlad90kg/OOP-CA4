package Models;

import java.util.Date;

public class Expense {
    private int ExpenseID;
    private String title, category;
    private double amount;
    private Date dateIncurred;

    public Expense(int expenseID, String title, String category, double amount, Date dateIncurred) {
        ExpenseID = expenseID;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.dateIncurred = dateIncurred;
    }

    public int getExpenseID() {
        return ExpenseID;
    }

    public void setExpenseID(int expenseID) {
        ExpenseID = expenseID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDateIncurred() {
        return dateIncurred;
    }

    public void setDateIncurred(Date dateIncurred) {
        this.dateIncurred = dateIncurred;
    }


    @Override
    public String toString() {
        return "Expense{" +
                "ExpenseID=" + ExpenseID +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                ", dateIncurred=" + dateIncurred +
                '}';
    }
}
