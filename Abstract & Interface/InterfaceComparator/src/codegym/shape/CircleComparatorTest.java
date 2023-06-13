package codegym.shape;

import java.util.Arrays;
import java.util.Comparator;

public class CircleComparatorTest {
    public static void main(String[] args) {
        Circle[]circles=new Circle[3];
        circles[0] = new Circle();
        circles[1]= new Circle(6);
        circles[2]=new Circle(3,"red",true);
        System.out.println("pre-sorted");
        for(Circle circle : circles){
            System.out.println(circle);
        }
        Comparator circleComparator = new CircleComparator();
        Arrays.sort(circles,circleComparator);
        System.out.println("after-sort");
        for(Circle circle : circles){
            System.out.println(circle);
        }

    }
}
