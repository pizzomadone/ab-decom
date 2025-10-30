package algobuild.executor;

import algobuild.model.*;

/**
 * Esecutore di algoritmi.
 * Esegue un algoritmo step-by-step o completamente.
 */
public class AlgorithmExecutor {

    private Algorithm algorithm;
    private ExecutionContext context;
    private Block currentBlock;
    private boolean running;
    private boolean paused;
    private int stepCount;
    private int maxSteps;

    public AlgorithmExecutor(Algorithm algorithm) {
        this.algorithm = algorithm;
        this.context = new ExecutionContext();
        this.currentBlock = null;
        this.running = false;
        this.paused = false;
        this.stepCount = 0;
        this.maxSteps = 100000;  // Limite per evitare loop infiniti
    }

    /**
     * Inizializza l'esecuzione
     */
    public void initialize() {
        currentBlock = algorithm.getFirstBlock();
        stepCount = 0;
        running = true;
        paused = false;
        context.log("Initializing algorithm: " + algorithm.getName());
    }

    /**
     * Esegue un singolo step
     * @return true se l'algoritmo continua, false se è terminato
     */
    public boolean step() throws Exception {
        if (currentBlock == null || !running || paused) {
            return false;
        }

        if (stepCount >= maxSteps) {
            throw new Exception("Maximum steps exceeded - possible infinite loop");
        }

        context.log("Step " + (stepCount + 1) + ": Executing " + currentBlock.getType());

        // Esegui il blocco corrente
        Block nextBlock = currentBlock.execute(context);

        // Avanza al blocco successivo
        currentBlock = nextBlock;
        stepCount++;

        // Controlla se l'algoritmo è terminato
        if (currentBlock == null) {
            running = false;
            context.log("Algorithm completed in " + stepCount + " steps");
            return false;
        }

        return true;
    }

    /**
     * Esegue l'intero algoritmo fino alla fine
     */
    public void runToCompletion() throws Exception {
        initialize();

        while (step()) {
            // Continua fino alla fine
        }
    }

    /**
     * Mette in pausa l'esecuzione
     */
    public void pause() {
        paused = true;
        context.log("Execution paused");
    }

    /**
     * Riprende l'esecuzione
     */
    public void resume() {
        paused = false;
        context.log("Execution resumed");
    }

    /**
     * Ferma l'esecuzione
     */
    public void stop() {
        running = false;
        currentBlock = null;
        context.log("Execution stopped");
    }

    /**
     * Resetta l'esecuzione
     */
    public void reset() {
        context = new ExecutionContext();
        currentBlock = null;
        running = false;
        paused = false;
        stepCount = 0;
    }

    // ========== Getters ==========

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

    public int getStepCount() {
        return stepCount;
    }

    public void setMaxSteps(int maxSteps) {
        this.maxSteps = maxSteps;
    }

    public void setDebugMode(boolean debug) {
        context.setDebugMode(debug);
    }
}
