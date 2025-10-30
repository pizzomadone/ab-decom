package algobuild.model;

import algobuild.model.blocks.Block;
import algobuild.execution.ExecutionContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Rappresenta l'intero documento AlgoBuild (algoritmo completo).
 * Equivalente a: a.c.a.b nell'originale
 *
 * Responsabilità:
 * - Gestione del programma principale
 * - Gestione di procedure e funzioni
 * - Opzioni di visualizzazione
 * - Stato di esecuzione
 * - Undo/Redo stack
 */
public class Document {

    // Nome del documento
    private String name;

    // Blocco principale (main)
    private Block mainBlock;

    // Procedure e funzioni
    private List<Block> procedures;
    private List<Block> functions;

    // Opzioni di visualizzazione
    private ViewOptions viewOptions;

    // Execution context
    private ExecutionContext executionContext;

    // Undo/Redo stacks
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;

    // Flag per indicare se il documento è stato modificato
    private boolean modified;

    public Document(String name) {
        this.name = name;
        this.procedures = new ArrayList<>();
        this.functions = new ArrayList<>();
        this.viewOptions = new ViewOptions();
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
        this.modified = false;
    }

    // ========== Main Block Methods ==========

    public Block getMainBlock() {
        return mainBlock;
    }

    public void setMainBlock(Block mainBlock) {
        this.mainBlock = mainBlock;
        setModified(true);
    }

    // ========== Procedure/Function Methods ==========

    public List<Block> getProcedures() {
        return procedures;
    }

    public void addProcedure(Block procedure) {
        procedures.add(procedure);
        setModified(true);
    }

    public void removeProcedure(Block procedure) {
        procedures.remove(procedure);
        setModified(true);
    }

    public List<Block> getFunctions() {
        return functions;
    }

    public void addFunction(Block function) {
        functions.add(function);
        setModified(true);
    }

    public void removeFunction(Block function) {
        functions.remove(function);
        setModified(true);
    }

    /**
     * Trova un blocco per path notation.
     * Path example: "main.0.1" = main -> primo blocco -> secondo blocco
     */
    public Block findBlockByPath(String path) {
        if (path == null || path.isEmpty()) {
            return null;
        }

        String[] parts = path.split("\\.");
        if (parts.length == 0) {
            return null;
        }

        Block current = mainBlock;
        for (int i = 1; i < parts.length && current != null; i++) {
            try {
                int index = Integer.parseInt(parts[i]);
                current = current.getChildAt(index);
            } catch (NumberFormatException e) {
                return null;
            }
        }

        return current;
    }

    // ========== View Options ==========

    public ViewOptions getViewOptions() {
        return viewOptions;
    }

    public void setViewOptions(ViewOptions viewOptions) {
        this.viewOptions = viewOptions;
    }

    // ========== Execution Context ==========

    public ExecutionContext getExecutionContext() {
        return executionContext;
    }

    public void setExecutionContext(ExecutionContext executionContext) {
        this.executionContext = executionContext;
    }

    // ========== Undo/Redo Methods ==========

    public void pushCommand(Command command) {
        undoStack.push(command);
        redoStack.clear(); // Clear redo when new action is performed
        setModified(true);
    }

    public boolean canUndo() {
        return !undoStack.isEmpty();
    }

    public void undo() {
        if (canUndo()) {
            Command command = undoStack.pop();
            command.undo();
            redoStack.push(command);
            setModified(true);
        }
    }

    public boolean canRedo() {
        return !redoStack.isEmpty();
    }

    public void redo() {
        if (canRedo()) {
            Command command = redoStack.pop();
            command.execute();
            undoStack.push(command);
            setModified(true);
        }
    }

    // ========== Document Properties ==========

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        setModified(true);
    }

    public boolean isModified() {
        return modified;
    }

    public void setModified(boolean modified) {
        this.modified = modified;
    }

    // ========== Command Interface for Undo/Redo ==========

    public interface Command {
        void execute();
        void undo();
    }
}
