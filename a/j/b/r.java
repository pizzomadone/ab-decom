/*
 * Decompiled with CFR 0.152.
 */
package a.j.b;

import a.c.b.b;
import a.c.b.c;
import a.j.b.C;
import a.j.b.b_0;
import a.j.b.d_0;
import a.j.b.n;
import a.j.b.p;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Vector;

public final class r
extends C {
    private String[] b;
    private int[] c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private String j = "CALL ";

    public r(p p2, d_0 d_02) {
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
        c c2;
        b_0 b_02 = (b_0)serializable;
        serializable = b_02.getFontMetrics(((Component)serializable).getFont());
        this.i = ((FontMetrics)serializable).charsWidth(this.j.toCharArray(), 0, this.j.length());
        Object object = (b)b_02.i;
        Object object2 = ((b)object).k();
        object = String.valueOf(((b)object).j()) + "(";
        int n2 = ((Vector)object2).size();
        int n3 = 0;
        while (n3 < n2) {
            object = n3 == 0 ? String.valueOf(object) + (String)((Vector)object2).elementAt(n3) : String.valueOf(object) + ", " + (String)((Vector)object2).elementAt(n3);
            ++n3;
        }
        object = String.valueOf(object) + ")";
        if (b_02.i instanceof c && (object2 = (c2 = (c)b_02.i).l()) != null && ((String)object2).length() > 0) {
            object = String.valueOf(object2) + " = " + (String)object;
        }
        this.b = ((String)object).split("\\n");
        this.c = new int[this.b.length];
        this.d = 0;
        this.e = ((this.b.length << 1) + 1) * b_02.f;
        this.f = 2 * b_02.f;
        int n4 = 0;
        while (n4 < this.b.length) {
            this.c[n4] = ((FontMetrics)serializable).charsWidth(this.b[n4].toCharArray(), 0, this.b[n4].length());
            this.d = Math.max(this.d, this.i + this.c[n4]);
            ++n4;
        }
        this.g = ((int)Math.ceil((double)this.d / (double)(2 * b_02.e)) << 1) * b_02.e;
        this.h = ((this.b.length << 1) + 1) * b_02.f;
        Dimension dimension = new Dimension(this.g, this.h);
        b_02.a(dimension);
    }
}

