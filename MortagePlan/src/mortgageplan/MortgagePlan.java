package mortgageplan;

import model.CSVReader;
import model.MortgageCalculator;
import model.Prospect;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.MortgageView;

public class MortgagePlan {
    
    private static final String PROSPECTS_PATH = "data/prospects.txt";

    public static void main(String[] args) {
        
        CSVReader csvReader = new CSVReader(1, 4);
        List<Prospect> prospects = null;
        
        try {
            prospects = csvReader.parse(csvReader.read(Paths.get(PROSPECTS_PATH)));
        } catch (IOException ex) {
            Logger.getLogger(MortgagePlan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        MortgageCalculator calculator = new MortgageCalculator();
        List<Double> payments = calculator.monthlyPayment(prospects);
        
        MortgageView view = new MortgageView();
        view.PrintProspects(prospects, payments);
    }
    
}
