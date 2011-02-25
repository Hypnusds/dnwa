package org.doneta.base.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 核心控制器,继承与BaseControl
 * @author Hypnusds
 */
public class CoreControl extends BaseControl {

	private static final long serialVersionUID = 4481112113440315607L;

	public void init() throws ServletException {
		super.init();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
