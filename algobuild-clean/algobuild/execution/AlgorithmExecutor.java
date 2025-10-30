package algobuild.execution;

import algobuild.model.Document;
import algobuild.model.blocks.Block;

import javax.swing.Timer;

/**
 * Esecutore di algoritmi con supporto per step-by-step execution.
 * Equivalente a: a.c.a.e nell'originale
 *
 * Modalità di esecuzione:
 * - Run to completion: esegue tutto senza pause
 * - Step-by-step: esegue un blocco alla volta
 * - Timed: esegue con delay tra i blocchi
 */
public class AlgorithmExecutor {

    private Document document;
    private Block rootBlock;
    private ExecutionContext context;

    // Stato esecuzione
    private Block currentBlock;
    private boolean running;
    private boolean paused;

    // Timer per esecuzione temporizzata
    private Timer executionTimer;

    // Listener per eventi
    private ExecutionListener listener;

    public AlgorithmExecutor(Document document, Block rootBlock) {
        this.document = document;
        this.rootBlock = rootBlock;
        this.context = new ExecutionContext();
        this.running = false;
        this.paused = false;

        // Setup timer per esecuzione temporizzata
        setupTimer();
    }

    private void setupTimer() {
        executionTimer = new Timer(context.getExecutionDelay(), e -> {
            if (running && !paused) {
                try {
                    executeStep();
                } catch (Exception ex) {
                    handleError(ex);
                    stop();
                }
            }
        });
        executionTimer.setRepeats(true);
    }

    /**
     * Inizializza l'esecuzione.
     */
    public void initialize() {
        context.reset();
        currentBlock = rootBlock;
        context.setCurrentBlock(currentBlock);
        context.setState(ExecutionContext.ExecutionState.STOPPED);

        if (listener != null) {
            listener.onExecutionInitialized();
        }
    }

    /**
     * Esegue l'algoritmo fino al completamento.
     */
    public void runToCompletion() throws Exception {
        initialize();
        running = true;
        context.setState(ExecutionContext.ExecutionState.RUNNING);

        if (listener != null) {
            listener.onExecutionStarted();
        }

        while (currentBlock != null && running) {
            executeCurrentBlock();
        }

        stop();
    }

    /**
     * Esegue l'algoritmo con timer (highlighting automatico).
     */
    public void runWithTimer() {
        initialize();
        running = true;
        context.setState(ExecutionContext.ExecutionState.RUNNING);
        context.setStepMode(false);

        if (listener != null) {
            listener.onExecutionStarted();
        }

        executionTimer.start();
    }

    /**
     * Esegue un singolo step.
     */
    public void executeStep() throws Exception {
        if (currentBlock == null) {
            stop();
            return;
        }

        if (!running) {
            initialize();
            running = true;
            context.setState(ExecutionContext.ExecutionState.RUNNING);
            context.setStepMode(true);

            if (listener != null) {
                listener.onExecutionStarted();
            }
        }

        executeCurrentBlock();

        if (currentBlock == null) {
            stop();
        }
    }

    /**
     * Esegue il blocco corrente.
     */
    private void executeCurrentBlock() throws Exception {
        if (currentBlock == null) {
            return;
        }

        // Notifica inizio esecuzione blocco
        if (listener != null) {
            listener.onBeforeBlockExecute(currentBlock);
        }

        // Esegui il blocco
        Block nextBlock = currentBlock.execute(context);

        // Notifica fine esecuzione blocco
        if (listener != null) {
            listener.onAfterBlockExecute(currentBlock);
        }

        // Passa al blocco successivo
        currentBlock = nextBlock;
        context.setCurrentBlock(currentBlock);
    }

    /**
     * Mette in pausa l'esecuzione.
     */
    public void pause() {
        if (running) {
            paused = true;
            context.setState(ExecutionContext.ExecutionState.PAUSED);
            executionTimer.stop();

            if (listener != null) {
                listener.onExecutionPaused();
            }
        }
    }

    /**
     * Riprende l'esecuzione.
     */
    public void resume() {
        if (running && paused) {
            paused = false;
            context.setState(ExecutionContext.ExecutionState.RUNNING);
            executionTimer.start();

            if (listener != null) {
                listener.onExecutionResumed();
            }
        }
    }

    /**
     * Ferma l'esecuzione.
     */
    public void stop() {
        running = false;
        paused = false;
        executionTimer.stop();
        context.setState(ExecutionContext.ExecutionState.STOPPED);
        context.setCurrentBlock(null);

        if (listener != null) {
            listener.onExecutionStopped();
        }
    }

    /**
     * Gestisce errori durante l'esecuzione.
     */
    private void handleError(Exception e) {
        if (listener != null) {
            listener.onExecutionError(e);
        }
    }

    // ========== Getters/Setters ==========

    public ExecutionContext getContext() {
        return context;
    }

    public Block getCurrentBlock() {
        return currentBlock;
    }

    public boolean isRunning() {
        return running;
    }

    public boolean isPaused() {
        return paused;
    }

    public void setExecutionDelay(int delayMs) {
        context.setExecutionDelay(delayMs);
        executionTimer.setDelay(delayMs);
    }

    public int getExecutionDelay() {
        return context.getExecutionDelay();
    }

    // ========== Listener Interface ==========

    public interface ExecutionListener {
        void onExecutionInitialized();
        void onExecutionStarted();
        void onBeforeBlockExecute(Block block);
        void onAfterBlockExecute(Block block);
        void onExecutionPaused();
        void onExecutionResumed();
        void onExecutionStopped();
        void onExecutionError(Exception e);
    }

    public void setExecutionListener(ExecutionListener listener) {
        this.listener = listener;
    }
}
