package model;

public class Motorbike extends Vehicle {
    private int id;
    private String motorbikeLisencePlate;
    private String color;
    private boolean isHired;
    public static int countID;

    public Motorbike(String model, int productManufactoringYear, String type, String motorbikeLisencePlate, String color, boolean isHired) {
        super(model, productManufactoringYear, type);
        this.id = countID++;
        this.motorbikeLisencePlate = motorbikeLisencePlate;
        this.color = color;
        this.isHired = isHired;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getModel() {
        return super.getModel();
    }

    @Override
    public void setModel(String model) {
        super.setModel(model);
    }

    @Override
    public int getProductManufactoringYear() {
        return super.getProductManufactoringYear();
    }

    @Override
    public void setProductManufactoringYear(int productManufactoringYear) {
        super.setProductManufactoringYear(productManufactoringYear);
    }

    @Override
    public int getQuantity() {
        return super.getQuantity();
    }

    @Override
    public void setQuantity(int quantity) {
        super.setQuantity(quantity);
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public void setType(String type) {
        super.setType(type);
    }

    public String getMotorbikeLisencePlate() {
        return motorbikeLisencePlate;
    }

    public void setMotorbikeLisencePlate(String motorbikeLisencePlate) {
        this.motorbikeLisencePlate = motorbikeLisencePlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isHired() {
        return isHired;
    }

    public void setHired(boolean hired) {
        isHired = hired;
    }

    @Override
    public String toString() {
        if (!isHired) {
            return "\tID xe máy:" + (this.id+1) + "\tbiển số xe:" + this.motorbikeLisencePlate + "\tMàu xe:" + this.color + "\tTình trạng: xe chưa được thuê";
        }else {
            return "\tID xe máy:" + (this.id+1)+ "\tbiển số xe:" + this.motorbikeLisencePlate + "\tMàu xe:" + this.color + "\tTình trạng: xe đã được thuê";
        }
    }
}
