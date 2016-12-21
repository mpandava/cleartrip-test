package com.ctrip.common.data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by manjunath.pandava on 21/12/16.
 */
public class DataUtils {
    public static String getDateInSearchStringFormat(Date date){
        return new SimpleDateFormat("EEE, dd MMM, YYYY").format(date);
    }
}
