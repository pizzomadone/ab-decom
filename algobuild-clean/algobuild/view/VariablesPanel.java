package algobuild.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Map;

/**
 * Pannello per visualizzare le variabili durante l'esecuzione.
 */
public class VariablesPanel extends JPanel {

    private JTable variablesTable;
    private DefaultTableModel tableModel;

    public VariablesPanel() {
        setupUI();
    }

    private void setupUI() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Variables"));

        // Table model
        String[] columnNames = {"Variable", "Value", "Type"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Read-only
            }
        };

        // Table
        variablesTable = new JTable(tableModel);
        variablesTable.setFont(new Font("Monospaced", Font.PLAIN, 12));
        variablesTable.getTableHeader().setReorderingAllowed(false);

        // Scroll pane
        JScrollPane scrollPane = new JScrollPane(variablesTable);
        add(scrollPane, BorderLayout.CENTER);

        // Toolbar
        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> {
            // Refresh è gestito dall'esterno chiamando updateVariables()
        });
        toolbar.add(refreshButton);

        add(toolbar, BorderLayout.SOUTH);
    }

    /**
     * Aggiorna la tabella con le variabili correnti.
     */
    public void updateVariables(Map<String, Object> variables) {
        // Pulisci tabella
        tableModel.setRowCount(0);

        // Aggiungi variabili
        if (variables != null) {
            for (Map.Entry<String, Object> entry : variables.entrySet()) {
                String name = entry.getKey();
                Object value = entry.getValue();
                String type = value != null ? value.getClass().getSimpleName() : "null";

                // Filtra variabili di sistema (iniziano con ___)
                if (!name.startsWith("___")) {
                    tableModel.addRow(new Object[]{name, value, type});
                }
            }
        }
    }

    /**
     * Pulisce la tabella.
     */
    public void clear() {
        tableModel.setRowCount(0);
    }
}
