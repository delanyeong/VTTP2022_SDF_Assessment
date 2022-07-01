package vttp2022.task01;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EmailMerger {
    
    private Map<String, List<List<String>>> dataSet = new HashMap<>(); 

    
    public void read(String data) {
    if ((null == data) || (data.trim().length() <= 0))
            return;

    String[] fields = data.split(",");
    String firstName = fields[0];
    String lastName = fields[1];
    String address = fields[2];
    String years = fields[3];

    addToReport(firstName, lastName, address, years);

    }

    private void addToReport(String firstName, String lastName, String address, String years) {
        if (!dataSet.containsKey(firstName)) {
            dataSet.put(firstName, mkEntry());
        }
        List<List<String>> entry = dataSet.get(firstName);
        entry.get(0).add(lastName);
        entry.get(1).add(address);
        entry.get(2).add(years);
    }

    private List<List<String>> mkEntry() {
        List<List<String>> catList = new LinkedList<>();
        // 0 - lastName, 1 - address, 2 -year
        for (int i = 0; i < 3; i++)
            catList.add(new LinkedList<String>());
        return catList;
    }

}
