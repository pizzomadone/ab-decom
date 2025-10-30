package algobuild.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Contesto di esecuzione dell'algoritmo.
 * Contiene le variabili, input/output, e stato dell'esecuzione.
 */
public class ExecutionContext {

    private Map<String, Object> variables;
    private Scanner inputScanner;
    private StringBuilder outputBuffer;
    private boolean debugMode;

    public ExecutionContext() {
        this.variables = new HashMap<>();
        this.inputScanner = new Scanner(System.in);
        this.outputBuffer = new StringBuilder();
        this.debugMode = false;
    }

    // Gestione variabili
    public void setVariable(String name, Object value) {
        variables.put(name, value);
    }

    public Object getVariable(String name) {
        return variables.get(name);
    }

    public boolean hasVariable(String name) {
        return variables.containsKey(name);
    }

    public Map<String, Object> getAllVariables() {
        return new HashMap<>(variables);
    }

    // Input/Output
    public String readInput(String prompt) {
        if (debugMode) {
            System.out.print("[INPUT] " + prompt + ": ");
        }
        String input = inputScanner.nextLine();
        return input;
    }

    public void writeOutput(String message) {
        outputBuffer.append(message).append("\n");
        if (debugMode) {
            System.out.println("[OUTPUT] " + message);
        }
    }

    public String getOutput() {
        return outputBuffer.toString();
    }

    public void clearOutput() {
        outputBuffer.setLength(0);
    }

    // Debug
    public void setDebugMode(boolean debug) {
        this.debugMode = debug;
    }

    public boolean isDebugMode() {
        return debugMode;
    }

    public void log(String message) {
        if (debugMode) {
            System.out.println("[DEBUG] " + message);
        }
    }
}
