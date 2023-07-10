package model;

public class Vehicle {
    private int id;
    String model;
    private int productManufactoringYear;
    private int quantity;
    public static int count;
    private String type;

    public Vehicle(String model, int productManufactoringYear, String type) {
        this.id = count++;
        this.model = model;
        this.productManufactoringYear = productManufactoringYear;
        this.type=type;
        this.quantity = 5;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductManufactoringYear() {
        return productManufactoringYear;
    }

    public void setProductManufactoringYear(int productManufactoringYear) {
        this.productManufactoringYear = productManufactoringYear;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Mã dòng xe: "+(this.id+1)+"\n"+
                "Dòng xe: "+model+"\n"+
                "Loại xe: "+this.type+"\n"+
                "Năm sản xuất: "+productManufactoringYear+"\n"+
                "Số lượng xe: "+quantity;
    }
}
