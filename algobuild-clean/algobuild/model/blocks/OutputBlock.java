package algobuild.model.blocks;

import algobuild.execution.ExecutionContext;
import algobuild.util.ExpressionEvaluator;

/**
 * Blocco di output: WRITE espressione
 * Equivalente a: a.c.b.j nell'originale
 * Type ID: ABIOUT
 * Shape: PARALLELOGRAM
 */
public class OutputBlock extends Block {

    private String expression;
    private boolean newLine; // true per println, false per print

    public OutputBlock(String expression) {
        super("ABIOUT");
        this.expression = expression;
        this.newLine = true; // Default: con newline
    }

    public OutputBlock(String expression, boolean newLine) {
        super("ABIOUT");
        this.expression = expression;
        this.newLine = newLine;
    }

    @Override
    public Block execute(ExecutionContext context) throws Exception {
        // Valuta l'espressione
        Object value = ExpressionEvaluator.evaluate(expression, context);

        // Stampa il valore
        if (newLine) {
            context.println(String.valueOf(value));
        } else {
            context.print(String.valueOf(value));
        }

        // Ritorna il prossimo blocco
        return getNextBlock();
    }

    @Override
    public String getDescription() {
        return "WRITE " + expression;
    }

    @Override
    public BlockShape getShape() {
        return BlockShape.PARALLELOGRAM;
    }

    @Override
    public String getDisplayText() {
        return "WRITE " + expression;
    }

    // ========== Getters/Setters ==========

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public boolean isNewLine() {
        return newLine;
    }

    public void setNewLine(boolean newLine) {
        this.newLine = newLine;
    }

    @Override
    public boolean validate() {
        return expression != null && !expression.trim().isEmpty();
    }
}
