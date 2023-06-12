package Points;

import java.util.Arrays;

public class Point2d {
    private float x = 0.0f;
    private float y = 0.0f;
    private float[] xy = new float[2];


    public Point2d() {
        this.xy[0] = x;
        this.xy[1] = y;
    }

    public Point2d(float x, float y) {
        this.x = x;
        this.y = y;
        this.xy[0] = x;
        this.xy[1] = y;
    }

    public float getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY() {
        return this.xy;
    }

    public void setXY(float x, float y) {
        this.xy[0] = x;
        this.xy[1] = y;
        this.x = x;
        this.y=y;
    }

    @Override
    public String toString() {
        return "Point2d{" +
                "x=" + this.x +
                ", y=" + this.y +
                ", (x,y)=" + Arrays.toString(this.getXY()) +
                '}';
    }
}
