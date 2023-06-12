package Points;

public class Point2dTest {
    public static void main(String[] args) {
        Point2d point2d = new Point2d();
        System.out.println(point2d);
        point2d = new Point2d(5.5f, 10.5f);
        System.out.println(point2d);
        point2d.setXY(20.4f, 30.4f);
        System.out.println(point2d);

    }
}
