/*
 * Decompiled with CFR 0.152.
 */
package a.c.b;

import a.c.a.b;
import a.c.a.d;
import a.c.b.h;
import a.c.b.n;
import a.c.b.p;
import a.c.b.r;
import a.c.b.s;
import b.a.c;
import c.g;
import c.l;

public final class f
extends h {
    private String b;
    private String c;

    public f(String string, String string2, String string3) {
        super(string2);
        this.b = string;
        this.c = string3;
    }

    public f() {
        super(null);
        this.b = null;
        this.c = null;
    }

    @Override
    public final String b() {
        return String.valueOf(this.b) + "; " + this.l() + "; " + this.c;
    }

    public final String j() {
        return this.b;
    }

    public final void a(String string) {
        this.b = string;
        this.a(true);
    }

    public final String k() {
        return this.c;
    }

    public final void b(String string) {
        this.c = string;
        this.a(true);
    }

    @Override
    public final int a(b b2, int n2) {
        if (n2 == 0) {
            String string = this.b;
            try {
                l l2 = b2.e().a(string, b2.c());
                b2.h("FOR INITIALIZATION: " + string + "   RESULT: " + l2);
            }
            catch (g g2) {
                b2.i("FOR INITIALIZATION ERROR: " + g2 + " IN " + string);
                return -2;
            }
            return 1;
        }
        if (n2 == 1) {
            boolean bl;
            String string = this.l();
            try {
                l l3 = b2.e().a(string, b2.c());
                boolean bl2 = l3 instanceof c.h && ((c.h)l3).a();
                bl = bl2;
                b2.h("FOR TEST:  " + string + "   RESULT: " + bl2);
                b2.i();
            }
            catch (g g3) {
                b2.i("FOR TEST ERROR: " + g3 + " IN " + string);
                return -2;
            }
            if (bl) {
                return 2;
            }
            return -1;
        }
        if (n2 == 2) {
            a.c.a.c c2 = new a.c.a.c(this.m(), b2);
            b2.d().push(c2);
            return 3;
        }
        if (n2 == 3) {
            String string = this.c;
            try {
                l l4 = b2.e().a(string, b2.c());
                b2.h("FOR INCREMENT: " + string + "   RESULT: " + l4);
            }
            catch (g g4) {
                b2.i("FOR INCREMENT ERROR: " + g4 + " IN " + string);
                return -2;
            }
            return 1;
        }
        return -1;
    }

    @Override
    public final String toString() {
        return "ABICycleFor  [ " + super.toString() + "]";
    }

    @Override
    protected final String g() {
        return "ABIFOR";
    }

    @Override
    public final a.f.g h() {
        a.f.g g2 = super.h();
        g2.a("initialization", this.b);
        g2.a("increment", this.c);
        return g2;
    }

    @Override
    public final void a(a.f.g g2) {
        super.a(g2);
        String string = g2.a("initialization");
        this.a(string);
        string = g2.a("increment");
        this.b(string);
    }

    @Override
    public final c b(boolean bl) {
        c c2 = super.b(bl);
        c2.b("initialization", this.b);
        c2.b("increment", this.c);
        return c2;
    }

    @Override
    public final void a(c c2, boolean bl) {
        super.a(c2, bl);
        String string = c2.f("initialization");
        this.a(string);
        string = c2.f("increment");
        this.b(string);
    }

    @Override
    public final d e() {
        f f2 = new f(this.b, this.l(), this.c);
        try {
            int n2 = 0;
            while (n2 < this.d()) {
                n n3 = this.c(n2);
                ((d)f2).a((n)n3.e());
                ++n2;
            }
        }
        catch (s s2) {
            s s3 = s2;
            s2.printStackTrace();
        }
        catch (r r2) {
            r r3 = r2;
            r2.printStackTrace();
        }
        return f2;
    }

    @Override
    public final boolean b(int n2) {
        return n2 == 0 || n2 == 3;
    }

    @Override
    public final p i() {
        p p2 = super.i();
        p2.a(0, this.b.length() + this.c.length());
        return p2;
    }
}

