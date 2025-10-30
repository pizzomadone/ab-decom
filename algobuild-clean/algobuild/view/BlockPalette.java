package algobuild.view;

import algobuild.model.blocks.*;

import javax.swing.*;
import java.awt.*;
import java.util.function.Supplier;

/**
 * Palette dei blocchi disponibili.
 * Equivalente a: a.j.a.a nell'originale
 *
 * Mostra i blocchi disponibili organizzati per categorie.
 */
public class BlockPalette extends JPanel {

    private OnBlockSelectedListener listener;

    public BlockPalette() {
        setupUI();
    }

    private void setupUI() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Block Palette"));

        // Panel principale con layout verticale
        JPanel blocksPanel = new JPanel();
        blocksPanel.setLayout(new BoxLayout(blocksPanel, BoxLayout.Y_AXIS));
        blocksPanel.setBackground(Color.WHITE);

        // Aggiungi categorie di blocchi

        // === Basic Blocks ===
        blocksPanel.add(createCategoryLabel("Basic"));
        blocksPanel.add(createBlockButton("Assignment", "x = value",
            () -> new AssignmentBlock("x", "value")));
        blocksPanel.add(createBlockButton("Comment", "// comment",
            () -> new CommentBlock("comment")));

        blocksPanel.add(Box.createVerticalStrut(10));

        // === I/O Blocks ===
        blocksPanel.add(createCategoryLabel("Input/Output"));
        blocksPanel.add(createBlockButton("Input", "READ x",
            () -> new InputBlock("x")));
        blocksPanel.add(createBlockButton("Output", "WRITE x",
            () -> new OutputBlock("x")));

        blocksPanel.add(Box.createVerticalStrut(10));

        // === Control Flow ===
        blocksPanel.add(createCategoryLabel("Control Flow"));
        blocksPanel.add(createBlockButton("IF", "if condition",
            () -> new IfBlock("condition")));
        blocksPanel.add(createBlockButton("FOR", "for i=1 to n",
            () -> new ForBlock("i", "1", "n")));
        blocksPanel.add(createBlockButton("WHILE", "while condition",
            () -> new WhileBlock("condition")));
        blocksPanel.add(createBlockButton("DO-WHILE", "do...while",
            () -> new DoWhileBlock("condition")));

        blocksPanel.add(Box.createVerticalStrut(10));

        // === Functions ===
        blocksPanel.add(createCategoryLabel("Functions"));
        blocksPanel.add(createBlockButton("Call", "call procedure",
            () -> new CallBlock("procedure")));

        // Scroll pane
        JScrollPane scrollPane = new JScrollPane(blocksPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Crea un'etichetta per categoria.
     */
    private JLabel createCategoryLabel(String category) {
        JLabel label = new JLabel(category);
        label.setFont(new Font("Dialog", Font.BOLD, 11));
        label.setForeground(new Color(0, 70, 150));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        label.setBorder(BorderFactory.createEmptyBorder(5, 5, 2, 5));
        return label;
    }

    /**
     * Crea un pulsante per un tipo di blocco.
     */
    private JButton createBlockButton(String name, String template, Supplier<Block> blockFactory) {
        JButton button = new JButton();
        button.setLayout(new BorderLayout());
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        button.setHorizontalAlignment(SwingConstants.LEFT);

        // Panel contenuto
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setOpaque(false);

        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("Dialog", Font.BOLD, 12));

        JLabel templateLabel = new JLabel(template);
        templateLabel.setFont(new Font("Dialog", Font.PLAIN, 10));
        templateLabel.setForeground(Color.GRAY);

        contentPanel.add(nameLabel);
        contentPanel.add(templateLabel);

        button.add(contentPanel, BorderLayout.CENTER);

        // Action
        button.addActionListener(e -> {
            if (listener != null) {
                Block block = blockFactory.get();
                listener.onBlockSelected(block);
            }
        });

        return button;
    }

    // ========== Listener Interface ==========

    public interface OnBlockSelectedListener {
        void onBlockSelected(Block block);
    }

    public void setOnBlockSelectedListener(OnBlockSelectedListener listener) {
        this.listener = listener;
    }
}
