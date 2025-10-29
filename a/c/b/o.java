/*
 * Decompiled with CFR 0.152.
 */
package a.c.b;

import a.c.a.b;
import a.c.a.c;
import a.c.a.d;
import a.c.a.k;
import a.c.b.n;
import a.c.b.p;
import java.util.Vector;

public final class o
extends n {
    private Vector b = new Vector();

    @Override
    public final boolean b(int n2) {
        return false;
    }

    @Override
    public final boolean a(int n2) {
        int n3 = this.b.size();
        return n2 >= 0 && n2 < n3;
    }

    @Override
    public final n c(int n2) {
        return (n)this.b.get(n2);
    }

    @Override
    public final void a(n n2) {
        o o2 = this;
        int n3 = o2.b.size();
        n2.a((d)this, n3);
        this.b.add(n2);
        if (this.a != null) {
            for (k k2 : this.a) {
                k2.a((d)n2, n3);
            }
        }
    }

    /*
     * Handled impossible loop by duplicating code
     * Enabled aggressive block sorting
     */
    @Override
    public final void a(n n2, int n3) {
        block5: {
            Object object;
            int n4;
            block4: {
                n4 = n3;
                if (!true) break block4;
                object = this;
                if (n4 >= ((o)object).b.size()) break block5;
            }
            do {
                this.c(n4).f(1);
                ++n4;
                object = this;
            } while (n4 < ((o)object).b.size());
        }
        n2.a((d)this, n3);
        this.b.add(n3, n2);
        if (this.a != null) {
            for (k k2 : this.a) {
                k2.a((d)n2, n3);
            }
        }
        n2.f();
    }

    /*
     * Handled impossible loop by duplicating code
     * Enabled aggressive block sorting
     */
    @Override
    public final void d(int n2) {
        block5: {
            Object object;
            int n3;
            block4: {
                this.b.remove(n2);
                n3 = n2;
                if (!true) break block4;
                object = this;
                if (n3 >= ((o)object).b.size()) break block5;
            }
            do {
                this.c(n3).f(-1);
                ++n3;
                object = this;
            } while (n3 < ((o)object).b.size());
        }
        if (this.a != null) {
            for (k k2 : this.a) {
                k2.a(n2);
            }
        }
    }

    /*
     * Handled impossible loop by duplicating code
     * Enabled aggressive block sorting
     */
    public final void j() {
        block3: {
            o o2;
            block2: {
                if (!true) break block2;
                o2 = this;
                if (o2.b.size() <= 0) break block3;
            }
            do {
                this.d(0);
                o2 = this;
            } while (o2.b.size() > 0);
        }
    }

    @Override
    public final int d() {
        return this.b.size();
    }

    @Override
    public final int a(b b2, int n2) {
        if (this.a(n2)) {
            int n3 = n2++;
            c c2 = new c((d)this.b.get(n3), b2);
            b2.d().push(c2);
        } else {
            n2 = -1;
        }
        return n2;
    }

    @Override
    public final String toString() {
        return "ABICompound [getOrderInParent()=" + this.n() + "\ninstructions=" + this.b + "]";
    }

    @Override
    public final boolean a() {
        return true;
    }

    /*
     * Handled impossible loop by duplicating code
     * Enabled aggressive block sorting
     */
    @Override
    public final void f() {
        block3: {
            n n2;
            int n3;
            block4: {
                if (this.a == null) break block3;
                n3 = 0;
                if (!true) break block4;
                n2 = this;
                if (n3 >= ((o)n2).b.size()) break block3;
            }
            do {
                n2 = this.c(n3);
                for (k k2 : this.a) {
                    k2.a((d)n2, n3);
                }
                n2.f();
                ++n3;
                n2 = this;
            } while (n3 < ((o)n2).b.size());
        }
    }

    /*
     * Handled impossible loop by duplicating code
     * Enabled aggressive block sorting
     */
    @Override
    public final p i() {
        p p2;
        block3: {
            n n2;
            int n3;
            block2: {
                p2 = new p();
                n3 = 0;
                if (!true) break block2;
                n2 = this;
                if (n3 >= ((o)n2).b.size()) break block3;
            }
            do {
                n2 = this.c(n3);
                p2.a(n2.i());
                ++n3;
                n2 = this;
            } while (n3 < ((o)n2).b.size());
        }
        return p2;
    }
}

