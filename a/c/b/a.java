/*
 * Decompiled with CFR 0.152.
 */
package a.c.b;

import a.c.a.b;
import a.c.a.d;
import a.c.b.n;
import a.c.b.p;
import b.a.c;
import c.g;
import c.l;

public final class a
extends n {
    private String b;
    private String[] c = null;

    public a(String string) {
        this.a(string);
    }

    public a() {
        this.a((String)null);
    }

    @Override
    public final String b() {
        return this.b;
    }

    public final void a(String string) {
        this.b = string;
        this.c = string != null ? string.split("\n|;") : null;
        this.a(true);
    }

    @Override
    public final int a(b b2, int n2) {
        n2 = 0;
        while (this.c != null && n2 < this.c.length) {
            String string = this.c[n2];
            try {
                l l2 = b2.e().a(string, b2.c());
                b2.h("ASSIGN: " + string + "   RESULT:" + l2);
            }
            catch (g g2) {
                b2.i("ASSIGN ERROR: " + g2 + " IN " + string);
                return -2;
            }
            ++n2;
        }
        b2.i();
        return -1;
    }

    @Override
    public final String toString() {
        return this.n() + "- ABIAssign: " + this.b + "\n";
    }

    @Override
    protected final String g() {
        return "ABIASS";
    }

    @Override
    public final a.f.g h() {
        a.f.g g2 = super.h();
        g2.a("label", this.b);
        return g2;
    }

    @Override
    public final void a(a.f.g object) {
        super.a((a.f.g)object);
        object = ((a.f.g)object).a("label");
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
    public final d e() {
        a a2 = new a();
        a2.a(this.b);
        return a2;
    }

    @Override
    public final p i() {
        return new p(1, this.b.length());
    }
}

