package algobuild.model.blocks;

import algobuild.execution.ExecutionContext;
import algobuild.util.ExpressionEvaluator;

/**
 * Blocco di assegnazione: x = espressione
 * Equivalente a: a.c.b.a nell'originale
 * Type ID: ABIASS
 * Shape: RECTANGLE
 */
public class AssignmentBlock extends Block {

    private String variableName;
    private String expression;

    public AssignmentBlock(String variableName, String expression) {
        super("ABIASS");
        this.variableName = variableName;
        this.expression = expression;
    }

    @Override
    public Block execute(ExecutionContext context) throws Exception {
        // Valuta l'espressione
        Object value = ExpressionEvaluator.evaluate(expression, context);

        // Assegna alla variabile
        context.setVariable(variableName, value);

        // Ritorna il prossimo blocco in sequenza
        return getNextBlock();
    }

    @Override
    public String getDescription() {
        return variableName + " = " + expression;
    }

    @Override
    public BlockShape getShape() {
        return BlockShape.RECTANGLE;
    }

    @Override
    public String getDisplayText() {
        return variableName + " = " + expression;
    }

    // ========== Getters/Setters ==========

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public boolean validate() {
        // Controlla che il nome variabile sia valido
        if (variableName == null || variableName.trim().isEmpty()) {
            return false;
        }

        // Controlla che l'espressione non sia vuota
        if (expression == null || expression.trim().isEmpty()) {
            return false;
        }

        return true;
    }
}
