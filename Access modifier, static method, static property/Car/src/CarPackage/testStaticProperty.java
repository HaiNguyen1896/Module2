package CarPackage;

public class testStaticProperty {
    public static void main(String[] args) {
        Car car1 = new Car("Ferrari","biTurbo V8");
        System.out.println(Car.numberOfCars);
        Car car2=new Car("Lambogini","bitTurbo V9");
        System.out.println(Car.numberOfCars);

    }

}
