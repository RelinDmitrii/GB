package lesson6HW_2course;

import javafx.event.ActionEvent;

import java.io.*;
import java.net.Socket;

public class Client {


    private static final String IP_ADDRESS = "localhost";
    private static final int PORT = 8187;

    private static Socket socket;
    static DataInputStream in;
    static DataOutput out;

    public static void main(String[] args) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        try {
            socket = new Socket(IP_ADDRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());



            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = null;
                            str = in.readUTF();

                            if (str.equals("/end")) {
                                System.out.println("Клиент отключился");
                                break;
                            }

                            System.out.println("Server: " + str);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("МЫ отключились от сервера");
                        try {
                            socket.close();
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }).start();

            while(true){
                String consoleTxt = reader.readLine();
                sendMsg(consoleTxt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public static void sendMsg(String txt) {
            try {
                out.writeUTF(txt);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
