package algobuild.view;

import algobuild.model.Document;
import algobuild.model.blocks.*;
import algobuild.view.blocks.*;

/**
 * Factory per creare le view appropriate per ogni tipo di blocco.
 *
 * Mappa BlockShape alla view corretta:
 * - RECTANGLE -> RectangleBlockView
 * - DIAMOND -> DiamondBlockView
 * - PARALLELOGRAM -> ParallelogramBlockView
 * - COMPOSITE -> CompositeBlockView (TODO)
 */
public class BlockViewFactory {

    /**
     * Crea la view appropriata per un blocco.
     */
    public BaseBlockPanel createView(Block block, Document document) {
        if (block == null) {
            return null;
        }

        Block.BlockShape shape = block.getShape();

        switch (shape) {
            case RECTANGLE:
                return new RectangleBlockView(block, document);

            case DIAMOND:
                if (block instanceof IfBlock) {
                    return new DiamondBlockView(block, document);
                }
                break;

            case PARALLELOGRAM:
                if (block instanceof InputBlock || block instanceof OutputBlock) {
                    return new ParallelogramBlockView(block, document);
                }
                break;

            case COMPOSITE:
                // TODO: Implementare CompositeBlockView per FOR, WHILE, DO-WHILE
                // Per ora usa RectangleBlockView come fallback
                return new RectangleBlockView(block, document);

            default:
                break;
        }

        // Fallback: RectangleBlockView
        return new RectangleBlockView(block, document);
    }

    /**
     * Determina se un blocco può avere figli.
     */
    public boolean canHaveChildren(Block block) {
        return block.getShape() == Block.BlockShape.COMPOSITE;
    }
}
