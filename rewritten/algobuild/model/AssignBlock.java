package algobuild.model;

import algobuild.parser.ExpressionEvaluator;

/**
 * Blocco di assegnazione: variabile = espressione
 * Esempio: x = 5, y = x + 10, name = "Mario"
 */
public class AssignBlock extends Block {

    private String variableName;
    private String expression;

    public AssignBlock(String variableName, String expression) {
        super();
        this.variableName = variableName;
        this.expression = expression;
    }

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
    public Block execute(ExecutionContext context) throws Exception {
        context.log("Executing ASSIGN: " + variableName + " = " + expression);

        // Valuta l'espressione
        Object value = ExpressionEvaluator.evaluate(expression, context);

        // Assegna alla variabile
        context.setVariable(variableName, value);

        context.log("  -> " + variableName + " = " + value);

        // Procedi al blocco successivo
        return nextBlock;
    }

    @Override
    public String getDescription() {
        return variableName + " = " + expression;
    }

    @Override
    public String getType() {
        return "ASSIGN";
    }
}
