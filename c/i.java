/*
 * Decompiled with CFR 0.152.
 */
package c;

import c.l;

public class i
implements l {
    double a;

    public i(double d2) {
        this.a = d2;
    }

    public i() {
        this.a = 0.0;
    }

    @Override
    public boolean a(l l2) {
        return l2 instanceof i && this.a == ((i)l2).a;
    }

    @Override
    public boolean b(l l2) {
        return l2 instanceof i && this.a < ((i)l2).a;
    }

    @Override
    public String toString() {
        return Double.toString(this.a);
    }

    @Override
    public String b() {
        return "(double)";
    }

    @Override
    public String c() {
        return "(double) " + Double.toString(this.a);
    }

    @Override
    public String d() {
        return Double.toString(this.a);
    }
}

