package algobuild.model;

import java.awt.*;

/**
 * Gestisce le opzioni di visualizzazione per l'editor AlgoBuild.
 * Equivalente a: a.c.a.i nell'originale
 *
 * Responsabilità:
 * - Font e sizing (unità e ed f)
 * - Colori per 3 stati: normale, hover, executing
 * - Stroke per disegno linee
 * - Dimensioni frecce e margini
 */
public class ViewOptions {

    // Font
    private Font font;

    // Colori per stati
    private Color normalBackground;
    private Color normalBorder;
    private Color hoverBackground;
    private Color hoverBorder;
    private Color executingBackground;
    private Color executingBorder;

    // Sizing
    private int marginWidth;
    private int arrowSize;
    private BasicStroke lineStroke;

    public ViewOptions() {
        // Default font
        this.font = new Font("Dialog", Font.PLAIN, 14);

        // Colori default (simili all'originale)
        this.normalBackground = new Color(255, 255, 230);      // Giallo chiaro
        this.normalBorder = Color.BLACK;
        this.hoverBackground = new Color(255, 240, 200);       // Giallo più scuro
        this.hoverBorder = Color.BLUE;
        this.executingBackground = new Color(180, 255, 180);   // Verde chiaro
        this.executingBorder = new Color(0, 150, 0);           // Verde scuro

        // Sizing default
        this.marginWidth = 5;
        this.arrowSize = 5;
        this.lineStroke = new BasicStroke(1.0f);
    }

    // ========== Font Methods ==========

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    /**
     * Calcola l'unità di width (e) basata sul font.
     * Formula originale: e = (fontHeight + 1) / 2
     */
    public int getWidthUnit() {
        return (font.getSize() + 1) / 2;
    }

    /**
     * Calcola l'unità di height (f) basata sul font.
     * Formula originale: f = (fontHeight + 1) / 2
     */
    public int getHeightUnit() {
        return (font.getSize() + 1) / 2;
    }

    // ========== Color Methods ==========

    public Color getNormalBackground() {
        return normalBackground;
    }

    public void setNormalBackground(Color normalBackground) {
        this.normalBackground = normalBackground;
    }

    public Color getNormalBorder() {
        return normalBorder;
    }

    public void setNormalBorder(Color normalBorder) {
        this.normalBorder = normalBorder;
    }

    public Color getHoverBackground() {
        return hoverBackground;
    }

    public void setHoverBackground(Color hoverBackground) {
        this.hoverBackground = hoverBackground;
    }

    public Color getHoverBorder() {
        return hoverBorder;
    }

    public void setHoverBorder(Color hoverBorder) {
        this.hoverBorder = hoverBorder;
    }

    public Color getExecutingBackground() {
        return executingBackground;
    }

    public void setExecutingBackground(Color executingBackground) {
        this.executingBackground = executingBackground;
    }

    public Color getExecutingBorder() {
        return executingBorder;
    }

    public void setExecutingBorder(Color executingBorder) {
        this.executingBorder = executingBorder;
    }

    // ========== Sizing Methods ==========

    public int getMarginWidth() {
        return marginWidth;
    }

    public void setMarginWidth(int marginWidth) {
        this.marginWidth = marginWidth;
    }

    public int getArrowSize() {
        return arrowSize;
    }

    public void setArrowSize(int arrowSize) {
        this.arrowSize = arrowSize;
    }

    public BasicStroke getLineStroke() {
        return lineStroke;
    }

    public void setLineStroke(BasicStroke lineStroke) {
        this.lineStroke = lineStroke;
    }
}
