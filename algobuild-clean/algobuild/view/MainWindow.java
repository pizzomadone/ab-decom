package algobuild.view;

import algobuild.model.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Finestra principale di AlgoBuild.
 * Equivalente a: a.k.c nell'originale
 *
 * Contiene:
 * - Menu bar (File, Edit, Run, Help)
 * - Toolbar
 * - Editor panel
 * - Status bar
 */
public class MainWindow extends JFrame {

    private Document document;
    private EditorPanel editorPanel;

    // Menu items che cambiano stato
    private JMenuItem saveMenuItem;
    private JMenuItem undoMenuItem;
    private JMenuItem redoMenuItem;

    // Toolbar buttons
    private JButton runButton;
    private JButton stepButton;
    private JButton pauseButton;
    private JButton stopButton;

    public MainWindow() {
        super("AlgoBuild - Visual Algorithm Editor");

        // Crea nuovo documento
        document = new Document("Untitled");

        setupUI();
        setupMenuBar();
        setupToolBar();
        setupStatusBar();

        // Window properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 900);
        setLocationRelativeTo(null);
    }

    private void setupUI() {
        setLayout(new BorderLayout());

        // Editor panel principale
        editorPanel = new EditorPanel(document);
        add(editorPanel, BorderLayout.CENTER);
    }

    private void setupMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // === File Menu ===
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        newMenuItem.addActionListener(e -> newDocument());
        fileMenu.add(newMenuItem);

        JMenuItem openMenuItem = new JMenuItem("Open...");
        openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        openMenuItem.addActionListener(e -> openDocument());
        fileMenu.add(openMenuItem);

        fileMenu.addSeparator();

        saveMenuItem = new JMenuItem("Save");
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        saveMenuItem.addActionListener(e -> saveDocument());
        fileMenu.add(saveMenuItem);

