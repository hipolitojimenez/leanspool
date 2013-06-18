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
import com.nioos.leanspool.gxt.shared.PrintJobModel;
import com.nioos.leanspool.gxt.shared.PrinterModel;
import com.nioos.leanspool.printjobs.PrintJobsDao;
import com.nioos.leanspool.printjobs.PrintJobsException;



/**
 * Get the print jobs servlet.
 * @author Hipolito Jimenez.
 *
 */
public class GetPrintJobsServlet extends HttpServlet {
	
	
	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1710633749069915649L;
	
	
	/**
	 * The print jobs DAO.
	 */
	private final transient PrintJobsDao printJobsDao;
	
	
	/**
	 * Constructor.
	 * @throws PrintJobsException on error.
	 */
	public GetPrintJobsServlet() throws PrintJobsException {
		super();
		printJobsDao = new PrintJobsDao();
	}
	
	
	@Override
	protected final void doGet(final HttpServletRequest req,
				final HttpServletResponse resp)
			throws ServletException, IOException {
		final String printer = req.getParameter("printer");
		try {
			List<PrintJobModel> printJobList;
			if (printer == null) {
				printJobList = printJobsDao.getPrintJobs();
			} else {
				printJobList = printJobsDao.getPrintJobsForPrinter(printer);
			}
			final Map<String, List<PrintJobModel>> printJobModelMap =
					Collections.singletonMap("jobs", printJobList);
			final JSONObject jsonObject =
				JSONObject.fromObject(printJobModelMap);
			final String result = jsonObject.toString();
			resp.getWriter().print(result);
		} catch (PrintJobsException pje) {
			final Map<String, Object> error = new HashMap<String, Object>();
			error.put("jobs", new ArrayList<PrinterModel>());
			error.put("errorCode", Errors.GETJOBS);
			final JSONObject jsonObject = JSONObject.fromObject(error);
			final String result = jsonObject.toString();
			resp.getWriter().print(result);
		}
	}
	
	
	/*
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
			final Map<String, Object> error = new HashMap<String, Object>();
			error.put("printers", new ArrayList<PrinterModel>());
			error.put("errorCode", Errors.GETPRINTERS);
			final JSONObject jsonObject = JSONObject.fromObject(error);
			final String result = jsonObject.toString();
			response.getWriter().print(result);
		}
	}
	*/
	
	
}
