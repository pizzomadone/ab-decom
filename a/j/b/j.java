/*
 * Decompiled with CFR 0.152.
 */
package a.j.b;

import a.c.a.b;
import a.c.a.d;
import a.c.b.k;
import a.j.a.a;
import a.j.b.o;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class j
extends o {
    private String[] a;
    private int[] k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private String q = "I/O";

    public j(b b2, a a2, d d2) {
        super(b2, a2, d2);
        this.a(d2);
        this.g();
    }

    public final void a(String string) {
        this.q = string;
    }

    @Override
    public final void a(Graphics graphics) {
        int n2 = this.getWidth();
        int n3 = this.getHeight();
        int[] nArray = new int[]{n2 / 2 - this.o, n2 / 2 + this.n, n2 / 2 + this.o, n2 / 2 - this.n};
        int[] nArray2 = new int[]{this.f, this.f, this.f + this.p, this.f + this.p};
        this.b(graphics);
        graphics.fillPolygon(nArray, nArray2, 4);
        this.c(graphics);
        graphics.drawPolygon(nArray, nArray2, 4);
        graphics.drawLine(n2 / 2, 0, n2 / 2, this.f);
        graphics.drawLine(n2 / 2, n3 - this.f, n2 / 2, n3);
        Object object = this;
        object = ((j)object).q;
        int n4 = this.f + this.p;
        int n5 = n2 / 2 - this.n + this.e;
        graphics.drawString((String)object, n5 + this.b.q().h(), n4 - this.b.q().h());
        n4 = this.m;
        n5 = 0;
        while (n5 < this.a.length) {
            graphics.drawString(this.a[n5], n2 / 2 - this.k[n5] / 2, n4);
            n4 += 2 * this.f;
            ++n5;
        }
    }

    @Override
    public void a() {
        Object object = ((k)this.i).k();
        this.a = ((String)object).split("\\n");
        this.k = new int[this.a.length];
        object = this.getFontMetrics(this.getFont());
        this.l = 0;
        Rectangle2D rectangle2D = ((FontMetrics)object).getStringBounds(this.a[0], this.getGraphics());
        this.m = (int)((double)(3 * this.f) - rectangle2D.getHeight() / 2.0 - rectangle2D.getY());
        this.p = (this.a.length + 1 << 1) * this.f;
        int n2 = 0;
        while (n2 < this.a.length) {
            this.k[n2] = ((FontMetrics)object).charsWidth(this.a[n2].toCharArray(), 0, this.a[n2].length());
            int n3 = this.k[n2];
            if (n2 == this.a.length - 1) {
                j j2 = this;
                j j3 = j2;
                j3 = this;
                n3 += 2 * (((FontMetrics)object).charsWidth(j2.q.toCharArray(), 0, j3.q.length()) - this.p / 2 + this.e);
            }
            this.l = Math.max(this.l, n3);
            ++n2;
        }
        n2 = this.l + 2 * this.e;
        this.o = n2 / 2;
        this.n = this.o + this.p / 2;
        this.a(new Dimension((this.n << 1) + 2 * this.e, this.p + 2 * this.f));
        this.j = new Rectangle(this.getWidth() / 2 - n2 / 2, this.f, n2, this.p);
    }
}

