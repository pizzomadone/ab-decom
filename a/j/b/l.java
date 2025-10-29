/*
 * Decompiled with CFR 0.152.
 */
package a.j.b;

import a.a.h;
import a.c.a.b;
import a.c.a.d;
import a.c.b.n;
import a.g.e;
import a.j.a.a;
import a.j.b.j;

public final class l
extends j {
    public l(b b2, a a2, d d2) {
        super(b2, a2, d2);
    }

    @Override
    public final void a() {
        int n2 = ((a.c.b.j)this.i).j();
        if (n2 == 0) {
            this.a("out");
        } else if (n2 == 1) {
            this.a("outln");
        } else if (n2 == 2) {
            this.a("outLN");
        }
        super.a();
    }

    @Override
    protected final void a_() {
        e e2 = new e((n)this.i);
        boolean bl = a.a.h.a(this.c.a(), (a.c.b.j)this.i);
        if (bl) {
            this.c.c().a(e2);
            this.b.a(true);
        }
        this.b.a((d)null);
    }
}

