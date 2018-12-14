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
		StringBuffer sb = new StringBuffer();
		//DB url
		String dbUrl = ((String)variables.get(AmbitQueryNodeModel.CFGKEY_AMBIT_DB_URL)).trim();
		sb.append(dbUrl);
		if (!dbUrl.endsWith("/"))
			sb.append("/");
		
		//Investigation, search and query type
		sb.append("investigation?");
		sb.append("search=" + variables.get(AmbitQueryNodeModel.CFGKEY_STUDY_TYPE));
		sb.append("&type=" + variables.get(AmbitQueryNodeModel.CFGKEY_QUERY_TYPE));
		
		//Chem objects ids
		String idsMultiLine = (String)variables.get(AmbitQueryNodeModel.CFGKEY_CHEM_OBJECT_ID);
		String ids[] = idsMultiLine.split("[\\r\\n]+");
		for (int i = 0; i < ids.length; i++)
		{
			String id = ids[i].trim();
			if (id.isEmpty())
				continue;
			sb.append("&id=" + id);
		}
		
		return sb.toString();
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
