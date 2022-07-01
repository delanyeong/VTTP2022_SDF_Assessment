package vttp2022.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.io.IOException;

public class Main 
{
    public static void main( String[] args ) throws IOException
    {
        // String templateFile = args[1];

        String csvFile = args[0];

        //Create the emailMerger object

        //readFile
        Reader r = new FileReader(csvFile);
        BufferedReader br = new BufferedReader(r);

        //Store the reading into variable 'data';

        //Remove the first line - the data category
        String data = br.readLine();

        while (null != data) {
            data = br.readLine();
            System.out.println(data);
        }

        br.close();
    }
}
