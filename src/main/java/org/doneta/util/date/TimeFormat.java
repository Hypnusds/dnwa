package org.doneta.util.date;

import java.util.Locale;

/**
 * TimeFormat 格式化时间模板
 * @author Hypnusds
 */
public class TimeFormat {
	
	private TimeFormat(String pattern, Locale locale){
        this.pattern = pattern;
        this.locale = locale;
    }
    
    private String pattern;
    
    private Locale locale;
    
    public String getPattern() {
        return pattern;
    }

    public Locale getLocale() {
        return locale;
    }
    
    public static TimeFormat getInstance(String pattern, Locale locale){
        return new TimeFormat(pattern, locale);
    }
    
    public static TimeFormat getInstance(String pattern){
        return new TimeFormat(pattern, null);
    }
    
}
