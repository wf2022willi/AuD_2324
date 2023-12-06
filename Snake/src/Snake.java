import java.util.ArrayList;

public class Snake {
    private ArrayList points;

    public Snake(int length, int x, int y) {
        if (length <= 0){
            throw  new IllegalArgumentException("Die Zahl ist negativ, ungultige Eingabe");
        }
        Point point1 = new Point(x,y); // erzeugen das Objekt Point
        points.add(0,point1);
    }

    public static void main(String[] args) {
        Snake t1 = new Snake(-1,0,0);

    }


}
