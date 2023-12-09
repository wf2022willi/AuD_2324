import java.awt.*;
import java.util.Random;

public class SnakeGame extends AudGameWindow {

    //Attributes und Konstanten
    public static final int SQUARE_SIZE = 16; // Gittergroeße
    private Snake snake;
    public static final int STEP_TIME = 100;
    private long lastSnakeUpdate;
    private int width;
    private int height;
    private int score;
    private Brick[] wall;


    public SnakeGame() { //Standard-Konstruktor
        // Berechnung der Gitteranzahl des Spielfeldes
        width = getGameAreaWidth() / SQUARE_SIZE;
        height = getGameAreaHeight() / SQUARE_SIZE;
        score = 0;
        setTitle("AuD-Snake - Score" + score);
        int centerX = width / 2;
        int centerY = height / 2;
        snake = new Snake(centerX, centerY);
        lastSnakeUpdate = System.currentTimeMillis();
        createWall();
//        checkCollisions();
        createNewApple();

    }

    @Override //Spiel-zeit update
    public void updateGame(long time) {
        long elapsedTime = time - lastSnakeUpdate;
        int steps = (int) (elapsedTime / STEP_TIME);
        for (int i = 0; i < steps; i++) {
            snake.step();
        }
        lastSnakeUpdate += steps * STEP_TIME;
//        checkCollisions();
    }

    private void checkCollisions() {
//        updateGame(lastSnakeUpdate );
        for (int i = 0; i < wall.length; i++) {
            if (wall[i] == null) {
                break;
            } else if (snake.collidesWith(wall[i])) {
                stop();
                showDialog("You died! Score: 0");

            }

        }

//        if (snake.collidsWith() ) {
//            stop();
//            showDialog("You died! Score: 0");
//
//        } else if (snake.collidsWith(width-1,height-1)) {
//            stop();
//            showDialog("You died! Score: 0");
//
//        }


    }

    @Override // Spielfeld zeichnen
    public void paintGame(AudGraphics g) {
        int areaWidth = getGameAreaWidth();
        int areaHeight = getGameAreaHeight();
        g.fillRect(0, 0, areaWidth, areaHeight);
        snake.paint(g);
        paintWall(g);
    }

    //Hilfsmethode Apple
    private void createNewApple() {
        int x;
        int y;
        do {
            Random x1 = new Random();
            x = x1.nextInt(SQUARE_SIZE, getGameAreaWidth() - SQUARE_SIZE);
            Random y1 = new Random();
            y = y1.nextInt(SQUARE_SIZE, getGameAreaHeight() - SQUARE_SIZE);
        } while (snake.collidsWith(x, y));
        Apple apple = new Apple(x,y);


    }


    @Override
    public void handleInput(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_RIGHT:
                snake.setNextDirection(Snake.Direction.RIGHT);
                break;
            case KeyEvent.VK_DOWN:
                snake.setNextDirection(Snake.Direction.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                snake.setNextDirection(Snake.Direction.LEFT);
                break;
            case KeyEvent.VK_UP:
                snake.setNextDirection(Snake.Direction.UP);
                break;
            default:
        }
    }



    /*
    public void setTitle() { //Methode Spiel-Titel
        int score = 0;
        setTitle("AuD-Snake - Score: " + score);
    }

     */


    private void createWall() {
        //int widthInSquares = getGameAreaWidth() / SQUARE_SIZE;//width
        //int hightInSquares = getGameAreaHeight() / SQUARE_SIZE;//height
        wall = new Brick[(width + height) * 2];
        for (int i = 0; i < width; i++) {
            wall[i] = new Brick(i, 0);
        }
        for (int i = 0; i < height; i++) {
            wall[i + width] = new Brick(width - 1, i);
        }
        for (int i = 0; i < width; i++) {
            wall[i + width + height] = new Brick(width - i, height - 1);
        }
        for (int i = 0; i < height; i++) {
            wall[i + width + height + width] = new Brick(0, height - i);
        }
    }

    private void paintWall(AudGraphics g) {
        createWall();
        for (Brick brick : wall) {
            brick.paint(g);
        }
    }

    public SnakeGame(int timerInterval) {
        super(timerInterval);
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public int getGameAreaWidth() {
        return super.getGameAreaWidth();
    }

    @Override
    public int getGameAreaHeight() {
        return super.getGameAreaHeight();
    }

    @Override
    public void setGameAreaWidth(int value) {
        super.setGameAreaWidth(value);
    }

    @Override
    public void setGameAreaHeight(int value) {
        super.setGameAreaHeight(value);
    }

    @Override
    public void setRepeatableKeys(int... keyCodes) {
        super.setRepeatableKeys(keyCodes);
    }

    @Override
    public void setShowFps(boolean showFps) {
        super.setShowFps(showFps);
    }

    @Override
    public boolean getShowFps() {
        return super.getShowFps();
    }

    @Override
    public long getStartTime() {
        return super.getStartTime();
    }

    public static void main(String[] args) {
        SnakeGame snakegame = new SnakeGame();
        snakegame.start();
        for (int i = 0; i < snakegame.wall.length; i++) {
            System.out.println(snakegame.wall[i].getPosition());
        }
    }
}

