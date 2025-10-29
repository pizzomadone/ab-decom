/*
 * Decompiled with CFR 0.152.
 */
package a.c.b;

import a.c.a.b;
import a.c.a.d;
import a.c.a.k;
import a.c.b.n;
import a.c.b.o;
import a.c.b.p;
import a.c.b.t;
import b.a.a;
import b.a.c;
import c.f;
import c.g;
import c.l;
import c.m;
import java.util.Vector;

public final class q
extends n {
    String b;
    private o d;
    private int e;
    Vector c;
    private String f = null;

    public q(String string, int n2) {
        this.b = string;
        this.e = n2;
        this.d = new o();
        this.d.a((d)this, -1);
        this.c = new Vector();
    }

    public q() {
        this.b = null;
        this.e = 0;
        this.d = new o();
        this.d.a((d)this, -1);
        this.c = new Vector();
    }

    public final String j() {
        return this.b;
    }

    public final void a(String string) {
        this.b = string;
    }

    public final void b(String string) {
        if (!this.c.contains(string)) {
            this.c.add(string);
        }
    }

    public final int k() {
        return this.c.size();
    }

    public final String e(int n2) {
        return (String)this.c.get(n2);
    }

    public final String l() {
        return this.f;
    }

    public final void c(String string) {
        this.f = string;
    }

    @Override
    public final int a(b b2, int n2) {
        if (n2 == 0) {
            b2.h("START:" + this.b);
            Object object = this;
            object = new a.c.a.c(((q)object).d, b2);
            b2.d().push(object);
            return 1;
        }
        if (n2 == 1) {
            if (this.f != null && this.f.length() > 0) {
                Object object = (f)b2.c().get(this.f);
                if (object != null) {
                    object = object.c();
                    b2.c().put("_RETVAL_", object);
                    b2.h("FUNCTION RETURN:" + this.f + " result:" + object.toString());
                } else {
                    try {
                        object = b2.e().a(this.f, b2.c());
                        b2.c().put("_RETVAL_", new m((l)object));
                        b2.h("FUNCTION RETURN:" + this.f + " result:" + object);
                    }
                    catch (g g2) {
                        b2.i("FUNCTION RETURN ERROR: " + g2 + " IN " + this.f);
                        return -2;
                    }
                }
            }
            if (this.e == 1) {
                b2.h("END:" + this.b);
            } else {
                b2.h("RET:" + this.b);
            }
            return -1;
        }
        return -1;
    }

    @Override
    public final void a(n n2) {
        int n3 = this.d.d();
        n2.a((d)this, n3);
        this.d.a(n2);
        if (this.a != null) {
            for (k k2 : this.a) {
                k2.a((d)n2, n3);
            }
            n2.f();
        }
    }

    @Override
    public final void a(n n2, int n3) {
        if (n3 < this.d.d()) {
            this.d.a(n2, n3);
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
        this.d.d(n2);
    }

    @Override
    public final int d() {
        return this.d.d();
    }

    @Override
    public final n c(int n2) {
        return this.d.c(n2);
    }

    @Override
    public final String c() {
        return this.b;
    }

    @Override
    public final String toString() {
        return "ABR_Base [name=" + this.b + ", body=" + this.d + ", formalParams=" + this.c + "]";
    }

    @Override
    public final String b() {
        return this.b;
    }

    @Override
    public final boolean a() {
        return true;
    }

    public final int m() {
        return this.e;
    }

    public final void g(int n2) {
        this.e = n2;
    }

    public final void o() {
        this.c.clear();
    }

    @Override
    public final a.f.g h() {
        a.f.g g2 = super.h();
        g2.a("codeType", Integer.toString(this.e));
        g2.a("name", this.b);
        q q2 = this;
        int n2 = q2.c.size();
        if (n2 > 0) {
            String string = this.e(0);
            int n3 = 1;
            while (n3 < n2) {
                string = String.valueOf(string) + "\n" + this.e(n3);
                ++n3;
            }
            g2.a("formalParams", string);
        }
        if (this.f != null) {
            g2.a("returnExpr", this.f);
        }
        return g2;
    }

    @Override
    public final void a(a.f.g g2) {
        super.a(g2);
        Object object = g2.a("codeType");
        this.e = Integer.parseInt((String)object);
        object = g2.a("name");
        q q2 = this;
        this.b = object;
        object = g2.a("formalParams");
        q2 = this;
        q2.c.clear();
        if (object != null) {
            object = object.split("\\n");
            int n2 = 0;
            while (n2 < ((String[])object).length) {
                this.b(object[n2]);
                ++n2;
            }
        }
        if ((object = g2.a("returnExpr")) != null) {
            q q3 = this;
            this.f = object;
        }
        this.a(true);
    }

    @Override
    public final c b(boolean bl) {
        int n2;
        c c2 = super.b(bl);
        c2.b("codeType", Integer.toString(this.e));
        c2.b("name", this.b);
        q q2 = this;
        int n3 = q2.c.size();
        if (n3 > 0) {
            n2 = 0;
            while (n2 < n3) {
                String string = this.e(n2).trim();
                if (!string.isEmpty()) {
                    c2.a("formalParams", (Object)string);
                }
                ++n2;
            }
        }
        q q3 = this;
        n2 = q3.d.d();
        if (bl) {
            int n4 = 0;
            while (n4 < n2) {
                c c3 = this.c(n4).b(true);
                c2.a("body", c3);
                ++n4;
            }
        }
        if (this.f != null && !this.f.isEmpty()) {
            c2.b("returnExpr", this.f);
        }
        return c2;
    }

    @Override
    public final void a(c object, boolean bl) {
        Object object2;
        Object object3;
        super.a((c)object, bl);
        Integer n2 = ((c)object).a("codeType");
        int n3 = n2;
        q q2 = this;
        this.e = n3;
        Object object4 = ((c)object).f("name");
        q2 = this;
        this.b = object4;
        object4 = ((c)object).d("formalParams");
        q2 = this;
        q2.c.clear();
        if (object4 != null) {
            int n4 = 0;
            while (n4 < ((a)object4).a()) {
                Object object5 = object3 = ((a)object4).d(n4);
                int n5 = n4;
                q q3 = this;
                if (n5 < q3.c.size()) {
                    q3.c.set(n5, object5);
                } else {
                    q3.c.add(object5);
                }
                System.out.println("SET PARAMETER  i=" + n4 + " par=" + (String)object3);
                ++n4;
            }
        }
        if ((object2 = ((c)object).f("returnExpr")) != null) {
            object4 = object2;
            object2 = this;
            this.f = object4;
        }
        if (bl) {
            object3 = ((c)object).d("body");
            try {
                this.d.j();
            }
            catch (t t2) {
                object = t2;
                t2.printStackTrace();
            }
            if (object3 != null) {
                int n6 = 0;
                while (n6 < ((a)object3).a()) {
                    object4 = ((a)object3).c(n6);
                    object2 = n.a((c)object4);
                    ((n)object2).a((c)object4, bl);
                    this.a((n)object2);
                    ++n6;
                }
            }
        }
        this.a(true);
    }

    @Override
    protected final String g() {
        return "ABRCOD";
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
                if (n3 >= ((q)n2).d.d()) break block3;
            }
            do {
                n2 = this.c(n3);
                for (k k2 : this.a) {
                    k2.a((d)n2, n3);
                }
                n2.f();
                ++n3;
                n2 = this;
            } while (n3 < ((q)n2).d.d());
        }
    }

    @Override
    public final p i() {
        p p2 = new p(1, this.b.length());
        p2.a(this.d.i());
        q q2 = this;
        int n2 = q2.c.size();
        int n3 = 0;
        while (n3 < n2) {
            p2.a(0, this.e(n3).length());
            ++n3;
        }
        return p2;
    }
}

