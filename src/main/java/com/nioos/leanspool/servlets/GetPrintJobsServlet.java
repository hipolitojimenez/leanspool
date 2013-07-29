package com.nioos.leanspool.servlets;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.nioos.leanspool.dao.DaoException;
import com.nioos.leanspool.dao.SortAndPaginationParameters;
import com.nioos.leanspool.dao.SortParameters;
import com.nioos.leanspool.gxt.shared.Errors;
import com.nioos.leanspool.gxt.shared.PrintJobModel;
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
		final SortParameters sortParameters =
			new SortParameters(sortField, sortDir);
		final SortAndPaginationParameters sapp = // NOPMD
			new SortAndPaginationParameters(sortParameters);
		boolean hasParameter = false; // NOPMD
		final String printer = req.getParameter("printer");
		if (printer != null) {
			hasParameter = true; // NOPMD
		}
		final String status = req.getParameter("status");
		if (status != null) {
			hasParameter = true;
		}
		try {
			List<PrintJobModel> printJobList = // NOPMD
				new ArrayList<PrintJobModel>();
			if (hasParameter) {
				if (printer != null) {
					printJobList = // NOPMD
						printJobsDao.getPrintJobsForPrinter(printer, sapp);
				}
				if (status != null) {
					printJobList =
						printJobsDao.getPrintJobsForStatus(status, sapp);
				}
			} else {
				printJobList = printJobsDao.getPrintJobs(sapp);
			}
			final Map<String, List<PrintJobModel>> printJobModelMap =
					Collections.singletonMap("jobs", printJobList);
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
