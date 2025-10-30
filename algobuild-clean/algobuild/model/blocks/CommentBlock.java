package algobuild.model.blocks;

import algobuild.execution.ExecutionContext;

/**
 * Blocco commento.
 * Equivalente a: a.c.b.d nell'originale
 * Type ID: ABICOM
 * Shape: RECTANGLE
 *
 * Non esegue alcuna azione, serve solo per documentazione.
 */
public class CommentBlock extends Block {

    private String comment;

    public CommentBlock(String comment) {
        super("ABICOM");
        this.comment = comment;
    }

    @Override
    public Block execute(ExecutionContext context) throws Exception {
        // I commenti non eseguono nulla, passano direttamente al prossimo blocco
        return getNextBlock();
    }

    @Override
    public String getDescription() {
        return "// " + comment;
    }

    @Override
    public BlockShape getShape() {
        return BlockShape.RECTANGLE;
    }

    @Override
    public String getDisplayText() {
        return comment;
    }

    // ========== Getters/Setters ==========

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean validate() {
        // I commenti sono sempre validi, anche se vuoti
        return true;
    }
}
