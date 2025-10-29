/*
 * Decompiled with CFR 0.152.
 */
package a.j.b;

import a.a.i;
import a.c.a.b;
import a.c.a.d;
import a.c.b.l;
import a.c.b.n;
import a.j.a.a;
import a.j.b.C;
import a.j.b.e;
import a.j.b.o;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.RectangularShape;

public final class m
extends o {
    private e a;
    private e k;
    private String[] l;
    private int[] m;
    private int n;
    private int o;
    private int p;
    private int q;

    public m(b b2, a a2, d d2) {
        super(b2, a2, d2);
        this.a(d2);
        d2 = (l)d2;
        this.k = new e(b2, a2, null);
        this.add(this.k);
        ((l)d2).j().a(this.k);
        this.a = new e(b2, a2, null);
        this.add(this.a);
        ((l)d2).k().a(this.a);
        this.g();
    }

    @Override
    public final void a(Graphics graphics) {
        int n2;
        int n3;
        int n4 = this.getWidth();
        int n5 = this.getHeight();
        int n6 = this.q;
        Dimension dimension = this.a.getSize();
        Dimension dimension2 = this.k.getSize();
        int n7 = (int)dimension.getWidth();
        if ((double)n3 < dimension2.getWidth()) {
            n7 = (int)dimension2.getWidth();
        }
        int n8 = (int)dimension.getHeight();
        if ((double)n2 < dimension2.getHeight()) {
            dimension2.getHeight();
        }
        this.a.getWidth();
        this.k.getWidth();
        this.a.getSize();
        this.k.getSize();
        int[] nArray = new int[]{n4 / 2 - this.p / 2, n4 / 2, n4 / 2 + this.p / 2, n4 / 2};
        int[] nArray2 = new int[4];
        nArray2[0] = this.q / 2;
        nArray2[2] = this.q / 2;
        nArray2[3] = this.q;
        int[] nArray3 = nArray2;
        this.a(graphics, 0);
        graphics.fillPolygon(nArray, nArray3, 4);
        this.d(graphics);
        graphics.drawPolygon(nArray, nArray3, 4);
        graphics.drawLine(n7 / 2, this.q / 2, n4 / 2 - this.p / 2, this.q / 2);
        graphics.drawLine(n7 / 2, this.q / 2, n7 / 2, n6);
        graphics.drawLine(n4 / 2 + this.p / 2, this.q / 2, n4 - n7 / 2, this.q / 2);
        graphics.drawLine(n4 - n7 / 2, this.q / 2, n4 - n7 / 2, n6);
        graphics.drawLine(n7 / 2, (int)((double)(this.q / 2) + dimension.getHeight() + (double)this.f), n7 / 2, n5 - this.f);
        graphics.drawLine(n7 / 2, n5 - this.f, n4 / 2, n5 - this.f);
        graphics.drawLine(n4 - n7 / 2, (int)((double)(this.q / 2) + dimension2.getHeight() + (double)this.f), n4 - n7 / 2, n5 - this.f);
        graphics.drawLine(n4 - n7 / 2, n5 - this.f, n4 / 2, n5 - this.f);
        graphics.drawLine(n4 / 2, n5 - 1 * this.f, n4 / 2, n5);
        n5 = this.o;
        n6 = 0;
        while (n6 < this.l.length) {
            graphics.drawString(this.l[n6], n4 / 2 - this.m[n6] / 2, n5);
            n5 += 2 * this.f;
            ++n6;
        }
        FontMetrics fontMetrics = graphics.getFontMetrics();
        n6 = fontMetrics.charsWidth("F".toCharArray(), 0, 1);
        graphics.drawString("F", n4 / 2 - this.p / 2 - n6, this.q / 2 - 2);
        graphics.drawString("T", n4 / 2 + this.p / 2, this.q / 2 - 2);
    }

    @Override
    public final void a() {
        int n2;
        int n3;
        this.a.g();
        this.k.g();
        Object object = this.getFontMetrics(this.getFont());
        String string = this.i.b();
        this.l = string.split("\\n");
        this.m = new int[this.l.length];
        this.n = 0;
        int n4 = 0;
        while (n4 < this.l.length) {
            this.m[n4] = ((FontMetrics)object).charsWidth(this.l[n4].toCharArray(), 0, this.l[n4].length());
            this.n = Math.max(this.n, this.m[n4]);
            ++n4;
        }
        n4 = ((int)Math.ceil((double)this.n / (double)(2 * this.e)) << 1) * this.e;
        int n5 = (this.l.length << 1) * this.f;
        this.q = n5 + n4 / 2;
        this.p = this.q << 1;
        object = ((FontMetrics)object).getStringBounds(this.l[0], this.getGraphics());
        this.o = (int)((double)(this.q / 2 - n5 / 2 + this.f) - ((RectangularShape)object).getHeight() / 2.0 - ((RectangularShape)object).getY());
        int n6 = 1 * this.e;
        int n7 = 1 * this.e;
        int n8 = 2 * this.f;
        int n9 = this.q;
        Dimension dimension = this.a.getSize();
        Dimension dimension2 = this.k.getSize();
        int n10 = this.p;
        int n11 = (int)dimension.getWidth();
        if ((double)n3 < dimension2.getWidth()) {
            n11 = (int)dimension2.getWidth();
        }
        int n12 = (int)dimension.getHeight();
        if ((double)n2 < dimension2.getHeight()) {
            n12 = (int)dimension2.getHeight();
        }
        if (n10 < n11) {
            n10 = n11;
        }
        this.a(new Dimension(n6 + n10 + n7 + n11, this.q + n8 + n12));
        n8 = (int)(((double)n11 - dimension.getWidth()) / 2.0);
        this.a.setLocation(n8, n9);
        n8 = (int)((double)(n6 + n10 + n7 + n11 / 2) - dimension2.getWidth() / 2.0);
        this.k.setLocation(n8, n9);
        this.j = new Rectangle(this.getWidth() / 2 - n4 / 2, this.o, n4, n5);
    }

    @Override
    public final void a(C c2) {
        super.a(c2);
        C c3 = c2.a().a(this.k);
        this.k.a(c3);
        c3 = c2.a().a(this.a);
        this.a.a(c3);
    }

    public final e d() {
        return this.a;
    }

    public final e e() {
        return this.k;
    }

    @Override
    protected final void a_() {
        a.g.e e2 = new a.g.e((n)this.i);
        boolean bl = a.a.i.a(this.c.a(), (l)this.i);
        if (bl) {
            this.c.c().a(e2);
            this.b.a(true);
        }
        this.b.a((d)null);
    }
}

