package P1RTT;
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class TCPClient {
    static final int port = 2740;
    static final String host = "129.3.149.47";

    public static void main(String[] args){
        ArrayList<Long> averageKB = new ArrayList<>();
        try{
            Socket socket = new Socket(host, port);
            socket.setSoTimeout(2000);

            InputStream ins = socket.getInputStream();
            OutputStream ops = socket.getOutputStream();
            DataInputStream di = new DataInputStream(ins);
            DataOutputStream dops = new DataOutputStream(ops);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
