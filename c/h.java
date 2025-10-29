/*
 * Decompiled with CFR 0.152.
 */
package c;

import c.l;

public final class h
implements l {
    boolean a;

    public h(boolean bl) {
        this.a = bl;
    }

    public h() {
        this.a = false;
    }

    public final boolean a() {
        return this.a;
    }

    @Override
    public final boolean a(l l2) {
        return l2 instanceof h && this.a == ((h)l2).a;
    }

    @Override
    public final boolean b(l l2) {
        return l2 instanceof h && !this.a && ((h)l2).a;
    }

    @Override
    public final String toString() {
        return Boolean.toString(this.a);
    }

    @Override
    public final String b() {
        return "(boolean)";
    }

    @Override
    public final String c() {
        return "(boolean) " + Boolean.toString(this.a);
    }

    @Override
    public final String d() {
        return Boolean.toString(this.a);
    }
}

