package net.idea.ambit.knime.query;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

/**
 * <code>NodeFactory</code> for the "AmbitQuery" Node.
 * Generates a REST query for Ambit
 *
 * @author Ideaconsult Ltd.
 */
public class AmbitQueryNodeFactory 
        extends NodeFactory<AmbitQueryNodeModel> {

    /**
     * {@inheritDoc}
     */
    @Override
    public AmbitQueryNodeModel createNodeModel() {
        return new AmbitQueryNodeModel();
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
    public NodeView<AmbitQueryNodeModel> createNodeView(final int viewIndex,
            final AmbitQueryNodeModel nodeModel) {
        return new AmbitQueryNodeView(nodeModel);
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
        return new AmbitQueryNodeDialog();
    }

}