        JMenuItem saveAsMenuItem = new JMenuItem("Save As...");
        saveAsMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
            KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK));
        saveAsMenuItem.addActionListener(e -> saveDocumentAs());
        fileMenu.add(saveAsMenuItem);

        fileMenu.addSeparator();

        JMenuItem exportMenuItem = new JMenuItem("Export Image...");
        exportMenuItem.addActionListener(e -> exportImage());
        fileMenu.add(exportMenuItem);

        fileMenu.addSeparator();

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> exit());
        fileMenu.add(exitMenuItem);

        // === Edit Menu ===
        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E);

        undoMenuItem = new JMenuItem("Undo");
        undoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
        undoMenuItem.setEnabled(false);
        undoMenuItem.addActionListener(e -> undo());
        editMenu.add(undoMenuItem);

        redoMenuItem = new JMenuItem("Redo");
        redoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK));
        redoMenuItem.setEnabled(false);
        redoMenuItem.addActionListener(e -> redo());
        editMenu.add(redoMenuItem);

        editMenu.addSeparator();

        JMenuItem preferencesMenuItem = new JMenuItem("Preferences...");
        preferencesMenuItem.addActionListener(e -> showPreferences());
        editMenu.add(preferencesMenuItem);

        // === Run Menu ===
        JMenu runMenu = new JMenu("Run");
        runMenu.setMnemonic(KeyEvent.VK_R);

        JMenuItem runMenuItem = new JMenuItem("Run");
        runMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
        runMenuItem.addActionListener(e -> runAlgorithm());
        runMenu.add(runMenuItem);

        JMenuItem stepMenuItem = new JMenuItem("Step");
        stepMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0));
        stepMenuItem.addActionListener(e -> stepAlgorithm());
        runMenu.add(stepMenuItem);

        JMenuItem pauseMenuItem = new JMenuItem("Pause");
        pauseMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0));
        pauseMenuItem.addActionListener(e -> pauseAlgorithm());
        runMenu.add(pauseMenuItem);

        JMenuItem stopMenuItem = new JMenuItem("Stop");
        stopMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0));
        stopMenuItem.addActionListener(e -> stopAlgorithm());
        runMenu.add(stopMenuItem);

        runMenu.addSeparator();

        JMenuItem executionOptionsMenuItem = new JMenuItem("Execution Options...");
        executionOptionsMenuItem.addActionListener(e -> showExecutionOptions());
        runMenu.add(executionOptionsMenuItem);

        // === Help Menu ===
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);

        JMenuItem helpMenuItem = new JMenuItem("Help");
        helpMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        helpMenuItem.addActionListener(e -> showHelp());
        helpMenu.add(helpMenuItem);

        helpMenu.addSeparator();

        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.addActionListener(e -> showAbout());
        helpMenu.add(aboutMenuItem);

        // Add menus to bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(runMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);
    }

    private void setupToolBar() {
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);

        // File actions
        JButton newButton = new JButton("New");
        newButton.setToolTipText("New document");
        newButton.addActionListener(e -> newDocument());
        toolBar.add(newButton);

        JButton openButton = new JButton("Open");
        openButton.setToolTipText("Open document");
        openButton.addActionListener(e -> openDocument());
        toolBar.add(openButton);

        JButton saveButton = new JButton("Save");
        saveButton.setToolTipText("Save document");
        saveButton.addActionListener(e -> saveDocument());
        toolBar.add(saveButton);

        toolBar.addSeparator();

        // Execution actions
        runButton = new JButton("▶ Run");
        runButton.setToolTipText("Run algorithm (F5)");
        runButton.addActionListener(e -> runAlgorithm());
        toolBar.add(runButton);

        stepButton = new JButton("⏯ Step");
        stepButton.setToolTipText("Execute one step (F10)");
        stepButton.addActionListener(e -> stepAlgorithm());
        toolBar.add(stepButton);

        pauseButton = new JButton("⏸ Pause");
        pauseButton.setToolTipText("Pause execution (F6)");
        pauseButton.addActionListener(e -> pauseAlgorithm());
        toolBar.add(pauseButton);

        stopButton = new JButton("⏹ Stop");
        stopButton.setToolTipText("Stop execution (F7)");
        stopButton.addActionListener(e -> stopAlgorithm());
        toolBar.add(stopButton);

        add(toolBar, BorderLayout.NORTH);
    }

    private void setupStatusBar() {
        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusBar.setBorder(BorderFactory.createEtchedBorder());

        JLabel statusLabel = new JLabel("Ready");
        statusBar.add(statusLabel);

        add(statusBar, BorderLayout.SOUTH);
    }

    // ========== Menu Actions ==========

    private void newDocument() {
        // TODO: Chiedi se salvare documento corrente
        document = new Document("Untitled");
        editorPanel = new EditorPanel(document);
        getContentPane().remove(1); // Rimuovi editor panel vecchio
        add(editorPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void openDocument() {
        // TODO: Implementare apertura file JSON
        JOptionPane.showMessageDialog(this,
            "Open functionality not yet implemented",
            "Info",
            JOptionPane.INFORMATION_MESSAGE);
    }

    private void saveDocument() {
        // TODO: Implementare salvataggio JSON
        JOptionPane.showMessageDialog(this,
            "Save functionality not yet implemented",
            "Info",
            JOptionPane.INFORMATION_MESSAGE);
    }

    private void saveDocumentAs() {
        // TODO: Implementare salvataggio JSON con dialog
        saveDocument();
    }

    private void exportImage() {
        // TODO: Esporta canvas come immagine
        JOptionPane.showMessageDialog(this,
            "Export functionality not yet implemented",
            "Info",
            JOptionPane.INFORMATION_MESSAGE);
    }

    private void exit() {
        // TODO: Chiedi se salvare
        System.exit(0);
    }

    private void undo() {
        if (document.canUndo()) {
            document.undo();
            editorPanel.getCanvas().refresh();
        }
    }

    private void redo() {
        if (document.canRedo()) {
            document.redo();
            editorPanel.getCanvas().refresh();
        }
    }

    private void showPreferences() {
        // TODO: Dialog preferenze
        JOptionPane.showMessageDialog(this,
            "Preferences dialog not yet implemented",
            "Info",
            JOptionPane.INFORMATION_MESSAGE);
    }

    private void runAlgorithm() {
        editorPanel.runAlgorithm();
    }

    private void stepAlgorithm() {
        editorPanel.stepAlgorithm();
    }

    private void pauseAlgorithm() {
        editorPanel.togglePause();
    }

    private void stopAlgorithm() {
        editorPanel.stopAlgorithm();
    }

    private void showExecutionOptions() {
        // Dialog per impostare velocità esecuzione
        String delayStr = JOptionPane.showInputDialog(this,
            "Execution delay (ms):",
            editorPanel.getExecutor() != null ?
                editorPanel.getExecutor().getExecutionDelay() : 1000);

        if (delayStr != null) {
            try {
                int delay = Integer.parseInt(delayStr);
                if (editorPanel.getExecutor() != null) {
                    editorPanel.getExecutor().setExecutionDelay(delay);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                    "Invalid number",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showHelp() {
        String helpText = "AlgoBuild - Visual Algorithm Editor\n\n" +
            "Keyboard Shortcuts:\n" +
            "  F5  - Run algorithm\n" +
            "  F10 - Execute one step\n" +
            "  F6  - Pause execution\n" +
            "  F7  - Stop execution\n" +
            "  Ctrl+N - New document\n" +
            "  Ctrl+O - Open document\n" +
            "  Ctrl+S - Save document\n" +
            "  Ctrl+Z - Undo\n" +
            "  Ctrl+Y - Redo\n\n" +
            "Usage:\n" +
            "1. Click on blocks in the palette to add them\n" +
            "2. Click on connectors (arrows) to insert blocks\n" +
            "3. Double-click blocks to edit\n" +
            "4. Use Run/Step buttons to execute";

        JOptionPane.showMessageDialog(this,
            helpText,
            "Help",
            JOptionPane.INFORMATION_MESSAGE);
    }

    private void showAbout() {
        String aboutText = "AlgoBuild\n" +
            "Visual Algorithm Editor\n\n" +
            "Version 2.0 - Clean Rewrite\n\n" +
            "Reimplementazione completa con codice pulito e leggibile,\n" +
            "mantenendo funzionalità identica all'originale.\n\n" +
            "Features:\n" +
            "- Forme geometriche corrette (rettangoli, rombi, parallelogrammi)\n" +
            "- Execution step-by-step con highlighting\n" +
            "- 10 tipi di blocchi\n" +
            "- Expression evaluator\n" +
            "- Codice 100% comprensibile";

        JOptionPane.showMessageDialog(this,
            aboutText,
            "About AlgoBuild",
            JOptionPane.INFORMATION_MESSAGE);
    }

    // ========== Main ==========

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Set system look and feel
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            MainWindow window = new MainWindow();
            window.setVisible(true);
        });
    }
}
