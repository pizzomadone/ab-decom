package algobuild.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe base per tutti i blocchi algoritmici.
 * Ogni blocco ha un ID, può contenere altri blocchi figli,
 * e ha un blocco successivo nella sequenza.
 */
public abstract class Block {

    protected String id;
    protected Block nextBlock;
    protected List<String> comments;

    public Block() {
        this.id = generateId();
        this.comments = new ArrayList<>();
    }

    private static int idCounter = 0;
    private static String generateId() {
        return "block_" + (idCounter++);
    }

    public String getId() {
        return id;
    }

    public Block getNextBlock() {
        return nextBlock;
    }

    public void setNextBlock(Block nextBlock) {
        this.nextBlock = nextBlock;
    }

    public void addComment(String comment) {
        this.comments.add(comment);
    }

    public List<String> getComments() {
        return comments;
    }

    /**
     * Esegue il blocco e ritorna il prossimo blocco da eseguire.
     * @param context Contesto di esecuzione con variabili e I/O
     * @return Il prossimo blocco da eseguire, o null se finito
     */
    public abstract Block execute(ExecutionContext context) throws Exception;

    /**
     * Ritorna una descrizione testuale del blocco
     */
    public abstract String getDescription();

    /**
     * Tipo del blocco per la serializzazione
     */
    public abstract String getType();
}
