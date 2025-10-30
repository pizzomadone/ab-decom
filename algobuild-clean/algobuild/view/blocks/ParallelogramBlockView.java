package algobuild.view.blocks;

import algobuild.model.Document;
import algobuild.model.blocks.Block;
import algobuild.model.blocks.InputBlock;
import algobuild.model.blocks.OutputBlock;

import java.awt.*;

/**
 * View per blocchi a parallelogramma (Input, Output).
 * Equivalente a: a.j.b.h nell'originale
 *
 * Rendering:
 * - Parallelogramma con 6 vertici (forma inclinata)
 * - Testo centrato
 * - Dimensioni calcolate dal testo
 */
public class ParallelogramBlockView extends BaseBlockPanel {

    // Dimensioni del parallelogramma
    private int blockWidth;
    private int blockHeight;
    private int skewOffset; // Offset per creare l'effetto inclinato

    public ParallelogramBlockView(Block block, Document document) {
        super(block, document);
        if (!(block instanceof InputBlock) && !(block instanceof OutputBlock)) {
            throw new IllegalArgumentException("ParallelogramBlockView requires InputBlock or OutputBlock");
        }
        calculateDimensions();
    }

    /**
     * Calcola le dimensioni del parallelogramma in base al testo.
     */
    private void calculateDimensions() {
        String text = block.getDisplayText();
        if (text == null || text.isEmpty()) {
            text = "...";
        }

        FontMetrics fm = getFontMetrics(document.getViewOptions().getFont());
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getHeight();

        // Larghezza: testo + padding
        this.blockWidth = textWidth + 6 * e;

        // Altezza
        this.blockHeight = textHeight + 4 * f;

        // Offset per l'inclinazione (circa 1/4 dell'altezza)
        this.skewOffset = blockHeight / 4;

        // Preferred size include spazio per skew e connessioni
        setPreferredSize(new Dimension(blockWidth + 2 * skewOffset, blockHeight + 4 * f));
    }

    @Override
    protected void drawBlock(Graphics2D g2d, Color backgroundColor, Color borderColor) {
        int panelWidth = getWidth();

        // Calcola posizione centrale
        int centerX = panelWidth / 2;
        int y = 2 * f; // Offset dall'alto

        // Calcola i 6 vertici del parallelogramma
        // Formula originale da IMPLEMENTATION_DETAILS.md:
        // Il parallelogramma ha forma inclinata verso destra in alto e basso
        //
        // Vertici (da sinistra in alto, senso orario):
        // 1. (centerX - width/2 - offset, y + height/2)        Left-top
        // 2. (centerX - width/2 + offset, y)                   Top-left
        // 3. (centerX + width/2 + offset, y)                   Top-right
        // 4. (centerX + width/2 - offset, y + height/2)        Right-top
        // 5. (centerX + width/2 - offset, y + height)          Right-bottom
        // 6. (centerX - width/2 - offset, y + height)          Left-bottom

        int halfWidth = blockWidth / 2;

        int[] xPoints = {
            centerX - halfWidth - skewOffset,  // 1. Left-top
            centerX - halfWidth + skewOffset,  // 2. Top-left
            centerX + halfWidth + skewOffset,  // 3. Top-right
            centerX + halfWidth - skewOffset,  // 4. Right-top
            centerX + halfWidth - skewOffset,  // 5. Right-bottom
            centerX - halfWidth - skewOffset   // 6. Left-bottom
        };

        int[] yPoints = {
            y + blockHeight / 2,  // 1
            y,                    // 2
            y,                    // 3
            y + blockHeight / 2,  // 4
            y + blockHeight,      // 5
            y + blockHeight       // 6
        };

        // Disegna ombra
        int[] xShadow = new int[6];
        int[] yShadow = new int[6];
        for (int i = 0; i < 6; i++) {
            xShadow[i] = xPoints[i] + 2;
            yShadow[i] = yPoints[i] + 2;
        }
        g2d.setColor(new Color(0, 0, 0, 30));
        g2d.fillPolygon(xShadow, yShadow, 6);

        // Disegna background
        g2d.setColor(backgroundColor);
        g2d.fillPolygon(xPoints, yPoints, 6);

        // Disegna bordo
        g2d.setColor(borderColor);
        g2d.drawPolygon(xPoints, yPoints, 6);
    }

    @Override
    protected void drawText(Graphics2D g2d) {
        String text = block.getDisplayText();
        if (text == null || text.isEmpty()) {
            return;
        }

        // Disegna il testo centrato
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getAscent();

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        int x = centerX - textWidth / 2;
        int y = centerY + textHeight / 2 - 2;

        g2d.setColor(Color.BLACK);
        g2d.drawString(text, x, y);
    }

    @Override
    protected void drawConnections(Graphics2D g2d, Color borderColor) {
        g2d.setColor(borderColor);

        int centerX = getWidth() / 2;

        // Linea dall'alto
        g2d.drawLine(centerX, 0, centerX, 2 * f);

        // Linea verso il basso
        int bottomY = getHeight();
        g2d.drawLine(centerX, bottomY - 2 * f, centerX, bottomY);
    }

    @Override
    protected void onMouseClicked(java.awt.event.MouseEvent e) {
        // TODO: Apri dialog per editare input/output
        System.out.println("Clicked on " + block.getTypeId() + ": " + block.getDescription());
    }

    public void updateDimensions() {
        calculateDimensions();
        revalidate();
        repaint();
    }
}
