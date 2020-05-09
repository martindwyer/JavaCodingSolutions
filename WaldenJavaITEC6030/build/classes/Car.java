public class Car {
    private int yearModel;
    private String make;
    private int speed;

    public Car(int yearModel, String make) {
        this.yearModel = yearModel;
        this.make = make;
        this.speed = 0;

    }

    public int getYearModel() {
        return yearModel;
    }

    public String getMake() {
        return make;
    }

    public int getSpeed() {
        return speed;
    }

    public void accelerate() {
        this.speed += 5;
    }

    public void brake() {
        this.speed -= 5;

    }

    public static void main(String[] args) {
        Car pinto = new Car(2019,"pinto");
        pinto.accelerate();
        System.out.println(pinto.getSpeed());
        pinto.accelerate();
        System.out.println(pinto.getSpeed());
        pinto.accelerate();
        System.out.println(pinto.getSpeed());
        pinto.accelerate();
        System.out.println(pinto.getSpeed());
        pinto.accelerate();
        System.out.println(pinto.getSpeed());
        pinto.brake();
        System.out.println(pinto.getSpeed());
        pinto.brake();
        System.out.println(pinto.getSpeed());
        pinto.brake();
        System.out.println(pinto.getSpeed());
        pinto.brake();
        System.out.println(pinto.getSpeed());
        pinto.brake();
        System.out.println(pinto.getSpeed());
    }
}
