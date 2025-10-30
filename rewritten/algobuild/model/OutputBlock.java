package algobuild.model;

import algobuild.parser.ExpressionEvaluator;

/**
 * Blocco di output: stampa il valore di un'espressione
 * Esempio: output x, output "Risultato: " + result
 */
public class OutputBlock extends Block {

    private String expression;

    public OutputBlock(String expression) {
        super();
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public Block execute(ExecutionContext context) throws Exception {
        context.log("Executing OUTPUT: " + expression);

        // Valuta l'espressione
        Object value = ExpressionEvaluator.evaluate(expression, context);

        // Stampa il risultato
        context.writeOutput(String.valueOf(value));

        context.log("  -> " + value);

        // Procedi al blocco successivo
        return nextBlock;
    }

    @Override
    public String getDescription() {
        return "OUTPUT " + expression;
    }

    @Override
    public String getType() {
        return "OUTPUT";
    }
}
