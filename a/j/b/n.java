/*
 * Decompiled with CFR 0.152.
 */
package a.j.b;

import a.c.a.b;
import a.j.a.a;
import a.j.b.C;
import a.k.b_0;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class n
extends JPanel
implements ActionListener,
MouseListener {
    protected b b;
    protected a c;
    protected boolean d = false;
    protected int e = (int)(6.0 * b_0.a());
    protected int f = (int)(6.0 * b_0.a());
    private int a = -1;
    protected boolean g = false;
    C h;

    public n(b b2, a a2) {
        this.b = b2;
        this.c = a2;
        this.setLayout(null);
        this.a(new Dimension(2 * this.e, 2 * this.f));
        this.addMouseListener(this);
        this.setToolTipText(null);
        this.setFont(b2.q().b());
        this.setOpaque(false);
    }

    public final void a(n n2, int n3) {
        n2.add((Component)this, 0);
        this.a = 0;
    }

    public int b() {
        return this.a;
    }

    @Override
    public String toString() {
        return "ABVFC_BasePanel ";
    }

    public final void a(Dimension dimension) {
        this.setPreferredSize(dimension);
        this.setMinimumSize(dimension);
        this.setMaximumSize(dimension);
        this.setSize(dimension);
    }

    protected final void a(boolean bl) {
        if (this.f()) {
            this.g();
        }
        this.d |= bl;
        try {
            ((n)this.getParent()).a(this.d);
            return;
        }
        catch (Exception exception) {
            this.invalidate();
            return;
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        this.g = true;
        this.repaint();
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        this.g = false;
        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if (mouseEvent.isPopupTrigger()) {
            this.c();
            return;
        }
        this.a(mouseEvent);
    }

    protected void a(MouseEvent mouseEvent) {
    }

    protected void c() {
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(this, "ABVFC_BasePanel - ActionPerformed - NOT IMPLEMENTED");
    }

    public boolean f() {
        return false;
    }

    protected void b(Graphics graphics) {
        if (this.g) {
            graphics.setColor(this.b.q().g());
            return;
        }
        graphics.setColor(this.b.q().e());
    }

    protected void c(Graphics graphics) {
        if (this.g) {
            graphics.setColor(this.b.q().k());
            return;
        }
        graphics.setColor(this.b.q().i());
    }

    protected void a(Graphics graphics, int n2) {
        if (this.g) {
            graphics.setColor(this.b.q().g());
            return;
        }
        graphics.setColor(this.b.q().e());
    }

    protected void d(Graphics graphics) {
        if (this.g) {
            graphics.setColor(this.b.q().k());
            return;
        }
        graphics.setColor(this.b.q().i());
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (this.h != null) {
            this.h.a(this, graphics);
            return;
        }
        this.a(graphics);
    }

    public final void g() {
        this.e = this.f = (this.b.q().b().getSize() + 1) / 2;
        this.setFont(this.b.q().b());
        if (this.h != null) {
            this.h.a(this);
            return;
        }
        this.a();
    }

    public void a(Graphics graphics) {
        n n2 = this;
        ((Graphics2D)graphics).setStroke(n2.b.q().l());
        ((Graphics2D)graphics).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public void a() {
    }

    public void a(C c2) {
        this.h = c2;
        if (c2 != null) {
            c2.b(this);
        }
    }

    @Override
    public void printComponent(Graphics graphics) {
        this.paintComponent(graphics);
    }
}

