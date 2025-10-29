/*
 * Decompiled with CFR 0.152.
 */
package a.j.b;

import a.c.a.c;
import a.j.b.C;
import a.j.b.d_0;
import a.j.b.n;
import a.j.b.p;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.RectangularShape;

public final class u
extends C {
    public u(p p2, d_0 d_02) {
        super(d_02);
    }

    @Override
    public final void a(n n2, Graphics graphics) {
        int n3 = n2.getWidth();
        int n4 = n2.getHeight();
        Object object = null;
        c c2 = n2.b.a();
        if (c2 != null) {
            object = n2.b.a().d();
        }
        n2.c(graphics);
        if (n2.g && object == null) {
            n2.b(graphics);
            graphics.fillRect(0, 0, n3 - 1, n4 - 1);
            n2.c(graphics);
            graphics.drawRect(0, 0, n3 - 1, n4 - 1);
            String string = " * * * ";
            object = graphics.getFontMetrics();
            object = ((FontMetrics)object).getStringBounds(string, graphics);
            int n5 = (int)(((RectangularShape)object).getWidth() / 2.0);
            int n6 = (int)Math.round(-((RectangularShape)object).getHeight() / 2.0 - ((RectangularShape)object).getY());
            n3 = n3 / 2 - n5;
            int n7 = 1 * n2.f + n6;
            graphics.drawString(string, n3, n7);
            return;
        }
        graphics.drawLine(0, 0, 0, n4);
    }

    @Override
    public final void a(n n2) {
        n2.a(new Dimension(10 * n2.e, 1 * n2.f));
    }
}

