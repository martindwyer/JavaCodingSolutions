import java.util.Scanner;

public class Payroll {
    private String name;
    private int idNumber;
    private double rate;
    private int hours;

    public Payroll(String name, int idNumber) {
        this.name = name;
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public double getRate() {
        return rate;
    }

    public int getHours() {
        return hours;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double grossPay() {
        return this.hours * this.rate;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String employeeName;
        int employeeID;
        double employeeRate;
        int hoursWorked;

        System.out.print("Enter employee's name:");
        employeeName = kb.nextLine();
        System.out.print("Enter employee's ID number:");
        employeeID = kb.nextInt();
        System.out.print("Enter hourly rate:");
        employeeRate = kb.nextDouble();
        System.out.print("Enter number of hours worked:");
        hoursWorked = kb.nextInt();

        Payroll employee = new Payroll(employeeName,employeeID);

        employee.setHours(hoursWorked);
        employee.setRate(employeeRate);

        System.out.println(employeeName + ", employee number " + employeeID + ", made $" + (String.format("%.2f",employee.grossPay())) + " in gross pay.");

    }
}
