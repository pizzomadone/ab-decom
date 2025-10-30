package algobuild.view;

import javax.swing.*;
import java.awt.*;

/**
 * Pannello console per visualizzare l'output durante l'esecuzione.
 * Equivalente a: a.j.a.c nell'originale
 */
public class ConsolePanel extends JPanel {

    private JTextArea outputArea;
    private JScrollPane scrollPane;

    public ConsolePanel() {
        setupUI();
    }

    private void setupUI() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Output"));

        // Text area per output
        outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);

        // Scroll pane
        scrollPane = new JScrollPane(outputArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane, BorderLayout.CENTER);

        // Toolbar con pulsante clear
        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> clear());
        toolbar.add(clearButton);

        add(toolbar, BorderLayout.SOUTH);
    }

    /**
     * Aggiunge testo all'output.
     */
    public void append(String text) {
        outputArea.append(text);
        // Auto-scroll alla fine
        outputArea.setCaretPosition(outputArea.getDocument().getLength());
    }

    /**
     * Aggiunge testo con newline.
     */
    public void appendLine(String text) {
        append(text + "\n");
    }

    /**
     * Pulisce l'output.
     */
    public void clear() {
        outputArea.setText("");
    }

    /**
     * Ottiene tutto il testo.
     */
    public String getText() {
        return outputArea.getText();
    }

    /**
     * Imposta il testo.
     */
    public void setText(String text) {
        outputArea.setText(text);
    }
}
