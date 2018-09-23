package com.example.suphuy.assigmment_huyphpk00628.Control;

/**
 * Created by SUPHUY on 9/30/2016.
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by sup huy quan sư
 */
// chúng ta tạo 1 class để lấy ngày giờ thứ trong tuần hay tháng cho tiện
    //mọi người nên tạo 1 class để dùng cho sau này...
// còn đối với trong 1 app thì dễ hiểu và đỡ coppy qua lại giữa các Acitivy vì chúng ta dùng chung luôn
public class DateTime {

    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMATThu = "AA yyyy-MM-dd HH:mm:ss";
    private Date mDate;
    private Calendar mCalendar;

    public DateTime() {
        this(new Date());
    }
    public DateTime(Date date) {
        mDate = date;
        mCalendar = Calendar.getInstance();
        mCalendar.setTime(mDate);
    }
//đưa 1 String sẽ tự động parse String đó và chúng ta có thể get ngày tháng năm và thứ
    public DateTime(String dateFormat, String dateString) {
        mCalendar = Calendar.getInstance();
        SimpleDateFormat mFormat = new SimpleDateFormat(dateFormat);
        try {
            mDate = mFormat.parse(dateString);
            mCalendar.setTime(mDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public DateTime(String dateString) {
        this(DATE_FORMAT, dateString);
    }

    public DateTime(int year, int monthOfYear, int dayOfMonth,
                    int hourOfDay, int minuteOfHour, int secondOfMinute) {
        mCalendar = Calendar.getInstance();
        mCalendar.set(year, monthOfYear, dayOfMonth, hourOfDay, minuteOfHour, secondOfMinute);
        mDate = mCalendar.getTime();
    }


    public DateTime(int year, int monthOfYear, int dayOfMonth,
                    int hourOfDay, int minuteOfHour) {
        this(year, monthOfYear, dayOfMonth, hourOfDay, minuteOfHour, 0);

    }
    public DateTime(int year, int monthOfYear, int dayOfMonth) {
        this(year, monthOfYear, dayOfMonth, 0,0,0);
    }

    public Date getDate() {
        return mDate;
    }

    public Calendar getCalendar() {
        return mCalendar;
    }

    public String getDateString(String dateFormat) {
        SimpleDateFormat mFormat = new SimpleDateFormat(dateFormat);
        return mFormat.format(mDate);
    }

    public String getDateString() {

        return getDateString(DATE_FORMAT);

    }

    public int getYear() {
        return mCalendar.get(Calendar.YEAR);
    }

    public int getMonthOfYear() {
        return mCalendar.get(Calendar.MONTH);
    }

    public int getDayOfMonth() {
        return mCalendar.get(Calendar.DAY_OF_MONTH);
    }

    public int getHourOfDay() {
        return mCalendar.get(Calendar.HOUR_OF_DAY);
    }

    public int getMinuteOfHour() {
        return mCalendar.get(Calendar.MINUTE);
    }

    public int getSecondOfMinute() {
        return mCalendar.get(Calendar.SECOND);
    }
    //lấy thứ trong tuần của tháng nha
    public String getThu(){
        switch ( mCalendar.get(Calendar.DAY_OF_WEEK))
        {
            case 1:{
                return "chủ nhật";
            }
            case 2:{
                return "thứ hai";
            }
            case 3:{
                return "thứ ba";
            }
            case 4:{
                return "thứ tư";
            }
            case 5:{
            return "thứ năm";
        }
            case 6:{
            return "thứ sáu";
        }
            case 7:{
            return "thứ bảy";
        }
        default:
            return "";
        }
    }
    //lấy số thứ tức là từ 1--->7
    public int getThu1() {
      return   mCalendar.get(Calendar.DAY_OF_WEEK);
    }
}