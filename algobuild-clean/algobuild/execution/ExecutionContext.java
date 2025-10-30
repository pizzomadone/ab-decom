package algobuild.execution;

import algobuild.model.blocks.Block;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Contesto di esecuzione per AlgoBuild.
 * Equivalente a: a.c.a.c nell'originale
 *
 * Gestisce:
 * - Variabili e loro valori
 * - Stack di esecuzione per chiamate annidate
 * - Input/Output
 * - Blocco corrente in esecuzione
 * - Stato di esecuzione (running, paused, stopped)
 */
public class ExecutionContext {

    // Variabili
    private Map<String, Object> variables;

    // Stack di esecuzione
    private Stack<CallFrame> callStack;

    // Blocco corrente
    private Block currentBlock;

    // Output accumulator
    private StringBuilder output;

    // Input scanner
    private Scanner inputScanner;

    // Execution state
    private ExecutionState state;

    // Step mode
    private boolean stepMode;

    // Execution delay (ms)
    private int executionDelay;

    public ExecutionContext() {
        this.variables = new HashMap<>();
        this.callStack = new Stack<>();
        this.output = new StringBuilder();
        this.inputScanner = new Scanner(System.in);
        this.state = ExecutionState.STOPPED;
        this.stepMode = false;
        this.executionDelay = 1000; // Default 1 second
    }

    // ========== Variable Methods ==========

    public void setVariable(String name, Object value) {
        variables.put(name, value);
    }

    public Object getVariable(String name) {
        return variables.get(name);
    }

    public boolean hasVariable(String name) {
        return variables.containsKey(name);
    }

    public void removeVariable(String name) {
        variables.remove(name);
    }

    public Map<String, Object> getAllVariables() {
        return new HashMap<>(variables);
    }

    public void clearVariables() {
        variables.clear();
    }

    // ========== Call Stack Methods ==========

    public void pushCallFrame(CallFrame frame) {
        callStack.push(frame);
    }

    public CallFrame popCallFrame() {
        if (!callStack.isEmpty()) {
            return callStack.pop();
        }
        return null;
    }

    public CallFrame getCurrentCallFrame() {
        if (!callStack.isEmpty()) {
            return callStack.peek();
        }
        return null;
    }

    public int getCallStackSize() {
        return callStack.size();
    }

    // ========== Current Block Methods ==========

    public Block getCurrentBlock() {
        return currentBlock;
    }

    public void setCurrentBlock(Block currentBlock) {
        this.currentBlock = currentBlock;
    }

    // ========== Output Methods ==========

    public void print(String text) {
        output.append(text);
    }

    public void println(String text) {
        output.append(text).append("\n");
    }

    public String getOutput() {
        return output.toString();
    }

    public void clearOutput() {
        output.setLength(0);
    }

    // ========== Input Methods ==========

    public String readLine() {
        return inputScanner.nextLine();
    }

    public int readInt() {
        return inputScanner.nextInt();
    }

    public double readDouble() {
        return inputScanner.nextDouble();
    }

    public void setInputScanner(Scanner scanner) {
        this.inputScanner = scanner;
    }

    // ========== Execution State Methods ==========

    public ExecutionState getState() {
        return state;
    }

    public void setState(ExecutionState state) {
        this.state = state;
    }

    public boolean isRunning() {
        return state == ExecutionState.RUNNING;
    }

    public boolean isPaused() {
        return state == ExecutionState.PAUSED;
    }

    public boolean isStopped() {
        return state == ExecutionState.STOPPED;
    }

    // ========== Step Mode Methods ==========

    public boolean isStepMode() {
        return stepMode;
    }

    public void setStepMode(boolean stepMode) {
        this.stepMode = stepMode;
    }

    // ========== Execution Delay Methods ==========

    public int getExecutionDelay() {
        return executionDelay;
    }

    public void setExecutionDelay(int executionDelay) {
        this.executionDelay = executionDelay;
    }

    // ========== Reset ==========

    public void reset() {
        variables.clear();
        callStack.clear();
        currentBlock = null;
        output.setLength(0);
        state = ExecutionState.STOPPED;
    }

    // ========== Call Frame Class ==========

    public static class CallFrame {
        private Block callerBlock;
        private Map<String, Object> localVariables;

        public CallFrame(Block callerBlock) {
            this.callerBlock = callerBlock;
            this.localVariables = new HashMap<>();
        }

        public Block getCallerBlock() {
            return callerBlock;
        }

        public Map<String, Object> getLocalVariables() {
            return localVariables;
        }

        public void setLocalVariable(String name, Object value) {
            localVariables.put(name, value);
        }

        public Object getLocalVariable(String name) {
            return localVariables.get(name);
        }
    }

    // ========== Execution State Enum ==========

    public enum ExecutionState {
        RUNNING,
        PAUSED,
        STOPPED
    }
}
