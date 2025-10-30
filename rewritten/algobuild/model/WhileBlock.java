package algobuild.model;

import algobuild.parser.ExpressionEvaluator;

/**
 * Blocco ciclo WHILE
 * Ripete il corpo finché la condizione è vera
 */
public class WhileBlock extends Block {

    private String condition;
    private Block loopBody;    // Primo blocco del corpo del ciclo

    public WhileBlock(String condition) {
        super();
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Block getLoopBody() {
        return loopBody;
    }

    public void setLoopBody(Block loopBody) {
        this.loopBody = loopBody;
    }

    @Override
    public Block execute(ExecutionContext context) throws Exception {
        context.log("Executing WHILE: " + condition);

        // Valuta la condizione
        Object result = ExpressionEvaluator.evaluate(condition, context);
        boolean isTrue = ExpressionEvaluator.toBoolean(result);

        context.log("  -> Condition is " + isTrue);

        if (isTrue) {
            // Condizione vera: entra nel corpo del ciclo
            // Dopo aver eseguito il corpo, tornerà a questo while
            return loopBody != null ? loopBody : this;
        } else {
            // Condizione falsa: esci dal ciclo
            return nextBlock;
        }
    }

    @Override
    public String getDescription() {
        return "WHILE " + condition;
    }

    @Override
    public String getType() {
        return "WHILE";
    }
}
