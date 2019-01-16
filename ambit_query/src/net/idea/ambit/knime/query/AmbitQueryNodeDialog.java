package net.idea.ambit.knime.query;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentMultiLineString;
import org.knime.core.node.defaultnodesettings.DialogComponentString;
import org.knime.core.node.defaultnodesettings.DialogComponentStringSelection;
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

	protected AmbitQueryNodeDialog() 
	{
		super();

		SettingsModelString studyGroupSettingsModel =	new SettingsModelString(AmbitQueryNodeModel.CFGKEY_STUDY_CATEGORY, AmbitConst.study_categoty[0]);

		DialogComponentStringSelection studyTypeDialogComponent = new DialogComponentStringSelection( 
				new SettingsModelString(AmbitQueryNodeModel.CFGKEY_STUDY_TYPE, AmbitConst.default_study_types_value),
				"Study type:", AmbitConst.ecotox_study_types);

		studyGroupSettingsModel.addChangeListener(new ChangeListener() {
			public void stateChanged(final ChangeEvent e) {
				
					if(studyGroupSettingsModel.getStringValue()=="Ecotox") {
						studyTypeDialogComponent.replaceListItems(new ArrayList<String>(Arrays.asList(AmbitConst.ecotox_study_types)),AmbitConst.ecotox_study_types[0]);
					}
					else if(studyGroupSettingsModel.getStringValue()=="Tox") {
						studyTypeDialogComponent.replaceListItems(new ArrayList<String>(Arrays.asList(AmbitConst.tox_study_types)),AmbitConst.tox_study_types[0]);
					}
					else if(studyGroupSettingsModel.getStringValue()=="Phychem") {
						studyTypeDialogComponent.replaceListItems(new ArrayList<String>(Arrays.asList(AmbitConst.phychem_study_types)),AmbitConst.phychem_study_types[0]);
					}
					else if(studyGroupSettingsModel.getStringValue()=="Environmental fate") {
						studyTypeDialogComponent.replaceListItems(new ArrayList<String>(Arrays.asList(AmbitConst.environmental_fate_study_types)),AmbitConst.environmental_fate_study_types[0]);
					}
				}
			
		}); 


		createNewGroup("Ambit");

		addDialogComponent(new DialogComponentString(
				new SettingsModelString(AmbitQueryNodeModel.CFGKEY_AMBIT_DB_URL, AmbitConst.default_ambit_db_url), 
				"Ambit database url:"));
		closeCurrentGroup();

		createNewGroup("Study");

		addDialogComponent(new DialogComponentStringSelection( 
				studyGroupSettingsModel,
				"Category:", AmbitConst.study_categoty)); 

		addDialogComponent(studyTypeDialogComponent); 

		closeCurrentGroup();

		createNewGroup("Search");

		addDialogComponent(new DialogComponentStringSelection(
				new SettingsModelString(AmbitQueryNodeModel.CFGKEY_QUERY_TYPE, AmbitConst.query_types[0]),
				"Search type:", AmbitConst.query_types));

		addDialogComponent(new DialogComponentMultiLineString(new SettingsModelString(
				AmbitQueryNodeModel.CFGKEY_CHEM_OBJECT_ID, "50-00-0"), "ChemObject IDs:"));

		closeCurrentGroup();
	}
}

