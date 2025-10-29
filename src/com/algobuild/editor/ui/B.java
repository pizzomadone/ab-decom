/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.editor.ui;

import a.c.b.q;
import a.j.b.C;
import a.j.b.c_0;
import a.j.b.d_0;
import a.j.b.n;
import a.j.b.o;
import a.j.b.p;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.RectangularShape;
import java.io.Serializable;

public final class B
extends C {
    private String b;
    private String c;
    private int d;
    private int e;
    private int f;

    public B(p p2, d_0 d_02) {
        super(d_02);
    }

    @Override
    public final void a(n n2, Graphics graphics) {
        c_0 c_02 = (c_0)n2;
        int n3 = c_02.getWidth();
        int n4 = c_02.getHeight();
        graphics.setColor(c_02.b.q().d());
        int n5 = this.f;
        graphics.setColor(c_02.b.q().d());
        graphics.fillRect(0, 0, n3, n4);
        c_02.a(graphics, 2);
        c_0 c_03 = c_02;
        graphics.fillRect(c_02.e, c_02.f, c_02.e, 6 * c_02.f + c_03.a.getHeight());
        c_02.a(graphics, 0);
        graphics.fillRect(c_02.e, c_02.f, n3, 3 * c_02.f);
        n2.d(graphics);
        graphics.drawString(this.b, c_02.e, n5);
        c_03 = c_02;
        c_02.a(graphics, 1);
        graphics.fillRect(c_02.e, (n5 += 3 * n2.f + c_03.a.getHeight()) - 2 * c_02.f, n3, 3 * c_02.f);
        c_02.d(graphics);
        graphics.drawString(this.c, c_02.e, n5);
    }

    @Override
    public final void a(n n2) {
        int n3;
        Object object = (q)((o)(n2 = (c_0)n2)).i();
        if (((q)object).m() == 2) {
            this.b = "PROC " + ((q)object).j() + "(";
            n3 = 0;
            while (n3 < ((q)object).k()) {
                if (n3 > 0) {
                    this.b = String.valueOf(this.b) + ", ";
                }
                this.b = String.valueOf(this.b) + ((q)object).e(n3);
                ++n3;
            }
            this.b = String.valueOf(this.b) + ")";
            this.c = "RET";
        } else if (((q)object).m() == 3) {
            this.b = "FUNC " + ((q)object).j() + "(";
            n3 = 0;
            while (n3 < ((q)object).k()) {
                if (n3 > 0) {
                    this.b = String.valueOf(this.b) + ", ";
                }
                this.b = String.valueOf(this.b) + ((q)object).e(n3);
                ++n3;
            }
            this.b = String.valueOf(this.b) + ")";
            this.c = "RET " + ((q)object).l();
        } else {
            this.b = "PROGRAM " + ((q)object).j();
            this.c = "END";
        }
        n n4 = n2;
        ((c_0)n4).a.g();
        Serializable serializable = n2.getFontMetrics(n2.getFont());
        this.d = 0;
        this.e = 3 * ((c_0)n2).f;
        object = serializable.getStringBounds(this.b, n2.getGraphics());
        this.f = 3 * ((c_0)n2).f;
        serializable = new Dimension((int)((RectangularShape)object).getWidth(), this.e + 2 * ((c_0)n2).f);
        this.d = (int)((RectangularShape)object).getWidth();
        n4 = n2;
        object = ((c_0)n4).a.getMinimumSize();
        ((Dimension)serializable).width = Math.max(((Dimension)serializable).width, ((Dimension)object).width + 3 * ((c_0)n2).e) + 2 * ((c_0)n2).e;
        ((Dimension)serializable).height += ((Dimension)object).height + 3 * ((c_0)n2).f;
        n2.a((Dimension)serializable);
        int n5 = 3 * ((c_0)n2).e;
        n4 = n2;
        ((c_0)n4).a.setLocation(n5, this.e + ((c_0)n2).f);
        n2.revalidate();
        this.a(new Rectangle(this.d, this.e));
        if (this.a != null && this.a instanceof c_0) {
            ((c_0)this.a).a(new Rectangle(0, ((Dimension)serializable).height - 2 * ((c_0)n2).f, this.d, 2 * ((c_0)n2).f));
        }
    }
}

