import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerTCP {
    public static void main(String[] args) {
        // TODO code application logic here
        ServerSocket serverSocket;
        int port = 3300;
        int timeOut = 60000;
        try {
            serverSocket = new ServerSocket(port);
            //set server timeoutserver
            serverSocket.setSoTimeout(timeOut);

            System.out.println("Waiting for client on port ");
            Socket server = serverSocket.accept();
            //getting Input Stream
            System.out.println("Connected to client " + server.getRemoteSocketAddress());
            //get client Socket Address
            DataInputStream in = new DataInputStream(server.getInputStream());
             //write client message
            System.out.println("Client says " + in.readUTF());
            //getting output stream
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress()
                    //get server socket Address and send to client
                    + "\nStart the message");

                String strInput = null;
                System.out.println("Enter your message: ");
                Scanner scanner = new Scanner(System.in);
                strInput = scanner.nextLine();
                DataOutputStream outMessage = new DataOutputStream(server.getOutputStream());
                outMessage.writeUTF(strInput);

            server.close();
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }
}
