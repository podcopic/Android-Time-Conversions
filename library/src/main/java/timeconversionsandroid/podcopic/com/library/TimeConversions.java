package timeconversionsandroid.podcopic.com.library;

import android.content.Context;
import android.content.Intent;
import android.text.format.DateUtils;
import android.util.Log;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * this class extract time ,date, day in desired format from time stamp
 */
public class TimeConversions {

    //variables
    private int day;
    private String month;
    private int year;
    private int minutes;
    private int hours;
    private int seconds;
    private String day_of_the_week;

    //constatnts day
    private String SUNDAY = "Sunday";
    private String MONDAY = "Monday";
    private String TUESDAY = "Tuesday";
    private String WEDNESDAY = "Wednesday";
    private String THURSDAY = "Thursday";
    private String FRIDAY = "Friday";
    private String SATURDAY = "Saturday";

    //constants month
    private String JANUARY = "January";
    private String FEBRUARY = "February";
    private String MARCH = "March";
    private String APRIL = "April";
    private String MAY = "May";
    private String JUNE = "June";
    private String JULY = "July";
    private String AUGUST = "August";
    private String SEPTEMBER = "September";
    private String OCTOBER = "October";
    private String November = "November";
    private String December = "December";

    //constructor
    public TimeConversions(Long timestamp) {

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


    }


    /*this method returns name of day using day of a weekend
    * @params --> 1.) 'dayOfTheWeekInInt' (itnteger value of day in a week)
    * @returns --> string , name of day
     */
    private String getDayOfWeekFromInt(int dayOfTheWeekInInt) {


        if (dayOfTheWeekInInt == 1)
            return SUNDAY;
        else if (dayOfTheWeekInInt == 2)
            return MONDAY;
        else if (dayOfTheWeekInInt == 3)
            return TUESDAY;
        else if (dayOfTheWeekInInt == 4)
            return WEDNESDAY;
        else if (dayOfTheWeekInInt == 5)
            return THURSDAY;
        else if (dayOfTheWeekInInt == 6)
            return FRIDAY;
        else
            return SATURDAY;

    }

    /*this method returns name of month using no. of a month
    * @params --> 1.) 'monthInInt' (itnteger value of month in a year)
    * @returns --> string , name of month
     */
    private String getMonthFromInt(int monthInInt) {
        if (monthInInt == 1)
            return JANUARY;
        else if (monthInInt == 2)
            return FEBRUARY;
        else if (monthInInt == 3)
            return MARCH;
        else if (monthInInt == 4)
            return APRIL;
        else if (monthInInt == 5)
            return MAY;
        else if (monthInInt == 6)
            return JUNE;
        else if (monthInInt == 7)
            return JULY;
        else if (monthInInt == 8)
            return AUGUST;
        else if (monthInInt == 9)
            return SEPTEMBER;
        else if (monthInInt == 10)
            return OCTOBER;
        else if (monthInInt == 11)
            return November;
        else
            return December;
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

}
