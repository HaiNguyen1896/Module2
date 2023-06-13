package codegym.shape;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Shape {
    public String color;
    public Boolean filled;

    public Shape() {
        this.color = "green";
        this.filled = true;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean isFilled() {
        return this.filled;
    }

    public void setFilled(Boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "a Shape with color {" +
                "color=" + getColor()
                + " and "
                + (isFilled() ? "filled}" : "not filled}");
    }
}
