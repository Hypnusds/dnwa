package org.doneta.base.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.doneta.util.config.SpringContextUtils;

/**
 * 底层控制器,初始化SpringContextUtils类
 * @author Hypnusds
 */
public abstract class BaseControl extends HttpServlet {

	private static final long serialVersionUID = 4197272398704803973L;

	protected SpringContextUtils springContextUtils;
	protected static final Logger log = Logger.getLogger(BaseControl.class);

	public void init() throws ServletException {
		springContextUtils = SpringContextUtils.getInstance();
		log.info(this.getClass().getName() + " initialization completed");
	}

	public abstract void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
