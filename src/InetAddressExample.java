import java.net.*;

public class InetAddressExample {
    public static void main(String[] args) throws Exception {
        InetAddress local = InetAddress.getLocalHost();
        System.out.println("Local Host: " + local);
        System.out.println("Local HostAddress: " + local.getHostAddress());
        System.out.println("Local HostName: " + local.getHostName());

        InetAddress google = InetAddress.getByName("www.naver.com");
        System.out.println("NAVER IP: " + google);

        InetAddress[] addresses = InetAddress.getAllByName("www.naver.com");
        for (InetAddress addr : addresses) {
            System.out.println("NAVER Address: " + addr);
        }
    }
}
