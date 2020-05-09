import java.text.NumberFormat;

public class Area {
    private int area;

    // area of a circle
    public static double area(double d) {
        double a1 = Math.PI*(d*d);
        return a1;
    }

    // area of a rectangle
    public static double area(double d1, double d2) {
        double a1 = (d1*d2);
        return a1;
    }

    // area of a trapezoid
    public static double area(double base, double length, double height) {
        double a1 =  ((base + length) * height)/2;
        return a1;
    }

    public static void main(String[] args) {

        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);

        double a1 = Area.area(3);
        double a2 = Area.area(2,4);
        double a3 = Area.area(3,4,5);

        System.out.println(nf.format(a1));
        System.out.println(nf.format(a2));
        System.out.println(nf.format(a3));
    }

}
