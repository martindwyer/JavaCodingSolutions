public class Date {
    private int day,    // day of month
            month,              // month of year
            year,               // valid since 1583!
            dayOfYear;          // number of days since end of last year
    public Date(int m, int d, int y) {
        if(checkMonth(m)) {
            month = m;
        } else {
            throw new IllegalArgumentException ("Month must be between 1 and 12");
        }
        if (checkYear(y)) {
            year = y;
        } else {
            throw new IllegalArgumentException
                    ("Not a valid year for the modern calendar");
        }
        if(checkDay(m, d, y)) {
            day = d;
        } else {
            throw new IllegalArgumentException("Not a valid day for this month");
        }
        dayOfYear = addUpDays();
    }
    // private helper methods to check data validity
    private boolean checkMonth(int m) { return m <=12 && m >= 1; }

    private boolean checkDay(int m, int d, int y) {
        // 30-day months include April, June, September and November
        boolean valid = true;
        if (d < 1)
            valid = false;
        if ((m==4 || m==6 || m==9 || m==11) && d > 30) {
            valid = false;
        } else if (m==2) { // check for leap year if it's February
            if (leapYear(y)) {
                if (d > 29) valid = false;
            } else if (d > 28) valid = false;
        } else { // should be 31 days in the month
            if (d > 31) valid = false;
        }
        return valid;
    }

    private boolean leapYear (int y) {
        boolean isLeap = false;
        if (y % 400 == 0) isLeap = true;
        else if (y % 4 == 0 && !(year % 100 == 0)) isLeap=true;
        return isLeap;
    }

    private boolean checkYear (int y) { return y >= 1583; }
    // public accessors:
    public int getDay() { return day; }

    public int getMonth() { return month; }

    public int getYear() { return year; }

    public int getDayOfYear() { return dayOfYear; }

    public String toString() {
        String date = null;
        switch(month) {
            case 1: date = "January "; break;
            case 2: date = "February "; break;
            case 3: date = "March "; break;
            case 4: date = "April "; break;
            case 5: date = "May "; break;
            case 6: date = "June "; break;
            case 7: date = "July "; break;
            case 8: date = "August "; break;
            case 9: date = "September "; break;
            case 10: date = "October "; break;
            case 11: date = "November "; break;
            case 12: date = "December ";
        }
        date = date + day + " " + year;
        return date;
    }

    /********* TO BE COMPLETED BY STUDENT !!! **********/
    // private helper method to find number of days since first of current year
    public int addUpDays() {

        int days = this.getDay();
        int daysFromJan1 = 0;
        int months = this.getMonth();
        int[][] month_days = {{1,31},{2,28},{3,31},{4,30},{5,31},{6,30},{7,31},{8,31},{9,30},{10,31},{11,30},{12,31}};
        if (months == 1) {
            daysFromJan1 = days;
        } else {
            for (int i = 0; i < (months-1); i++) {
                daysFromJan1 += month_days[i][1];}
            daysFromJan1 += days;
        }
        return daysFromJan1;
    }


}
