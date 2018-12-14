package net.idea.ambit.knime.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.knime.core.node.ExecutionContext;

public class AmbitQueryExecManager 
{
	public Map<String,Object> variables = new HashMap<String,Object>();
	public BufferedDataTable[] inData = null;
	public ExecutionContext exec = null;
	public List<String> warnings = new ArrayList<String>();
	public List<String> errors = new ArrayList<String>();
	
	public AmbitQueryExecManager(BufferedDataTable[] inData, ExecutionContext exec)
	{
		this.inData = inData;
		this.exec = exec;
	}
	
	public BufferedDataTable[] execute() throws Exception 
	{
		//Setup table specification
		DataColumnSpec[] allColSpecs = new DataColumnSpec[1];
		allColSpecs[0] = 
				new DataColumnSpecCreator("AmbitQueryURL", StringCell.TYPE).createSpec();		
		DataTableSpec outputSpec = new DataTableSpec(allColSpecs);
		
		//Calculate output table
		String query = generateQuery();
		
		BufferedDataContainer container = exec.createDataContainer(outputSpec);
		RowKey key = new RowKey("Row 1");
		DataCell[] cells = new DataCell[1];
		cells[0] = new StringCell(query);
		DataRow row = new DefaultRow(key, cells);
		container.addRowToTable(row);
		container.close();
        BufferedDataTable out = container.getTable();
        return new BufferedDataTable[]{out};
	}
	
	String generateQuery()
	{
		String outputURL = 
				"https://apps.ideaconsult.net/data/" 
					+ "investigation?"
					+ "search=" + variables.get(AmbitQueryNodeModel.CFGKEY_STUDY_TYPE)
					+ "type=" + variables.get(AmbitQueryNodeModel.CFGKEY_QUERY_TYPE);
		
		return outputURL;
	}
	
	public String getWarningsAsString() {
		StringBuffer sb = new StringBuffer();
		for (String warn: warnings)
			sb.append(warn + "; ");
		return sb.toString();
	}
	
	public String getErrorsAsString() {
		StringBuffer sb = new StringBuffer();
		for (String err: errors)
			sb.append(err + "; ");
		return sb.toString();
	}
}
