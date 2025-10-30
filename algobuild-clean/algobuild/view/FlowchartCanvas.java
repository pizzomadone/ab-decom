package algobuild.view;

import algobuild.model.Document;
import algobuild.model.blocks.Block;
import algobuild.view.blocks.BaseBlockPanel;
import algobuild.view.blocks.ConnectorView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Canvas principale per visualizzare il flowchart dell'algoritmo.
 * Equivalente a: a.j.b.n + a.j.b.o nell'originale
 *
 * Gestisce:
 * - Layout verticale dei blocchi
 * - Connettori tra blocchi
 * - Scroll e zoom
 * - Aggiunta/rimozione blocchi
 */
public class FlowchartCanvas extends JPanel {

    private Document document;
    private Block rootBlock;

    // Lista di pannelli blocchi visualizzati
    private List<BaseBlockPanel> blockViews;
    private List<ConnectorView> connectorViews;

    // Factory per creare view da model
    private BlockViewFactory viewFactory;

    // Listener per eventi
    private OnBlockActionListener actionListener;

    public FlowchartCanvas(Document document) {
        this.document = document;
        this.blockViews = new ArrayList<>();
        this.connectorViews = new ArrayList<>();
        this.viewFactory = new BlockViewFactory();

        setupUI();
    }

    private void setupUI() {
        // Layout verticale
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);

        // Bordo
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    /**
     * Carica e visualizza un algoritmo (blocco root).
     */
    public void loadAlgorithm(Block rootBlock) {
        this.rootBlock = rootBlock;
        refresh();
    }

    /**
     * Ricarica completamente la visualizzazione.
     */
    public void refresh() {
        // Rimuovi tutti i componenti
        removeAll();
        blockViews.clear();
        connectorViews.clear();

        if (rootBlock == null) {
            // Mostra messaggio "Empty"
            JLabel emptyLabel = new JLabel("Empty algorithm - Click '+' to add blocks");
            emptyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(emptyLabel);
        } else {
            // Aggiungi START marker
            addStartMarker();

            // Connettore iniziale
            addConnector(null);

            // Renderizza blocchi in sequenza
            renderBlockSequence(rootBlock);

            // Connettore finale
            addConnector(null);

            // Aggiungi END marker
            addEndMarker();
        }

        // Aggiorna layout
        revalidate();
        repaint();
    }

    /**
     * Renderizza una sequenza di blocchi (collegati da nextBlock).
     */
    private void renderBlockSequence(Block block) {
        Block current = block;

        while (current != null) {
            // Crea view per questo blocco
            BaseBlockPanel blockView = viewFactory.createView(current, document);

            if (blockView != null) {
                blockViews.add(blockView);
                blockView.setAlignmentX(Component.CENTER_ALIGNMENT);
                add(blockView);

                // Aggiungi connettore dopo il blocco
                Block nextBlock = current.getNextBlock();
                if (nextBlock != null) {
                    addConnector(current);
                }
            }

            current = current.getNextBlock();
        }
    }

    /**
     * Aggiunge un connettore cliccabile.
     */
    private void addConnector(Block afterBlock) {
        ConnectorView connector = new ConnectorView(document, 40);
        connector.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Listener per inserire nuovo blocco
        connector.setOnConnectorClickListener(conn -> {
            if (actionListener != null) {
                actionListener.onInsertBlockRequested(afterBlock);
            }
        });

        connectorViews.add(connector);
        add(connector);
    }

    /**
     * Aggiunge marker START.
     */
    private void addStartMarker() {
        JPanel startPanel = new JPanel();
        startPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        startPanel.setOpaque(false);

        JLabel startLabel = new JLabel("START");
        startLabel.setFont(new Font("Dialog", Font.BOLD, 12));
        startLabel.setForeground(new Color(0, 100, 0));

        startPanel.add(startLabel);
        startPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(startPanel);
    }

    /**
     * Aggiunge marker END.
     */
    private void addEndMarker() {
        JPanel endPanel = new JPanel();
        endPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        endPanel.setOpaque(false);

        JLabel endLabel = new JLabel("END");
        endLabel.setFont(new Font("Dialog", Font.BOLD, 12));
        endLabel.setForeground(new Color(150, 0, 0));

        endPanel.add(endLabel);
        endPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(endPanel);
    }

    /**
     * Aggiunge un blocco alla fine della sequenza.
     */
    public void addBlock(Block block) {
        if (rootBlock == null) {
            rootBlock = block;
        } else {
            // Trova l'ultimo blocco
            Block current = rootBlock;
            while (current.getNextBlock() != null) {
                current = current.getNextBlock();
            }
            current.setNextBlock(block);
        }

        refresh();
    }

    /**
     * Inserisce un blocco dopo un altro blocco specifico.
     */
    public void insertBlockAfter(Block newBlock, Block afterBlock) {
        if (afterBlock == null) {
            // Inserisci all'inizio
            newBlock.setNextBlock(rootBlock);
            rootBlock = newBlock;
        } else {
            // Inserisci in mezzo
            Block next = afterBlock.getNextBlock();
            afterBlock.setNextBlock(newBlock);
            newBlock.setNextBlock(next);
        }

        refresh();
    }

    /**
     * Rimuove un blocco.
     */
    public void removeBlock(Block block) {
        if (block == rootBlock) {
            rootBlock = rootBlock.getNextBlock();
        } else {
            // Trova il blocco precedente
            Block current = rootBlock;
            while (current != null && current.getNextBlock() != block) {
                current = current.getNextBlock();
            }

            if (current != null) {
                current.setNextBlock(block.getNextBlock());
            }
        }

        refresh();
    }

    /**
     * Evidenzia un blocco durante l'esecuzione.
     */
    public void highlightBlock(Block block) {
        // Aggiorna il blocco corrente nel context
        if (document.getExecutionContext() != null) {
            document.getExecutionContext().setCurrentBlock(block);
        }

        // Repaint per mostrare highlighting
        repaint();
    }

    /**
     * Rimuove highlighting.
     */
    public void clearHighlight() {
        if (document.getExecutionContext() != null) {
            document.getExecutionContext().setCurrentBlock(null);
        }
        repaint();
    }

    // ========== Getters/Setters ==========

    public Block getRootBlock() {
        return rootBlock;
    }

    public void setRootBlock(Block rootBlock) {
        this.rootBlock = rootBlock;
        refresh();
    }

    public Document getDocument() {
        return document;
    }

    public List<BaseBlockPanel> getBlockViews() {
        return blockViews;
    }

    // ========== Listener Interface ==========

    public interface OnBlockActionListener {
        void onInsertBlockRequested(Block afterBlock);
        void onBlockSelected(Block block);
        void onBlockDoubleClicked(Block block);
    }

    public void setOnBlockActionListener(OnBlockActionListener listener) {
        this.actionListener = listener;
    }
}
