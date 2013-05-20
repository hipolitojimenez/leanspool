package com.nioos.leanspool.servlets;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Get the printers servlet.
 * @author Hipolito Jimenez.
 *
 */
public class GetPrintersServlet extends HttpServlet {
	
	
	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 2196005984475478275L;
	
	
	@Override
	protected final void doGet(final HttpServletRequest request,
				final HttpServletResponse response) throws ServletException,
			IOException {
		// TODO Auto-generated method stub
		String result = "{\"printers\": [{\"key\": \"Key 01\"},	{\"key\": \"Key 02\"}, {\"key\": \"Key 03\"}]}";
		response.getWriter().print(result);
	}
	
	
}
