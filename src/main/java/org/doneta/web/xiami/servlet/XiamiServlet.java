package org.doneta.web.xiami.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.doneta.base.servlet.BaseServlet;
import org.doneta.web.xiami.bo.XiamiBO;
import org.doneta.web.xiami.dto.TrackInfo;

public class XiamiServlet extends BaseServlet {

	private static final long serialVersionUID = 1181713510537176614L;
	private static final String ERROR = "WEB-INF/jsp/xiami/error.jsp";
	private static final String LISTEN = "WEB-INF/jsp/xiami/xmlisten.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		XiamiBO xiamiBO = XiamiBO.getInstance();
		Object songid = request.getParameter("songid");
		if (songid == null) {
			forward(ERROR, request, response);
			return;
		}
		Object listen = request.getParameter("listen");
		if (listen != null && "true".equals(listen.toString())) {
			TrackInfo info = xiamiBO.getDetailSongInfo(songid.toString());
			if (info == null) {
				forward(ERROR, request, response);
				return;
			}
			request.setAttribute("track", info);
			forward(LISTEN, request, response);
		} else {
			String realPath = xiamiBO.onlyGetPath(songid.toString());
			if (realPath == null) {
				forward(ERROR, request, response);
				return;
			}
			response.sendRedirect(realPath);
		}
	}

}
