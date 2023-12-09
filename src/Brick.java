public class Brick extends GameItem {
    private static final AudColor BRICK_COLOR = AudColor.GRAY;

    public Brick(int x, int y) {
        super(x, y);
    }

    @Override
    public void paint(AudGraphics g) {
        g.setColor(BRICK_COLOR);

        Point position = getPosition();
        int pixelX = position.getX() * SnakeGame.SQUARE_SIZE;
        int pixelY = position.getY() * SnakeGame.SQUARE_SIZE;
        g.fillRect(pixelX, pixelY, SnakeGame.SQUARE_SIZE, SnakeGame.SQUARE_SIZE);
    }

}
