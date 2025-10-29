/*
 * Decompiled with CFR 0.152.
 */
package a.c.a;

import a.c.a.b;
import a.c.a.c;
import a.c.a.d;
import a.c.b.n;

public final class e {
    private b a;

    public e(b b2) {
        this.a = b2;
    }

    public final void a(String object) {
        object = this.a.a((String)object);
        c c2 = new c((d)object, this.a);
        this.a.d().push(c2);
        this.a.f();
        if (object instanceof n) {
            ((n)object).a(false);
        }
    }

    public final void a() {
        boolean bl = this.b();
        if (bl) {
            Object object = (c)this.a.d().peek();
            if ((object = ((c)object).d()) instanceof n) {
                ((n)object).a(false);
            }
        }
        this.a.b();
    }

    public final boolean b() {
        return this.a != null && !this.a.d().empty();
    }

    public final void c() {
        boolean bl = this.b();
        while (bl) {
            Object object = (c)this.a.d().peek();
            if (object != null) {
                ((c)object).a();
                if (((c)object).c() == -2) {
                    this.a.d().clear();
                }
                if ((object = ((c)object).d()) instanceof n) {
                    ((n)object).a(false);
                }
            }
            if (this.a.d().empty()) {
                bl = false;
                continue;
            }
            object = (c)this.a.d().peek();
            if (object == null || ((c)object).b()) {
                bl = false;
            }
            if (object == null || !((object = ((c)object).d()) instanceof n)) continue;
            ((n)object).a(false);
        }
    }
}

