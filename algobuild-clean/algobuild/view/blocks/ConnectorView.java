package algobuild.view.blocks;

import algobuild.model.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * View per connettori tra blocchi (frecce).
 * Equivalente a: a.j.b.f nell'originale
 *
 * Rendering:
 * - Linea verticale
 * - Freccia verso il basso
 * - Cliccabile per inserire nuovo blocco
 * - Mostra "NEW" al passaggio del mouse
 */
public class ConnectorView extends JPanel {

    private Document document;
    private boolean hovered;
    private OnConnectorClickListener clickListener;

    // Dimensioni
    private int lineHeight;

    public ConnectorView(Document document, int lineHeight) {
        this.document = document;
        this.lineHeight = lineHeight;
        this.hovered = false;

        setPreferredSize(new Dimension(100, lineHeight));
        setOpaque(false); // Trasparente per vedere i blocchi dietro

        setupListeners();
    }

    private void setupListeners() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hovered = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hovered = false;
                repaint();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (clickListener != null) {
                    clickListener.onConnectorClicked(ConnectorView.this);
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;

        // Determina colore in base allo stato
        Color lineColor;
        if (hovered) {
            lineColor = document.getViewOptions().getHoverBorder();
        } else {
            lineColor = document.getViewOptions().getNormalBorder();
        }

        g2d.setColor(lineColor);
        g2d.setStroke(document.getViewOptions().getLineStroke());

        // Disegna linea verticale
        g2d.drawLine(centerX, 0, centerX, height);

        // Disegna freccia verso il basso
        int arrowSize = document.getViewOptions().getArrowSize();
        int arrowY = height - arrowSize;

        g2d.drawLine(centerX, height, centerX - arrowSize, arrowY);
        g2d.drawLine(centerX, height, centerX + arrowSize, arrowY);

        // Se hover, mostra area cliccabile e testo "NEW"
        if (hovered) {
            // Background semi-trasparente
            g2d.setColor(new Color(
                document.getViewOptions().getHoverBackground().getRed(),
                document.getViewOptions().getHoverBackground().getGreen(),
                document.getViewOptions().getHoverBackground().getBlue(),
                150
            ));
            g2d.fillRect(centerX - 20, height / 2 - 10, 40, 20);

            // Bordo
            g2d.setColor(lineColor);
            g2d.drawRect(centerX - 20, height / 2 - 10, 40, 20);

            // Testo "NEW"
            g2d.setFont(new Font("Dialog", Font.BOLD, 10));
            FontMetrics fm = g2d.getFontMetrics();
            String text = "NEW";
            int textWidth = fm.stringWidth(text);
            int textX = centerX - textWidth / 2;
            int textY = height / 2 + fm.getAscent() / 2 - 2;

            g2d.setColor(Color.BLACK);
            g2d.drawString(text, textX, textY);
        }
    }

    // ========== Listener Interface ==========

    public interface OnConnectorClickListener {
        void onConnectorClicked(ConnectorView connector);
    }

    public void setOnConnectorClickListener(OnConnectorClickListener listener) {
        this.clickListener = listener;
    }

    // ========== Getters/Setters ==========

    public int getLineHeight() {
        return lineHeight;
    }

    public void setLineHeight(int lineHeight) {
        this.lineHeight = lineHeight;
        setPreferredSize(new Dimension(getWidth(), lineHeight));
        revalidate();
        repaint();
    }
}
