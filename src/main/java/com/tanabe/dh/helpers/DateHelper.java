package com.tanabe.dh.helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by BTanabe on 5/29/2014.
 */
public class DateHelper {

    public static String getHumanReadableDateAndTimeMMddyyyyHHmmss(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getHumanReadableDateMMddYYYY(Calendar date){
        int month = date.get(Calendar.MONTH) + 1;
        int dayOfMonth = date.get(Calendar.DAY_OF_MONTH);
        int year = date.get(Calendar.YEAR);

        return month + "/" + dayOfMonth + "/" + year;
    }

    public static Calendar getCalendarObjectFromMMDDYYYYString(String dateString){
        Calendar date = Calendar.getInstance();

        try {
            String[] splitDate = dateString.split("/");
            int month = Integer.parseInt(splitDate[0]) - 1;
            int dayOfMonth = Integer.parseInt(splitDate[1]);
            int year = Integer.parseInt(splitDate[2]);

            date.set(Calendar.MONTH, month);
            date.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            date.set(Calendar.YEAR, year);

        } catch(NumberFormatException ex){
            return null;
        } catch(ArrayIndexOutOfBoundsException ex){
            return null;
        }

        return date;
    }

    public static int getCurrentYearAsYYYY(){
        Calendar currentYear = Calendar.getInstance();
        return currentYear.get(Calendar.YEAR);
    }
}
