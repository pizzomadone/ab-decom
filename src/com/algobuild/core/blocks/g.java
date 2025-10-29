/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.core.blocks;

import a.c.a.b;
import a.c.a.c;
import a.c.a.d;
import a.c.b.h;
import a.c.b.n;
import a.c.b.r;
import a.c.b.s;
import c.l;

public final class g
extends h {
    public g(String string) {
        super(string);
    }

    public g() {
        super(null);
    }

    @Override
    public final int a(b b2, int n2) {
        boolean bl;
        String string = this.l();
        string = string.replace('\n', ' ');
        try {
            l l2 = b2.e().a(string, b2.c());
            boolean bl2 = l2 instanceof c.h && ((c.h)l2).a();
            bl = bl2;
            b2.h("WHILE TEST:  " + string + "   RESULT: " + bl2);
            b2.i();
        }
        catch (c.g g2) {
            b2.i("WHILE ERROR: " + g2 + " IN " + string);
            return -2;
        }
        if (bl) {
            c c2 = new c(this.m(), b2);
            b2.d().push(c2);
            return 0;
        }
        return -1;
    }

    @Override
    public final String toString() {
        return "ABICycleWhile  [ " + super.toString() + "]";
    }

    @Override
    public final d e() {
        g g2 = new g(this.l());
        try {
            int n2 = 0;
            while (n2 < this.d()) {
                n n3 = this.c(n2);
                ((d)g2).a((n)n3.e());
                ++n2;
            }
        }
        catch (s s2) {
            s s3 = s2;
            s2.printStackTrace();
        }
        catch (r r2) {
            r r3 = r2;
            r2.printStackTrace();
        }
        return g2;
    }

    @Override
    protected final String g() {
        return "ABIWHI";
    }
}

