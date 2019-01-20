package net.idea.ambit.knime.query;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentBoolean;
import org.knime.core.node.defaultnodesettings.DialogComponentMultiLineString;
import org.knime.core.node.defaultnodesettings.DialogComponentString;
import org.knime.core.node.defaultnodesettings.DialogComponentStringSelection;
import org.knime.core.node.defaultnodesettings.SettingsModelBoolean;
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

		SettingsModelString studyGroupSettingsModel = new SettingsModelString(AmbitQueryNodeModel.CFGKEY_STUDY_CATEGORY, AmbitConst.study_categoty[0]);
		SettingsModelString queryTypeSettingsModel = new SettingsModelString(AmbitQueryNodeModel.CFGKEY_QUERY_TYPE, AmbitConst.query_types[0]);
		SettingsModelBoolean pagingEnabled = new SettingsModelBoolean(AmbitQueryNodeModel.PAGING_ENABLED, false);
		SettingsModelString pageSettingsModel = new SettingsModelString(AmbitQueryNodeModel.PAGE, AmbitConst.page);
		pageSettingsModel.setEnabled(false);
		SettingsModelString pageSizeSettingsModel = new SettingsModelString(AmbitQueryNodeModel.PAGE_SIZE, AmbitConst.page_size);
		pageSizeSettingsModel.setEnabled(false);
		
		
		DialogComponentStringSelection studyTypeDialogComponent = new DialogComponentStringSelection( 
				new SettingsModelString(AmbitQueryNodeModel.CFGKEY_STUDY_TYPE, AmbitConst.default_study_types_value),
				"Study type:", AmbitConst.ecotox_study_types);
		
		DialogComponentStringSelection queryTypeDialogComponent = new DialogComponentStringSelection(
				queryTypeSettingsModel,
				"Search type:", AmbitConst.query_types);
		
		DialogComponentMultiLineString chemObjectIdSettingsModel = new DialogComponentMultiLineString(new SettingsModelString(
				AmbitQueryNodeModel.CFGKEY_CHEM_OBJECT_ID, "50-00-0"), "ChemObject IDs:");
		
		DialogComponentBoolean pagingEnabledDialogComponent = new DialogComponentBoolean(pagingEnabled, "Enable paging");
		DialogComponentString pageDialog = new DialogComponentString(pageSettingsModel, 
				"Page:");
		 DialogComponentString pageSizeDialog = new DialogComponentString(pageSizeSettingsModel,"PageSize:");
		
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
		
		queryTypeSettingsModel.addChangeListener(new ChangeListener() {
			public void stateChanged(final ChangeEvent e) {
				
					if(queryTypeSettingsModel.getStringValue()=="bystudytype") {
						chemObjectIdSettingsModel.setEnabled(false);
						chemObjectIdSettingsModel.getComponentPanel().setVisible(false);
						//chemObjectIdSettingsModel.getComponentPanel().setEnabled(false);
					}
					else {
						chemObjectIdSettingsModel.setEnabled(true);
						chemObjectIdSettingsModel.getComponentPanel().setVisible(true);
						//chemObjectIdSettingsModel.getComponentPanel().setEnabled(true);
					}
					 
				}
			
		}); 
		pagingEnabled.addChangeListener(new ChangeListener() {
			public void stateChanged(final ChangeEvent e) {
				
				if(pagingEnabledDialogComponent.isSelected()) {
					pageSettingsModel.setEnabled(true);
					pageSizeSettingsModel.setEnabled(true);
				}
				else {
					pageSettingsModel.setEnabled(false);
					pageSizeSettingsModel.setEnabled(false);
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

		addDialogComponent(queryTypeDialogComponent);

		addDialogComponent(chemObjectIdSettingsModel);

		closeCurrentGroup();
				
		createNewGroup("Paging");
		addDialogComponent(pagingEnabledDialogComponent);
		addDialogComponent(pageDialog);

		addDialogComponent(pageSizeDialog);

		closeCurrentGroup();
	}
}

