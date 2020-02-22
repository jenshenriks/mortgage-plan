package model;

import java.util.ArrayList;
import java.util.List;

public class MortgageCalculator {
    
    private static final int MONTHS = 12;
    
    public MortgageCalculator() { }
    
    public List<Double> monthlyPayment(List<Prospect> prospects) {
        List<Double> monthlyPayments = new ArrayList<>();
        
        for(Prospect prospect : prospects) {
            monthlyPayments.add(monthlyPayment(prospect));
        }
        
        return monthlyPayments;
    }
    
    public Double monthlyPayment(Prospect prospect) {
        
        double monthlyInterest = prospect.getInterest() / 100 / MONTHS;
        int amountOfPayments = prospect.getYears() * MONTHS;
        
        return prospect.getTotalLoan() *
                (monthlyInterest * powerOf((1 + monthlyInterest),amountOfPayments)) /
                (powerOf(1+monthlyInterest, amountOfPayments) - 1);
    }
    
    public Double powerOf(Double base, int exponent) {
        double result = base;
        if(exponent == 0) result = 0.0;
        
        for(int i = 1; i < exponent; i++) {
            result = result * base;
        }
        
        return result;
    }
    
}
