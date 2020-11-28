package lesson8HW_2course.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {

    Server server = null;
    Socket socket = null;
    DataInputStream in;
    DataOutputStream out;
    private String nickName;

    public ClientHandler(Server server, Socket socket) {
        try{
        this.server = server;
        this.socket = socket;
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        new Thread(() -> {
                try {
                    // ЦИКЛ АУТЕНТИФИКАЦИИ (ПОЛЬЗОВАТЕЛЬ ИМЕЕТ НЕСКОЛЬКО ПОПЫТОК)
                    while (true){
                        String str = in.readUTF();
                        if (str.startsWith("/auth")){
                        String [] token = str.split("\\s");
                        String newNick = server.getAuthService().getNicknameByLoginAndPassword(token[1],token[2]);

                            if(newNick!=null){
                                nickName = newNick;
                                sendMsg("/authok " + nickName);
                                server.subscribe(this);
                                System.out.println("Клиент "+ nickName+ " подключился.");
                                break;
                            } else {
                                sendMsg("Неверный Логин / Пароль");
                            }
                        }
                    }
                    // ЦИКЛ РАБОТЫ
                    while (true) {
                        String str = in.readUTF();

                        if (str.equals("/end")){
                            out.writeUTF("/end");
                            break;
                        }
                        server.broadCastMsg(this,str);
                    }
                } catch (IOException e){
                        e.printStackTrace();
                    } finally {
                    System.out.println("Клиент отключился");
                    server.unsubscribe(this);
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        }).start();
    } catch (IOException e) {
            e.printStackTrace();
        }
    }


    void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNickName(){
        return nickName;
    }
}
