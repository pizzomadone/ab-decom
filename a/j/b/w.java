/*
 * Decompiled with CFR 0.152.
 */
package a.j.b;

import a.j.b.C;
import a.j.b.d_0;
import a.j.b.h;
import a.j.b.n;
import a.j.b.p;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

public final class w
extends C {
    private String[] b;
    private int[] c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private String j = "FOR ";
    private String k = "END FOR";

    public w(p p2, d_0 d_02) {
        super(d_02);
    }

    @Override
    public final void a(n n2, Graphics graphics) {
        int n3 = n2.getWidth();
        n2.getHeight();
        Dimension dimension = ((h)n2).d().getMinimumSize();
        n2.b(graphics);
        graphics.fillRect(0, 0, n3, this.e);
        n2.a(graphics, 1);
        graphics.fillRect(0, this.e, n2.f, (int)((double)this.e + dimension.getHeight() + (double)(3 * n2.f)));
        n2.c(graphics);
        int n4 = this.f;
        graphics.drawString(this.j, 0, n4);
        int n5 = 0;
        while (n5 < this.b.length) {
            graphics.drawString(this.b[n5], this.i, n4);
            n4 += 2 * n2.f;
            ++n5;
        }
        n4 += n2.f;
        n4 = (int)((double)n4 + dimension.getHeight());
        n2.a(graphics, 1);
        graphics.fillRect(0, n4 - 2 * n2.f, n3, 3 * n2.f);
        n2.c(graphics);
        graphics.drawString(this.k, 0, n4);
    }

    @Override
    public final void a(n serializable) {
        h h2 = (h)serializable;
        serializable = h2.getFontMetrics(((Component)serializable).getFont());
        String string = h2.i.b();
        this.i = ((FontMetrics)serializable).charsWidth(this.j.toCharArray(), 0, this.j.length());
        this.b = string.split("\\n");
        this.c = new int[this.b.length];
        this.d = 0;
        this.e = ((this.b.length << 1) + 1) * h2.f;
        this.f = 2 * h2.f;
        int n2 = 0;
        while (n2 < this.b.length) {
            this.c[n2] = ((FontMetrics)serializable).charsWidth(this.b[n2].toCharArray(), 0, this.b[n2].length());
            this.d = Math.max(this.d, this.i + this.c[n2]);
            ++n2;
        }
        this.g = ((int)Math.ceil((double)this.d / (double)(2 * h2.e)) << 1) * h2.e;
        this.h = ((this.b.length << 1) + 1) * h2.f;
        Dimension dimension = new Dimension(this.g, this.h);
        h2.d().g();
        serializable = h2.d().getMinimumSize();
        dimension.width = Math.max(dimension.width, ((Dimension)serializable).width + 2 * h2.e) + 2 * h2.e;
        dimension.height += ((Dimension)serializable).height + 3 * h2.f;
        h2.a(dimension);
        int n3 = 2 * h2.e;
        h2.d().setLocation(n3, 3 * h2.f);
        this.a(new Rectangle(this.d, this.e));
        h2.revalidate();
    }
}

