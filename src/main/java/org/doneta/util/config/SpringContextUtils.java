package org.doneta.util.config;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

/**
 * SpringContextUtils 关于SpringContext的工具类
 * @author Hypnusds
 */
public class SpringContextUtils {

	private boolean isNotInitializable;
	private static final Logger log = Logger.getLogger(SpringContextUtils.class);
	private ApplicationContext springContext;

	private SpringContextUtils() {

	}

	static class SingletonHolder {
		static SpringContextUtils instance = new SpringContextUtils();
	}

	public static SpringContextUtils getInstance() {
		return SingletonHolder.instance;
	}

	public void initSpringContextUtils(ApplicationContext springContext) {
		if (isNotInitializable) {
			log.info("initialization failed : SpringContextUtils Already initialization completed");
			return;
		}
		this.springContext = springContext;
		log.info("SpringContextUtils initialization completed");
		isNotInitializable = true;
	}

	public Object getBean(String beanIdOrBeanName) {
		if (isNotInit())
			return null;
		return springContext.getBean(beanIdOrBeanName);
	}

	public <T> T getBean(String beanIdOrBeanName, Class<T> clazz) {
		if (isNotInit())
			return null;
		return springContext.getBean(beanIdOrBeanName, clazz);
	}

	public <T> T getBean(Class<T> clazz) {
		if (isNotInit())
			return null;
		return springContext.getBean(clazz);
	}

	public boolean isNotInit() {
		if (isNotInitializable) {
			log.error("SpringContextUtils is not initialized");
			return isNotInitializable;
		}
		return isNotInitializable;
	}

	public ApplicationContext getSpringContext() {
		return this.springContext;
	}

}
