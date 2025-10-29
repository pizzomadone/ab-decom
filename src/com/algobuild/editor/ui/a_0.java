/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.editor.ui;

import a.c.b.r;
import a.j.b.C;
import a.j.b.d_0;
import a.j.b.m;
import a.j.b.n;
import a.j.b.p;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;

/*
 * Renamed from a.j.b.A
 */
public final class a_0
extends C {
    private String[] b;
    private int[] c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private String j = "IF ";
    private String k = "ELSE";
    private String l = "END IF";

    public a_0(p p2, d_0 d_02) {
        super(d_02);
    }

    @Override
    public final void a(n n2, Graphics graphics) {
        int n3 = n2.getWidth();
        n2.getHeight();
        Dimension dimension = ((m)n2).e().getMinimumSize();
        Dimension dimension2 = ((m)n2).d().getMinimumSize();
        boolean bl = false;
        try {
            if (((m)n2).d().i().d() > 0) {
                bl = true;
            }
        }
        catch (r r2) {
            r r3 = r2;
            r2.printStackTrace();
        }
        n2.a(graphics, 0);
        graphics.fillRect(0, 0, n3, this.e);
        n2.a(graphics, 1);
        if (bl) {
            graphics.fillRect(0, this.e + dimension.height, n3, 3 * n2.f);
            graphics.fillRect(0, this.e + dimension.height + dimension2.height + 3 * n2.f, n3, 3 * n2.f);
            graphics.fillRect(0, this.e, n2.e, this.e + dimension.height + dimension2.height + 6 * n2.f);
        } else {
            graphics.fillRect(0, this.e + dimension.height, n3, 1 * n2.f);
            graphics.fillRect(0, this.e + dimension.height + dimension2.height + 1 * n2.f, n3, 3 * n2.f);
            graphics.fillRect(0, this.e, n2.e, this.e + dimension.height + dimension2.height + 4 * n2.f);
        }
        n2.d(graphics);
        int n4 = this.f;
        graphics.drawString(this.j, 0, n4);
        n3 = 0;
        while (n3 < this.b.length) {
            graphics.drawString(this.b[n3], this.i, n4);
            n4 += 2 * n2.f;
            ++n3;
        }
        n4 += n2.f;
        n4 = (int)((double)n4 + dimension.getHeight());
        n2.d(graphics);
        if (bl) {
            graphics.drawString(this.k, 0, n4);
            n4 += 3 * n2.f;
        } else {
            n4 += 1 * n2.f;
        }
        n4 = (int)((double)n4 + dimension2.getHeight());
        graphics.drawString(this.l, 0, n4);
    }

    @Override
    public final void a(n serializable) {
        m m2 = (m)serializable;
        serializable = m2.getFontMetrics(((Component)serializable).getFont());
        String string = m2.i.b();
        this.i = ((FontMetrics)serializable).charsWidth(this.j.toCharArray(), 0, this.j.length());
        this.b = string.split("\\n");
        this.c = new int[this.b.length];
        this.d = 0;
        this.e = ((this.b.length << 1) + 1) * m2.f;
        this.f = 2 * m2.f;
        int n2 = 0;
        while (n2 < this.b.length) {
            this.c[n2] = ((FontMetrics)serializable).charsWidth(this.b[n2].toCharArray(), 0, this.b[n2].length());
            this.d = Math.max(this.d, this.i + this.c[n2]);
            ++n2;
        }
        this.g = ((int)Math.ceil((double)this.d / (double)(2 * m2.e)) << 1) * m2.e;
        this.h = ((this.b.length << 1) + 1) * m2.f;
        Dimension dimension = new Dimension(this.g, this.h);
        m2.e().g();
        serializable = m2.e().getMinimumSize();
        m2.d().g();
        Dimension dimension2 = m2.d().getMinimumSize();
        dimension.width = Math.max(dimension.width, ((Dimension)serializable).width + 2 * m2.e) + 2 * m2.e;
        dimension.height += ((Dimension)serializable).height;
        dimension.width = Math.max(dimension.width, dimension2.width + 2 * m2.e) + 2 * m2.e;
        dimension.height += dimension2.height;
        int n3 = 0;
        try {
            if (m2.d().i().d() > 0) {
                dimension.height += 6 * m2.f;
                n3 = 3 * m2.f;
            } else {
                dimension.height += 4 * m2.f;
                n3 = 1 * m2.f;
            }
        }
        catch (r r2) {
            r r3 = r2;
            r2.printStackTrace();
        }
        m2.a(dimension);
        int n4 = 2 * m2.e;
        m2.e().setLocation(n4, this.e);
        m2.d().setLocation(n4, (int)((double)this.e + ((Dimension)serializable).getHeight() + (double)n3));
        m2.revalidate();
    }
}

