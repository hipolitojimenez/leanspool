package com.nioos.leanspool.servlets;



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.nioos.leanspool.dao.DaoException;
import com.nioos.leanspool.dao.PaginationParameters;
import com.nioos.leanspool.dao.SortAndPaginationParameters;
import com.nioos.leanspool.dao.SortParameters;
import com.nioos.leanspool.gxt.shared.Errors;
import com.nioos.leanspool.gwt.shared.PrintJobModel;
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
	 * @throws DaoException on error.
	 */
	public GetPrintJobsServlet() throws DaoException {
		super();
		printJobsDao = new PrintJobsDao();
	}
	
	
	@Override
	protected final void doGet(final HttpServletRequest req,
				final HttpServletResponse resp)
			throws ServletException, IOException {
		final String sortField = req.getParameter("sortField");
		final String sortDir = req.getParameter("sortDir");
		final int limit = Integer.parseInt(req.getParameter("limit"));
		final int offset = Integer.parseInt(req.getParameter("offset"));
		final SortParameters sortParameters =
			new SortParameters(sortField, sortDir);
		final PaginationParameters pagParameters =
				new PaginationParameters(limit, offset);
		final SortAndPaginationParameters sapp = // NOPMD
			new SortAndPaginationParameters(sortParameters, pagParameters);
		boolean hasParameter = false; // NOPMD
		final String printer = req.getParameter("printer");
		if (printer != null) {
			hasParameter = true; // NOPMD
		}
		final String status = req.getParameter("status");
		if (status != null) {
			hasParameter = true;
		}
		int countOfResults = 0; // NOPMD
		try {
			List<PrintJobModel> printJobList = // NOPMD
				new ArrayList<PrintJobModel>();
			if (hasParameter) {
				if (printer != null) {
					printJobList = // NOPMD
						printJobsDao.getPrintJobsForPrinter(printer, sapp);
					countOfResults = // NOPMD
						printJobsDao.getNumberOfPrintJobsForPrinter(printer);
				}
				if (status != null) {
					printJobList =
						printJobsDao.getPrintJobsForStatus(status, sapp);
					countOfResults =
						printJobsDao.getNumberOfPrintJobsForStatus(status);
				}
			} else {
				printJobList = printJobsDao.getPrintJobs(sapp);
				countOfResults = printJobsDao.getNumberOfPrintJobs();
			}
			final Map<String, Object> printJobModelMap =
				new HashMap<String, Object>(3);
			printJobModelMap.put("jobs", printJobList);
			printJobModelMap.put("totalLen", countOfResults);
			printJobModelMap.put("offset", offset);
			final JSONObject jsonObject =
				JSONObject.fromObject(printJobModelMap);
			final String result = jsonObject.toString();
			resp.getWriter().print(result);
		} catch (PrintJobsException pje) {
			Error2JSON.send(resp, Errors.GETJOBS);
		} catch (DaoException daoEx) {
			Error2JSON.send(resp, Errors.GETJOBS);
		}
	}
	
	
}
