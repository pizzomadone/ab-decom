package algobuild.view.blocks;

import algobuild.model.Document;
import algobuild.model.blocks.Block;
import algobuild.model.blocks.IfBlock;

import java.awt.*;

/**
 * View per blocchi a rombo (IF condition).
 * Equivalente a: a.j.b.j nell'originale
 *
 * Rendering:
 * - Rombo (diamond) con 4 vertici
 * - Condizione centrata nel rombo
 * - Labels "T" (TRUE) e "F" (FALSE) per i rami
 */
public class DiamondBlockView extends BaseBlockPanel {

    // Dimensioni del rombo
    private int diamondWidth;
    private int diamondHeight;

    public DiamondBlockView(Block block, Document document) {
        super(block, document);
        if (!(block instanceof IfBlock)) {
            throw new IllegalArgumentException("DiamondBlockView requires IfBlock");
        }
        calculateDimensions();
    }

    /**
     * Calcola le dimensioni del rombo in base al testo della condizione.
     * Il rombo deve essere abbastanza grande da contenere il testo.
     */
    private void calculateDimensions() {
        IfBlock ifBlock = (IfBlock) block;
        String condition = ifBlock.getCondition();
        if (condition == null || condition.isEmpty()) {
            condition = "?";
        }

        FontMetrics fm = getFontMetrics(document.getViewOptions().getFont());
        int textWidth = fm.stringWidth(condition);
        int textHeight = fm.getHeight();

        // Il rombo deve essere circa 1.5 volte più largo del testo
        // per avere spazio sui lati
        this.diamondWidth = (int) (textWidth * 1.5) + 4 * e;

        // Altezza: abbastanza per il testo + padding
        this.diamondHeight = textHeight + 6 * f;

        // Preferred size include spazio per le linee di connessione
        setPreferredSize(new Dimension(diamondWidth + 4 * e, diamondHeight + 4 * f));
    }

    @Override
    protected void drawBlock(Graphics2D g2d, Color backgroundColor, Color borderColor) {
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        // Centro del pannello
        int centerX = panelWidth / 2;
        int centerY = panelHeight / 2;

        // Calcola i 4 vertici del rombo
        // Formula originale da IMPLEMENTATION_DETAILS.md:
        // Top: (centerX, centerY - diamondHeight/2)
        // Right: (centerX + diamondWidth/2, centerY)
        // Bottom: (centerX, centerY + diamondHeight/2)
        // Left: (centerX - diamondWidth/2, centerY)

        int halfWidth = diamondWidth / 2;
        int halfHeight = diamondHeight / 2;

        int[] xPoints = {
            centerX,              // Top
            centerX + halfWidth,  // Right
            centerX,              // Bottom
            centerX - halfWidth   // Left
        };

        int[] yPoints = {
            centerY - halfHeight, // Top
            centerY,              // Right
            centerY + halfHeight, // Bottom
            centerY               // Left
        };

        // Disegna ombra
        int[] xShadow = new int[4];
        int[] yShadow = new int[4];
        for (int i = 0; i < 4; i++) {
            xShadow[i] = xPoints[i] + 2;
            yShadow[i] = yPoints[i] + 2;
        }
        g2d.setColor(new Color(0, 0, 0, 30));
        g2d.fillPolygon(xShadow, yShadow, 4);

        // Disegna background
        g2d.setColor(backgroundColor);
        g2d.fillPolygon(xPoints, yPoints, 4);

        // Disegna bordo
        g2d.setColor(borderColor);
        g2d.drawPolygon(xPoints, yPoints, 4);

        // Disegna labels "T" e "F"
        drawBranchLabels(g2d, borderColor, centerX, centerY, halfWidth, halfHeight);
    }

    /**
     * Disegna le labels "T" (TRUE) e "F" (FALSE) per i rami.
     * T va a destra, F va in basso.
     */
    private void drawBranchLabels(Graphics2D g2d, Color color, int centerX, int centerY,
                                   int halfWidth, int halfHeight) {
        g2d.setColor(color);
        Font labelFont = document.getViewOptions().getFont().deriveFont(Font.BOLD, 10f);
        g2d.setFont(labelFont);

        // Label "T" a destra
        g2d.drawString("T", centerX + halfWidth + 5, centerY + 5);

        // Label "F" in basso
        g2d.drawString("F", centerX - 5, centerY + halfHeight + 15);
    }

    @Override
    protected void drawText(Graphics2D g2d) {
        IfBlock ifBlock = (IfBlock) block;
        String condition = ifBlock.getCondition();
        if (condition == null || condition.isEmpty()) {
            condition = "?";
        }

        // Disegna il testo della condizione centrato nel rombo
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(condition);
        int textHeight = fm.getAscent();

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        int x = centerX - textWidth / 2;
        int y = centerY + textHeight / 2 - 2; // Leggermente sopra il centro

        g2d.setColor(Color.BLACK);
        g2d.drawString(condition, x, y);
    }

    @Override
    protected void drawConnections(Graphics2D g2d, Color borderColor) {
        g2d.setColor(borderColor);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int halfHeight = diamondHeight / 2;

        // Linea dall'alto al vertice top del rombo
        g2d.drawLine(centerX, 0, centerX, centerY - halfHeight);

        // Linea dal vertice bottom del rombo verso il basso
        g2d.drawLine(centerX, centerY + halfHeight, centerX, getHeight());
    }

    @Override
    protected void onMouseClicked(java.awt.event.MouseEvent e) {
        // TODO: Apri dialog per editare la condizione
        IfBlock ifBlock = (IfBlock) block;
        System.out.println("Clicked on IF: " + ifBlock.getCondition());
    }

    public void updateDimensions() {
        calculateDimensions();
        revalidate();
        repaint();
    }
}
