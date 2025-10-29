/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.graphics;

import a.c.a.b;
import a.c.b.n;
import a.c.b.s;
import a.c.b.t;
import a.g.g;

public final class f
extends g {
    private b a;
    private String b;
    private int c;
    private n d;

    public f(b b2, String string, int n2, n n3) {
        this.a = b2;
        this.b = string;
        this.c = n2;
        this.d = n3;
    }

    @Override
    public final void a() {
        try {
            this.a.a(this.b, this.c, this.d);
            return;
        }
        catch (NumberFormatException numberFormatException) {
            NumberFormatException numberFormatException2 = numberFormatException;
            numberFormatException.printStackTrace();
            return;
        }
        catch (s s2) {
            s s3 = s2;
            s2.printStackTrace();
            return;
        }
    }

    @Override
    public final void b() {
        try {
            String string = String.valueOf(this.b) + "." + this.c;
            this.a.c(string);
            return;
        }
        catch (NumberFormatException numberFormatException) {
            NumberFormatException numberFormatException2 = numberFormatException;
            numberFormatException.printStackTrace();
            return;
        }
        catch (s s2) {
            s s3 = s2;
            s2.printStackTrace();
            return;
        }
        catch (t t2) {
            t t3 = t2;
            t2.printStackTrace();
            return;
        }
    }
}

