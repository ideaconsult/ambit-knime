package net.idea.ambit.knime.rest.connectionsetting;

import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentNumber;
import org.knime.core.node.defaultnodesettings.SettingsModelIntegerBounded;

/**
 * <code>NodeDialog</code> for the "AmbitConnectionSetting" Node.
 * 
 *
 * This node dialog derives from {@link DefaultNodeSettingsPane} which allows
 * creation of a simple dialog with standard components. If you need a more 
 * complex dialog please derive directly from 
 * {@link org.knime.core.node.NodeDialogPane}.
 * 
 * @author Ideaconsult, University of Plovdiv
 */
public class AmbitConnectionSettingNodeDialog extends DefaultNodeSettingsPane {

    /**
     * New pane for configuring AmbitConnectionSetting node dialog.
     * This is just a suggestion to demonstrate possible default dialog
     * components.
     */
    protected AmbitConnectionSettingNodeDialog() {
        super();
        
        addDialogComponent(new DialogComponentNumber(
                new SettingsModelIntegerBounded(
                    AmbitConnectionSettingNodeModel.CFGKEY_COUNT,
                    AmbitConnectionSettingNodeModel.DEFAULT_COUNT,
                    Integer.MIN_VALUE, Integer.MAX_VALUE),
                    "Counter:", /*step*/ 1, /*componentwidth*/ 5));
                    
    }
}

