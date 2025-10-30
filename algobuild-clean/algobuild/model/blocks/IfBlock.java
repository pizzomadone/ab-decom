package algobuild.model.blocks;

import algobuild.execution.ExecutionContext;
import algobuild.util.ExpressionEvaluator;

/**
 * Blocco condizionale IF.
 * Equivalente a: a.c.b.l nell'originale
 * Type ID: ABIIF_
 * Shape: DIAMOND
 *
 * Struttura:
 * - condition: espressione booleana
 * - trueBranch: primo child (indice 0) - eseguito se condizione vera
 * - falseBranch: secondo child (indice 1) - eseguito se condizione falsa
 */
public class IfBlock extends Block {

    private String condition;

    public IfBlock(String condition) {
        super("ABIIF_");
        this.condition = condition;
    }

    @Override
    public Block execute(ExecutionContext context) throws Exception {
        // Valuta la condizione
        Object result = ExpressionEvaluator.evaluate(condition, context);
        boolean conditionValue = ExpressionEvaluator.toBoolean(result);

        // Se la condizione è vera, esegui il ramo TRUE
        if (conditionValue) {
            Block trueBranch = getTrueBranch();
            if (trueBranch != null) {
                return trueBranch;
            }
        } else {
            // Altrimenti, esegui il ramo FALSE
            Block falseBranch = getFalseBranch();
            if (falseBranch != null) {
                return falseBranch;
            }
        }

        // Dopo l'IF, continua con il blocco successivo
        return getNextBlock();
    }

    @Override
    public String getDescription() {
        return "IF " + condition;
    }

    @Override
    public BlockShape getShape() {
        return BlockShape.DIAMOND;
    }

    @Override
    public String getDisplayText() {
        return condition;
    }

    // ========== Branch Methods ==========

    /**
     * Ritorna il ramo TRUE (primo child).
     */
    public Block getTrueBranch() {
        return getChildAt(0);
    }

    /**
     * Imposta il ramo TRUE (primo child).
     */
    public void setTrueBranch(Block trueBranch) {
        if (getChildCount() == 0) {
            addChild(trueBranch);
        } else {
            getChildren().set(0, trueBranch);
        }
    }

    /**
     * Ritorna il ramo FALSE (secondo child).
     */
    public Block getFalseBranch() {
        return getChildAt(1);
    }

    /**
     * Imposta il ramo FALSE (secondo child).
     */
    public void setFalseBranch(Block falseBranch) {
        if (getChildCount() == 0) {
            addChild(null); // Placeholder per TRUE branch
            addChild(falseBranch);
        } else if (getChildCount() == 1) {
            addChild(falseBranch);
        } else {
            getChildren().set(1, falseBranch);
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
