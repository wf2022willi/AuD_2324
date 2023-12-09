public class Apple extends GameItem{

    private final int VALUE;
    private static int k = 0; //klassenvariable k fuer Counter


    public Apple(int x, int y) {
        super(x, y);
        k ++;
        VALUE = k;
    }

    @Override
    public void paint(AudGraphics g) {
        Apple apple = new Apple(getPosition().getY(), getPosition().getY());
        int x = apple.getPosition().getX();
        int y = apple.getPosition().getY();

        g.fillOval(x,y,SnakeGame.SQUARE_SIZE, SnakeGame.SQUARE_SIZE);

    }

//    public static void main(String[] args) {
//        Apple a1 = new Apple(0,2);
//        System.out.println(a1.VALUE);
//        Apple a2 = new Apple(1,1);
//        System.out.println(a2.VALUE);
//    }
}
