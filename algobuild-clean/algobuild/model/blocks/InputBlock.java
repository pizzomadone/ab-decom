package algobuild.model.blocks;

import algobuild.execution.ExecutionContext;

/**
 * Blocco di input: READ variabile
 * Equivalente a: a.c.b.i nell'originale
 * Type ID: ABIINP
 * Shape: PARALLELOGRAM
 */
public class InputBlock extends Block {

    private String variableName;
    private String prompt; // Opzionale: testo da mostrare prima dell'input

    public InputBlock(String variableName) {
        super("ABIINP");
        this.variableName = variableName;
        this.prompt = null;
    }

    public InputBlock(String variableName, String prompt) {
        super("ABIINP");
        this.variableName = variableName;
        this.prompt = prompt;
    }

    @Override
    public Block execute(ExecutionContext context) throws Exception {
        // Mostra il prompt se presente
        if (prompt != null && !prompt.isEmpty()) {
            context.print(prompt + ": ");
        }

        // Legge l'input
        String input = context.readLine();

        // Tenta di convertire in numero, altrimenti lascia come stringa
        Object value;
        try {
            if (input.contains(".")) {
                value = Double.parseDouble(input);
            } else {
                value = Integer.parseInt(input);
            }
        } catch (NumberFormatException e) {
            value = input;
        }

        // Assegna alla variabile
        context.setVariable(variableName, value);

        // Ritorna il prossimo blocco
        return getNextBlock();
    }

    @Override
    public String getDescription() {
        return "READ " + variableName;
    }

    @Override
    public BlockShape getShape() {
        return BlockShape.PARALLELOGRAM;
    }

    @Override
    public String getDisplayText() {
        if (prompt != null && !prompt.isEmpty()) {
            return "READ " + variableName + " (\"" + prompt + "\")";
        }
        return "READ " + variableName;
    }

    // ========== Getters/Setters ==========

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    @Override
    public boolean validate() {
        return variableName != null && !variableName.trim().isEmpty();
    }
}
