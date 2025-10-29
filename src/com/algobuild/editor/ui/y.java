/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.editor.ui;

import a.j.b.C;
import a.j.b.d_0;
import a.j.b.k;
import a.j.b.n;
import a.j.b.p;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;

public final class y
extends C {
    private String[] b;
    private int[] c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private String j = "INPUT ";

    public y(p p2, d_0 d_02) {
        super(d_02);
    }

    @Override
    public final void a(n n2, Graphics graphics) {
        int n3 = n2.getWidth();
        n2.getHeight();
        n2.b(graphics);
        graphics.fillRect(0, 0, n3, this.e);
        n2.c(graphics);
        n3 = this.f;
        graphics.drawString(this.j, 0, n3);
        int n4 = 0;
        while (n4 < this.b.length) {
            graphics.drawString(this.b[n4], this.i, n3);
            n3 += 2 * n2.f;
            ++n4;
        }
    }

    @Override
    public final void a(n serializable) {
        k k2 = (k)serializable;
        serializable = k2.getFontMetrics(((Component)serializable).getFont());
        String string = ((a.c.b.k)k2.i).k();
        this.i = ((FontMetrics)serializable).charsWidth(this.j.toCharArray(), 0, this.j.length());
        this.b = string.split("\\n");
        this.c = new int[this.b.length];
        this.d = 0;
        this.e = ((this.b.length << 1) + 1) * k2.f;
        this.f = 2 * k2.f;
        int n2 = 0;
        while (n2 < this.b.length) {
            this.c[n2] = ((FontMetrics)serializable).charsWidth(this.b[n2].toCharArray(), 0, this.b[n2].length());
            this.d = Math.max(this.d, this.i + this.c[n2]);
            ++n2;
        }
        this.g = ((int)Math.ceil((double)this.d / (double)(2 * k2.e)) << 1) * k2.e;
        this.h = ((this.b.length << 1) + 1) * k2.f;
        Dimension dimension = new Dimension(this.g, this.h);
        k2.a(dimension);
    }
}

