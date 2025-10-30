package algobuild.view;

import algobuild.execution.AlgorithmExecutor;
import algobuild.model.Document;
import algobuild.model.blocks.Block;

import javax.swing.*;
import java.awt.*;

/**
 * Pannello principale dell'editor.
 * Equivalente a: a.j.a.g nell'originale
 *
 * Combina:
 * - Block Palette (sinistra)
 * - Flowchart Canvas (centro)
 * - Console + Variables (destra)
 */
public class EditorPanel extends JPanel {

    private Document document;

    // Componenti UI
    private BlockPalette blockPalette;
    private FlowchartCanvas canvas;
    private ConsolePanel consolePanel;
    private VariablesPanel variablesPanel;

    // Execution
    private AlgorithmExecutor executor;

    public EditorPanel(Document document) {
        this.document = document;
        setupUI();
        setupExecutor();
    }

    private void setupUI() {
        setLayout(new BorderLayout(5, 5));

        // === LEFT: Block Palette ===
        blockPalette = new BlockPalette();
        blockPalette.setPreferredSize(new Dimension(200, 600));
        blockPalette.setOnBlockSelectedListener(block -> {
            // Aggiungi blocco al canvas
            if (canvas.getRootBlock() == null) {
                block.setDocument(document);
                canvas.setRootBlock(block);
            } else {
                block.setDocument(document);
                canvas.addBlock(block);
            }
            document.setModified(true);
        });

        // === CENTER: Flowchart Canvas ===
        canvas = new FlowchartCanvas(document);
        canvas.setOnBlockActionListener(new FlowchartCanvas.OnBlockActionListener() {
            @Override
            public void onInsertBlockRequested(Block afterBlock) {
                // TODO: Mostra dialog per scegliere tipo di blocco da inserire
                showInsertBlockDialog(afterBlock);
            }

            @Override
            public void onBlockSelected(Block block) {
                // TODO: Evidenzia blocco selezionato
            }

            @Override
            public void onBlockDoubleClicked(Block block) {
                // TODO: Apri dialog per editare blocco
                showEditBlockDialog(block);
            }
        });

        JScrollPane canvasScroll = new JScrollPane(canvas);
        canvasScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        canvasScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // === RIGHT: Console + Variables ===
        JPanel rightPanel = new JPanel(new BorderLayout(5, 5));

        consolePanel = new ConsolePanel();
        variablesPanel = new VariablesPanel();

        JSplitPane rightSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
            consolePanel, variablesPanel);
        rightSplit.setDividerLocation(300);
        rightSplit.setResizeWeight(0.6);

        rightPanel.add(rightSplit, BorderLayout.CENTER);
        rightPanel.setPreferredSize(new Dimension(350, 600));

