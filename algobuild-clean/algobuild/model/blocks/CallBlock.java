package algobuild.model.blocks;

import algobuild.execution.ExecutionContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Blocco chiamata a procedura/funzione.
 * Equivalente a: a.c.b.c nell'originale
 * Type ID: ABICAL
 * Shape: RECTANGLE
 */
public class CallBlock extends Block {

    private String procedureName;
    private List<String> arguments;

    public CallBlock(String procedureName) {
        super("ABICAL");
        this.procedureName = procedureName;
        this.arguments = new ArrayList<>();
    }

    public CallBlock(String procedureName, List<String> arguments) {
        super("ABICAL");
        this.procedureName = procedureName;
        this.arguments = arguments;
    }

    @Override
    public Block execute(ExecutionContext context) throws Exception {
        // Trova la procedura/funzione nel documento
        Block procedure = getDocument().findBlockByPath(procedureName);

        if (procedure == null) {
            throw new Exception("Procedura/funzione non trovata: " + procedureName);
        }

        // Crea un nuovo call frame
        ExecutionContext.CallFrame frame = new ExecutionContext.CallFrame(this);

        // TODO: Passare gli argomenti al call frame
        // Per ora salviamo gli argomenti nel contesto

        // Pusha il call frame
        context.pushCallFrame(frame);

        // Esegui la procedura
        return procedure;
    }

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("CALL ").append(procedureName);

        if (!arguments.isEmpty()) {
            sb.append("(");
            for (int i = 0; i < arguments.size(); i++) {
                sb.append(arguments.get(i));
                if (i < arguments.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append(")");
        }

        return sb.toString();
    }

    @Override
    public BlockShape getShape() {
        return BlockShape.RECTANGLE;
    }

    @Override
    public String getDisplayText() {
        return getDescription();
    }

    // ========== Getters/Setters ==========

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public List<String> getArguments() {
        return arguments;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }

    public void addArgument(String argument) {
        arguments.add(argument);
    }

    @Override
    public boolean validate() {
        return procedureName != null && !procedureName.trim().isEmpty();
    }
}
