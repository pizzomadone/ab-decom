/*
 * Decompiled with CFR 0.152.
 */
package a.c.a;

import a.c.a.b;
import a.c.a.k;
import a.c.b.n;
import a.c.b.r;
import a.c.b.s;
import a.c.b.t;
import java.util.Vector;

public abstract class d {
    protected Vector a = null;

    public abstract int a(b var1, int var2);

    public boolean a(int n2) {
        return n2 != -1;
    }

    public boolean b(int n2) {
        return true;
    }

    public boolean a() {
        return false;
    }

    public abstract String b();

    public abstract String c();

    public n c(int n2) {
        throw new s("ABEExecutable getInstr(" + n2 + ")");
    }

    public void a(n n2) {
        throw new s("ABEExecutable addInstr(" + n2 + ")");
    }

    public void a(n n2, int n3) {
        throw new s("ABEExecutable addInstr(" + n2 + "," + n3 + ")");
    }

    public void d(int n2) {
        throw new t("ABEExecutable removeInstr(" + n2 + ")");
    }

    public int d() {
        throw new r("ABEExecutable getNInstr()");
    }

    public final void a(k k2) {
        if (k2 != null) {
            if (this.a == null) {
                this.a = new Vector();
            }
            this.a.add(k2);
            k2.a(this);
        }
    }

    public final void a(boolean bl) {
        if (this.a != null) {
            for (k k2 : this.a) {
                k2.a(this, bl);
            }
        }
    }

    public d e() {
        return null;
    }

    public void f() {
    }
}

