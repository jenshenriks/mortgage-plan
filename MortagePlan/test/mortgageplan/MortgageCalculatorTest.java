package mortgageplan;

import model.MortgageCalculator;
import model.Prospect;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MortgageCalculatorTest {
    
    private MortgageCalculator calculator;
    
    @Before
    public void setUp() {
        calculator = new MortgageCalculator();
    }
    
    @Test
    public void powerOfZeroShouldReturnZero() {
        Double result = calculator.powerOf(5.0, 0);
        assertEquals(0.0, result,0.1);
    }
    
    @Test
    public void powerOf3OnBase3ShouldReturn27() {
        Double result = calculator.powerOf(3.0, 3);
        assertEquals(27.0, result, 0.1);
    }
    
    @Test
    public void powerOf5OnBase7ShouldReturn78125() {
        Double result = calculator.powerOf(5.0, 7);
        assertEquals(78125.0, result, 0.1);
    }
    
    @Test
    public void monthlyPaymentTest() {
        Prospect prospect = new Prospect("Donald Duck", 1500.0, 8.5, 5);
        double monthlyPayment = calculator.monthlyPayment(prospect);
        System.out.println("Monthly payment: " + monthlyPayment);
        assertEquals(30.77, monthlyPayment, 0.1);
    }
}
