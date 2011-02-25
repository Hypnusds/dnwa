package org.doneta.util.empty;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * EmptyUtils 判断常用类型是否为空的工具类
 * @author Hypnusds
 */
public class EmptyUtils {
	
	private static final Logger log = Logger.getLogger(EmptyUtils.class);
	
	public static  boolean isEmpty(String str){
		return StringUtils.isEmpty(str);
	}

	public static boolean isEmpty(InputStream stream) {
		int size = 0;
		if(stream == null)
			return true;
		try {
			size = stream.available();
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return size == 0 ? true : false;
	}
		
	public static boolean isEmpty(Object[] array){
		return ArrayUtils.isEmpty(array);
	}
	
	public static boolean isEmpty(Collection<?> coll){
		return CollectionUtils.isEmpty(coll);
	}
	
	public static boolean isEmpty(Object obj){
		return obj == null ? true : false;
	}
	
	public static boolean isEmpty(Map<?, ?> map){
		return MapUtils.isEmpty(map);
	}
	
}
