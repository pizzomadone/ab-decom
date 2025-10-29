/*
 * Decompiled with CFR 0.152.
 */
package a.c.b;

import a.c.a.d;
import a.c.b.b;
import a.f.g;
import c.f;
import java.util.Vector;

public final class c
extends b {
    private String d;

    public c(String string) {
        super(string);
    }

    private c(String string, Vector vector) {
        super(string, vector);
    }

    public c() {
        this(null);
    }

    public final String l() {
        return this.d;
    }

    public final void b(String string) {
        System.out.println("SET RETURN VARIABLE " + string);
        this.d = string;
        this.a(true);
    }

    @Override
    public final int a(a.c.a.b b2, int n2) {
        f f2 = null;
        boolean bl = false;
        if (n2 == 1 && this.d != null && this.d.length() > 0) {
            f2 = (f)b2.c().get("_RETVAL_");
            bl = true;
        }
        n2 = super.a(b2, n2);
        if (bl) {
            b2.c().put(this.d, f2);
            b2.h("RETURN VALUE: " + f2.toString());
        }
        b2.i();
        return n2;
    }

    @Override
    public final g h() {
        g g2 = super.h();
        if (this.d != null) {
            g2.a("returnVariable", this.d);
        }
        return g2;
    }

    @Override
    public final void a(g object) {
        super.a((g)object);
        object = ((g)object).a("returnVariable");
        if (object != null) {
            this.b((String)object);
        }
    }

    @Override
    public final b.a.c b(boolean bl) {
        b.a.c c2 = super.b(bl);
        System.out.println("getAsJSONObject RETURN VARIABLE " + this.d);
        if (this.d != null) {
            c2.b("returnVariable", this.d);
        }
        return c2;
    }

    @Override
    public final void a(b.a.c object, boolean bl) {
        super.a((b.a.c)object, bl);
        object = ((b.a.c)object).f("returnVariable");
        System.out.println("getAsJSONObject RETURN VARIABLE " + (String)object);
        if (object != null) {
            this.b((String)object);
        }
    }

    @Override
    public final d e() {
        c c2 = new c(this.b, (Vector)this.c.clone());
        c2.b(this.d);
        return c2;
    }
}

