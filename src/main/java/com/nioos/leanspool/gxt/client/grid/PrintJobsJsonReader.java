package com.nioos.leanspool.gxt.client.grid;



import java.util.List;

import com.nioos.leanspool.gxt.shared.Errors;
import com.nioos.leanspool.gwt.shared.PrintJobModel;
import com.nioos.leanspool.gxt.client.tree.ErrorDialog;
import com.sencha.gxt.data.shared.loader.JsonReader;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoadResultBean;



/**
 * Print jobs json reader.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class PrintJobsJsonReader extends
		JsonReader<PagingLoadResult<PrintJobModel>, PrintJobsJsonRoot> {
	
	
	/**
	 * Constructor.
	 */
	public PrintJobsJsonReader() {
		super(PrintJobsAutoBeanFactory.INSTANCE, PrintJobsJsonRoot.class);
	}
	
	
	@Override
	protected final PagingLoadResult<PrintJobModel> createReturnData(
			final Object loadConfig,
			final PrintJobsJsonRoot records) {
		final Errors errorCode = records.getErrorCode();
		if (errorCode != null) {
			new ErrorDialog(errorCode);
		}
		final List<PrintJobModel> jobList = records.getJobs();
		return new PagingLoadResultBean<PrintJobModel>(jobList,
			records.getTotalLen(), records.getOffset());
	}
	
	
}
