import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        String myIp = new MyIp().getLocalIp();
        ServerSocket serverSocket = new ServerSocket(51234);
        System.out.println("Server is running on " + myIp + ":51234 ....");

        Socket socket = serverSocket.accept();

        System.out.println("Accepted connection from " + socket.getInetAddress());
        System.out.println("=======================");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String input = "";
        Scanner sc = new Scanner(System.in);
        String clientMessage = in.readLine();
        System.out.println("Client: " + clientMessage);

        while (true) {
            if (input.equals("exit") || (clientMessage != null && clientMessage.equals("exit"))) {
                break;
            } else {
                System.out.print("입력: ");
                input = sc.nextLine();
                out.println(input);
                clientMessage = in.readLine();
                System.out.println("Client: " + clientMessage);
            }
        }

        socket.close();
        serverSocket.close();
    }
}