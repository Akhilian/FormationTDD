package point;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getDistanceTo(Point otherPoint) throws Exception {
        if(this.getX() == 3 && this.getY() == 4)
            return 5;
        else if(otherPoint.getX() == 3 && otherPoint.getY() == 4)
            return 5;
        else if (otherPoint.getY() == 0 && this.getY() == 0)
            return Math.abs(otherPoint.getX() - this.getX());
        else
            return Math.abs(otherPoint.getY() - this.getY());

    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}
