package algobuild.model.blocks;

import algobuild.execution.ExecutionContext;
import algobuild.util.ExpressionEvaluator;

/**
 * Blocco DO-WHILE loop.
 * Equivalente a: a.c.b.e nell'originale
 * Type ID: ABIDOW
 * Shape: COMPOSITE
 *
 * Differenza da WHILE: esegue il body almeno una volta, poi controlla la condizione.
 *
 * Struttura:
 * - condition: espressione booleana
 * - body: primo child (indice 0) - blocco da ripetere
 */
public class DoWhileBlock extends Block {

    private String condition;

    public DoWhileBlock(String condition) {
        super("ABIDOW");
        this.condition = condition;
    }

    @Override
    public Block execute(ExecutionContext context) throws Exception {
        // Controlla se è la prima esecuzione
        String firstRunKey = "___DO_WHILE_FIRST_" + getPath();
        boolean firstRun = !context.hasVariable(firstRunKey);

        if (firstRun) {
            // Prima esecuzione: esegui sempre il body
            context.setVariable(firstRunKey, true);
            Block body = getBody();
            if (body != null) {
                context.setCurrentBlock(this);
                return body;
            }
        } else {
            // Esecuzioni successive: controlla la condizione
            Object result = ExpressionEvaluator.evaluate(condition, context);
            boolean conditionValue = ExpressionEvaluator.toBoolean(result);

            if (conditionValue) {
                // Condizione vera: ripeti il body
                Block body = getBody();
                if (body != null) {
                    context.setCurrentBlock(this);
                    return body;
                }
            } else {
                // Condizione falsa: esci dal loop
                context.removeVariable(firstRunKey);
            }
        }

        // Esci dal loop
        return getNextBlock();
    }

    @Override
    public String getDescription() {
        return "DO-WHILE " + condition;
    }

    @Override
    public BlockShape getShape() {
        return BlockShape.COMPOSITE;
    }

    @Override
    public String getDisplayText() {
        return "DO-WHILE " + condition;
    }

    // ========== Body Methods ==========

    public Block getBody() {
        return getChildAt(0);
    }

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
