/*
 * Decompiled with CFR 0.152.
 */
package a.j.b;

import a.a.b;
import a.c.a.c;
import a.c.a.d;
import a.c.b.n;
import a.g.e;
import a.j.a.a;
import a.j.a.g;
import a.j.b.o;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.Vector;
import javax.swing.JPanel;

/*
 * Renamed from a.j.b.b
 */
public final class b_0
extends o {
    private int a;
    private int k;
    private int l;
    private int m;
    private String n;

    public b_0(a.c.a.b b2, a a2, d d2) {
        super(b2, a2, d2);
        d2.a(this);
        this.g();
    }

    @Override
    public final void a(Graphics graphics) {
        int n2 = this.getWidth();
        int n3 = this.getHeight();
        this.b(graphics);
        graphics.fillRect(n2 / 2 - this.l / 2, this.f, this.l, this.m);
        this.c(graphics);
        graphics.drawRect(n2 / 2 - this.l / 2, this.f, this.l, this.m);
        graphics.drawLine(n2 / 2 - this.l / 2 + this.e, this.f, n2 / 2 - this.l / 2 + this.e, this.m + this.f);
        graphics.drawLine(n2 / 2 + this.l / 2 - this.e, this.f, n2 / 2 + this.l / 2 - this.e, this.m + this.f);
        graphics.drawLine(n2 / 2, 0, n2 / 2, this.f);
        graphics.drawLine(n2 / 2, n3 - this.f, n2 / 2, n3);
        n3 = this.k;
        graphics.drawString(this.n, n2 / 2 - this.a / 2, n3);
    }

    @Override
    public final void a() {
        a.c.b.c c2;
        Object object = (a.c.b.b)this.i;
        Object object2 = ((a.c.b.b)object).k();
        this.n = String.valueOf(((a.c.b.b)object).j()) + "(";
        object = this.getFontMetrics(this.getFont());
        int n2 = ((Vector)object2).size();
        int n3 = 0;
        while (n3 < n2) {
            this.n = n3 == 0 ? String.valueOf(this.n) + (String)((Vector)object2).elementAt(n3) : String.valueOf(this.n) + ", " + (String)((Vector)object2).elementAt(n3);
            ++n3;
        }
        this.n = String.valueOf(this.n) + ")";
        if (this.i instanceof a.c.b.c && (object2 = (c2 = (a.c.b.c)this.i).l()) != null && ((String)object2).length() > 0) {
            this.n = String.valueOf(object2) + " = " + this.n;
        }
        this.a = 0;
        Rectangle2D rectangle2D = ((FontMetrics)object).getStringBounds(this.n, this.getGraphics());
        this.a = ((FontMetrics)object).charsWidth(this.n.toCharArray(), 0, this.n.length());
        this.k = (int)((double)(3 * this.f) - rectangle2D.getHeight() / 2.0 - rectangle2D.getY());
        this.l = (4 + ((int)Math.ceil((double)this.a / (double)(2 * this.e)) << 1)) * this.e;
        this.m = 4 * this.f;
        object2 = new Dimension(this.l + 2 * this.e, this.m + 2 * this.f);
        this.a((Dimension)object2);
        this.j = new Rectangle(this.getWidth() / 2 - this.l / 2, this.f, this.l, this.m);
    }

    @Override
    public final void a(d object, boolean bl) {
        int n2;
        c c2;
        super.a((d)object, bl);
        if (!bl && (c2 = this.b.a()) != null && c2.d() == this.i && c2.c() == 1 && (n2 = ((String)(object = ((d)object).c())).indexOf(46)) > 0) {
            object = ((String)object).substring(0, n2);
            JPanel jPanel = this.c;
            jPanel = jPanel.c();
            ((g)jPanel).h((String)object);
        }
    }

    @Override
    protected final void a_() {
        e e2 = new e((n)this.i);
        boolean bl = a.a.b.a(this.c.a(), (a.c.b.c)this.i, this.b);
        if (bl) {
            this.c.c().a(e2);
            this.b.a(true);
        }
        this.b.a((d)null);
    }
}

