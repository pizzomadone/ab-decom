/*
 * Decompiled with CFR 0.152.
 */
package a.c.a;

import a.c.a.b;
import a.c.a.d;

public final class c {
    private int a = -1;
    private d b;
    private b c;

    public c(d d2, b b2) {
        this.b = d2;
        this.c = b2;
        if (this.b != null) {
            this.a = 0;
        }
    }

    public final void a() {
        this.a = this.b.a(this.c, this.a);
        if (this.a == -1) {
            this.c.d().pop();
        }
    }

    public final String toString() {
        return "ABEExecFragment [status=" + this.a + ", executable=" + this.b + "]";
    }

    public final boolean b() {
        return this.b.b(this.a);
    }

    public final int c() {
        return this.a;
    }

    public final d d() {
        return this.b;
    }
}

