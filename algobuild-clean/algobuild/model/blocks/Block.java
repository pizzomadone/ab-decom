package algobuild.model.blocks;

import algobuild.model.Document;
import algobuild.execution.ExecutionContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe base per tutti i blocchi di AlgoBuild.
 * Equivalente a: a.c.b.* nell'originale
 *
 * Ogni blocco può:
 * - Essere eseguito
 * - Avere blocchi figli (per composite blocks)
 * - Essere serializzato/deserializzato
 * - Fornire informazioni per il rendering
 */
public abstract class Block {

    // Type identifier (es: "ABIASS", "ABIIF_", etc)
    protected String typeId;

    // Parent document
    protected Document document;

    // Path notation (es: "main.0.1")
    protected String path;

    // Child blocks (per composite blocks come IF, FOR, WHILE)
    protected List<Block> children;

    // Next block in sequence
    protected Block nextBlock;

    public Block(String typeId) {
        this.typeId = typeId;
        this.children = new ArrayList<>();
    }

    // ========== Abstract Methods ==========

    /**
     * Esegue questo blocco.
     * @param context Contesto di esecuzione
     * @return Il prossimo blocco da eseguire (o null se fine)
     */
    public abstract Block execute(ExecutionContext context) throws Exception;

    /**
     * Ritorna una descrizione testuale del blocco.
     */
    public abstract String getDescription();

    /**
     * Ritorna il tipo di forma da renderizzare (RECTANGLE, DIAMOND, PARALLELOGRAM).
     */
    public abstract BlockShape getShape();

    /**
     * Ritorna il testo da visualizzare nel blocco.
     */
    public abstract String getDisplayText();

    // ========== Type Methods ==========

    public String getTypeId() {
        return typeId;
    }

    public boolean isAssignment() {
        return typeId.equals("ABIASS");
    }

    public boolean isInput() {
        return typeId.equals("ABIINP");
    }

    public boolean isOutput() {
        return typeId.equals("ABIOUT");
    }

    public boolean isIf() {
        return typeId.equals("ABIIF_");
    }

    public boolean isFor() {
        return typeId.equals("ABIFOR");
    }

    public boolean isWhile() {
        return typeId.equals("ABIWHI");
    }

    public boolean isDoWhile() {
        return typeId.equals("ABIDOW");
    }

    public boolean isComment() {
        return typeId.equals("ABICOM");
    }

    public boolean isCall() {
        return typeId.equals("ABICAL");
    }

    public boolean isProcedure() {
        return typeId.equals("ABRCOD");
    }

    // ========== Document Methods ==========

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    // ========== Path Methods ==========

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    // ========== Children Methods ==========

    public List<Block> getChildren() {
        return children;
    }

    public void addChild(Block child) {
        children.add(child);
        child.setDocument(this.document);
    }

    public void removeChild(Block child) {
        children.remove(child);
    }

    public Block getChildAt(int index) {
        if (index >= 0 && index < children.size()) {
            return children.get(index);
        }
        return null;
    }

    public int getChildCount() {
        return children.size();
    }

    // ========== Next Block Methods ==========

    public Block getNextBlock() {
        return nextBlock;
    }

    public void setNextBlock(Block nextBlock) {
        this.nextBlock = nextBlock;
    }

    // ========== Validation ==========

    /**
     * Valida il blocco (es: sintassi espressioni, variabili, etc).
     * @return true se valido, false altrimenti
     */
    public boolean validate() {
        // Default: valido
        return true;
    }

    // ========== Block Shape Enum ==========

    public enum BlockShape {
        RECTANGLE,      // Assignment, Comment, Call
        DIAMOND,        // IF condition
        PARALLELOGRAM,  // Input, Output
        COMPOSITE       // FOR, WHILE, DO-WHILE (with nested container)
    }

    @Override
    public String toString() {
        return typeId + ": " + getDescription();
    }
}
