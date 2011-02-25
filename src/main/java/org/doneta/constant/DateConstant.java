package org.doneta.constant;

import java.util.Locale;

import org.doneta.util.date.TimeFormat;

/**
 * DateConstant 时间常量
 * @author Hypnusds
 */
public class DateConstant {
	
	public static final TimeFormat FULL_CHINESE_TIME = TimeFormat.getInstance("yyyy年MM月dd日 HH点mm分ss秒");
	public static final TimeFormat CHINESE_TIME = TimeFormat.getInstance("yyyy年MM月dd日 HH:mm:ss");
	public static final TimeFormat DEFAULT_TIME = TimeFormat.getInstance("yyyy-MM-dd HH:mm:dd");
	public static final TimeFormat FULL_ENGLISH_TIME = TimeFormat.getInstance("EEE d MMM yyyy HH:mm:ss z", Locale.US);
	public static final TimeFormat ENGLISH_TIME = TimeFormat.getInstance("EEE d MMM yyyy HH:mm:ss", Locale.US);
	
}
