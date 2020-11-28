package lesson8HW_2course.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;


public class Server {

    private static int PORT = 8146;
    ServerSocket server = null;
    Socket socket = null;
    List<ClientHandler> clients;
    private AuthService authService;

    public Server(){
        clients = new Vector<>();
        authService = new SimpleAuthService();
        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен");

            while(true) {
                socket = server.accept();
                System.out.println("Клиент подключился");
                new ClientHandler(this, socket);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    void broadCastMsg (ClientHandler sender, String msg){
            String message = String.format("%s : %s", sender.getNickName(), msg);
            if(msg.startsWith("/w")){
                for (ClientHandler client : clients) {
                if(client.getNickName().equals(sender.getNickName()) || client.getNickName().equals(msg.split(" ")[1])){
                    message = String.format("%s : %s", sender.getNickName(), msg.split(" ",3)[2]);
                    client.sendMsg(message + "\n");
                }
                }
            } else {
                for (ClientHandler client : clients) {
                    client.sendMsg(message + "\n");
                }
            }
        }


    public void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
    }



    public void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    public AuthService getAuthService(){
        return authService;
    }
}

