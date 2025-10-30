package algobuild.model.blocks;

import algobuild.execution.ExecutionContext;
import algobuild.util.ExpressionEvaluator;

/**
 * Blocco WHILE loop.
 * Equivalente a: a.c.b.g nell'originale
 * Type ID: ABIWHI
 * Shape: COMPOSITE
 *
 * Struttura:
 * - condition: espressione booleana
 * - body: primo child (indice 0) - blocco da ripetere
 */
public class WhileBlock extends Block {

    private String condition;

    public WhileBlock(String condition) {
        super("ABIWHI");
        this.condition = condition;
    }

    @Override
    public Block execute(ExecutionContext context) throws Exception {
        // Valuta la condizione
        Object result = ExpressionEvaluator.evaluate(condition, context);
        boolean conditionValue = ExpressionEvaluator.toBoolean(result);

        // Se la condizione è vera, esegui il body
        if (conditionValue) {
            Block body = getBody();
            if (body != null) {
                // Esegui il body, poi ritorna a questo blocco per ricontrollare la condizione
                context.setCurrentBlock(this);
                return body;
            }
        }

        // Condizione falsa, esci dal loop
        return getNextBlock();
    }

    @Override
    public String getDescription() {
        return "WHILE " + condition;
    }

    @Override
    public BlockShape getShape() {
        return BlockShape.COMPOSITE;
    }

    @Override
    public String getDisplayText() {
        return "WHILE " + condition;
    }

    // ========== Body Methods ==========

    /**
     * Ritorna il body del loop (primo child).
     */
    public Block getBody() {
        return getChildAt(0);
    }

    /**
     * Imposta il body del loop (primo child).
     */
    public void setBody(Block body) {
        if (getChildCount() == 0) {
            addChild(body);
        } else {
            getChildren().set(0, body);
        }
    }

    // ========== Getters/Setters ==========

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public boolean validate() {
        return condition != null && !condition.trim().isEmpty();
    }
}
