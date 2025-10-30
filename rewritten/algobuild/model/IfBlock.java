package algobuild.model;

import algobuild.parser.ExpressionEvaluator;

/**
 * Blocco condizionale IF-THEN-ELSE
 * Se la condizione è vera esegue il ramo THEN, altrimenti il ramo ELSE
 */
public class IfBlock extends Block {

    private String condition;
    private Block thenBranch;    // Primo blocco del ramo THEN
    private Block elseBranch;    // Primo blocco del ramo ELSE (opzionale)

    public IfBlock(String condition) {
        super();
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Block getThenBranch() {
        return thenBranch;
    }

    public void setThenBranch(Block thenBranch) {
        this.thenBranch = thenBranch;
    }

    public Block getElseBranch() {
        return elseBranch;
    }

    public void setElseBranch(Block elseBranch) {
        this.elseBranch = elseBranch;
    }

    @Override
    public Block execute(ExecutionContext context) throws Exception {
        context.log("Executing IF: " + condition);

        // Valuta la condizione
        Object result = ExpressionEvaluator.evaluate(condition, context);
        boolean isTrue = ExpressionEvaluator.toBoolean(result);

        context.log("  -> Condition is " + isTrue);

        if (isTrue) {
            // Esegui ramo THEN
            return thenBranch != null ? thenBranch : nextBlock;
        } else {
            // Esegui ramo ELSE
            return elseBranch != null ? elseBranch : nextBlock;
        }
    }

    @Override
    public String getDescription() {
        return "IF " + condition;
    }

    @Override
    public String getType() {
        return "IF";
    }
}
