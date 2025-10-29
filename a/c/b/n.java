/*
 * Decompiled with CFR 0.152.
 */
package a.c.b;

import a.c.a.b;
import a.c.b.a;
import a.c.b.c;
import a.c.b.d;
import a.c.b.e;
import a.c.b.f;
import a.c.b.g;
import a.c.b.i;
import a.c.b.j;
import a.c.b.l;
import a.c.b.p;
import a.c.b.q;

public abstract class n
extends a.c.a.d {
    private a.c.a.d b = null;
    private int c = -1;

    public final void a(a.c.a.d d2, int n2) {
        this.b = d2;
        this.c = n2;
    }

    public final void f(int n2) {
        this.c += n2;
        if (this.c < 0) {
            this.c = 0;
        }
    }

    public final int n() {
        return this.c;
    }

    @Override
    public String c() {
        n n2 = this;
        if (n2.b != null) {
            n2 = this;
            String string = n2.b.c();
            n2 = this;
            if (n2.c >= 0) {
                n2 = this;
                return String.valueOf(string) + "." + n2.c;
            }
            return string;
        }
        n2 = this;
        return Integer.toString(n2.c);
    }

    @Override
    public int a(b b2, int n2) {
        return 0;
    }

    public String toString() {
        return "ABI_Base [parent=" + this.b + ", orderInParent=" + this.c + "]";
    }

    @Override
    public String b() {
        return null;
    }

    @Override
    public boolean b(int n2) {
        return true;
    }

    protected String g() {
        return null;
    }

    public a.f.g h() {
        a.f.g g2 = new a.f.g();
        g2.a("path", this.c());
        g2.a("abiid", this.g());
        return g2;
    }

    public void a(a.f.g g2) {
    }

    public b.a.c b(boolean bl) {
        b.a.c c2 = new b.a.c();
        c2.b("abiid", this.g());
        return c2;
    }

    public void a(b.a.c c2, boolean bl) {
    }

    public static n a(b.a.c object) {
        object = (String)((b.a.c)object).c("abiid");
        n n2 = null;
        if (((String)object).equals("ABIASS")) {
            n2 = new a();
        } else if (((String)object).equals("ABICAL")) {
            n2 = new c();
        } else if (((String)object).equals("ABICOM")) {
            n2 = new d();
        } else if (((String)object).equals("ABIDOW")) {
            n2 = new e();
        } else if (((String)object).equals("ABIFOR")) {
            n2 = new f();
        } else if (((String)object).equals("ABIWHI")) {
            n2 = new g();
        } else if (((String)object).equals("ABIINP")) {
            n2 = new i();
        } else if (((String)object).equals("ABIOUT")) {
            n2 = new j();
        } else if (((String)object).equals("ABIIF_")) {
            n2 = new l();
        } else if (((String)object).equals("ABRCOD")) {
            n2 = new q();
        }
        return n2;
    }

    public abstract p i();
}

