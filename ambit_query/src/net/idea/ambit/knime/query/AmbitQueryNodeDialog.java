package net.idea.ambit.knime.query;

import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentNumber;
import org.knime.core.node.defaultnodesettings.SettingsModelIntegerBounded;

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
public class AmbitQueryNodeDialog extends DefaultNodeSettingsPane {

    /**
     * New pane for configuring AmbitQuery node dialog.
     * This is just a suggestion to demonstrate possible default dialog
     * components.
     */
    protected AmbitQueryNodeDialog() {
        super();
        
        addDialogComponent(new DialogComponentNumber(
                new SettingsModelIntegerBounded(
                    AmbitQueryNodeModel.CFGKEY_COUNT,
                    AmbitQueryNodeModel.DEFAULT_COUNT,
                    Integer.MIN_VALUE, Integer.MAX_VALUE),
                    "Counter:", /*step*/ 1, /*componentwidth*/ 5));
                    
    }
}

