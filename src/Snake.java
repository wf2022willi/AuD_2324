public class Snake {
    private Point[] points;
    private AudColor color = AudColor.blue;
    private Direction nextDirection;
    private Direction lastDirection;

    public Snake(int length, int x, int y) {
        if (length <= 0) {
            throw new IllegalArgumentException("Die Länge der Schlange muss eine positive Zahl sein.");
        }
        //this.color = color;
        points = new Point[length];
        points[0] = new Point(x, y);
        for (int i = 1; i < length; i++) {
            points[i] = null;
        }
        nextDirection = Direction.RIGHT;
        lastDirection = Direction.RIGHT;
    }

    public Snake(int x, int y) {

        this(5, x, y);
    }

    //Objekt "Point" auf dem Gamewindow visualizieren
    public void paint(AudGraphics g) {
        g.setColor(color);

        for (Point point : points) {
            if (point != null) {
                int pixelX = point.getX() * SnakeGame.SQUARE_SIZE;
                int pixelY = point.getY() * SnakeGame.SQUARE_SIZE;
                g.fillRect(pixelX, pixelY, SnakeGame.SQUARE_SIZE, SnakeGame.SQUARE_SIZE);
            }
        }
    }

    public int getNextDirection() {

        return nextDirection.ordinal();
    }

    public void setNextDirection(Direction nextDirection) {
        if (nextDirection != reverseDirection(lastDirection)) {
            this.nextDirection = nextDirection;
        }

    }

    public enum Direction {
        RIGHT, DOWN, LEFT, UP
    }

    public void step() {
        int headX = points[0].getX();
        int headY = points[0].getY();
        lastDirection = nextDirection;
        switch (nextDirection) {
            case RIGHT:
                headX++;
                break;
            case DOWN:
                headY++;
                break;
            case LEFT:
                headX--;
                break;
            case UP:
                headY--;
                break;
        }
        Point[] pointstemp = new Point[points.length];
        System.arraycopy(points, 0, pointstemp, 1, points.length - 1);
        pointstemp[0] = new Point(headX, headY);
        points = pointstemp;
    }

    private Direction reverseDirection(Direction dir) {
        switch (dir) {
            case RIGHT:
                return Direction.LEFT;
            case DOWN:
                return Direction.UP;
            case LEFT:
                return Direction.RIGHT;
            case UP:
                return Direction.DOWN;
            default:
                return dir;
        }
    }

//    public boolean collidesWith(GameItem item){
//        for (int i = 0; i < points.length; i++) {
//            int x = item.getPosition().getX();
//            int y = item.getPosition().getY();
//            if (x == points[i].getX() || y == points[i].getY()) {
//                return true;
//            }
//        }
//
//
//        return false;
//    }

    public boolean collidesWith(GameItem item){
        for (int i = 0; i < points.length; i++) {
            if (points[i].getX() == item.getPosition().getX() && points[i].getY() == item.getPosition().getY()) {
                return true;
            }
        }


        return false;
    }

    public boolean collidsWith(int x, int y){
        for (int i = 0; i < points.length; i++) {
            if (x == points[i].getX()) {
                return true;
            } else if (y == points[i].getY()) {
                return true;
            }
        }
        return false;
    }

//   public boolean collidesWithSelf() {
//        for (int i = 0; i < points.length; i++) {
//            if (points[i] == ) {
//
//            }
//        }
//        return false;
//    }
//

}
