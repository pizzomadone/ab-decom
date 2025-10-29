/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.graphics;

import a.c.b.n;
import a.c.b.s;
import a.c.b.t;
import a.g.g;

public final class b
extends g {
    private a.c.a.b a;
    private n b;
    private int c = 0;
    private String d = "";

    public b(a.c.a.b object, String string) {
        this.a = object;
        int n2 = string.lastIndexOf(46);
        this.c = Integer.parseInt(string.substring(n2 + 1));
        this.d = string.substring(0, n2);
        try {
            this.b = ((a.c.a.b)object).d(string);
            return;
        }
        catch (NumberFormatException numberFormatException) {
            object = numberFormatException;
            numberFormatException.printStackTrace();
            return;
        }
        catch (s s2) {
            object = s2;
            s2.printStackTrace();
            return;
        }
    }

    @Override
    public final void b() {
        try {
            this.a.a(this.d, this.c, this.b);
            this.a.a(this.b);
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
    public final void a() {
        try {
            this.a.c(String.valueOf(this.d) + "." + this.c);
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

