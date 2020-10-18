package lesson8HW;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.util.Set;

public class GameWindow extends JFrame {
    static final int WINDOW_X = 600;
    static final int WINDOW_Y = 300;
    static final int WINDOW_WIDTH = 505;
    static final int WINDOW_HEIGHT = 555;

    private SettingWindow settingWindow;
    private BattleField battleField;



    public GameWindow() {
        setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT); // Коорлинаты нахождения окна
        setTitle("TicTacToe"); // заголовок
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Закрывать окно при нажатии

        settingWindow = new SettingWindow(this); // передаем ссылку на Setting
        battleField = new BattleField(this);
        add(battleField, BorderLayout.CENTER);


        JPanel panel = new JPanel(new GridLayout(1,2)); // создаем панель с 2 кнопками
        JButton buttonStartGame = new JButton("Start new Game"); // создаем кнопку
        panel.add(buttonStartGame); // добавляем кнопку в панель
        buttonStartGame.addActionListener(e -> {
            settingWindow.setVisible(true); // при нажатии появляется окно

        });


        JButton buttonExit = new JButton("Exit");
        panel.add(buttonExit);
        buttonExit.addActionListener(e -> {   // при нажатии кнопки приложение закрывается
            System.exit(0);
        });

        add(panel, BorderLayout.SOUTH); // Добавление самой панели в окно в нижнюю часть



        setVisible(true);
    }

    public  void startNewGame(int gameMode, int fieldSize, int winningLength){
        battleField.startNewGame(gameMode, fieldSize, winningLength);
    }
}
