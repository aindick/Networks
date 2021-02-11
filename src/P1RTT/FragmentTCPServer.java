package P1RTT;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class FragmentTCPServer {
    static final int port = 2740;

    public static void main(String[] args){
        Socket client;
        //Establishing a new socket that connects to my port.
        try {
            ServerSocket socket = new ServerSocket(port);
            //setSoTimeout throws a SocketTimeout Exception when time is reached.
            socket.setSoTimeout(2000);

            for (; ; ) {
                try {
                    client = socket.accept();
                    System.out.println("Works on: " + port);
                    break;
                    //Catches if the socket times out.
                } catch (SocketTimeoutException e) {
                    e.printStackTrace();
                }

            }
            //This is for reading primitive Java data types(Data) and writing data (Output). Input = reading bytes.
            OutputStream ops = client.getOutputStream();
            DataOutputStream dops = new DataOutputStream(ops);

            InputStream ins = client.getInputStream();
            DataInputStream di = new DataInputStream(ins);
            int size = 0;
            for (;; ) {
                try {
                    int messages = di.readInt();
                    for(int k = 0; k < messages; k++){
                        size = di.readInt();
                        byte[] byt = new byte[size];
                        di.readFully(byt);
                    }

                } catch (EOFException e) {
                    System.out.println("Done on Port: " + port);
                    break;

                }
                dops.writeChar('a');
                System.out.println("Received:" + (size/1024));
            }
            //Closing up the scanner
            ops.close();
            ins.close();
            di.close();
            client.close();
            socket.close();



            //Catch exception that will be thrown when something goes wrong and will exit the program.
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

    }
}
