package vttp2022.task02.client;

import java.io.Console;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class ClientMain {
    public static void main( String[] args ) throws UnknownHostException, IOException
    {
        try {

            //Connect to the server
            //1.Create socket
            Socket sock = new Socket("task02.chuklee.com", 80);

            // 1b. Connected
            System.out.println("Connected ...");

            //2. Input/Output Streams
            NetworkIO netIO = new NetworkIO(sock);
            
            // //Before WHILE Loop
            // String req = "";
            // String resp = "";   //first case: set neutral value
            // Console cons = System.console();

            // //WHILE Loop - you want to read, write, exit
            // while (!req.equals("exit")) {
            //     req = cons.readLine("> "); //scan.nextLine();

            //     //exit
            //     if (req.trim().equals("exit"))
            //     break; //break out of the closest loop
                
            //     //write - have to Write FIRST!!!
            //     netIO.write(req);
                
            //     //read
            //     resp = netIO.read();
            //     System.out.printf(">> %s\n", resp);
                

                
            // }

            // //After WHILE Loop
            // netIO.close();
            // sock.close();

            // System.out.println("Terminating client ...");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
