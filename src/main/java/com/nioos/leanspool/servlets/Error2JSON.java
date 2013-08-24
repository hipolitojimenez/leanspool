package com.nioos.leanspool.servlets;



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.nioos.leanspool.gxt.shared.Errors;
import com.nioos.leanspool.gwt.shared.PrinterModel;



/**
 * Utility class to handle errors as json data.
 * @author Hipolito Jimenez.
 */
public final class Error2JSON {
	
	
	/**
	 * Constructor.
	 */
	private Error2JSON() {
		//
	}
	
	
	/**
	 * Sends an HTTP error.
	 * @param resp the response.
	 * @param errorCode the error code.
	 * @throws IOException on error.
	 */
	public static void send(final HttpServletResponse resp,
			final Errors errorCode) throws IOException {
		final Map<String, Object> error = new HashMap<String, Object>();
		error.put("jobs", new ArrayList<PrinterModel>());
		error.put("errorCode", errorCode);
		final JSONObject jsonObject = JSONObject.fromObject(error);
		final String result = jsonObject.toString();
		resp.getWriter().print(result);
	}
	
	
}
