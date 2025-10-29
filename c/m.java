/*
 * Decompiled with CFR 0.152.
 */
package c;

import c.f;
import c.g;
import c.i;
import c.j;
import c.l;

public final class m
implements f {
    private l a;

    public m(l l2) {
        this.a = l2;
    }

    public final l d() {
        return this.a;
    }

    public final void a(l l2) {
        String string = this.a.getClass().getSimpleName();
        String string2 = l2.getClass().getSimpleName();
        if (this.a instanceof i && !(this.a instanceof j) && l2 instanceof j) {
            l2 = (j)l2;
            this.a = l2 = new i(((i)l2).a);
            return;
        }
        if (!string2.equals(string)) {
            throw new g(105, " try to assign " + l2.b() + " to " + this.a.b());
        }
        this.a = l2;
    }

    public final String toString() {
        return this.a.toString();
    }

    @Override
    public final String a() {
        return this.a.c();
    }

    public final String e() {
        return this.a.b();
    }

    @Override
    public final String b() {
        return this.a.d();
    }

    @Override
    public final f c() {
        return new m(this.a);
    }
}

