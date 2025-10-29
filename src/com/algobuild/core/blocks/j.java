/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.core.blocks;

import a.c.a.b;
import a.c.a.d;
import a.c.b.k;
import b.a.c;
import c.g;

public final class j
extends k {
    private int b = 1;

    public j(String string) {
        super(string);
    }

    private j(String string, int n2) {
        super(string);
        this.e(n2);
    }

    public j() {
        super(null);
    }

    public final int j() {
        return this.b;
    }

    public final void e(int n2) {
        if (n2 < 0) {
            n2 = 0;
        } else if (n2 > 2) {
            n2 = 2;
        }
        this.b = n2;
        this.a(true);
    }

    @Override
    public final int a(b b2, int n2) {
        String[] stringArray = this.l();
        int n3 = 0;
        while (stringArray != null && n3 < stringArray.length) {
            Object object;
            b2.h("OUTPUT: " + stringArray[n3]);
            String string = stringArray[n3];
            if (string.startsWith("\"")) {
                object = string.replace("\"", "");
                if (this.b == 2) {
                    b2.g((String)object);
                } else {
                    b2.f((String)object);
                }
            } else if (string.startsWith("'")) {
                object = string.replace("'", "");
                if (this.b == 2) {
                    b2.g((String)object);
                } else {
                    b2.f((String)object);
                }
            } else {
                try {
                    object = b2.e().a(string, b2.c());
                    if (this.b == 2) {
                        b2.g(object.toString());
                    } else {
                        b2.f(object.toString());
                    }
                }
                catch (g g2) {
                    b2.i("OUTPUT ERROR: " + g2 + " IN " + string);
                    return -2;
                }
            }
            ++n3;
        }
        if (this.b == 1) {
            b2.n();
        }
        return -1;
    }

    @Override
    public final String toString() {
        return this.n() + "- ABIIOOutput: " + this.k().replace("\n", ", ") + "\n";
    }

    @Override
    public final a.f.g h() {
        a.f.g g2 = super.h();
        g2.a("lineSeparators", Integer.toString(this.b));
        return g2;
    }

    @Override
    public final void a(a.f.g object) {
        super.a((a.f.g)object);
        object = ((a.f.g)object).a("lineSeparators");
        this.b = Integer.parseInt((String)object);
    }

    @Override
    public final c b(boolean bl) {
        c c2 = super.b(bl);
        c2.b("lineSeparators", Integer.toString(this.b));
        return c2;
    }

    @Override
    public final void a(c object, boolean bl) {
        super.a((c)object, bl);
        object = ((c)object).f("lineSeparators");
        this.e(new Integer((String)object));
    }

    @Override
    public final d e() {
        j j2 = this;
        j2 = new j(this.k(), j2.b);
        return j2;
    }

    @Override
    protected final String g() {
        return "ABIOUT";
    }
}

