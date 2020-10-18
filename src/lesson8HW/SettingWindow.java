package lesson8HW;

import javax.swing.*;
import java.awt.*;

public class SettingWindow extends JFrame {
    static final int WINDOW_X = GameWindow.WINDOW_X+50; // обращаемся к константам GameWindow
    static final int WINDOW_Y = GameWindow.WINDOW_Y+50;
    static final int WINDOW_WIDTH = GameWindow.WINDOW_WIDTH-100;
    static final int WINDOW_HEIGHT = 450;

    public static final int GAME_MODE_H_VS_AI = 0;
    public static final int GAME_MODE_H_VS_H = 1;


    private final int MIN_FIELD_SIZE = 3;
    private final int MAX_FIELD_SIZE = 10;

    private GameWindow gameWindow;

    private JRadioButton jrbHvsAi;
    private JRadioButton jrbHvsH;
    private ButtonGroup buttonGroupGameMode; // группа кнопок для связки компанентов

    private JSlider slFieldSize; // Слайдеры (шкала с ходунком)
    private JSlider slWinningLength;

    public SettingWindow(GameWindow gameWindow) { // передаем ссылку на GameWindow
        this.gameWindow = gameWindow;
        setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT); // Коорлинаты нахождения окна
        setTitle("Setting game"); // заголовок

        setLayout(new GridLayout(8,1)); // расположение сверху вниз из 8 строчек и 1 столбца

        add(new JLabel("Choose game mod:"));

        jrbHvsAi = new JRadioButton("H vs A",true); // инициализация поля (Сразу выбран этот режим)
        jrbHvsH =new JRadioButton("H vs H");
        add(jrbHvsAi);
        add(jrbHvsH);
        buttonGroupGameMode = new ButtonGroup();
        buttonGroupGameMode.add(jrbHvsAi); // добавление в группу
        buttonGroupGameMode.add(jrbHvsH);
        jrbHvsH.setEnabled(false); // делаем режим недостпуным

        slFieldSize = new JSlider(MIN_FIELD_SIZE,MAX_FIELD_SIZE,MIN_FIELD_SIZE); //Инициализация слайдера
        slFieldSize.setMajorTickSpacing(1);
        slFieldSize.setPaintLabels(true);
        slFieldSize.setPaintTicks(true);

        slWinningLength = new JSlider(MIN_FIELD_SIZE,MIN_FIELD_SIZE,MIN_FIELD_SIZE);
        slWinningLength.setMajorTickSpacing(1);
        slWinningLength.setPaintLabels(true);
        slWinningLength.setPaintTicks(true);

        slFieldSize.addChangeListener(e -> { // при выборе слайдера1 задается значение второму
            slWinningLength.setMaximum(slFieldSize.getValue());
        });

        add(new JLabel("Choose field size:"));
        add(slFieldSize);

        add(new JLabel("Choose winning length:"));
        add(slWinningLength);

        JButton buttonStart = new JButton("Start a game");
        add(buttonStart);

        buttonStart.addActionListener(e -> { //принажатии кнопки старт идет сбор данных со всех полей окна сайтинг
            int gameMode;
            if(jrbHvsAi.isSelected()){
                gameMode = GAME_MODE_H_VS_AI;
            } else {
                gameMode = GAME_MODE_H_VS_H;
            }
            int fieldSize = slFieldSize.getValue();
            int winningLength = slWinningLength.getValue();

            Logic.SIZE = fieldSize; // при нажатии меняются в классе логик значения
            Logic.DOTS_TO_WIN = winningLength;
            Logic.finishedGame = false; // Игра не закончена
            Logic.initMap(); // заполнение карты в логике


            gameWindow.startNewGame(gameMode,fieldSize,winningLength);
            setVisible(false);
        });

        setVisible(false);
    }
}
