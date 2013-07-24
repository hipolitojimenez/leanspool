package com.nioos.leanspool.servlets;



import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.nioos.leanspool.dao.DaoException;
import com.nioos.leanspool.gxt.shared.Errors;
import com.nioos.leanspool.gxt.shared.PrinterModel;
import com.nioos.leanspool.printer.PrinterDao;
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
	
	
	/**
	 * The printer DAO.
	 */
	private final transient PrinterDao printerDao;
	
	
	/**
	 * Contructor.
	 * @throws DaoException on error. 
	 */
	public GetPrintersServlet() throws DaoException {
		super();
		printerDao = new PrinterDao();
	}
	
	
	@Override
	protected final void doGet(final HttpServletRequest request,
				final HttpServletResponse response) throws ServletException,
			IOException {
		try {
			final List<PrinterModel> printerModelList =
				printerDao.getPrinters();
			final Map<String, List<PrinterModel>> printerModelMap =
					Collections.singletonMap("printers", printerModelList);
			final JSONObject jsonObject =
				JSONObject.fromObject(printerModelMap);
			final String result = jsonObject.toString();
			response.getWriter().print(result);
		} catch (PrintersException prtEx) {
			Error2JSON.send(response, Errors.GETPRINTERS);
		} catch (DaoException daoEx) {
			Error2JSON.send(response, Errors.GETPRINTERS);
		}
	}
	
	
}
