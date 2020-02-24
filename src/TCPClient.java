import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        String serverName = "localhost";
        int port = 2306;

        try {
            System.out.println("Connecting to " + serverName
                    + " on port "+ port);

            Socket client = new Socket(serverName, port);
            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            out.writeUTF("Hello, I am " + client.getLocalSocketAddress());
            //read InputStream from server
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            //read server message
            System.out.println("Server says " + in.readUTF());

            DataInputStream inputMessage = new DataInputStream(client.getInputStream());
            String msg = inputMessage.readUTF();
            System.out.println(msg);
            client.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
