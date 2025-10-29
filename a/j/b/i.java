/*
 * Decompiled with CFR 0.152.
 */
package a.j.b;

import a.a.j;
import a.c.a.b;
import a.c.a.d;
import a.c.b.g;
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

public final class i
extends o {
    private e a;
    private String[] k;
    private int[] l;
    private int m;
    private int n;
    private int o;
    private int p;

    public i(b b2, a a2, d d2) {
        super(b2, a2, d2);
        this.a(d2);
        this.a = new e(b2, a2, null);
        this.add(this.a);
        this.g();
    }

    @Override
    public final void a(Graphics graphics) {
        int n2 = this.getWidth();
        int n3 = this.getHeight();
        int[] nArray = new int[]{n2 / 2 - this.o / 2, n2 / 2, n2 / 2 + this.o / 2, n2 / 2};
        int[] nArray2 = new int[]{this.p / 2 + 2 * this.f, 2 * this.f, this.p / 2 + 2 * this.f, this.p + 2 * this.f};
        this.a(graphics, 0);
        graphics.fillPolygon(nArray, nArray2, 4);
        this.d(graphics);
        graphics.drawPolygon(nArray, nArray2, 4);
        this.d(graphics);
        int n4 = this.e;
        int n5 = n2 - this.e;
        graphics.drawLine(n2 / 2, 0, n2 / 2, 2 * this.f);
        graphics.drawLine(n4, 1 * this.f, n2 / 2, 1 * this.f);
        int n6 = this.b.q().m();
        graphics.drawLine(n2 / 2, 1 * this.f, n2 / 2 - n6, 1 * this.f - n6);
        graphics.drawLine(n2 / 2, 1 * this.f, n2 / 2 - n6, 1 * this.f + n6);
        graphics.drawLine(n4, 1 * this.f, n4, n3 - 2 * this.f);
        graphics.drawLine(n4, n3 - 2 * this.f, n2 / 2, n3 - 2 * this.f);
        graphics.drawLine(n2 / 2, n3 - 2 * this.f, n2 / 2, n3 - 3 * this.f);
        graphics.drawLine(n2 / 2, this.p + 4 * this.f, n2 / 2, this.p + 2 * this.f);
        graphics.drawLine(n2 / 2 + this.o / 2, this.p / 2 + 2 * this.f, n5, this.p / 2 + 2 * this.f);
        graphics.drawLine(n5, this.p / 2 + 2 * this.f, n5, n3 - this.f);
        graphics.drawLine(n5, n3 - 1 * this.f, n2 / 2, n3 - 1 * this.f);
        graphics.drawLine(n2 / 2, n3 - 1 * this.f, n2 / 2, n3);
        n3 = this.n;
        n4 = 0;
        while (n4 < this.k.length) {
            graphics.drawString(this.k[n4], n2 / 2 - this.l[n4] / 2, n3);
            n3 += 2 * this.f;
            ++n4;
        }
        graphics.drawString("F", n2 / 2 + this.o / 2 + 2, this.p / 2 + 2 * this.f - 2);
        graphics.drawString("T", n2 / 2 + 2, this.p + 4 * this.f - 2);
    }

    @Override
    public final void a() {
        this.a.g();
        Object object = this.getFontMetrics(this.getFont());
        String string = this.i.b();
        this.k = string.split("\\n");
        this.l = new int[this.k.length];
        this.m = 0;
        int n2 = 0;
        while (n2 < this.k.length) {
            this.l[n2] = ((FontMetrics)object).charsWidth(this.k[n2].toCharArray(), 0, this.k[n2].length());
            this.m = Math.max(this.m, this.l[n2]);
            ++n2;
        }
        n2 = ((int)Math.ceil((double)this.m / (double)(2 * this.e)) << 1) * this.e;
        int n3 = (this.k.length << 1) * this.f;
        this.p = n3 + n2 / 2;
        this.o = this.p << 1;
        object = ((FontMetrics)object).getStringBounds(this.k[0], this.getGraphics());
        this.n = (int)((double)(this.p / 2 - n3 / 2 + 3 * this.f) - ((RectangularShape)object).getHeight() / 2.0 - ((RectangularShape)object).getY());
        int n4 = 2 * this.e;
        int n5 = 2 * this.e;
        int n6 = 4 * this.f;
        int n7 = 3 * this.f;
        int n8 = this.p + n6;
        Dimension dimension = this.a.getSize();
        int n9 = this.o;
        if (dimension.getWidth() > (double)n9) {
            n9 = (int)dimension.getWidth();
        }
        Dimension dimension2 = new Dimension(n4 + n9 + n5, (int)((double)(this.p + n6 + n7) + dimension.getHeight()));
        this.a(dimension2);
        n4 = (int)((double)n4 + ((double)n9 - dimension.getWidth()) / 2.0);
        this.a.setLocation(n4, n8);
        this.j = new Rectangle(this.getWidth() / 2 - n2 / 2, this.n, n2, n3);
    }

    @Override
    public final void a(d d2, int n2) {
        o o2 = this.b(d2);
        this.a.a(o2, n2);
        if (this.h != null) {
            C c2 = this.h.a().a(o2);
            o2.a(c2);
        }
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
        this.a(true);
        this.revalidate();
    }

    @Override
    protected final void a_() {
        a.g.e e2 = new a.g.e((n)this.i);
        boolean bl = a.a.j.a(this.c.a(), (g)this.i);
        if (bl) {
            this.c.c().a(e2);
            this.b.a(true);
        }
        this.b.a((d)null);
    }

    public final e d() {
        return this.a;
    }

    @Override
    public final void a(C c2) {
        super.a(c2);
        c2 = c2.a().a(this.a);
        this.a.a(c2);
    }
}

