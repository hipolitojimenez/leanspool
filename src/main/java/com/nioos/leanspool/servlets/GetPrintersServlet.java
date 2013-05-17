package com.nioos.leanspool.servlets;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class GetPrintersServlet
 */
public class GetPrintersServlet extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2196005984475478275L;
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String result = "{\"printers\": [{\"key\": \"Key 01\"},	{\"key\": \"Key 02\"}, {\"key\": \"Key 03\"}]}";
		response.getWriter().print(result);
	}
	
	
}
