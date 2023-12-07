public class SnakeGame extends AudGameWindow{

    // Attributen
    private int score;
    private int width;
    private int height;
    public static final int SQUARE_SIZE = 16;
    public static final int STEP_TIME = 100;
    private Snake snake;
    private long lastSnakeUpdate;




    //stanrad Konstruktor 1d)
    public SnakeGame() {
        super();
        score = 0; //Spielanfang ist Score 0
        setTitle("AuD-Snake - Score:"+score);
        width = getGameAreaWidth() / SQUARE_SIZE ;
        height = getGameAreaHeight() / SQUARE_SIZE;
        int areaWidth = getGameAreaHeight();
        int areaHeight = getGameAreaHeight();
        snake = new Snake(areaWidth/2 - SQUARE_SIZE,areaHeight/2 - SQUARE_SIZE,5);
        lastSnakeUpdate = System.currentTimeMillis();// zeitpunkt letzte Update
    }

    public void updateGame(long time) {
        long runtime = time - lastSnakeUpdate;
        int steps = (int) (runtime / STEP_TIME);
        for (int i = 0; i < steps; i++) {
            snake.step();
        }
        lastSnakeUpdate += steps * STEP_TIME;


    }

    @Override
    public void paintGame(AudGraphics g) {
        int areaWidth = getGameAreaWidth();
        int areaHeight = getGameAreaHeight();
        g.drawRect(0,0,areaWidth,areaHeight);
        g.fillRect(0,0,areaWidth,areaHeight);
        snake.paint(g);

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






    @Override
    public void handleInput(int keyCode) {

    }



    public static void main(String[] args) {
        SnakeGame game1 = new SnakeGame();
        game1.start(); //1c)




    }
}
