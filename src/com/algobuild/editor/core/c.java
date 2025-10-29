/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.editor.core;

import a.j.a.b;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.util.Vector;
import javax.swing.JPanel;

public final class c
extends JPanel {
    private a.c.a.b a;
    private Vector b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private static Color[] j;

    public c(a.c.a.b b2) {
        Color[] colorArray = new Color[6];
        j = colorArray;
        colorArray[0] = new Color(191, 255, 255);
        a.j.a.c.j[1] = new Color(255, 191, 255);
        a.j.a.c.j[2] = new Color(255, 255, 191);
        a.j.a.c.j[3] = new Color(255, 191, 191);
        a.j.a.c.j[4] = new Color(191, 255, 191);
        a.j.a.c.j[5] = new Color(191, 191, 255);
        this.b = new Vector(100);
        this.a = b2;
        this.e = 0;
        this.setBackground(Color.WHITE);
    }

    @Override
    protected final void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        FontMetrics fontMetrics = this.getFontMetrics(this.getFont());
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        while (n4 < this.b.size()) {
            int n5;
            int n6;
            b b2 = (b)this.b.get(n4);
            String string = b2.a();
            Rectangle2D rectangle2D = fontMetrics.getStringBounds(string, graphics);
            if (!(rectangle2D.getWidth() < 5.0)) {
                rectangle2D.getHeight();
            }
            if (!b2.d()) {
                n6 = 0;
                if (this.a.r().a()) {
                    n5 = (int)(0.25 * (double)fontMetrics.getHeight());
                    n6 = b2.b() * fontMetrics.getHeight();
                    graphics.setColor(j[b2.b() % j.length]);
                    graphics.fillRect(n6 - n5, n2, n5, fontMetrics.getHeight());
                }
                graphics.setColor(Color.BLACK);
                graphics.drawString(string, n3 + n6, (int)((double)n2 - rectangle2D.getY()));
                n3 += (int)rectangle2D.getWidth();
                if (b2.c()) {
                    n3 = 0;
                }
                if (b2.c() || this.a.r().a()) {
                    n2 = (int)rectangle2D.getHeight() + n2;
                }
            } else if (this.a.r().a()) {
                n6 = (int)(0.25 * (double)fontMetrics.getHeight());
                n5 = b2.b() * fontMetrics.getHeight();
                graphics.setColor(j[b2.b() % j.length]);
                graphics.fillRect(n5 - n6, n2, n6, fontMetrics.getHeight());
                graphics.fillRect(n5, n2, (int)rectangle2D.getWidth(), (int)rectangle2D.getHeight());
                if (b2.e()) {
                    graphics.setColor(Color.RED);
                } else {
                    graphics.setColor(Color.BLUE);
                }
                graphics.drawString(string, n5, (int)((double)n2 - rectangle2D.getY()));
                n2 = (int)rectangle2D.getHeight() + n2;
            }
            ++n4;
        }
    }

    protected final void a() {
        Graphics graphics = this.getGraphics();
        FontMetrics fontMetrics = this.getFontMetrics(this.getFont());
        int n2 = 0;
        int n3 = 0;
        int n4 = 10;
        this.f = 0;
        this.g = 0;
        this.c = 0;
        this.d = 0;
        int n5 = 0;
        while (n5 < this.b.size()) {
            int n6;
            b b2 = (b)this.b.get(n5);
            String string = b2.a();
            Rectangle2D rectangle2D = fontMetrics.getStringBounds(string, graphics);
            n4 = (int)rectangle2D.getHeight();
            if (!b2.d()) {
                n6 = b2.b() * fontMetrics.getHeight();
                if ((n3 += (int)rectangle2D.getWidth()) > this.d) {
                    this.d = n3;
                }
                if (n3 + n6 > this.g) {
                    this.g = n3 + n6;
                }
                this.c = (int)rectangle2D.getHeight() + n2;
                if (b2.c()) {
                    n3 = 0;
                }
                if (b2.c()) {
                    n2 = (int)rectangle2D.getHeight() + n2;
                }
            } else {
                n6 = b2.b() * fontMetrics.getHeight();
                if (n6 + (int)rectangle2D.getWidth() > this.g) {
                    this.g = n6 + (int)rectangle2D.getWidth();
                }
            }
            ++n5;
        }
        this.f = this.b.size() * n4;
        this.revalidate();
        this.repaint();
    }

    public final void a(String object, boolean bl, boolean bl2, boolean bl3) {
        if (bl2) {
            object = object.replaceAll("\\\\n", "");
            bl = false;
        }
        object = object.split("\\\\n");
        FontMetrics fontMetrics = this.getFontMetrics(this.getFont());
        int n2 = this.e * fontMetrics.getHeight();
        Graphics graphics = this.getGraphics();
        Object object2 = null;
        int n3 = 0;
        int n4 = 0;
        while (n4 < ((String[])object).length) {
            boolean bl4;
            boolean bl5 = bl4 = bl || n4 < ((String[])object).length - 1;
            if (object[n4].length() > 0 || bl4) {
                ++n3;
                object2 = new b(object[n4], this.e, bl4, bl2, bl3);
                this.b.add(object2);
                object2 = fontMetrics.getStringBounds(object[n4], graphics);
                if (!bl2) {
                    if (bl4) {
                        this.h = 0;
                        this.i += (int)((RectangularShape)object2).getHeight();
                    } else {
                        this.h += (int)((RectangularShape)object2).getWidth();
                    }
                    if ((double)this.h + ((RectangularShape)object2).getWidth() > (double)this.d) {
                        this.d = this.h + (int)((RectangularShape)object2).getWidth();
                    }
                    this.c = this.i + (int)((RectangularShape)object2).getHeight();
                }
                if ((double)(n2 + this.h) + ((RectangularShape)object2).getWidth() > (double)this.g) {
                    this.g = n2 + this.h + (int)((RectangularShape)object2).getWidth();
                }
            }
            ++n4;
        }
        if (n3 > 0) {
            this.f = this.b.size() * (int)((RectangularShape)object2).getHeight();
            this.revalidate();
            if (object2 != null) {
                if (!this.a.r().a()) {
                    this.scrollRectToVisible(new Rectangle(this.h, this.i, (int)((RectangularShape)object2).getWidth(), (int)((RectangularShape)object2).getHeight()));
                } else {
                    this.scrollRectToVisible(new Rectangle(n2 + this.h, this.f - (int)((RectangularShape)object2).getHeight(), (int)((RectangularShape)object2).getWidth(), (int)((RectangularShape)object2).getHeight()));
                }
            }
            this.repaint();
        }
    }

    public final void a(int n2) {
        if (n2 >= 0 && n2 <= 100) {
            this.e = n2;
        }
    }

    public final void b() {
        this.b.removeAllElements();
        this.c = 0;
        this.d = 0;
        this.i = 0;
        this.h = 0;
        this.e = 0;
        Dimension dimension = new Dimension(this.d, this.c);
        this.setPreferredSize(dimension);
        this.setMinimumSize(dimension);
        this.revalidate();
        this.repaint();
    }

    @Override
    public final Dimension getPreferredSize() {
        Dimension dimension = !this.a.r().a() ? new Dimension(this.d, this.c) : new Dimension(this.g, this.f);
        return dimension;
    }
}

