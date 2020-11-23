package lesson6HW_2course;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static int PORT = 8187;
    ServerSocket server = null;
    Socket ClientSocket = null;
    ClientHandler client;


    public Server() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен");
            ClientSocket = server.accept();
            System.out.println("Клиент подключился");
            client = new ClientHandler(this, ClientSocket);
            while(true) {
                String serverTxt = reader.readLine();
                client.sendMsg(serverTxt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        }


}