        // === Layout Principale ===
        JSplitPane mainSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
            blockPalette, canvasScroll);
        mainSplit.setDividerLocation(200);
        mainSplit.setResizeWeight(0.0);

        JSplitPane outerSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
            mainSplit, rightPanel);
        outerSplit.setDividerLocation(800);
        outerSplit.setResizeWeight(1.0);

        add(outerSplit, BorderLayout.CENTER);
    }

    private void setupExecutor() {
        // Executor sarà ricreato ad ogni run
        executor = null;
    }

    /**
     * Mostra dialog per inserire nuovo blocco.
     */
    private void showInsertBlockDialog(Block afterBlock) {
        // TODO: Dialog più sofisticato
        String[] options = {"Assignment", "Input", "Output", "IF", "FOR", "WHILE", "Cancel"};
        int choice = JOptionPane.showOptionDialog(this,
            "Select block type to insert:",
            "Insert Block",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null, options, options[0]);

        Block newBlock = null;
        switch (choice) {
            case 0: // Assignment
                String varName = JOptionPane.showInputDialog(this, "Variable name:");
                String expr = JOptionPane.showInputDialog(this, "Expression:");
                if (varName != null && expr != null) {
                    newBlock = new algobuild.model.blocks.AssignmentBlock(varName, expr);
                }
                break;
            case 1: // Input
                String inputVar = JOptionPane.showInputDialog(this, "Variable name:");
                if (inputVar != null) {
                    newBlock = new algobuild.model.blocks.InputBlock(inputVar);
                }
                break;
            case 2: // Output
                String outputExpr = JOptionPane.showInputDialog(this, "Expression:");
                if (outputExpr != null) {
                    newBlock = new algobuild.model.blocks.OutputBlock(outputExpr);
                }
                break;
            // TODO: Aggiungere altri tipi
        }

        if (newBlock != null) {
            newBlock.setDocument(document);
            canvas.insertBlockAfter(newBlock, afterBlock);
            document.setModified(true);
        }
    }

    /**
     * Mostra dialog per editare blocco.
     */
    private void showEditBlockDialog(Block block) {
        // TODO: Dialog specifico per tipo di blocco
        JOptionPane.showMessageDialog(this,
            "Edit block: " + block.getDescription(),
            "Edit Block",
            JOptionPane.INFORMATION_MESSAGE);
    }

    // ========== Execution Methods ==========

    /**
     * Esegue l'algoritmo con timer.
     */
    public void runAlgorithm() {
        Block rootBlock = canvas.getRootBlock();
        if (rootBlock == null) {
            JOptionPane.showMessageDialog(this,
                "No algorithm to execute!",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crea nuovo executor
        executor = new AlgorithmExecutor(document, rootBlock);
        document.setExecutionContext(executor.getContext());

        // Setup listener per highlighting
        executor.setExecutionListener(new AlgorithmExecutor.ExecutionListener() {
            @Override
            public void onExecutionInitialized() {
                consolePanel.clear();
                variablesPanel.clear();
            }

            @Override
            public void onExecutionStarted() {
                consolePanel.appendLine("=== Execution Started ===");
            }

            @Override
            public void onBeforeBlockExecute(Block block) {
                canvas.highlightBlock(block);
                variablesPanel.updateVariables(executor.getContext().getAllVariables());
            }

            @Override
            public void onAfterBlockExecute(Block block) {
                // Aggiorna output se disponibile
                String output = executor.getContext().getOutput();
                if (!output.isEmpty()) {
                    consolePanel.setText(output);
                }
                variablesPanel.updateVariables(executor.getContext().getAllVariables());
            }

            @Override
            public void onExecutionPaused() {
                consolePanel.appendLine("\n--- Paused ---");
            }

            @Override
            public void onExecutionResumed() {
                consolePanel.appendLine("--- Resumed ---");
            }

            @Override
            public void onExecutionStopped() {
                canvas.clearHighlight();
                consolePanel.appendLine("\n=== Execution Completed ===");
            }

            @Override
            public void onExecutionError(Exception e) {
                consolePanel.appendLine("\nERROR: " + e.getMessage());
                canvas.clearHighlight();
            }
        });

        // Avvia esecuzione con timer
        executor.runWithTimer();
    }

    /**
     * Esegue un singolo step.
     */
    public void stepAlgorithm() {
        if (executor == null) {
            runAlgorithm(); // Inizializza
        }

        try {
            executor.executeStep();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Execution error: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Ferma l'esecuzione.
     */
    public void stopAlgorithm() {
        if (executor != null) {
            executor.stop();
        }
    }

    /**
     * Pausa/riprendi esecuzione.
     */
    public void togglePause() {
        if (executor != null) {
            if (executor.isPaused()) {
                executor.resume();
            } else {
                executor.pause();
            }
        }
    }

    // ========== Getters ==========

    public FlowchartCanvas getCanvas() {
        return canvas;
    }

    public ConsolePanel getConsolePanel() {
        return consolePanel;
    }

    public VariablesPanel getVariablesPanel() {
        return variablesPanel;
    }

    public AlgorithmExecutor getExecutor() {
        return executor;
    }
}
