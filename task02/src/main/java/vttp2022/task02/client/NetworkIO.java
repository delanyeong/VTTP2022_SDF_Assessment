package vttp2022.task02.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class NetworkIO {

    //Fields
    private InputStream is;
    private OutputStream os;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    
    //Constructor
    public NetworkIO (Socket sock) throws IOException {
        os = sock.getOutputStream();

        oos = new ObjectOutputStream(os);
        
        is = sock.getInputStream();
        
        ois = new ObjectInputStream(is);
    }

    //Methods
    //Methods - Getters and Setters

    //Methods - Actions
    public String read () throws IOException{
        return ois.readUTF();
    }

    public void write (String msg) throws IOException{
        oos.writeUTF(msg);
        oos.flush();
    }

    public void close () throws IOException{
        try {
            ois.close();
            is.close();
            oos.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
