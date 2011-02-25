package org.doneta.base.listener;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

/**
 * SpringContextLoaderListener继承与ContextLoaderListener<br>
 * 修改了ContextLoaderListener的contextInitialized方法
 * @author Hypnusds
 */
public class SpringContextLoaderListener extends ContextLoaderListener {

	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		//SpringContextUtils.getInstance().initSpringContextUtils(WebApplicationContextUtils.getWebApplicationContext(event.getServletContext()));
	}

}
