package net.idea.ambit.knime.rest.connectionsettingrequest;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

/**
 * <code>NodeFactory</code> for the "AmbitConnectionSettingRequest" Node.
 * 
 *
 * @author Ideaconsult, University of Plovdiv
 */
public class AmbitConnectionSettingRequestNodeFactory 
        extends NodeFactory<AmbitConnectionSettingRequestNodeModel> {

    /**
     * {@inheritDoc}
     */
    @Override
    public AmbitConnectionSettingRequestNodeModel createNodeModel() {
        return new AmbitConnectionSettingRequestNodeModel();
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
    public NodeView<AmbitConnectionSettingRequestNodeModel> createNodeView(final int viewIndex,
            final AmbitConnectionSettingRequestNodeModel nodeModel) {
        return new AmbitConnectionSettingRequestNodeView(nodeModel);
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
        return new AmbitConnectionSettingRequestNodeDialog();
    }

}

