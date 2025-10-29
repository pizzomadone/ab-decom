/*
 * Decompiled with CFR 0.152.
 */
package a.j.b;

import a.c.a.b;
import a.c.a.d;
import a.c.b.n;
import a.g.e;
import a.j.b.o;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.RectangularShape;

public final class a
extends o {
    private String[] a;
    private int[] k;
    private int l;
    private int m;
    private int n;
    private int o;

    public a(b b2, a.j.a.a a2, d d2) {
        super(b2, a2, d2);
        d2.a(this);
        this.g();
    }

    @Override
    public final void a(Graphics graphics) {
        int n2 = this.getWidth();
        int n3 = this.getHeight();
        this.b(graphics);
        graphics.fillRect(n2 / 2 - this.n / 2, this.f, this.n, this.o);
        this.c(graphics);
        graphics.drawRect(n2 / 2 - this.n / 2, this.f, this.n, this.o);
        graphics.drawLine(n2 / 2, 0, n2 / 2, this.f);
        graphics.drawLine(n2 / 2, n3 - this.f, n2 / 2, n3);
        n3 = this.m;
        int n4 = 0;
        while (n4 < this.a.length) {
            graphics.drawString(this.a[n4], n2 / 2 - this.k[n4] / 2, n3);
            n3 += 2 * this.f;
            ++n4;
        }
    }

    @Override
    public final void a() {
        Object object = this.i.b();
        FontMetrics fontMetrics = this.getFontMetrics(this.getFont());
        this.a = ((String)object).split("\\n");
        this.k = new int[this.a.length];
        this.l = 0;
        object = "X";
        if (this.a.length > 0) {
            object = this.a[0];
        }
        object = fontMetrics.getStringBounds((String)object, this.getGraphics());
        this.m = (int)((double)(3 * this.f) - ((RectangularShape)object).getHeight() / 2.0 - ((RectangularShape)object).getY());
        int n2 = 0;
        while (n2 < this.a.length) {
            this.k[n2] = fontMetrics.charsWidth(this.a[n2].toCharArray(), 0, this.a[n2].length());
            this.l = Math.max(this.l, this.k[n2]);
            ++n2;
        }
        this.n = (2 + ((int)Math.ceil((double)this.l / (double)(2 * this.e)) << 1)) * this.e;
        this.o = (this.a.length + 1 << 1) * this.f;
        Dimension dimension = new Dimension(this.n + 2 * this.e, this.o + 2 * this.f);
        this.a(dimension);
        this.j = new Rectangle(this.getWidth() / 2 - this.n / 2, this.f, this.n, this.o);
    }

    @Override
    protected final void a_() {
        e e2 = new e((n)this.i);
        boolean bl = a.a.a.a(this.c.a(), (a.c.b.a)this.i);
        if (bl) {
            this.c.c().a(e2);
            this.b.a(true);
        }
        this.b.a((d)null);
    }
}

