/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.editor.ui;

import a.c.a.b;
import a.c.b.q;
import a.g.c;
import a.g.d;
import a.j.a.a;
import a.j.a.g;
import a.j.b.C;
import a.j.b.e;
import a.j.b.o;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/*
 * Renamed from a.j.b.c
 */
public final class c_0
extends o {
    e a;
    private String k;
    private String l;
    private Rectangle m;

    public final void a(Rectangle rectangle) {
        this.m = rectangle;
    }

    public c_0(b b2, a a2, a.c.a.d d2) {
        super(b2, a2, d2);
        this.a(d2);
        this.setOpaque(true);
        this.a = new e(b2, a2, null);
        this.add(this.a);
        this.a.g();
        this.g();
        this.a(this.d);
        this.revalidate();
        int n2 = ((q)d2).m();
        if (n2 == 3 || n2 == 2) {
            this.setToolTipText("clic Modifica / Copia / Taglia");
            return;
        }
        this.setToolTipText(null);
    }

    @Override
    public final void a(Graphics graphics) {
        super.a(graphics);
        this.i.b();
        Dimension dimension = this.getPreferredSize();
        int n2 = (int)dimension.getWidth();
        int n3 = (int)dimension.getHeight();
        int n4 = this.getWidth();
        int n5 = this.getHeight();
        graphics.setColor(this.b.q().d());
        graphics.fillRect(0, 0, n4, n5);
        this.a(graphics, 0);
        graphics.fillOval(n2 / 2 - 10 * this.e, 1 * this.f, 20 * this.e, 4 * this.f - 1);
        this.d(graphics);
        String string = this.k;
        FontMetrics fontMetrics = graphics.getFontMetrics();
        graphics.drawOval(n2 / 2 - 10 * this.e, 1 * this.f, 20 * this.e, 4 * this.f - 1);
        graphics.drawLine(n2 / 2, 5 * this.f, n2 / 2, 6 * this.f);
        Rectangle2D rectangle2D = fontMetrics.getStringBounds(string, graphics);
        int n6 = (int)(rectangle2D.getWidth() / 2.0);
        int n7 = (int)Math.round(-rectangle2D.getHeight() / 2.0 - rectangle2D.getY());
        n6 = n2 / 2 - n6;
        n7 = 3 * this.f + n7;
        graphics.drawString(string, n6, n7);
        this.a(graphics, 1);
        graphics.fillOval(n2 / 2 - 10 * this.e, n3 - 5 * this.f, 20 * this.e, 4 * this.f - 1);
        this.d(graphics);
        string = this.l;
        graphics.drawLine(n2 / 2, n3 - 6 * this.f, n2 / 2, n3 - 5 * this.f);
        graphics.drawOval(n2 / 2 - 10 * this.e, n3 - 5 * this.f, 20 * this.e, 4 * this.f);
        Rectangle2D rectangle2D2 = fontMetrics.getStringBounds(string, graphics);
        n6 = (int)(rectangle2D2.getWidth() / 2.0);
        int n8 = (int)Math.round(-rectangle2D2.getHeight() / 2.0 - rectangle2D2.getY());
        n6 = n2 / 2 - n6;
        n8 = n3 - 3 * this.f + n8;
        graphics.drawString(string, n6, n8);
    }

    @Override
    public final void a() {
        int n2;
        Object object = (q)this.i;
        if (((q)object).m() == 2) {
            this.k = "PROC " + ((q)object).j() + "(";
            n2 = 0;
            while (n2 < ((q)object).k()) {
                if (n2 > 0) {
                    this.k = String.valueOf(this.k) + ", ";
                }
                this.k = String.valueOf(this.k) + ((q)object).e(n2);
                ++n2;
            }
            this.k = String.valueOf(this.k) + ")";
            this.l = "RET";
        } else if (((q)object).m() == 3) {
            this.k = "FUNC " + ((q)object).j() + "(";
            n2 = 0;
            while (n2 < ((q)object).k()) {
                if (n2 > 0) {
                    this.k = String.valueOf(this.k) + ", ";
                }
                this.k = String.valueOf(this.k) + ((q)object).e(n2);
                ++n2;
            }
            this.k = String.valueOf(this.k) + ")";
            this.l = "RET " + ((q)object).l();
        } else {
            this.k = "START " + ((q)object).j();
            this.l = "END";
        }
        Dimension dimension = new Dimension(22 * this.e, 12 * this.f);
        this.a.g();
        object = this.a.getMinimumSize();
        dimension.width = Math.max(dimension.width, ((Dimension)object).width);
        dimension.height += ((Dimension)object).height;
        this.a(dimension);
        int n3 = (int)(dimension.getWidth() - ((Dimension)object).getWidth()) / 2;
        this.a.setLocation(n3, 6 * this.f);
        this.j = new Rectangle(n3, this.f, 20 * this.e, 4 * this.f);
        this.m = new Rectangle(n3, dimension.height - 5 * this.f, 20 * this.e, 4 * this.f);
        this.revalidate();
    }

    @Override
    public final void a(a.c.a.d d2, int n2) {
        o o2 = this.b(d2);
        if (this.h != null) {
            C c2 = this.h.a().a(o2);
            o2.a(c2);
        }
        this.a.a(o2, n2);
        d2.a(o2);
        this.g();
        this.d = true;
        this.a(this.d);
        this.revalidate();
    }

    @Override
    public final void a(int n2) {
        this.a.b(n2);
        this.g();
        this.invalidate();
    }

    @Override
    public final void a(a.c.a.d object, boolean bl) {
        super.a((a.c.a.d)object, bl);
        if (!bl && (object = this.b.a()) != null && ((a.c.a.c)object).d() == this.i && ((a.c.a.c)object).c() == 0) {
            object = ((q)this.i).j();
            JPanel jPanel = this.c;
            jPanel = jPanel.c();
            ((g)jPanel).h((String)object);
        }
    }

    @Override
    protected final void b_() {
        block3: {
            block4: {
                a.c.a.c c2;
                a.c.a.d d2;
                block2: {
                    d2 = null;
                    c2 = this.b.a();
                    if (c2 != null) {
                        d2 = this.b.a().d();
                    }
                    if (d2 != null) break block2;
                    if (this.b.j() != this.i || this.j == null) break block3;
                    break block4;
                }
                if (d2 == this.i && c2.c() == 1) {
                    this.scrollRectToVisible(this.m);
                    return;
                }
            }
            this.scrollRectToVisible(this.j);
        }
    }

    @Override
    public final void a(MouseEvent mouseEvent) {
        if (((q)this.i).m() != 1) {
            JPopupMenu jPopupMenu = new JPopupMenu();
            JMenuItem jMenuItem = new JMenuItem(a.i.c.a("instructionModify"));
            jMenuItem.addActionListener(this);
            jPopupMenu.add(jMenuItem);
            jPopupMenu.addSeparator();
            jMenuItem = new JMenuItem(a.i.c.a("codeDuplicate"));
            jMenuItem.addActionListener(this);
            jPopupMenu.add(jMenuItem);
            jMenuItem = new JMenuItem(a.i.c.a("codeDelete"));
            jMenuItem.addActionListener(this);
            jPopupMenu.add(jMenuItem);
            jPopupMenu.show(mouseEvent.getComponent(), mouseEvent.getX(), mouseEvent.getY());
        }
    }

    @Override
    public final void actionPerformed(ActionEvent object) {
        if ((object = ((ActionEvent)object).getActionCommand()) != null && ((String)object).length() > 0) {
            if (((String)object).equals(a.i.c.a("instructionModify"))) {
                this.a_();
                return;
            }
            if (((String)object).equals(a.i.c.a("codeDuplicate"))) {
                JOptionPane.showMessageDialog(this.c.a(), "TO DO!");
                return;
            }
            if (((String)object).equals(a.i.c.a("codeDelete"))) {
                object = new c(this.b, (q)this.i);
                this.b.b(((q)this.i).j());
                this.c.c().a((a.g.g)object);
            }
        }
    }

    @Override
    protected final void a_() {
        if (((q)this.i).m() != 1) {
            d d2 = new d(this.b, (q)this.i);
            boolean bl = a.a.c.a(this.c.a(), (q)this.i, this.b);
            if (bl) {
                this.c.c().a(d2);
                this.b.a(true);
            }
            this.b.a((a.c.a.d)null);
        }
    }

    @Override
    public final void a(C c2) {
        super.a(c2);
        c2 = c2.a().a(this.a);
        this.a.a(c2);
    }
}

