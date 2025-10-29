/*
 * Decompiled with CFR 0.152.
 */
package a.j.b;

import a.j.b.C;
import a.j.b.d_0;
import a.j.b.g;
import a.j.b.n;
import a.j.b.p;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;

public final class v
extends C {
    private String[] b;
    private int[] c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private String j = "DO ";
    private String k = "END DO WHILE ";

    public v(p p2, d_0 d_02) {
        super(d_02);
    }

    @Override
    public final void a(n n2, Graphics graphics) {
        int n3 = n2.getWidth();
        n2.getHeight();
        Dimension dimension = ((g)n2).d().getMinimumSize();
        n2.a(graphics, 2);
        graphics.fillRect(0, 0, n3, 3 * n2.f);
        graphics.fillRect(0, 0, n2.e, (int)(dimension.getHeight() + (double)this.e + (double)(3 * n2.f)));
        n2.c(graphics);
        int n4 = this.f;
        graphics.drawString(this.j, 0, n4);
        n4 += n2.f;
        n4 = (int)((double)n4 + dimension.getHeight());
        n2.a(graphics, 1);
        graphics.fillRect(0, n4, n3, this.e);
        n2.d(graphics);
        graphics.drawString(this.k, 0, n4 += 2 * n2.f);
        n3 = 0;
        while (n3 < this.b.length) {
            graphics.drawString(this.b[n3], this.i, n4);
            n4 += 2 * n2.f;
            ++n3;
        }
    }

    @Override
    public final void a(n serializable) {
        g g2 = (g)serializable;
        serializable = g2.getFontMetrics(((Component)serializable).getFont());
        String string = g2.i.b();
        this.i = ((FontMetrics)serializable).charsWidth(this.k.toCharArray(), 0, this.k.length());
        this.b = string.split("\\n");
        this.c = new int[this.b.length];
        this.d = 0;
        this.e = ((this.b.length << 1) + 1) * g2.f;
        this.f = 2 * g2.f;
        int n2 = 0;
        while (n2 < this.b.length) {
            this.c[n2] = ((FontMetrics)serializable).charsWidth(this.b[n2].toCharArray(), 0, this.b[n2].length());
            this.d = Math.max(this.d, this.i + this.c[n2]);
            ++n2;
        }
        this.g = ((int)Math.ceil((double)this.d / (double)(2 * g2.e)) << 1) * g2.e;
        this.h = ((this.b.length << 1) + 1) * g2.f;
        Dimension dimension = new Dimension(this.g, this.h);
        g2.d().g();
        serializable = g2.d().getMinimumSize();
        dimension.width = Math.max(dimension.width, ((Dimension)serializable).width + 2 * g2.e) + 2 * g2.e;
        dimension.height += ((Dimension)serializable).height + 4 * g2.f;
        g2.a(dimension);
        int n3 = 2 * g2.e;
        g2.d().setLocation(n3, 3 * g2.f);
        g2.revalidate();
    }
}

