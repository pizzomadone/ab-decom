/*
 * Decompiled with CFR 0.152.
 */
package a.j.b;

import a.c.a.b;
import a.c.a.d;
import a.c.b.f;
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

public final class h
extends o {
    private e a;
    private String[] k;
    private int[] l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;

    public h(b b2, a a2, d d2) {
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
        int[] nArray = new int[]{n2 / 2 - this.o, n2 / 2 - this.p, n2 / 2 + this.p, n2 / 2 + this.o, n2 / 2 + this.p, n2 / 2 - this.p};
        int[] nArray2 = new int[]{this.q / 2 + 2 * this.f, 2 * this.f, 2 * this.f, this.q / 2 + 2 * this.f, this.q + 2 * this.f, this.q + 2 * this.f};
        this.b(graphics);
        graphics.fillPolygon(nArray, nArray2, 6);
        this.c(graphics);
        graphics.drawPolygon(nArray, nArray2, 6);
        this.c(graphics);
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
        graphics.drawLine(n2 / 2, this.q + 4 * this.f, n2 / 2, this.q + 2 * this.f);
        graphics.drawLine(n2 / 2 + this.o, this.q / 2 + 2 * this.f, n5, this.q / 2 + 2 * this.f);
        graphics.drawLine(n5, this.q / 2 + 2 * this.f, n5, n3 - this.f);
        graphics.drawLine(n5, n3 - 1 * this.f, n2 / 2, n3 - 1 * this.f);
        graphics.drawLine(n2 / 2, n3 - 1 * this.f, n2 / 2, n3);
        String string = this.i.b();
        if (string != null) {
            int n7 = this.n;
            n4 = 0;
            while (n4 < this.k.length) {
                graphics.drawString(this.k[n4], n2 / 2 - this.l[n4] / 2, n7);
                n7 += 2 * this.f;
                ++n4;
            }
        }
        graphics.drawString("F", n2 / 2 + this.o + 2, this.q / 2 + 2 * this.f - 2);
        graphics.drawString("T", n2 / 2 + 2, this.q + 4 * this.f - 2);
    }

    @Override
    public final void a() {
        Object object = this.i.b();
        this.a.g();
        FontMetrics fontMetrics = this.getFontMetrics(this.getFont());
        this.k = ((String)object).split("\\\\n");
        this.l = new int[this.k.length];
        this.m = 0;
        object = fontMetrics.getStringBounds(this.k[0], this.getGraphics());
        this.n = (int)((double)(4 * this.f) - ((RectangularShape)object).getHeight() / 2.0 - ((RectangularShape)object).getY());
        int n2 = 0;
        while (n2 < this.k.length) {
            this.l[n2] = fontMetrics.charsWidth(this.k[n2].toCharArray(), 0, this.k[n2].length());
            this.m = Math.max(this.m, this.l[n2]);
            ++n2;
        }
        n2 = (2 + ((int)Math.ceil((double)this.m / (double)(2 * this.e)) << 1)) * this.e;
        this.q = (this.k.length + 1 << 1) * this.f;
        this.p = n2 / 2;
        this.o = this.p + this.q / 2;
        int n3 = 2 * this.e;
        int n4 = 2 * this.e;
        int n5 = 4 * this.f;
        int n6 = 3 * this.f;
        int n7 = this.q + n5;
        Dimension dimension = this.a.getSize();
        int n8 = this.o << 1;
        if (dimension.getWidth() > (double)n8) {
            n8 = (int)dimension.getWidth();
        }
        this.a(new Dimension(n3 + n8 + n4, (int)((double)(this.q + n5 + n6) + dimension.getHeight())));
        n3 = (int)((double)n3 + ((double)n8 - dimension.getWidth()) / 2.0);
        this.a.setLocation(n3, n7);
        this.j = new Rectangle(this.getWidth() / 2 - n2 / 2, 2 * this.f, n2, (this.k.length + 1 << 1) * this.f);
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
        this.invalidate();
    }

    @Override
    protected final void a_() {
        a.g.e e2 = new a.g.e((n)this.i);
        boolean bl = a.a.e.a(this.c.a(), (f)this.i);
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

