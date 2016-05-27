package timeconversionsandroid.podcopic.com.library;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * this class extract time ,date, day in desired format from time stamp
 */
public class TimeExtractionFromTimeStamp {

    //variables
    private int day;
    private String month;
    private int year;
    private int minutes;
    private int hours;
    private int seconds;
    private String day_of_the_week;
    private String dateString;
    private Date date;


    //constructor
    public TimeExtractionFromTimeStamp(Long timestamp) {

        Date date = new Date(timestamp * 1000);
        TimeZone tz = TimeZone.getTimeZone("GMT");
        Calendar cal = new GregorianCalendar();
        cal.setTimeZone(tz);
        cal.setTime(date);


        this.year = cal.get(Calendar.YEAR);
        this.month = getMonthFromInt(cal.get(Calendar.MONTH) + 1);
        this.day = cal.get(Calendar.DAY_OF_MONTH);
        this.hours = cal.get(Calendar.HOUR);
        this.minutes = cal.get(Calendar.MINUTE);
        this.seconds = cal.get(Calendar.SECOND);
        this.day_of_the_week = getDayOfWeekFromInt(cal.get(Calendar.DAY_OF_WEEK));
        this.dateString = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa").format(date);
        this.date = date;


    }


    /*this method returns name of day using day of a weekend
    * @params --> 1.) 'dayOfTheWeekInInt' (itnteger value of day in a week)
    * @returns --> string , name of day
     */
    private String getDayOfWeekFromInt(int dayOfTheWeekInInt) {


        if (dayOfTheWeekInInt == 1)
            return Day.SUNDAY;
        else if (dayOfTheWeekInInt == 2)
            return Day.MONDAY;
        else if (dayOfTheWeekInInt == 3)
            return Day.TUESDAY;
        else if (dayOfTheWeekInInt == 4)
            return Day.WEDNESDAY;
        else if (dayOfTheWeekInInt == 5)
            return Day.THURSDAY;
        else if (dayOfTheWeekInInt == 6)
            return Day.FRIDAY;
        else
            return Day.SATURDAY;

    }

    /*this method returns name of month using no. of a month
    * @params --> 1.) 'monthInInt' (itnteger value of month in a year)
    * @returns --> string , name of month
     */
    private String getMonthFromInt(int monthInInt) {
        if (monthInInt == 1)
            return Month.JANUARY;
        else if (monthInInt == 2)
            return Month.FEBRUARY;
        else if (monthInInt == 3)
            return Month.MARCH;
        else if (monthInInt == 4)
            return Month.APRIL;
        else if (monthInInt == 5)
            return Month.MAY;
        else if (monthInInt == 6)
            return Month.JUNE;
        else if (monthInInt == 7)
            return Month.JULY;
        else if (monthInInt == 8)
            return Month.AUGUST;
        else if (monthInInt == 9)
            return Month.SEPTEMBER;
        else if (monthInInt == 10)
            return Month.OCTOBER;
        else if (monthInInt == 11)
            return Month.November;
        else
            return Month.December;
    }


    public void setDay(int day) {
        this.day = day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void setMonth(int month) {
        this.month = getMonthFromInt(month);
    }

    public void setDay_of_the_week(int dayOfTheWeekInInt) {
        this.day_of_the_week = getDayOfWeekFromInt(dayOfTheWeekInInt);
    }

    public int getDay() {
        return this.day;
    }

    public int getYear() {
        return this.year;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public String getDay_of_the_week() {
        return this.day_of_the_week;
    }

    public String getMonth() {
        return this.month;
    }

    public String getStringDate(){
        return dateString;
    }

}
