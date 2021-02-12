package P1RTT;
import java.net.*;
import java.io.*;
public class TCPServer {
    static final int port = 2740;

    public static void main(String[] args) throws IOException {

        OutputStream outStream;
        DataInputStream inputStream;
        PrintWriter pW = null;
        BufferedReader bR = null;
        Socket client = null;

        try {

            ServerSocket socket = new ServerSocket(port);
            client = socket.accept();

            pW = new PrintWriter(client.getOutputStream(), true);
            bR = new BufferedReader(new InputStreamReader(client.getInputStream()));

            inputStream = new DataInputStream(new BufferedInputStream(client.getInputStream()));
            outStream = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));

            byte[] bytOne = new byte[1];
            byte[] bytTen = new byte[1000];
            byte[] bytSixteen = new byte[16000];
            byte[] bytSixtyFour = new byte[64000];
            byte[] bytTwoFiftySixT = new byte[256000];
            byte[] bytOneMil = new byte[1000000];
            byte[] bytOneTTwoFour = new byte[1024];
            byte[] bytFiveOneTwo = new byte[512];
            byte[] bytTwoFiveSix = new byte[256];


            inputStream.read(bytOne, 0, 1);
            outStream.write(bytOne);


            inputStream.read(bytTen);
            inputStream.read(bytSixteen);
            inputStream.read(bytSixtyFour);
            inputStream.read(bytTwoFiftySixT);
            inputStream.read(bytOneMil);


            int r = 0;
            while ((r = inputStream.read(bytTwoFiveSix, 0, 256)) == 256) {
                client.setSoTimeout(200);
            }
            outStream.write(bytOne);

            while ((r = inputStream.read(bytFiveOneTwo, 0, 512)) == 512) {
                client.setSoTimeout(200);
            }

            outStream.write(bytOne);

            while ((r = inputStream.read(bytOneTTwoFour, 0, 1024)) == 1024) {
                client.setSoTimeout(300);
            }

            outStream.write(bytOne);


        } catch (IOException e) {
            e.printStackTrace();

            System.exit(-1);
        }
        bR.close();

        try {

            pW.close();
            client.close();

        } catch (IOException e) {
            e.printStackTrace();

            System.exit(-1);
        }
    }
}
