package message;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(3002);
            Socket s = serverSocket.accept();

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String usr, cl;

            while (true){
                usr = reader.readLine();
                dos.writeUTF(usr);
                cl = dis.readUTF();

                System.out.println(cl);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
