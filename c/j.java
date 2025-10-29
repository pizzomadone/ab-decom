/*
 * Decompiled with CFR 0.152.
 */
package c;

import c.i;
import c.l;

public final class j
extends i {
    long b;

    public j(long l2) {
        this.b = l2;
        this.a = l2;
    }

    public j() {
        this.b = 0L;
        this.a = 0.0;
    }

    @Override
    public final boolean a(l l2) {
        boolean bl = false;
        if (l2 instanceof j) {
            long l3 = ((j)l2).b;
            bl = this.b == l3;
        } else if (l2 instanceof i) {
            double d2 = ((i)l2).a;
            bl = this.a == d2;
        }
        return bl;
    }

    @Override
    public final boolean b(l l2) {
        boolean bl = false;
        if (l2 instanceof j) {
            long l3 = ((j)l2).b;
            bl = this.b < l3;
        } else if (l2 instanceof i) {
            double d2 = ((i)l2).a;
            bl = this.a < d2;
        }
        return bl;
    }

    @Override
    public final String toString() {
        return Long.toString(this.b);
    }

    @Override
    public final String b() {
        return "(int)";
    }

    @Override
    public final String c() {
        return "(int) " + Long.toString(this.b);
    }

    @Override
    public final String d() {
        return Long.toString(this.b);
    }
}

