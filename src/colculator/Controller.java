package colculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Controller {

    @FXML
    private TextArea outputTA;
    private long num1 = 0; // переменные чисел
    private long num2 = 0;

    private boolean startOperation = false; //отвечает за новое действие
    private String operator = "";
    private Calculator calculator = new Calculator();





    public void number(javafx.event.ActionEvent actionEvent) { // метод для цифр
        String value = ((Button)actionEvent.getSource()).getText();
        if(!startOperation){
            outputTA.setText(outputTA.getText()+value); }
        else {
            outputTA.setText("");
            outputTA.setText(value);
            startOperation = false;
        }
    }

    public void operator(javafx.event.ActionEvent actionEvent) { // метод для логических кнопок
        if(((Button)actionEvent.getSource()).getText().equals("=")){
            num2 = Long.parseLong(outputTA.getText());
            outputTA.setText(String.valueOf((calculator.colculation(num1, num2, operator))));
        }
        else if(((Button)actionEvent.getSource()).getText().equals("C")){
            outputTA.setText("");
            num1 = 0;
            num2 = 0;
            operator = "";

        }
        else {
            operator = ((Button) actionEvent.getSource()).getText();
            num1 = Long.parseLong(outputTA.getText());
            startOperation = true;
        }



    }
}
