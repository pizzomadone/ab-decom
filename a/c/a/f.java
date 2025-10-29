/*
 * Decompiled with CFR 0.152.
 */
package a.c.a;

public final class f {
    private boolean a = true;
    private boolean b = true;
    private int c = 500;

    public final boolean a() {
        return this.a;
    }

    public final void a(boolean bl) {
        this.a = bl;
    }

    public final boolean b() {
        return this.b;
    }

    public final void b(boolean bl) {
        this.b = bl;
    }

    public final int c() {
        return this.c;
    }

    public final void a(int n2) {
        if (n2 > 0 && n2 < 10000) {
            this.c = n2;
        }
    }
}

