/*
 * Decompiled with CFR 0.152.
 */
package a.j.a;

public final class b {
    private String a;
    private int b;
    private boolean c;
    private boolean d;
    private boolean e;

    public b() {
    }

    public b(String string, int n2, boolean bl, boolean bl2, boolean bl3) {
        this.a = string;
        this.b = n2;
        this.c = bl;
        this.d = bl2;
        this.e = bl3;
    }

    public final String a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final boolean c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final boolean e() {
        return this.e;
    }

    public final String toString() {
        return "ABVConsoleMessages [msgText=" + this.a + ", indent=" + this.b + ", endLine=" + this.c + ", traceMsg=" + this.d + ", errorMsg=" + this.e + "]";
    }
}

