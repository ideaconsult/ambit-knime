package net.idea.ambit.knime.rest.connectionsetting;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

/**
 * <code>NodeFactory</code> for the "AmbitConnectionSetting" Node.
 * 
 *
 * @author Ideaconsult, University of Plovdiv
 */
public class AmbitConnectionSettingNodeFactory 
        extends NodeFactory<AmbitConnectionSettingNodeModel> {

    /**
     * {@inheritDoc}
     */
    @Override
    public AmbitConnectionSettingNodeModel createNodeModel() {
        return new AmbitConnectionSettingNodeModel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getNrNodeViews() {
        return 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NodeView<AmbitConnectionSettingNodeModel> createNodeView(final int viewIndex,
            final AmbitConnectionSettingNodeModel nodeModel) {
        return new AmbitConnectionSettingNodeView(nodeModel);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasDialog() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NodeDialogPane createNodeDialogPane() {
        return new AmbitConnectionSettingNodeDialog();
    }

}

