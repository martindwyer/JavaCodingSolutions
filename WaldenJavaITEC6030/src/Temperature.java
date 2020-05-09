import java.util.Scanner;

public class Temperature {
    private double ftemp; //temp in fahrenheit

    public Temperature(double d) {
        this.ftemp = d;
    }

    public void setFahrenheit(double d) {
        this.ftemp = d;
    }

    public double getFahrehheit() {
        return this.ftemp;
    }

    public double getCelsius() {
        return (5.0/9)*(this.ftemp -32);
    }

    public double getKelvin() {
        return (5.0/9)*(this.ftemp -32) + 273;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter a Fahrenheit temperature:");
        double input = kb.nextDouble();
        Temperature testTemp = new Temperature(input);
        System.out.println("The temperature in Fahrenheit is " + input);
        System.out.println("The temperature in Celsius is " + testTemp.getCelsius());
        System.out.println("The temperature in Kelvin is " + testTemp.getKelvin());

    }

}