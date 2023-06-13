package codegym.shape;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {
    public int compare(Circle s1, Circle s2){
        if(s1.getRadius()>s2.getRadius()) return 1;
        if(s1.getRadius()<s2.getRadius()) return -1;
        else return 0;
    }
}
