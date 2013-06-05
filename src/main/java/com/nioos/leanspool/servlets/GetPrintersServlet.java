package com.nioos.leanspool.servlets;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.nioos.leanspool.gxt.shared.Errors;
import com.nioos.leanspool.gxt.shared.PrinterModel;
import com.nioos.leanspool.printer.Printers;
import com.nioos.leanspool.printer.PrintersException;



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
	
	
	private Printers printers;
	
	
	public GetPrintersServlet() throws PrintersException {
		printers = new Printers();
	}
	
	
	@Override
	protected final void doGet(final HttpServletRequest request,
				final HttpServletResponse response) throws ServletException,
			IOException {
		try {
			List<PrinterModel> printerModelList = printers.getPrinters();
			Map<String, List<PrinterModel>> printerModelMap =
					Collections.singletonMap("printers", printerModelList);
				JSONObject jsonObject = JSONObject.fromObject(printerModelMap);
				String result = jsonObject.toString();
				response.getWriter().print(result);
		} catch (PrintersException prtEx) {
			Map<String, Object> error = new HashMap<String, Object>();
			error.put("printers", new ArrayList<PrinterModel>());
			error.put("errorCode", Errors.GETPRINTERS);
			JSONObject jsonObject = JSONObject.fromObject(error);
			String result = jsonObject.toString();
			response.getWriter().print(result);
		}
	}
	
	
}
