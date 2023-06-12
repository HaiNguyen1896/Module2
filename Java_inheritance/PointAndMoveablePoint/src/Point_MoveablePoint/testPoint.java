package Point_MoveablePoint;

public class testPoint {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println(point);
        point = new Point(3.5f,2.6f);
        System.out.println(point);
        point.setX(10f);
        System.out.println(point);
    }
}
