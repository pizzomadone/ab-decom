package algobuild.model.blocks;

import algobuild.execution.ExecutionContext;
import algobuild.util.ExpressionEvaluator;

/**
 * Blocco FOR loop.
 * Equivalente a: a.c.b.f nell'originale
 * Type ID: ABIFOR
 * Shape: COMPOSITE
 *
 * Struttura:
 * - variableName: variabile di loop
 * - startExpression: valore iniziale
 * - endExpression: valore finale
 * - stepExpression: incremento (default: 1)
 * - body: primo child (indice 0) - blocco da ripetere
 */
public class ForBlock extends Block {

    private String variableName;
    private String startExpression;
    private String endExpression;
    private String stepExpression;

    public ForBlock(String variableName, String startExpression, String endExpression) {
        super("ABIFOR");
        this.variableName = variableName;
        this.startExpression = startExpression;
        this.endExpression = endExpression;
        this.stepExpression = "1"; // Default step
    }

    public ForBlock(String variableName, String startExpression, String endExpression, String stepExpression) {
        super("ABIFOR");
        this.variableName = variableName;
        this.startExpression = startExpression;
        this.endExpression = endExpression;
        this.stepExpression = stepExpression;
    }

    @Override
    public Block execute(ExecutionContext context) throws Exception {
        // Controlla se il loop è già inizializzato
        String loopInitKey = "___FOR_INIT_" + getPath();
        boolean initialized = context.hasVariable(loopInitKey);

        if (!initialized) {
            // Prima esecuzione: inizializza la variabile di loop
            Object startValue = ExpressionEvaluator.evaluate(startExpression, context);
            context.setVariable(variableName, startValue);
            context.setVariable(loopInitKey, true);
        } else {
            // Incrementa la variabile di loop
            Object currentValue = context.getVariable(variableName);
            Object stepValue = ExpressionEvaluator.evaluate(stepExpression, context);

            double current = ExpressionEvaluator.toNumber(currentValue);
            double step = ExpressionEvaluator.toNumber(stepValue);

            context.setVariable(variableName, current + step);
        }

        // Controlla la condizione di fine
        Object endValue = ExpressionEvaluator.evaluate(endExpression, context);
        double current = ExpressionEvaluator.toNumber(context.getVariable(variableName));
        double end = ExpressionEvaluator.toNumber(endValue);
        double step = ExpressionEvaluator.toNumber(
            ExpressionEvaluator.evaluate(stepExpression, context)
        );

        boolean shouldContinue;
        if (step > 0) {
            shouldContinue = current <= end;
        } else {
            shouldContinue = current >= end;
        }

        if (shouldContinue) {
            // Esegui il body
            Block body = getBody();
            if (body != null) {
                context.setCurrentBlock(this);
                return body;
            }
        } else {
            // Fine loop: pulisci la variabile di inizializzazione
            context.removeVariable(loopInitKey);
        }

        // Esci dal loop
        return getNextBlock();
    }

    @Override
    public String getDescription() {
        return "FOR " + variableName + " = " + startExpression + " TO " + endExpression + " STEP " + stepExpression;
    }

    @Override
    public BlockShape getShape() {
        return BlockShape.COMPOSITE;
    }

    @Override
    public String getDisplayText() {
        String text = "FOR " + variableName + " = " + startExpression + " TO " + endExpression;
        if (!stepExpression.equals("1")) {
            text += " STEP " + stepExpression;
        }
        return text;
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

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getStartExpression() {
        return startExpression;
    }

    public void setStartExpression(String startExpression) {
        this.startExpression = startExpression;
    }

    public String getEndExpression() {
        return endExpression;
    }

    public void setEndExpression(String endExpression) {
        this.endExpression = endExpression;
    }

    public String getStepExpression() {
        return stepExpression;
    }

    public void setStepExpression(String stepExpression) {
        this.stepExpression = stepExpression;
    }

    @Override
    public boolean validate() {
        return variableName != null && !variableName.trim().isEmpty() &&
               startExpression != null && !startExpression.trim().isEmpty() &&
               endExpression != null && !endExpression.trim().isEmpty();
    }
}
