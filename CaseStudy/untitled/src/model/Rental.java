package model;

public class Rental {
   private int rentalID;
   private String customerName;
  private String motorbikeType;
  private String motorbikeLisence;
  private String startDay;
  private String returnDay;
  private double amountPaid;
  public static int countRentalID;

    public Rental(String customerName, String motorbikeType,String lisencePlate, String startDay, String returnDay, double amountPaid) {
        this.rentalID = countRentalID++;
        this.customerName = customerName;
        this.motorbikeType = motorbikeType;
        this.startDay = startDay;
        this.returnDay = returnDay;
        this.amountPaid=amountPaid;
        this.motorbikeLisence = lisencePlate;
    }

    public int getRentalID() {
        return rentalID;
    }

    public void setRentalID(int rentalID) {
        this.rentalID = rentalID;
    }

//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    public Vehicle getVehicle() {
//        return vehicle;
//    }
//
//    public void setVehicle(Vehicle vehicle) {
//        this.vehicle = vehicle;
//    }


    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(String returnDay) {
        this.returnDay = returnDay;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

//    public Motorbike getMotorbike() {
//        return motorbike;
//    }

//    public void setMotorbike(Motorbike motorbike) {
//        this.motorbike = motorbike;
//    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMotorbikeType() {
        return motorbikeType;
    }

    public void setMotorbikeType(String motorbikeType) {
        this.motorbikeType = motorbikeType;
    }

    public String getMotorbikeLisence() {
        return motorbikeLisence;
    }

    public void setMotorbikeLisence(String motorbikeLisence) {
        this.motorbikeLisence = motorbikeLisence;
    }

    public static int getCountRentalID() {
        return countRentalID;
    }

    public static void setCountRentalID(int countRentalID) {
        Rental.countRentalID = countRentalID;
    }

    @Override
    public String toString() {
        return "Mã số hợp đồng: "+(rentalID+1)+"\n"+
                "\tTên người thuê: "+customerName+"\n"+
                "\tDòng xe:"+this.motorbikeType+"\n"+
                "\tBiển kiểm soát: "+this.motorbikeLisence+ "\n"+
                "\tNgày bắt đầu thuê: " + startDay+ "\n"+
                "\tNgày kết thúc thuê: "+returnDay+"\n"+
                "\tSố tiền phải trả "+ amountPaid+" đồng";
    }
}
