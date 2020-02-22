package view;

import java.text.DecimalFormat;
import java.util.List;
import model.Prospect;

public class MortgageView {
    
    public void PrintProspects(List<Prospect> prospects, List<Double> payments) {
        
        DecimalFormat format = new DecimalFormat("0.00");
        
        for(int i = 0; i < prospects.size(); i++) {
            String customer = prospects.get(i).getCustomer();
            double totalLoan = prospects.get(i).getTotalLoan();
            int years = prospects.get(i).getYears();
            double monthlyPayment = payments.get(i);
            
            System.out.println("Prospect " + (i+1) + ": " + customer + 
                    " wants to borrow " + totalLoan + " € for a period of "
                    + years + " years and pay " + format.format(monthlyPayment) 
                    + " € each month");
        }
    }
    
}
