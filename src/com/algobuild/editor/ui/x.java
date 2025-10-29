/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.editor.ui;

import a.j.b.C;
import a.j.b.d_0;
import a.j.b.i;
import a.j.b.n;
import a.j.b.p;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;

public final class x
extends C {
    private String[] b;
    private int[] c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private String j = "WHILE ";
    private String k = "END WHILE ";

    public x(p p2, d_0 d_02) {
        super(d_02);
    }

    @Override
    public final void a(n n2, Graphics graphics) {
        int n3 = n2.getWidth();
        n2.getHeight();
        Dimension dimension = ((i)n2).d().getMinimumSize();
        n2.a(graphics, 0);
        graphics.fillRect(0, 0, n3, this.e);
        n2.a(graphics, 1);
        graphics.fillRect(0, this.e, n2.e, (int)((double)(4 * n2.f) + dimension.getHeight()));
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
        i i2 = (i)serializable;
        serializable = i2.getFontMetrics(((Component)serializable).getFont());
        String string = i2.i.b();
        this.i = ((FontMetrics)serializable).charsWidth(this.j.toCharArray(), 0, this.j.length());
        this.b = string.split("\\n");
        this.c = new int[this.b.length];
        this.d = 0;
        this.e = ((this.b.length << 1) + 1) * i2.f;
        this.f = 2 * i2.f;
        int n2 = 0;
        while (n2 < this.b.length) {
            this.c[n2] = ((FontMetrics)serializable).charsWidth(this.b[n2].toCharArray(), 0, this.b[n2].length());
            this.d = Math.max(this.d, this.i + this.c[n2]);
            ++n2;
        }
        this.g = ((int)Math.ceil((double)this.d / (double)(2 * i2.e)) << 1) * i2.e;
        this.h = ((this.b.length << 1) + 1) * i2.f;
        Dimension dimension = new Dimension(this.g, this.h);
        i2.d().g();
        serializable = i2.d().getMinimumSize();
        dimension.width = Math.max(dimension.width, ((Dimension)serializable).width + 2 * i2.e) + 2 * i2.e;
        dimension.height += ((Dimension)serializable).height + 3 * i2.f;
        i2.a(dimension);
        int n3 = 2 * i2.e;
        i2.d().setLocation(n3, this.e);
        i2.revalidate();
    }
}

