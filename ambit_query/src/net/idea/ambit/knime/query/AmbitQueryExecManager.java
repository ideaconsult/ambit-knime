package net.idea.ambit.knime.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		//TODO
		return null;
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
