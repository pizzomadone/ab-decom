/*
 * Decompiled with CFR 0.152.
 */
package a.c.a;

import a.k.b_0;
import b.a.a;
import b.a.c;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Stroke;
import java.io.Serializable;

public final class i {
    private Font a;
    private Font b;
    private Color c;
    private Color d;
    private Color e;
    private Color f;
    private int g;
    private Color h;
    private Color i;
    private Color j;
    private Stroke k;
    private int l;

    public i() {
        this.a();
    }

    public final void a() {
        this.a = new Font("SansSerif", 0, (int)(12.0 * b_0.a()));
        this.b = new Font("SansSerif", 0, (int)(12.0 * b_0.a()));
        this.c = Color.WHITE;
        this.d = Color.WHITE;
        this.e = Color.GREEN;
        this.f = new Color(235, 235, 255);
        this.g = 1;
        this.h = Color.BLACK;
        this.i = Color.BLACK;
        this.j = Color.DARK_GRAY;
        this.o();
        this.l = 6;
    }

    public final Font b() {
        return this.a;
    }

    public final void a(Font font) {
        this.a = font;
    }

    public final Font c() {
        return this.b;
    }

    public final void b(Font font) {
        this.b = font;
    }

    public final Color d() {
        return this.c;
    }

    public final void a(Color color) {
        this.c = color;
    }

    public final Color e() {
        return this.d;
    }

    public final void b(Color color) {
        this.d = color;
    }

    public final Color f() {
        return this.e;
    }

    public final Color g() {
        return this.f;
    }

    public final int h() {
        return this.g;
    }

    public final void a(int n2) {
        if (n2 > 0) {
            this.g = n2;
            this.o();
        }
    }

    public final Color i() {
        return this.h;
    }

    public final void c(Color color) {
        this.h = color;
    }

    public final Color j() {
        return this.i;
    }

    public final Color k() {
        return this.j;
    }

    public final Stroke l() {
        return this.k;
    }

    private void o() {
        this.k = new BasicStroke((float)((double)this.g * b_0.a()), 1, 1);
    }

    public final int m() {
        return this.l;
    }

    public final void b(int n2) {
        if (n2 > 0) {
            this.l = n2;
        }
    }

    public final c n() {
        c c2 = new c();
        c2.b("abopt", "ViewOptions");
        c2.b("codeFont", a.c.a.i.c(this.a));
        c2.b("consoleFont", a.c.a.i.c(this.b));
        c2.b("backgroundColor", a.c.a.i.d(this.c));
        c2.b("fillingColor", a.c.a.i.d(this.d));
        c2.b("fillingColorRunning", a.c.a.i.d(this.e));
        c2.b("fillingColorSelected", a.c.a.i.d(this.f));
        int n2 = this.g;
        String string = "lineWidth";
        c c3 = c2;
        c3.b(string, new Integer(n2));
        c2.b("lineColor", a.c.a.i.d(this.h));
        c2.b("lineColorRunning", a.c.a.i.d(this.i));
        c2.b("lineColorSelected", a.c.a.i.d(this.j));
        return c2;
    }

    public final void a(c c2) {
        Object object = c2.f("abopt");
        if (((String)object).equals("ViewOptions")) {
            Serializable serializable = a.c.a.i.a(c2.b("codeFont"));
            object = this;
            this.a = serializable;
            serializable = a.c.a.i.a(c2.b("consoleFont"));
            object = this;
            this.b = serializable;
            serializable = a.c.a.i.b(c2.b("backgroundColor"));
            object = this;
            this.c = serializable;
            serializable = a.c.a.i.b(c2.b("fillingColor"));
            object = this;
            this.d = serializable;
            serializable = a.c.a.i.b(c2.b("fillingColorRunning"));
            object = this;
            this.e = serializable;
            serializable = a.c.a.i.b(c2.b("fillingColorSelected"));
            object = this;
            this.f = serializable;
            serializable = a.c.a.i.b(c2.b("lineColor"));
            object = this;
            this.h = serializable;
            serializable = a.c.a.i.b(c2.b("lineColorRunning"));
            object = this;
            this.i = serializable;
            serializable = a.c.a.i.b(c2.b("lineColorSelected"));
            object = this;
            this.j = serializable;
            this.a(c2.a("lineWidth"));
        }
    }

    private static a c(Font font) {
        a a2 = new a();
        a2.a(font.getName());
        a2.e((int)((double)font.getSize() * b_0.a()));
        a2.e(font.getStyle());
        return a2;
    }

    private static a d(Color color) {
        a a2 = new a();
        a2.e(color.getRed());
        a2.e(color.getGreen());
        a2.e(color.getBlue());
        a2.e(color.getAlpha());
        return a2;
    }

    private static Font a(a a2) {
        String string = (String)a2.a(0);
        int n2 = a2.b(1);
        int n3 = a2.b(2);
        return new Font(string, n3, (int)((double)n2 * b_0.a()));
    }

    private static Color b(a a2) {
        int n2 = a2.b(0);
        int n3 = a2.b(1);
        int n4 = a2.b(2);
        int n5 = a2.b(3);
        return new Color(n2, n3, n4, n5);
    }
}

