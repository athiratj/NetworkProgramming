import java.net.*;
import java.io.*;
import java.util.*;

public class Server {

    public static void main(String[] args) throws Exception {

        DatagramSocket ss = new DatagramSocket(1234);

        while (true) {

            System.out.println("Server is up....");

            byte[] rd = new byte[100];
            byte[] sd = new byte[100];

            DatagramPacket rp = new DatagramPacket(rd, rd.length);

            ss.receive(rp);

            InetAddress ip = rp.getAddress();

            int port = rp.getPort();

            Date d = new Date(); // getting system time

            String time = d + ""; // converting it to String

            sd = time.getBytes(); // converting that String to byte

            DatagramPacket sp = new DatagramPacket(sd, sd.length, ip, port);

            ss.send(sp);

            rp = null;

            System.out.println("Done !! ");

        }

    }

}