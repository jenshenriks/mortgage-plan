package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {
    
    private int fields;
    private int startCol;
    
    public CSVReader(int startCol, int fields) {
        this.fields = fields;
        this.startCol = startCol;
    }
    
    public List<String> read(Path path) throws IOException {
        List<String> Prospects = Files.readAllLines(path);
        return Prospects;
    }
    
    public List<Prospect> parse(List<String> prospectsData) {
        List<Prospect> prospects = new ArrayList<>();
        
        for(int i = 1; i < prospectsData.size(); i++) {
            Prospect prospect = parseProspectData(prospectsData.get(i));
            if(prospect != null) prospects.add(prospect);
        }
        
        return prospects;
    }
    
    // Assumes that only the field/column for customer name is within quotes
    public Prospect parseProspectData(String prospectData) {
        String[] split = prospectData.split(",");
        List<String> data = new ArrayList<>(Arrays.asList(split));
        
        if(data.isEmpty()) return null;
        else if(data.size() < fields) return null;
        else if(data.size() > fields) {
            StringBuilder builder = new StringBuilder();
            builder.append(data.get(0).replace("\"", "")).append(" ")
                    .append(data.get(1).replace("\"", ""));
            
            data.remove(0);
            data.remove(0);
            data.add(0, builder.toString());
        }
        
        String customer = data.get(0);
        double totalLoan = Double.parseDouble(data.get(1));
        double interest = Double.parseDouble(data.get(2));
        int years = Integer.parseInt(data.get(3));
        
        return new Prospect(customer, totalLoan, interest, years);
    }
}
