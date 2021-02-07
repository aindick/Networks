package P1RTT;
import java.net.*;
import java.io.*;
public class TCPServer {
    static final int port = 2740;

    public static void main(String[] args){
        //Establishing a new socket that connects to my port.
        try{
            ServerSocket socket = new ServerSocket(port);
            //setSoTimeout throws a SocketTimeout Exception when time is reached.
            socket.setSoTimeout(2000);
            Socket a;

            for(;;){
                try{
                    a = socket.accept();
                    System.out.println("Works on: " + port);
                    break;
                    //Catches if the socket times out.
                } catch (SocketTimeoutException e) {
                    e.printStackTrace();
                }

            }
            //Catch exception that will be thrown when something goes wrong and will exit the program
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

    }
}
