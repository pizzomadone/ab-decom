package algobuild.model;

import algobuild.parser.ExpressionEvaluator;

/**
 * Blocco ciclo FOR
 * For variabile = da to fino { corpo }
 * Esempio: for i = 1 to 10
 */
public class ForBlock extends Block {

    private String variableName;
    private String startExpression;
    private String endExpression;
    private String stepExpression;    // Opzionale, default 1
    private Block loopBody;

    public ForBlock(String variableName, String startExpression, String endExpression) {
        this(variableName, startExpression, endExpression, "1");
    }

    public ForBlock(String variableName, String startExpression, String endExpression, String stepExpression) {
        super();
        this.variableName = variableName;
        this.startExpression = startExpression;
        this.endExpression = endExpression;
        this.stepExpression = stepExpression;
    }

    public String getVariableName() {
        return variableName;
    }

    public Block getLoopBody() {
        return loopBody;
    }

    public void setLoopBody(Block loopBody) {
        this.loopBody = loopBody;
    }

    @Override
    public Block execute(ExecutionContext context) throws Exception {
        context.log("Executing FOR: " + variableName + " = " + startExpression + " to " + endExpression);

        // Variabile privata per tracciare se è la prima iterazione
        String forStateVar = "__FOR_" + id + "_INITIALIZED";

        if (!context.hasVariable(forStateVar)) {
            // Prima volta: inizializza la variabile del ciclo
            Object startValue = ExpressionEvaluator.evaluate(startExpression, context);
            context.setVariable(variableName, ExpressionEvaluator.toNumber(startValue));
            context.setVariable(forStateVar, true);
            context.log("  -> Initialized " + variableName + " = " + startValue);
        } else {
            // Iterazioni successive: incrementa la variabile
            Object currentValue = context.getVariable(variableName);
            Object stepValue = ExpressionEvaluator.evaluate(stepExpression, context);

            double newValue = ExpressionEvaluator.toNumber(currentValue) + ExpressionEvaluator.toNumber(stepValue);
            context.setVariable(variableName, newValue);
            context.log("  -> Incremented " + variableName + " = " + newValue);
        }

        // Controlla se continuare
        Object currentValue = context.getVariable(variableName);
        Object endValue = ExpressionEvaluator.evaluate(endExpression, context);

        boolean shouldContinue = ExpressionEvaluator.toNumber(currentValue) <= ExpressionEvaluator.toNumber(endValue);

        if (shouldContinue) {
            // Continua il ciclo
            return loopBody != null ? loopBody : this;
        } else {
            // Esci dal ciclo
            context.setVariable(forStateVar, null);  // Cleanup
            return nextBlock;
        }
    }

    @Override
    public String getDescription() {
        return "FOR " + variableName + " = " + startExpression + " TO " + endExpression;
    }

    @Override
    public String getType() {
        return "FOR";
    }
}
