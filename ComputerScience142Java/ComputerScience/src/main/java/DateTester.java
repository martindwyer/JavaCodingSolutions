public class DateTester {
    public static void main(String[] args) {
        Date testDate = new Date(3,14,2018);
        String date = testDate.toString();
        System.out.println(date);
        int days = testDate.addUpDays();
        System.out.println(days);
    }

}
