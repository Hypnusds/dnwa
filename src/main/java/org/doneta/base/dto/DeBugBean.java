package org.doneta.base.dto;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.doneta.util.string.FirstOne;

/**
 * BaseEntity 
 * @author Hypnusds
 */
public abstract class DeBugBean extends BaseBean {

	private static final long serialVersionUID = -7758254976043723487L;
	
	private StringBuffer toString = null;

	public String getClazz() {
		return this.getClass().getName();
	}

	public String getSimpleClazz() {
		return this.getClass().getSimpleName();
	}

	public String toString() {
		toString = new StringBuffer();
		Field[] fields = this.getClass().getDeclaredFields();
		toString.append("{ ");
		{
			int size = fields.length;
			if (size == 0)
				toString.append("null ");
			for (int i = 0; i < size; i++) {
				String name = fields[i].getName();
				String value = null;
				try {
					Method m = this.getClass().getMethod("get" + FirstOne.toUpperCaseFirstOne(name));
					if(m != null){
						toString.append(name).append(" = ");
						value = (String) m.invoke(this);
						toString.append(value).append(" , ");
					}
				} catch (SecurityException e) {
					log.error(e.getMessage());
				} catch (NoSuchMethodException e) {
				} catch (IllegalArgumentException e) {
					log.error(e.getMessage());
				} catch (IllegalAccessException e) {
					log.error(e.getMessage());
				} catch (InvocationTargetException e) {
					log.error(e.getMessage());
				}
			}
		}
		toString.append("}");
		return toString.toString();
	}

}
