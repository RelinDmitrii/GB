package lesson7HW_2course.Client;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public TextArea textArea;
    @FXML
    public TextField textField;

    private final String IP_ADDRESS = "localhost";
    private final int PORT = 8146;

    private Socket socket;
    DataInputStream in;
    DataOutput out;

    @FXML
    public HBox authPanel;
    @FXML
    public TextField loginField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public HBox msgPanel;

    private boolean authenticated;
    private String nickName;
    private final String TITLE = "ГикЧат";


    public void setAuthenticated(boolean authenticated){
        this.authenticated = authenticated;
        authPanel.setVisible(!authenticated);
        authPanel.setManaged(!authenticated);
        msgPanel.setVisible(authenticated);
        msgPanel.setManaged(authenticated);
        if(!authenticated){
            nickName = "";
        }
        setTitle(nickName);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setAuthenticated(false);
    }


    private void connection () {
        try {
            socket = new Socket(IP_ADDRESS,PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // ЦИКЛ АУТЕНТИФИКАЦИИ
                        while (true){
                            String str = in.readUTF();
                            if (str.startsWith("/authok")){
                                nickName= str.split("\\s", 2)[1];
                                setAuthenticated(true);
                                break;
                            }
                            textArea.appendText(str + "\n");
                        }
                        //ЦИКЛ РАБОТЫ
                        while (true) {
                            String str = null;
                            str = in.readUTF();

                            if (str.equals("/end")) {
                                System.out.println("Клиент отключился");
                                break;
                            }

                            System.out.println("Клиент: " + str);
                            textArea.appendText(str);
                        }
                    } catch(IOException e){
                        e.printStackTrace();
                    } finally{
                        System.out.println("МЫ отключились от сервера");
                        setAuthenticated(false);
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void sendMsg(ActionEvent actionEvent) {
        try {
            out.writeUTF(textField.getText());
            textField.clear();
            textField.requestFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void tryToAuth(ActionEvent actionEvent) {
        if(socket==null || socket.isClosed()){
            connection();
        }
        try {
            out.writeUTF(String.format("/auth %s %s", loginField.getText().trim().toLowerCase(),
            passwordField.getText().trim()));
            passwordField.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void setTitle(String nick){
        Platform.runLater(()-> {
            ((Stage)textField.getScene().getWindow()).setTitle(TITLE+" "+nick);
                });
    }
}
