/*********************************** NEW FILE ******************************/
public class Justified {
    public static void main (String [] args) {
        double d = Math.random();
        System.out.printf
        ("Field width of 10, 3 places, right justified:%10.3f\n", d);
        System.out.printf
        ("%-10.3f shown in field width of 10, left justified\n", d);
    }
}
