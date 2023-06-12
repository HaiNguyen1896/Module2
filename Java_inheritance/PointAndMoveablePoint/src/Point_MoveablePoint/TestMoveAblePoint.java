package Point_MoveablePoint;

public class TestMoveAblePoint {
    public static void main(String[] args) {
        MoveAblePoint moveablepoint = new MoveAblePoint();
        System.out.println(moveablepoint);
        moveablepoint = new MoveAblePoint(10.5f,20.5f);
        System.out.println(moveablepoint);
        moveablepoint= new MoveAblePoint(20f,20f,30f,30f);
        System.out.println(moveablepoint);
    }
}
