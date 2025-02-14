package Models;

import java.util.Date;

public class Income {
    private int incomeID;
    private String title;
    private double amount;
    private Date dateIncurred;

    public Income(int incomeID, String title, double amount, Date dateIncurred) {
        this.incomeID = incomeID;
        this.title = title;
        this.amount = amount;
        this.dateIncurred = dateIncurred;
    }

    public int getIncomeID() {
        return incomeID;
    }

    public void setIncomeID(int incomeID) {
        this.incomeID = incomeID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
