package labone;

public class Lab1ConverterYear {
    private int[] daysInMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    public String getDate(int year, int dayNum) {
        int monthNum = 0;
        boolean isLeapYear = (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);

        if ((dayNum > 365 && !isLeapYear) || (dayNum > 366) || (dayNum <= 0)) return "";

        if (isLeapYear == true) daysInMonth[1]++;

        for (int daysi : daysInMonth) {
            if (dayNum <= daysi) break;
            dayNum -= daysi;
            monthNum++;
        }

        return months[monthNum] + " " + dayNum;
    }
}
