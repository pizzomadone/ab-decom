package algobuild.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Rappresenta un algoritmo completo.
 * Un algoritmo è una sequenza di blocchi con un nome.
 */
public class Algorithm {

    private String name;
    private Block firstBlock;
    private List<String> inputVariables;
    private String returnVariable;

    public Algorithm(String name) {
        this.name = name;
        this.inputVariables = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Block getFirstBlock() {
        return firstBlock;
    }

    public void setFirstBlock(Block firstBlock) {
        this.firstBlock = firstBlock;
    }

    public List<String> getInputVariables() {
        return inputVariables;
    }

    public void addInputVariable(String varName) {
        inputVariables.add(varName);
    }

    public String getReturnVariable() {
        return returnVariable;
    }

    public void setReturnVariable(String returnVariable) {
        this.returnVariable = returnVariable;
    }

    /**
     * Conta il numero totale di blocchi nell'algoritmo
     */
    public int countBlocks() {
        int count = 0;
        Block current = firstBlock;
        while (current != null) {
            count++;
            current = current.getNextBlock();
        }
        return count;
    }

    /**
     * Ritorna una rappresentazione testuale dell'algoritmo
     */
    public String toText() {
        StringBuilder sb = new StringBuilder();
        sb.append("ALGORITHM: ").append(name).append("\n");

        if (!inputVariables.isEmpty()) {
            sb.append("INPUT: ").append(String.join(", ", inputVariables)).append("\n");
        }

        sb.append("\nBLOCKS:\n");
        Block current = firstBlock;
        int blockNum = 1;
        while (current != null) {
            sb.append("  ").append(blockNum++).append(". ");
            sb.append(current.getDescription()).append("\n");
            current = current.getNextBlock();
        }

        if (returnVariable != null) {
            sb.append("\nRETURN: ").append(returnVariable).append("\n");
        }

        return sb.toString();
    }
}
