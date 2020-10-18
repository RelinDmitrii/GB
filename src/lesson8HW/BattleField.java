package lesson8HW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleField extends JPanel {
    private GameWindow gameWindow;
    private int gameMode;
    private int fieldSize;
    private int winningLength;

    private boolean isInit; // переменная для понимания считанны ли данные с окна Настроек

    private int cellWidth;
    private int cellHeight;

    public BattleField(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        setBackground(Color.ORANGE);

        addMouseListener(new MouseAdapter() { // Высчитывает координаты квадрата на которую нажимаем мышкой
            @Override
            public void mouseReleased(MouseEvent e) {
                int cellX = e.getX()/cellWidth;
                int cellY = e.getY()/cellHeight;

                if(!Logic.finishedGame) {
                    Logic.humanTurn(cellX, cellY);
                }

                repaint();
            }
        });

    }

    public  void startNewGame(int gameMode, int fieldSize, int winningLength){
        this.gameMode = gameMode;
        this.fieldSize = fieldSize;
        this.winningLength = winningLength;
        isInit = true;
        repaint(); // данные пришли запускаем перерисовку
    }

    @Override  // метод для отрисвоки поля
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(!isInit){
            return;
        }

        int panelWidth = getWidth(); // обращение к размеру в пикселях оранжевой панели (длина)
        int panelHeight = getHeight(); // обращение к размеру в пикселях оранжевой панели (высота)

        cellWidth = panelWidth / fieldSize;
        cellHeight = panelHeight / fieldSize;

        for (int i = 1; i < fieldSize; i++) { // прорисовка горизонтальных линий
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 1; i < fieldSize; i++) { // прорисовка вертикальных линий линий
            int x = i * cellWidth;
            g.drawLine(x,0,x,panelHeight);
        }

        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if (Logic.map[i][j] == Logic.DOT_X) {
                    drawX(g, j, i);
                }
                if(Logic.map[i][j] == Logic.DOT_O){
                    drawO(g, j, i);
                }
            }
        }


    }

    void drawX(Graphics g, int x, int y){
            g.setColor(Color.BLUE); // цвет
            ((Graphics2D)g).setStroke(new BasicStroke(5)); // толщина
            g.drawLine(x*cellWidth, y*cellHeight,
                    (x+1)*cellWidth, (y+1)*cellHeight);
            g.drawLine((x+1)*cellWidth,y*cellHeight, x*cellWidth, (y+1)*cellHeight);

        }

        void drawO(Graphics g, int x, int y){
            g.setColor(Color.RED);
            ((Graphics2D)g).setStroke(new BasicStroke(5));
            g.drawOval(x*cellWidth, y*cellHeight,
                    cellWidth, cellHeight);
    }
}
