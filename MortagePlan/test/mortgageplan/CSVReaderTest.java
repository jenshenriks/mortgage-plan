package mortgageplan;

import model.CSVReader;
import model.Prospect;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class CSVReaderTest {
    
    private CSVReader csv;
    
    public CSVReaderTest() {
        
    }
    
    @Before
    public void setUp() {
        csv = new CSVReader(1,4);
    }
    
    @Test
    public void parseEmptyDataShouldReturnNull() {
        Prospect prospect = csv.parseProspectData("");
        assertEquals(null, prospect);
    }
    
    @Test
    public void parseValidDataShouldReturnProspectObject() {
        Prospect prospect = csv.parseProspectData("Juha,1000,5,2");
        assertEquals("Juha", prospect.getCustomer());
    }
    
    @Test
    public void parseTooFewFieldsShouldReturnNull() {
        Prospect prospect = csv.parseProspectData("Juha,1000,5");
        assertEquals(null, prospect);
    }
    
    @Test
    public void parseTooManyValidFieldsShouldReturnProspectObject() {
        Prospect p = csv.parseProspectData("\"Clarencé,Andersson\",2000,6,4");
        assertEquals("Clarencé Andersson", p.getCustomer());
    }
}
