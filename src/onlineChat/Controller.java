package onlineChat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;

public class Controller {
    @FXML
    public javafx.scene.control.TextArea taChatBoard;
    @FXML
    public javafx.scene.control.TextField tfChatLine;

    public void onClickBtn(ActionEvent actionEvent) {
        taChatBoard.appendText(tfChatLine.getText() + "\n");
        tfChatLine.clear();
    }

    public void presEnter(KeyEvent keyEvent) {
        if(keyEvent.getText().contains("\r")){
            taChatBoard.appendText(tfChatLine.getText() + "\n");
            tfChatLine.clear();

        }
    }
}
