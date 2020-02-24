package message;

import java.io.*;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1",3002);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String usr, cl;

            while (true){
                cl = dis.readUTF();
                System.out.println(cl);
                usr = reader.readLine();
                dos.writeUTF(usr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
