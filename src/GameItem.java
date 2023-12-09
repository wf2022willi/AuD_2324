public abstract class GameItem {
    private Point position;

    public GameItem(int x, int y) {
        this.position = new Point(x, y);
    }

//    public Point getPosition() {
//        int x = position.getX();
//        int y = position.getY();
//        return new Point(x,y);
//
//    }


    public Point getPosition() {
        return position;
    }

    public abstract void paint(AudGraphics g);
}
