package net.idea.ambit.knime.query;

import java.io.File;
import java.io.IOException;

import org.knime.core.data.DataCell;
import org.knime.core.data.DataColumnSpec;
import org.knime.core.data.DataColumnSpecCreator;
import org.knime.core.data.DataRow;
import org.knime.core.data.DataTableSpec;
import org.knime.core.data.RowKey;
import org.knime.core.data.def.DefaultRow;
import org.knime.core.data.def.DoubleCell;
import org.knime.core.data.def.IntCell;
import org.knime.core.data.def.StringCell;
import org.knime.core.node.BufferedDataContainer;
import org.knime.core.node.BufferedDataTable;
import org.knime.core.node.CanceledExecutionException;
import org.knime.core.node.defaultnodesettings.SettingsModelIntegerBounded;
import org.knime.core.node.defaultnodesettings.SettingsModelString;
import org.knime.core.node.ExecutionContext;
import org.knime.core.node.ExecutionMonitor;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeLogger;
import org.knime.core.node.NodeModel;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;


/**
 * This is the model implementation of AmbitQuery.
 * Generates a REST query for Ambit
 *
 * @author Ideaconsult Ltd.
 */
public class AmbitQueryNodeModel extends NodeModel {

	// the logger instance
	private static final NodeLogger logger = NodeLogger
			.getLogger(AmbitQueryNodeModel.class);

	//the settings keys which is used to retrieve and 
	//store the settings (from the dialog or from a settings file)
	static final String CFGKEY_STUDY_TYPE = "STUDY_TYPE";
	static final String CFGKEY_QUERY_TYPE = "QUERY_TYPE";
	static final String CFGKEY_CHEM_OBJECT_ID = "CHEM_OBJECT_ID";
	
	//Model settings handling
	private final SettingsModelString m_studyType = 
			new SettingsModelString(CFGKEY_STUDY_TYPE, "EC_ALGAETOX_SECTION");	
    private final SettingsModelString m_queryType = 
    		new SettingsModelString(CFGKEY_QUERY_TYPE, "bystructure_name");
    private final SettingsModelString m_id = 
    		new SettingsModelString(CFGKEY_CHEM_OBJECT_ID, "50-0-0");

    
	protected AmbitQueryNodeModel() 
	{
		// TODO one incoming port and one outgoing port is assumed
		super(1, 1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected BufferedDataTable[] execute(final BufferedDataTable[] inData,
			final ExecutionContext exec) throws Exception 
	{
		//TODO setup variables .. m_count.getIntValue()
		
		AmbitQueryExecManager execMan = new AmbitQueryExecManager(inData, exec);
		BufferedDataTable result[] = execMan.execute(); 
		
		if (!execMan.warnings.isEmpty())
			setWarningMessage(execMan.getWarningsAsString());
		
		if (!execMan.errors.isEmpty())
			throw new Exception(execMan.getErrorsAsString());
		
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void reset() {
		// TODO Code executed on reset.
		// Models build during execute are cleared here.
		// Also data handled in load/saveInternals will be erased here.
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected DataTableSpec[] configure(final DataTableSpec[] inSpecs)
			throws InvalidSettingsException {

		// TODO: check if user settings are available, fit to the incoming
		// table structure, and the incoming types are feasible for the node
		// to execute. If the node can execute in its current state return
		// the spec of its output data table(s) (if you can, otherwise an array
		// with null elements), or throw an exception with a useful user message

		return new DataTableSpec[]{null};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void saveSettingsTo(final NodeSettingsWO settings) 
	{
		m_studyType.saveSettingsTo(settings);
		m_queryType.saveSettingsTo(settings);
		m_id.saveSettingsTo(settings);		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void loadValidatedSettingsFrom(final NodeSettingsRO settings)
			throws InvalidSettingsException 
	{
		m_studyType.loadSettingsFrom(settings);
		m_queryType.loadSettingsFrom(settings);
		m_id.loadSettingsFrom(settings);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void validateSettings(final NodeSettingsRO settings)
			throws InvalidSettingsException 
	{
		m_studyType.validateSettings(settings);
		m_queryType.validateSettings(settings);
		m_id.validateSettings(settings);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void loadInternals(final File internDir,
			final ExecutionMonitor exec) throws IOException,
	CanceledExecutionException {

		// TODO load internal data. 
		// Everything handed to output ports is loaded automatically (data
		// returned by the execute method, models loaded in loadModelContent,
		// and user settings set through loadSettingsFrom - is all taken care 
		// of). Load here only the other internals that need to be restored
		// (e.g. data used by the views).

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void saveInternals(final File internDir,
			final ExecutionMonitor exec) throws IOException,
	CanceledExecutionException {

		// TODO save internal models. 
		// Everything written to output ports is saved automatically (data
		// returned by the execute method, models saved in the saveModelContent,
		// and user settings saved through saveSettingsTo - is all taken care 
		// of). Save here only the other internals that need to be preserved
		// (e.g. data used by the views).

	}

}

