package P1RTT;
import java.net.*;
import java.io.*;


public class TCPClient {

        static String host = "129.3.20.62";
        static final int port = 2740;

   public static void main(String[]args) throws IOException {
       OutputStream outputStream = null;
       DataInputStream inputStream = null;

       Socket socket = null;
       //s stands for start and f stands for finish
       long s = 0;
       long f = 0;

       byte[] bytOne = new byte[1];
       byte[] bytSixtyFour = new byte[64];
       byte[] bytTen = new byte[1000];
       byte[] bytSixteen = new byte[16000];
       byte[] bytSixtyFourT = new byte[64000];
       byte[] bytTwoFiftySixT = new byte[256000];
       byte[] bytOneMil = new byte[1000000];
       byte[] bytOneTTwoFour = new byte[1024];
       byte[] bytFiveOneTwo = new byte[512];
       byte[] bytTwoFiveSix = new byte[256];
    try {

       socket = new Socket(host,port);

        inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        outputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

    } catch (IOException e) {
        e.printStackTrace();
    }
    try{
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        //Request 1
        s = System.nanoTime();
        outputStream.write(bytOne);
        inputStream.read(bytOne, 0, 1);
        f = System.nanoTime() - s;
        System.out.println("RTT: " + f);

        //Request 2
        s = System.nanoTime();
        outputStream.write(bytOne);
        inputStream.read(bytSixtyFour, 0, 1);
        f = System.nanoTime() - s;
        System.out.println("RTT: " + f);

        //Request 3
        s = System.nanoTime();
        outputStream.write(bytOne);
        inputStream.read(bytOneTTwoFour, 0, 1);
        f = System.nanoTime() - s;
        System.out.println("RTT: " + f);

        //Throughput of 1k
        s = System.nanoTime();
        outputStream.write(bytTen);
        outputStream.flush();
        f = System.nanoTime() - s;
        System.out.println("1k message: " + f);

        //Throughput of 16k
        s = System.nanoTime();
        outputStream.write(bytSixteen);
        outputStream.flush();
        f = System.nanoTime() - s;
        System.out.println("16k message: " + f);

        //Throughput of 64k
        s = System.nanoTime();
        outputStream.write(bytSixtyFourT);
        outputStream.flush();
        f = System.nanoTime() - s;
        System.out.println("64k message: " + f);

        //Throughput of 256k
        s = System.nanoTime();
        outputStream.write(bytTwoFiftySixT);
        outputStream.flush();
        f = System.nanoTime() - s;
        System.out.println("256k message: " + f);

        //Throughput of 1M
        s = System.nanoTime();
        outputStream.write(bytOneMil);
        outputStream.flush();
        f = System.nanoTime() - s;
        System.out.println("RTT of 1M message: " + f);

        //1024 byte messages
        s = System.nanoTime();
        for (int i = 0; i < 1024; i++){
            outputStream.write(bytOneTTwoFour);
        }
        outputStream.write(bytOne);
        inputStream.read(bytOne);
        f = System.nanoTime() - s;
        System.out.println("1024 byte messages: " + f);

        //512 byte messages
        s = System.nanoTime();
        for (int i = 0; i < 2048; i++){
            outputStream.write(bytFiveOneTwo);
        }
        outputStream.write(bytOne);
        inputStream.read(bytOne);
        f = System.nanoTime() - s;
        System.out.println("512 byte messages: " + f);

        //256 byte messages
        s = System.nanoTime();
        for (int i = 0; i < 4096; i++){
            outputStream.write(bytTwoFiveSix);
        }
        outputStream.write(bytOne);
        inputStream.read(bytOne);
        f = System.nanoTime() - s;
        System.out.println("256 byte messages: " + f);


        //Closing port and scanners
        stdin.close();

        outputStream.close();
        inputStream.close();

        socket.close();




    } catch (Exception e) {
        e.printStackTrace();
    }
   }}
