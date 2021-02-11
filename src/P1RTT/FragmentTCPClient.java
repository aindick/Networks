package P1RTT;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

public class FragmentTCPClient {
    static final String host = "129.3.20.62";
    static final int port = 2740;

    static final int kB = 1024;
    static final int mB = kB * 1024;

    public static void main(String[] args){
        ArrayList<Long> averageOne = new ArrayList<>();
        ArrayList<Long> averageTwo = new ArrayList<>();
        ArrayList<Long> averageFour = new ArrayList<>();
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
