/*
 * Decompiled with CFR 0.152.
 */
package a.c.b;

import a.c.a.b;
import a.c.a.c;
import a.c.a.d;
import a.c.b.h;
import a.c.b.n;
import a.c.b.r;
import a.c.b.s;
import c.g;
import c.l;

public final class e
extends h {
    public e(String string) {
        super(string);
    }

    public e() {
        super(null);
    }

    @Override
    public final int a(b b2, int n2) {
        boolean bl;
        String string = this.l();
        string = string.replace('\n', ' ');
        if (n2 == 0) {
            c c2 = new c(this.m(), b2);
            b2.d().push(c2);
            return 1;
        }
        try {
            l l2 = b2.e().a(string, b2.c());
            boolean bl2 = l2 instanceof c.h && ((c.h)l2).a();
            bl = bl2;
            b2.h("DO-WHILE TEST:  " + string + "   RESULT: " + bl2);
            b2.i();
        }
        catch (g g2) {
            b2.i("DO-WHILE ERROR: " + g2 + " IN " + string);
            return -2;
        }
        if (bl) {
            return 0;
        }
        return -1;
    }

    @Override
    public final String toString() {
        return "ABICycleDoWhile  [ " + super.toString() + "]";
    }

    @Override
    public final d e() {
        e e2 = new e(this.l());
        try {
            int n2 = 0;
            while (n2 < this.d()) {
                n n3 = this.c(n2);
                ((d)e2).a((n)n3.e());
                ++n2;
            }
        }
        catch (r r2) {
            r r3 = r2;
            r2.printStackTrace();
        }
        catch (s s2) {
            s s3 = s2;
            s2.printStackTrace();
        }
        return e2;
    }

    @Override
    public final boolean b(int n2) {
        return n2 == 1;
    }

    @Override
    protected final String g() {
        return "ABIDOW";
    }
}

