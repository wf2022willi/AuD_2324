public class SnakeGame extends AudGameWindow{

    // Attributen
    private int score;
    private int width;
    private int height;
    public static final int SQUARE_SIZE = 16;

    //stanrad Konstruktor 1d)
    public SnakeGame() {
        super();
        score = 0; //Spielanfang ist Score 0
        setTitle("AuD-Snake - Score:"+score);
        width = getGameAreaWidth() / SQUARE_SIZE ;
        height = getGameAreaHeight() / SQUARE_SIZE;
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
    public void updateGame(long time) {

    }

    @Override
    public void paintGame(AudGraphics g) {
        int areaWidth = getGameAreaWidth();
        int areaHeight = getGameAreaHeight();
        g.drawRect(0,0,areaWidth,areaHeight);
        g.fillRect(0,0,areaWidth,areaHeight);

    }

    @Override
    public void handleInput(int keyCode) {

    }



    public static void main(String[] args) {
        SnakeGame game1 = new SnakeGame();
        game1.start(); //1c)




    }
}
