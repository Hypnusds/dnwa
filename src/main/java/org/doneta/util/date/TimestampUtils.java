package org.doneta.util.date;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.doneta.constant.DateConstant;

/**
 *TimestampUtil 时间戳工具类 
 * @author Hypnusds
 */
public class TimestampUtils {
    
	public static int getTimestamp() {
		return (int) (System.currentTimeMillis() / 1000);
	}

    private static long toLong(int Timestamp) {
        return (long) Timestamp * 1000;
    }
    
    public static Date formatTimestamp(int Timestamp, boolean getDate) {
    	if(!getDate)
    		return null;
        long longTime = toLong(Timestamp);
        return new Date(longTime);
    }

    public static String formatTimestamp(int Timestamp) {
    	 return formatTimestamp(Timestamp, DEFAULT_TIME);
    }
    
    public static String formatTimestamp(int Timestamp, String pattern){
    	if(StringUtils.isEmpty(pattern))
    		 return formatTimestamp(Timestamp);
        return DateFormatUtils.format(toLong(Timestamp), pattern);
    }

    public static String formatTimestamp(int Timestamp, TimeFormat timeFormat){
        return DateFormatUtils.format(toLong(Timestamp), timeFormat.getPattern(), timeFormat.getLocale());
    }
    
    public static final TimeFormat FULL_CHINESE_TIME = DateConstant.FULL_CHINESE_TIME;
    public static final TimeFormat CHINESE_TIME = DateConstant.CHINESE_TIME;
    public static final TimeFormat DEFAULT_TIME = DateConstant.DEFAULT_TIME;
    public static final TimeFormat FULL_ENGLISH_TIME = DateConstant.FULL_ENGLISH_TIME;
    public static final TimeFormat ENGLISH_TIME = DateConstant.ENGLISH_TIME;

}
