package algobuild.view.blocks;

import algobuild.model.Document;
import algobuild.model.blocks.Block;

import java.awt.*;

/**
 * View per blocchi rettangolari (Assignment, Comment, Call).
 * Equivalente a: a.j.b.a nell'originale
 *
 * Rendering:
 * - Rettangolo con angoli quadrati (come nell'originale)
 * - Testo centrato
 * - Dimensioni calcolate dal testo
 */
public class RectangleBlockView extends BaseBlockPanel {

    // Dimensioni del blocco
    private int blockWidth;
    private int blockHeight;

    public RectangleBlockView(Block block, Document document) {
        super(block, document);
        calculateDimensions();
    }

    /**
     * Calcola le dimensioni del blocco in base al testo.
     * Formula originale da IMPLEMENTATION_DETAILS.md:
     * width = (2 + ((textWidth / (2*e)) << 1)) * e
     * height = (lines + 1 << 1) * f
     */
    private void calculateDimensions() {
        String text = block.getDisplayText();
        if (text == null || text.isEmpty()) {
            text = "...";
        }

        // Split multiline text
        String[] lines = text.split("\n");

        // Calcola la larghezza massima delle righe
        FontMetrics fm = getFontMetrics(document.getViewOptions().getFont());
        int maxTextWidth = 0;
        for (String line : lines) {
            int lineWidth = fm.stringWidth(line);
            if (lineWidth > maxTextWidth) {
                maxTextWidth = lineWidth;
            }
        }

        // Calcola dimensioni del blocco
        // Formula originale: (2 + ((textWidth / (2*e)) << 1)) * e
        // Semplificata: aggiungiamo padding proporzionale alle unità
        this.blockWidth = maxTextWidth + 4 * e;

        // Altezza: (lines + 1) * 2 * f
        this.blockHeight = (lines.length + 1) * 2 * f;

        // Imposta preferred size per il layout manager
        setPreferredSize(new Dimension(blockWidth, blockHeight + 2 * f));
    }

    @Override
    protected void drawBlock(Graphics2D g2d, Color backgroundColor, Color borderColor) {
        int panelWidth = getWidth();

        // Calcola posizione X centrata
        int x = (panelWidth - blockWidth) / 2;
        int y = f; // Offset dall'alto per la linea di connessione

        // Disegna background (angoli quadrati come nell'originale!)
        g2d.setColor(backgroundColor);
        g2d.fillRect(x, y, blockWidth, blockHeight);

        // Disegna bordo
        g2d.setColor(borderColor);
        g2d.drawRect(x, y, blockWidth, blockHeight);
    }

    @Override
    protected void drawText(Graphics2D g2d) {
        // Il testo viene disegnato sopra il blocco da BaseBlockPanel
        String text = block.getDisplayText();
        if (text == null || text.isEmpty()) {
            return;
        }

        String[] lines = text.split("\n");
        FontMetrics fm = g2d.getFontMetrics();

        int panelWidth = getWidth();

        // Calcola posizione Y iniziale
        int totalTextHeight = lines.length * fm.getHeight();
        int startY = (getHeight() - totalTextHeight) / 2 + fm.getAscent();

        // Disegna ogni riga
        g2d.setColor(Color.BLACK);
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            int lineWidth = fm.stringWidth(line);
            int x = (panelWidth - lineWidth) / 2;
            int y = startY + i * fm.getHeight();

            g2d.drawString(line, x, y);
        }
    }

    @Override
    protected void onMouseClicked(java.awt.event.MouseEvent e) {
        // TODO: Apri dialog per editare il blocco
        System.out.println("Clicked on " + block.getTypeId() + ": " + block.getDescription());
    }

    /**
     * Aggiorna le dimensioni se il blocco è cambiato.
     */
    public void updateDimensions() {
        calculateDimensions();
        revalidate();
        repaint();
    }
}
