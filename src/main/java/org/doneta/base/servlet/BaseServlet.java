package org.doneta.base.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public abstract class BaseServlet  extends HttpServlet {

	private static final long serialVersionUID = -3965072089257322443L;
	protected static final Logger log = Logger.getLogger(BaseServlet.class);
	
	public BaseServlet() {
        super();
    }

	protected abstract void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void forward(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher(path).forward(request, response);
	}
	
}
