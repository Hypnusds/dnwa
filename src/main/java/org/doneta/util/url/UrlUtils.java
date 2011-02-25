package org.doneta.util.url;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * UrlUtils URL处理的工具类
 * @author Hypnusds
 */
public class UrlUtils {
	
	/**
	 * 相对路径转换绝对路径 <br>
	 * 注意：请补全/ 
	 * @param realPath 当前页面的URL 如：http://www.google.com/ 
	 * @param relatedPath 相对路径
	 * @return 绝对路径
	 * @throws URISyntaxException URL 异常
	 */
	public static String relatedToAbs(String realPath, String relatedPath) throws URISyntaxException {
		URI base = new URI(realPath);
		URI abs = base.resolve(relatedPath);
		return abs.toASCIIString();
	}
	
}
