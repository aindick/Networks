package P1RTT;
import java.net.*;
import java.io.*;


public class TCPClient {

        static final String host = "129.3.20.62";
        static final int port = 2740;

   public static void main(String[]args) throws IOException {
       OutputStream outStream = null;
       DataInputStream inputStream = null;
       PrintWriter pW = null;
       BufferedReader bR = null;
       Socket socket = null;
       //s stands for start and f stands for finish
       long s = 0;
       long f = 0;

       byte[] bytOne = new byte[1];
       byte[] bytTen = new byte[1000];
       byte[] bytSixteen = new byte[16000];
       byte[] bytSixtyFour = new byte[64000];
       byte[] bytTwoFiftySixT = new byte[256000];
       byte[] bytOneMil = new byte[1000000];
       byte[] bytOneTTwoFour = new byte[1024];
       byte[] bytFiveOneTwo = new byte[512];
       byte[] bytTwoFiveSix = new byte[256];
    try {

       socket = new Socket(host,port);


        pW = new PrintWriter(socket.getOutputStream(), true);
        bR = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        outStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

    } catch (IOException e) {
        e.printStackTrace();
    }
    try{
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        //Request 1
        s = System.nanoTime();
        outStream.write(bytOne);
        inputStream.read(bytOne, 0, 1);
        f = System.nanoTime() - s;
        System.out.println("RTT: " + f);


    } catch (Exception e) {
        e.printStackTrace();
    }
   }}
