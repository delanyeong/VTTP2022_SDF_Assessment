package vttp2022.task02.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.lang.*;

public class ClientResp {
    
    //fields
    private String initresp;
   



    //constructor
    public ClientResp (String initresp) {
        this.initresp = initresp;
    }





    //Methods - Getters | Setters
    //-

    //Methods - Functions
    //1. Convert String to ArrayList<Float> and remove first item
    public List<Float> stringToIntArray () {
        String[] intArray = this.initresp.split( "[\\s,]+");
        // List<String> al = new ArrayList<String>();
	    // al = Arrays.asList(intArray);
        
        List<String> al = new ArrayList<String>();
        Collections.addAll(al, intArray);
        al.remove(0);

        List<Float> floatList = new ArrayList<>();

        for (int i = 0; i < al.size(); i++)
        {
            Float number = Float.valueOf(al.get(i));
            floatList.add(number);
        }

        return floatList;
    }


    public float avgInt (List<Float> floatList){
        Float avg = 0f;
    if (!floatList.isEmpty() && floatList.size() > 1) {
        for (int i = 1; i < floatList.size(); i++) {
            avg+= floatList.get(i);
        }
        avg = avg / floatList.size();
    }
    return avg;
        
    }






}
