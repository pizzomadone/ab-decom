/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.editor.ui;

import a.c.b.j;
import a.c.b.k;
import a.j.b.C;
import a.j.b.d_0;
import a.j.b.l;
import a.j.b.n;
import a.j.b.p;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

public final class z
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

    public z(p p2, d_0 d_02) {
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
        l l2 = (l)serializable;
        int n2 = ((j)l2.i).j();
        if (n2 == 0) {
            this.j = "OUT ";
        } else if (n2 == 1) {
            this.j = "OUTLN ";
        } else if (n2 == 2) {
            this.j = "OUT*LN ";
        }
        serializable = l2.getFontMetrics(((Component)serializable).getFont());
        String string = ((k)l2.i).k();
        this.i = ((FontMetrics)serializable).charsWidth(this.j.toCharArray(), 0, this.j.length());
        this.b = string.split("\\n");
        this.c = new int[this.b.length];
        this.d = 0;
        this.e = ((this.b.length << 1) + 1) * l2.f;
        this.f = 2 * l2.f;
        int n3 = 0;
        while (n3 < this.b.length) {
            this.c[n3] = ((FontMetrics)serializable).charsWidth(this.b[n3].toCharArray(), 0, this.b[n3].length());
            this.d = Math.max(this.d, this.i + this.c[n3]);
            ++n3;
        }
        this.g = ((int)Math.ceil((double)this.d / (double)(2 * l2.e)) << 1) * l2.e;
        this.h = ((this.b.length << 1) + 1) * l2.f;
        Dimension dimension = new Dimension(this.g, this.h);
        l2.a(dimension);
        this.a(new Rectangle(this.d, this.e));
    }
}

