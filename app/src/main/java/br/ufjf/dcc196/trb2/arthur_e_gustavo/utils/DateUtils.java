package br.ufjf.dcc196.trb2.arthur_e_gustavo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static String pattern = "MM/dd/yyyy hh:mm:ss aa";

    public static Date converToDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        if (dateString == null) {
            return null;
        }
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String convertToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        if (date == null) {
            return null;
        }
        return dateFormat.format(date);
    }
}
