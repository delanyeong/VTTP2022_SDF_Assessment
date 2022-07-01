package vttp2022.task01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EmailMerger {
    
    private Map<String, ArrayList<String>> dataSet = new HashMap<>(); 



    
    public void read(String data) {
    if ((null == data) || (data.trim().length() <= 0))
            return;

    String[] fields = data.split(",");
    String firstName = fields[0];
    String lastName = fields[1];
    String address = fields[2];
    String years = fields[3];

    addToTable(firstName, lastName, address, years);

    }

    public void generateTable() {
        for (String firstName: dataSet.keySet()) {
            ArrayList<String> entry = dataSet.get(firstName);
            String lastName1 = entry.get(0);
            String address1 = entry.get(1);
            String years1 = entry.get(2);
            System.out.printf("First Name: %s\n", firstName);
            System.out.printf("\tMath: %.3f\n", lastName1);
            System.out.printf("\tReading: %.3f\n", address1);
            System.out.printf("\tWriting: %.3f\n\n", years1);
        }
    }

    private void addToTable(String firstName, String lastName, String address, String years) {
        if (!dataSet.containsKey(firstName)) {
            dataSet.put(firstName, mkEntry());
        }
        ArrayList<String> entry = dataSet.get(firstName);
        entry.add(0, lastName);
        entry.add(1, address);
        entry.add(2, years);
    }

    private ArrayList<String> mkEntry() {
        ArrayList<String> catList = new ArrayList<>();
        return catList;
    }

}
