package net.idea.ambit.knime.json.parse;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;

/**
 * <code>NodeFactory</code> for the "AmbitJsonParser" Node.
 * 
 *
 * @author Ideaconsult Ltd.
 */
public class AmbitJsonParserNodeFactory extends NodeFactory<AmbitJsonParserNodeModel> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AmbitJsonParserNodeModel createNodeModel() {
		return new AmbitJsonParserNodeModel();
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
	public NodeView<AmbitJsonParserNodeModel> createNodeView(final int viewIndex,
			final AmbitJsonParserNodeModel nodeModel) {
		return new AmbitJsonParserNodeView(nodeModel);
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
		return new AmbitJsonParserNodeDialog();
	}

}

