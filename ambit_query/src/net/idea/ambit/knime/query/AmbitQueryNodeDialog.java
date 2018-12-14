package net.idea.ambit.knime.query;

import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentMultiLineString;
import org.knime.core.node.defaultnodesettings.DialogComponentNumber;
import org.knime.core.node.defaultnodesettings.DialogComponentStringSelection;
import org.knime.core.node.defaultnodesettings.SettingsModelIntegerBounded;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

/**
 * <code>NodeDialog</code> for the "AmbitQuery" Node.
 * Generates a REST query for Ambit
 *
 * This node dialog derives from {@link DefaultNodeSettingsPane} which allows
 * creation of a simple dialog with standard components. If you need a more 
 * complex dialog please derive directly from 
 * {@link org.knime.core.node.NodeDialogPane}.
 * 
 * @author Ideaconsult Ltd.
 */
public class AmbitQueryNodeDialog extends DefaultNodeSettingsPane 
{

	/**
	 * New pane for configuring AmbitQuery node dialog.
	 * This is just a suggestion to demonstrate possible default dialog
	 * components.
	 */
	
	
	protected AmbitQueryNodeDialog() 
	{
		super();
		
		addDialogComponent(new DialogComponentStringSelection( 
				new SettingsModelString(AmbitQueryNodeModel.CFGKEY_STUDY_TYPE, AmbitConst.study_types[0]),
				"Study:", AmbitConst.study_types)); 
				
		addDialogComponent(new DialogComponentStringSelection(
				new SettingsModelString(AmbitQueryNodeModel.CFGKEY_QUERY_TYPE, AmbitConst.query_types[0]),
				"Search type:", AmbitConst.query_types));
		
		addDialogComponent(new DialogComponentMultiLineString(new SettingsModelString(
				AmbitQueryNodeModel.CFGKEY_CHEM_OBJECT_ID, "50-00-0"), "ChemObject IDs:"));
		
		closeCurrentGroup();
	}
}

