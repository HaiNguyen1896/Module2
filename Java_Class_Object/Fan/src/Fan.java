public class Fan {
    private static final int SLOW = 1;
    private static final int MEDIUM = 2;
    private static final int FAST = 3;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5.0;
    private String color = "blue";

    public Fan() {
//        this.speed = SLOW;
//        this.on = false;
//        this.radius = 5.0;
//        this.color = "blue";
    }

    public int getSpeed() {
        return this.speed;
    }

    public boolean getOn() {
        return this.on;
    }

    public double getRadius() {
        return this.radius;
    }

    public String getColor() {
        return this.color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double rad) {
        this.radius = rad;
    }

    public String toString() {
        if (this.on) {
            return "FAN IS ON with Speed=" + this.speed + " color=" + this.color + " radius=" + this.radius;
        } else {
            return "FAN IS OFF with" + " color=" + this.color + " radius=" + this.radius;
        }
    }

    public static void main(String[] args) {
        Fan Fan1 = new Fan();
        Fan Fan2 = new Fan();
        Fan1.setOn(true);
        Fan1.setSpeed(FAST);
        Fan1.setRadius(10);
        Fan1.setColor("yellow");
        Fan2.setOn(false);
        Fan2.setSpeed(MEDIUM);
        Fan2.setRadius(5);
        Fan2.setColor("blue");
        System.out.println(Fan1);
        System.out.println(Fan2);
    }

}
