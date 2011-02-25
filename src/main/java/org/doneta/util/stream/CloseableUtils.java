package org.doneta.util.stream;

import java.io.Closeable;
import java.io.IOException;

import org.apache.log4j.Logger;

public class CloseableUtils{
	
	private static Logger log = Logger.getLogger(CloseableUtils.class);
	
	/**
	 * 关闭流方法
	 * @param closeable
	 */
	public static void closeStream(Closeable closeable) {
		try {
			closeable.close();
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}
}
