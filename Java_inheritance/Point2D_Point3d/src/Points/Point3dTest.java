package Points;

public class Point3dTest {
    public static void main(String[] args) {
        Point3d point3d = new Point3d();
        System.out.println(point3d);
        point3d = new Point3d(10.4f, 20.4f, 30.5f);
        System.out.println(point3d);
        point3d.setXYZ(30.5f,90.8f,60f);
        System.out.println(point3d);
    }
}
