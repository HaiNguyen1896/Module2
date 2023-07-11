package model;

public class Product {
    private String id;
    private String productName;
    private double productPrice;
    private int productCapacity;
    private String productDescribe;
    public Product(String id, String productName, double productPrice, int productCapacity, String productDescribe) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCapacity = productCapacity;
        this.productDescribe = productDescribe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductCapacity() {
        return productCapacity;
    }

    public void setProductCapacity(int productCapacity) {
        this.productCapacity = productCapacity;
    }

    public String getProductDescribe() {
        return productDescribe;
    }

    public void setProductDescribe(String productDescribe) {
        this.productDescribe = productDescribe;
    }

    @Override
    public String toString() {
        return "Mã sản phẩm=" + id + ", Tên sản phẩm=" + productName + ", Giá thành sản phẩm=" + productPrice + ", Số lượng=" + productCapacity + ", Mô tả sản phẩm=" + productDescribe;
    }
}
