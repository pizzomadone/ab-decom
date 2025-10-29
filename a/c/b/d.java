/*
 * Decompiled with CFR 0.152.
 */
package a.c.b;

import a.c.a.b;
import a.c.b.n;
import a.c.b.p;
import a.f.g;
import b.a.c;

public final class d
extends n {
    private String b;

    public d(String string) {
        this.a(string);
    }

    public d() {
        this.a((String)null);
    }

    @Override
    public final String b() {
        return this.b;
    }

    public final void a(String string) {
        this.b = string;
        if (string != null) {
            string.split("\n|;");
        }
        this.a(true);
    }

    @Override
    public final int a(b b2, int n2) {
        return -1;
    }

    @Override
    public final String toString() {
        return this.n() + "- ABIComment: " + this.b + "\n";
    }

    @Override
    protected final String g() {
        return "ABICOM";
    }

    @Override
    public final g h() {
        g g2 = super.h();
        g2.a("label", this.b);
        return g2;
    }

    @Override
    public final void a(g object) {
        super.a((g)object);
        object = ((g)object).a("label");
        this.a((String)object);
    }

    @Override
    public final c b(boolean bl) {
        c c2 = super.b(bl);
        c2.b("label", this.b);
        return c2;
    }

    @Override
    public final void a(c object, boolean bl) {
        super.a((c)object, bl);
        object = ((c)object).f("label");
        this.a((String)object);
    }

    @Override
    public final a.c.a.d e() {
        d d2 = new d();
        d2.a(this.b);
        return d2;
    }

    @Override
    public final boolean b(int n2) {
        return false;
    }

    @Override
    public final p i() {
        return new p(1, this.b.length());
    }
}

