package model;

public class Prospect {
    private String customer;
    private double totalLoan;
    private double interest;
    private int years;

    public Prospect(String customer, double totalLoan, double interest, int years) {
        this.customer = customer;
        this.totalLoan = totalLoan;
        this.interest = interest;
        this.years = years;
    }

    public String getCustomer() {
        return customer;
    }

    public double getTotalLoan() {
        return totalLoan;
    }

    public double getInterest() {
        return interest;
    }

    public int getYears() {
        return years;
    }
}
