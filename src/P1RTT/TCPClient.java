package P1RTT;
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class TCPClient {

        static final String host = "129.3.20.62";
        static final int port = 2740;

        public static void main(String[] args) {

            ArrayList<Long> averageOne = new ArrayList<>();
            ArrayList<Long> averageKB = new ArrayList<>();
            ArrayList<Long> averageSixtyFour = new ArrayList<>();

            try {
                Socket socket = new Socket(host, port);
                socket.setSoTimeout(2000);
                OutputStream ops = socket.getOutputStream();
                DataOutputStream dops = new DataOutputStream(ops);
                InputStream ins = socket.getInputStream();
                DataInputStream di = new DataInputStream(ins);

                for (int k = 0; k < 200; k++) {

                    byte byt[] = new byte[1];
                    averageOne.add(getTime(byt, di, dops));
                    byt = new byte[1024];
                    averageKB.add(getTime(byt, di, dops));
                    byt = new byte[64];
                    averageSixtyFour.add(getTime(byt, di, dops));

                    System.out.println(k + 1);
                }

                dops.close();
                di.close();
                ops.close();
                ins.close();
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println( average(averageOne));
            System.out.println( average(averageKB));
            System.out.println( average(averageSixtyFour));
        }

        private static long getTime(byte[] byt,DataInputStream di, DataOutputStream dops) {

            try {
                for (int i = 0; i < byt.length; i++) {
                    byt[i] = (byte) i;
                }
                long elapse;
                long tO; //Time Out

                tO = System.nanoTime();
                dops.writeInt(byt.length);
                dops.write(byt);
                di.readFully(byt);
                elapse = System.nanoTime() - tO;
                return elapse;
            } catch (SocketTimeoutException ex) {
                System.err.println("Timeout On: " + byt.length );
                return 0;
            } catch (IOException ex) {
                System.err.println(ex);
                return 0;
            }
        }

        private static double average(ArrayList<Long> values) {
            int r = values.size();
            double s = 0;
            for (Long v : values) {
                if(v != 0) {
                    s += (v / 1000000);
                }
            }
            s /= r;
            return s;
        }
    }

