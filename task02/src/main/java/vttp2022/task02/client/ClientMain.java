package vttp2022.task02.client;

import java.io.Console;
import java.io.IOException;
import java.math.RoundingMode;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;


public class ClientMain {
    public static void main( String[] args ) throws UnknownHostException, IOException
    {
        try {

            //Connect to the server
            //1.Create socket
            Socket sock = new Socket("68.183.239.26", 80);

            // 1b. Connected
            System.out.println("Connected ...");

            //2. Input/Output Streams
            NetworkIO netIO = new NetworkIO(sock);
            
            //Before WHILE Loop
            // String req = "";
            boolean req = false;
            String resp = "";   //first case: set neutral value
            Console cons = System.console();

            //WHILE Loop - you want to read, write, exit
            // while (!req.equals("exit")) {
            while (!req) {

                // req = cons.readLine("> "); //scan.nextLine();

                // //exit
                // if (req.trim().equals("exit"))
                // break; //break out of the closest loop
                
                // //write - have to Write FIRST!!!
                // netIO.write(req);
                
                //read
                System.out.println("reached");
                resp = netIO.read();

                //readBoolean() method
                if ((Boolean.parseBoolean(resp)) == true) {
                    System.out.println("SUCCESS");
                    break;
                }

                String[] getId = resp.split( "[\\s,]+");
                String id = getId[0];
                System.out.println(id);
                System.out.printf(">> %s\n", resp);

                //Create new resp handler
                ClientResp client = new ClientResp(resp);

                //resp handler - convert string[] to List<Flaot>
                List<Float> al = client.stringToIntArray();
                for(Float s: al){
                    System.out.println(s);
                }

                //resp handler - calculate the avg from List<Float>
                float answer = client.avgInt(al);
                System.out.println("this is the answer: " + answer);

                //write back
                System.out.println("writing1");
                netIO.write(id);
                System.out.println("writing2");
                netIO.write("Yeong Jia Jun Delan");
                System.out.println("writing3");
                netIO.write("delan.april@gmail.com");
                System.out.println("writing4");
                DecimalFormat hisFormat = new DecimalFormat("######.#");
                hisFormat.setRoundingMode(RoundingMode.DOWN);
                System.out.println(hisFormat.format(answer));
                netIO.write1(answer);

                // System.out.println(Arrays.toString(intArrayResp));

            }

            //After WHILE Loop
            netIO.close();
            sock.close();

            System.out.println("Terminating client ...");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
