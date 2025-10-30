package algobuild.model;

/**
 * Blocco di input: legge un valore dall'utente e lo assegna a una variabile
 * Esempio: input x, input nome
 */
public class InputBlock extends Block {

    private String variableName;
    private String prompt;

    public InputBlock(String variableName) {
        this(variableName, "Inserisci " + variableName);
    }

    public InputBlock(String variableName, String prompt) {
        super();
        this.variableName = variableName;
        this.prompt = prompt;
    }

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
    public Block execute(ExecutionContext context) throws Exception {
        context.log("Executing INPUT: " + variableName);

        // Leggi input dall'utente
        String input = context.readInput(prompt);

        // Prova a convertire in numero se possibile
        Object value;
        try {
            if (input.contains(".")) {
                value = Double.parseDouble(input);
            } else {
                value = Integer.parseInt(input);
            }
        } catch (NumberFormatException e) {
            // Rimane stringa
            value = input;
        }

        // Assegna alla variabile
        context.setVariable(variableName, value);

        context.log("  -> " + variableName + " = " + value);

        // Procedi al blocco successivo
        return nextBlock;
    }

    @Override
    public String getDescription() {
        return "INPUT " + variableName;
    }

    @Override
    public String getType() {
        return "INPUT";
    }
}
