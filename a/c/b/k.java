/*
 * Decompiled with CFR 0.152.
 */
package a.c.b;

import a.c.b.n;
import a.c.b.p;
import a.f.g;
import b.a.c;

public abstract class k
extends n {
    private String b;
    private String[] c = null;

    public k(String string) {
        this.b = string;
    }

    public final String k() {
        return this.b;
    }

    public final void a(String string) {
        this.b = string;
        this.j();
        this.a(true);
    }

    private void j() {
        this.c = this.b.split("\n");
    }

    protected final String[] l() {
        if (this.c == null && this.b != null) {
            this.j();
        }
        return this.c;
    }

    @Override
    public String toString() {
        return "ABIIO_Base [content=" + this.b + ", getOrderInParent()=" + this.n() + "]";
    }

    @Override
    public g h() {
        g g2 = super.h();
        g2.a("content", this.b);
        return g2;
    }

    @Override
    public void a(g object) {
        super.a((g)object);
        object = ((g)object).a("content");
        this.a((String)object);
    }

    @Override
    public c b(boolean bl) {
        c c2 = super.b(bl);
        c2.b("content", this.b);
        return c2;
    }

    @Override
    public void a(c object, boolean bl) {
        super.a((c)object, bl);
        object = ((c)object).f("content");
        this.a((String)object);
    }

    @Override
    public final p i() {
        return new p(1, this.b.length());
    }
}

