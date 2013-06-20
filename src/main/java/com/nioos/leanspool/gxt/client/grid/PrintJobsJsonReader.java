package com.nioos.leanspool.gxt.client.grid;



import java.util.List;

import com.nioos.leanspool.gxt.client.tree.ErrorDialog;
import com.nioos.leanspool.gxt.shared.Errors;
import com.nioos.leanspool.gxt.shared.PrintJobModel;
import com.sencha.gxt.data.shared.loader.JsonReader;
import com.sencha.gxt.data.shared.loader.ListLoadResult;
import com.sencha.gxt.data.shared.loader.ListLoadResultBean;



/**
 * Print jobs json reader.
 * 
 * @author Hipolito Jimenez.
 *
 */
public class PrintJobsJsonReader extends
		JsonReader<ListLoadResult<PrintJobModel>, PrintJobsJsonRoot> {
	
	
	/**
	 * Constructor.
	 */
	public PrintJobsJsonReader() {
		super(PrintJobsAutoBeanFactory.INSTANCE, PrintJobsJsonRoot.class);
	}
	
	
	@Override
	protected final ListLoadResult<PrintJobModel> createReturnData(
			final Object loadConfig,
			final PrintJobsJsonRoot records) {
		final Errors errorCode = records.getErrorCode();
		if (errorCode != null) {
			new ErrorDialog(errorCode);
		}
		final List<PrintJobModel> jobList = records.getJobs();
		return new ListLoadResultBean<PrintJobModel>(jobList);
	}
	
	
}
