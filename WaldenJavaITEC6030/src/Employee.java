public class Employee {
    private String name;
    private int idNumber;
    private String department;
    private String position;

    public Employee(String name, int idNumber, String department, String position) {
        this.name = name;
        this.idNumber = idNumber;
        this.department = department;
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public static void main(String[] args) {
        Employee susan = new Employee("Susan Meyers",47899,"Marketing","Sales Rep");
        Employee mark = new Employee("Mark Jones",39119,"IT","Programmer");
        Employee joy = new Employee("Joy Rogers",81774,"Manufacturing","Engineer");

        System.out.println(susan.getName()+", employee number "+susan.getIdNumber() + ", works as a "+susan.getPosition()+" in "+susan.getDepartment()+".");
        System.out.println(mark.getName()+", employee number "+mark.getIdNumber() + ", works as a "+mark.getPosition()+" in "+mark.getDepartment()+".");
        System.out.println(joy.getName()+", employee number "+joy.getIdNumber() + ", works as a "+joy.getPosition()+" in "+joy.getDepartment()+".");

    }
}
