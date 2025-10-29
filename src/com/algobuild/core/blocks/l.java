/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.core.blocks;

import a.c.a.b;
import a.c.a.d;
import a.c.b.m;
import a.c.b.n;
import a.c.b.o;
import a.c.b.p;
import a.c.b.s;
import a.c.b.t;
import b.a.a;
import b.a.c;
import c.g;
import c.h;

public final class l
extends m {
    private o b = new o();
    private o c;

    public l(String string) {
        super(string);
        this.b.a((d)this, 1);
        this.c = new o();
        this.c.a((d)this, 2);
    }

    public l() {
        this(null);
    }

    public final o j() {
        return this.b;
    }

    public final o k() {
        return this.c;
    }

    @Override
    public final n c(int n2) {
        if (n2 == 1) {
            return this.b;
        }
        if (n2 == 2) {
            return this.c;
        }
        throw new s("ABISelectionIf getInstr(" + n2 + ")");
    }

    @Override
    public final int a(b b2, int n2) {
        if (n2 == 0) {
            boolean bl;
            Object object = this.l();
            object = ((String)object).replace('\n', ' ');
            try {
                c.l l2 = b2.e().a((String)object, b2.c());
                boolean bl2 = l2 instanceof h && ((h)l2).a();
                bl = bl2;
                b2.h("IF TEST:  " + (String)object + "   RESULT: " + bl2);
                b2.i();
            }
            catch (g g2) {
                b2.i("IF ERROR: " + g2 + " IN " + (String)object);
                return -2;
            }
            if (bl) {
                b2.d().pop();
                object = this;
                a.c.a.c c2 = new a.c.a.c(((l)object).b, b2);
                b2.d().push(c2);
                return 1;
            }
            b2.d().pop();
            object = this;
            a.c.a.c c3 = new a.c.a.c(((l)object).c, b2);
            b2.d().push(c3);
            return 2;
        }
        if (n2 == 1) {
            return -1;
        }
        if (n2 == 2) {
            return -1;
        }
        return -1;
    }

    @Override
    public final String toString() {
        return "ABISelectionIf " + this.l() + " [bodyTrue=" + this.b + ", bodyFalse=" + this.c + ", getOrderInParent()=" + this.n() + "]";
    }

    @Override
    public final c b(boolean n2) {
        c c2 = super.b(n2 != 0);
        if (n2 != 0) {
            n2 = 0;
            while (n2 < this.c.d()) {
                c2.a("0", this.c.c(n2).b(true));
                ++n2;
            }
            n2 = 0;
            while (n2 < this.b.d()) {
                c2.a("1", this.b.c(n2).b(true));
                ++n2;
            }
        }
        return c2;
    }

    @Override
    public final void a(c c2, boolean bl) {
        super.a(c2, bl);
        if (bl) {
            n n2;
            c c3;
            int n3;
            Object object;
            try {
                this.c.j();
                this.b.j();
            }
            catch (t t2) {
                object = t2;
                t2.printStackTrace();
            }
            object = c2.d("0");
            if (object != null) {
                n3 = 0;
                while (n3 < ((a)object).a()) {
                    c3 = ((a)object).c(n3);
                    n2 = n.a(c3);
                    n2.a(c3, bl);
                    this.c.a(n2);
                    ++n3;
                }
            }
            if ((object = c2.d("1")) != null) {
                n3 = 0;
                while (n3 < ((a)object).a()) {
                    c3 = ((a)object).c(n3);
                    n2 = n.a(c3);
                    n2.a(c3, bl);
                    this.b.a(n2);
                    ++n3;
                }
            }
        }
    }

    @Override
    public final d e() {
        n n2;
        l l2 = new l(this.l());
        int n3 = 0;
        while (n3 < this.b.d()) {
            n2 = this.b.c(n3);
            l2.b.a((n)n2.e());
            ++n3;
        }
        n3 = 0;
        while (n3 < this.c.d()) {
            n2 = this.c.c(n3);
            l2.c.a((n)n2.e());
            ++n3;
        }
        return l2;
    }

    @Override
    public final void f() {
        if (this.a != null) {
            this.b.f();
            this.c.f();
        }
    }

    @Override
    protected final String g() {
        return "ABIIF_";
    }

    @Override
    public final p i() {
        p p2 = super.i();
        p2.a(this.b.i());
        p2.a(this.c.i());
        return p2;
    }
}

