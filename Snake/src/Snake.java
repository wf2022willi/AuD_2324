import java.util.ArrayList;

public class Snake {
    public enum Direction {
        RIGHT,
        DOWN,
        LEFT,
        UP
    }


    public Direction getNextDirection() {
        return nextDirection;
    }

    public void setNextDirection(Direction nextDirection) {
        this.nextDirection = nextDirection;
    }

    private Direction nextDirection;
    private Direction lastDirection;




    private Point[] points;
    private AudColor color = AudColor.red;

    public Snake(int x, int y, int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Die Zahl ist negativ, ungultige Eingabe");
        }
        points = new Point[length]; // erzeugen das Objekt Point mit angegenbende Laenge
        points[0] = new Point(x, y);
        for (int i = 1; i < length; i++) {
            points[i] = null;
        }

    }

    public Snake(int x, int y) {
       this(x,y,5);
    }

    //aufg 4e) ii)
    public void paint(AudGraphics g) {
        g.setColor(color);
        int len = points.length;
        for (int i = 0; i < len; i++) {
            if (points[i] == null) {
                continue;
            } else {
                int x = points[i].getX();
                int y = points[i].getY();
                g.fillRect(x, y, SnakeGame.SQUARE_SIZE, SnakeGame.SQUARE_SIZE);
            }
        }

    }

    public void step(){
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
        System.arraycopy(points, 0, points, 1, points.length - 1);
        points[0] = new Point(headX, headY);

    }


    /*
    public static void main(String[] args) {
        Snake t1 = new Snake(-1, 0, 0);

    }
    */


}
