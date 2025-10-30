package algobuild.view.blocks;

import algobuild.model.Document;
import algobuild.model.ViewOptions;
import algobuild.model.blocks.Block;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Pannello base per il rendering dei blocchi.
 * Equivalente a: a.j.b.n nell'originale
 *
 * Responsabilità:
 * - Setup Graphics2D con antialiasing
 * - Gestione font metrics
 * - Calcolo unità e ed f
 * - Gestione stati (normale, hover, executing)
 * - Mouse handling
 */
public abstract class BaseBlockPanel extends JPanel {

    // Blocco rappresentato da questo pannello
    protected Block block;

    // Documento di riferimento
    protected Document document;

    // Stato hover
    protected boolean hovered;

    // Unità di sizing (calcolate da font metrics)
    protected int e; // width unit
    protected int f; // height unit

    public BaseBlockPanel(Block block, Document document) {
        this.block = block;
        this.document = document;
        this.hovered = false;

        // Calcola unità e ed f
        calculateUnits();

        // Setup listeners
        setupListeners();
    }

    /**
     * Calcola le unità e ed f basate sul font.
     * Formula originale: e = f = (fontHeight + 1) / 2
     */
    protected void calculateUnits() {
        ViewOptions options = document.getViewOptions();
        this.e = options.getWidthUnit();
        this.f = options.getHeightUnit();
    }

    /**
     * Setup listeners per mouse events.
     */
    protected void setupListeners() {
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                hovered = true;
                repaint();
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                hovered = false;
                repaint();
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                onMouseClicked(e);
            }
        });
    }

    /**
     * Override per gestire click del mouse.
     */
    protected void onMouseClicked(java.awt.event.MouseEvent e) {
        // Da sovrascrivere nelle sottoclassi
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Setup Graphics2D con antialiasing
        Graphics2D g2d = (Graphics2D) g;
        setupGraphics2D(g2d);

        // Determina i colori in base allo stato
        Color backgroundColor = getBackgroundColor();
        Color borderColor = getBorderColor();

        // Disegna il blocco
        drawBlock(g2d, backgroundColor, borderColor);

        // Disegna il testo
        drawText(g2d);

        // Disegna le linee di connessione
        drawConnections(g2d, borderColor);
    }

    /**
     * Setup Graphics2D con rendering hints.
     */
    protected void setupGraphics2D(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        ViewOptions options = document.getViewOptions();
        g2d.setStroke(options.getLineStroke());
        g2d.setFont(options.getFont());
    }

    /**
     * Determina il colore di background in base allo stato.
     */
    protected Color getBackgroundColor() {
        ViewOptions options = document.getViewOptions();

        // Controlla se il blocco è in esecuzione
        if (isExecuting()) {
            return options.getExecutingBackground();
        }

        // Controlla hover
        if (hovered) {
            return options.getHoverBackground();
        }

        // Normale
        return options.getNormalBackground();
    }

    /**
     * Determina il colore del bordo in base allo stato.
     */
    protected Color getBorderColor() {
        ViewOptions options = document.getViewOptions();

        // Controlla se il blocco è in esecuzione
        if (isExecuting()) {
            return options.getExecutingBorder();
        }

        // Controlla hover
        if (hovered) {
            return options.getHoverBorder();
        }

        // Normale
        return options.getNormalBorder();
    }

    /**
     * Controlla se questo blocco è attualmente in esecuzione.
     */
    protected boolean isExecuting() {
        if (document.getExecutionContext() == null) {
            return false;
        }

        Block currentBlock = document.getExecutionContext().getCurrentBlock();
        return currentBlock == this.block;
    }

    /**
     * Disegna il blocco (da sovrascrivere nelle sottoclassi).
     */
    protected abstract void drawBlock(Graphics2D g2d, Color backgroundColor, Color borderColor);

    /**
     * Disegna il testo del blocco.
     */
    protected void drawText(Graphics2D g2d) {
        String text = block.getDisplayText();
        if (text == null || text.isEmpty()) {
            return;
        }

        // Split multiline text
        String[] lines = text.split("\n");

        ViewOptions options = document.getViewOptions();
        FontMetrics fm = g2d.getFontMetrics(options.getFont());

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        // Calcola posizione di partenza Y (centrata verticalmente)
        int totalTextHeight = lines.length * fm.getHeight();
        int startY = (panelHeight - totalTextHeight) / 2 + fm.getAscent();

        // Disegna ogni riga centrata orizzontalmente
        g2d.setColor(Color.BLACK);
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            Rectangle2D bounds = fm.getStringBounds(line, g2d);
            int x = (int) ((panelWidth - bounds.getWidth()) / 2);
            int y = startY + i * fm.getHeight();

            g2d.drawString(line, x, y);
        }
    }

    /**
     * Disegna le linee di connessione al blocco precedente e successivo.
     */
    protected void drawConnections(Graphics2D g2d, Color borderColor) {
        g2d.setColor(borderColor);

        int centerX = getWidth() / 2;

        // Linea dall'alto (connessione al blocco precedente)
        g2d.drawLine(centerX, 0, centerX, f);

        // Linea verso il basso (connessione al blocco successivo)
        int bottomY = getHeight();
        g2d.drawLine(centerX, bottomY - f, centerX, bottomY);
    }

    // ========== Getters/Setters ==========

    public Block getBlock() {
        return block;
    }

    public Document getDocument() {
        return document;
    }

    public boolean isHovered() {
        return hovered;
    }
}
