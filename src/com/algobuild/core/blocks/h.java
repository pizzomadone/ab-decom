/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.core.blocks;

import a.c.a.d;
import a.c.a.k;
import a.c.b.n;
import a.c.b.o;
import a.c.b.p;
import a.c.b.r;
import a.c.b.t;
import a.f.g;
import b.a.a;
import b.a.c;
import java.util.Iterator;

public abstract class h
extends n {
    private o b;
    private String c;

    public h(String string) {
        this.c = string;
        this.b = new o();
    }

    public final String l() {
        return this.c;
    }

    public final void c(String string) {
        this.c = string;
        this.a(true);
    }

    @Override
    public String b() {
        return this.c;
    }

    protected final o m() {
        return this.b;
    }

    @Override
    public final void a(n n2) {
        int n3 = this.b.d();
        this.b.a(n2);
        n2.a((d)this, n3);
        if (this.a != null) {
            for (k k2 : this.a) {
                k2.a((d)n2, n3);
            }
            n2.f();
        }
    }

    @Override
    public final void a(n n2, int n3) {
        if (n3 < this.b.d()) {
            this.b.a(n2, n3);
            n2.a((d)this, n3);
            if (this.a != null) {
                for (k k2 : this.a) {
                    k2.a((d)n2, n3);
                }
                n2.f();
                return;
            }
        } else {
            this.a(n2);
        }
    }

    @Override
    public final void d(int n2) {
        if (this.a != null) {
            for (k k2 : this.a) {
                k2.a(n2);
            }
        }
        this.b.d(n2);
    }

    @Override
    public final int d() {
        return this.b.d();
    }

    @Override
    public final n c(int n2) {
        return this.b.c(n2);
    }

    @Override
    public String toString() {
        return "ABICycle_Base [getOrderInParent()=" + this.n() + ", condition=" + this.c + "\nbody=" + this.b + ", condition=" + this.c + "]";
    }

    @Override
    public final boolean a() {
        return true;
    }

    @Override
    public g h() {
        g g2 = super.h();
        g2.a("condition", this.c);
        return g2;
    }

    @Override
    public void a(g object) {
        super.a((g)object);
        object = ((g)object).a("condition");
        this.c((String)object);
    }

    @Override
    public c b(boolean n2) {
        c c2 = super.b(n2 != 0);
        c2.b("condition", this.c);
        if (n2 != 0) {
            n2 = 0;
            while (n2 < this.b.d()) {
                c2.a("body", this.b.c(n2).b(true));
                ++n2;
            }
        }
        return c2;
    }

    @Override
    public void a(c c2, boolean bl) {
        super.a(c2, bl);
        Object object = c2.f("condition");
        this.c((String)object);
        if (bl) {
            try {
                this.b.j();
            }
            catch (t t2) {
                object = t2;
                t2.printStackTrace();
            }
            object = c2.d("body");
            if (object != null) {
                int n2 = 0;
                while (n2 < ((a)object).a()) {
                    c c3 = ((a)object).c(n2);
                    n n3 = n.a(c3);
                    n3.a(c3, bl);
                    this.a(n3);
                    ++n2;
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void f() {
        if (this.a != null) {
            try {
                int n2 = 0;
                block2: while (true) {
                    n n3 = this;
                    if (n2 >= ((h)n3).b.d()) {
                        return;
                    }
                    n3 = this.c(n2);
                    Iterator iterator = this.a.iterator();
                    while (true) {
                        if (!iterator.hasNext()) {
                            n3.f();
                            ++n2;
                            continue block2;
                        }
                        k k2 = (k)iterator.next();
                        k2.a((d)n3, n2);
                    }
                    break;
                }
            }
            catch (r r2) {
                r r3 = r2;
                r2.printStackTrace();
            }
        }
    }

    @Override
    public p i() {
        p p2 = new p(1, this.c.length());
        p2.a(this.b.i());
        return p2;
    }
}

