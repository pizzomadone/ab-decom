/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.expression;

import c.f;
import c.g;
import c.l;
import c.m;
import java.util.Vector;

public final class d
implements f {
    private Vector a;
    private m b;

    public d() {
        this.a = new Vector(10, 10);
    }

    private d(Vector vector) {
        this.a = (Vector)vector.clone();
    }

    public final l a(int n2) {
        l l2 = null;
        if (n2 >= 0 && n2 < this.a.size()) {
            m m2 = (m)this.a.get(n2);
            if (m2 != null) {
                l2 = m2.d();
            }
        } else {
            System.out.println("INDEX - OUT - OF - BOUND " + n2);
            throw new g(450);
        }
        return l2;
    }

    public final void a(l l2, int n2) {
        int n3;
        if (this.a == null) {
            n3 = (int)Math.ceil((double)(n2 + 1) / 10.0) * 10;
            this.a = new Vector(n3, 10);
        }
        if (n2 >= 0) {
            if (n2 < this.a.size()) {
                m m2 = (m)this.a.get(n2);
                if (m2 != null) {
                    m2.a(l2);
                    return;
                }
                if (this.b != null) {
                    this.b = (m)this.b.c();
                    this.b.a(l2);
                } else {
                    this.b = new m(l2);
                }
                this.a.set(n2, new m(l2));
                return;
            }
            n3 = this.a.size();
            while (n3 <= n2) {
                this.a.add(null);
                ++n3;
            }
            if (this.b != null) {
                this.b = (m)this.b.c();
                this.b.a(l2);
            } else {
                this.b = new m(l2);
            }
            this.a.set(n2, this.b);
        }
    }

    public final String toString() {
        String string = "{";
        int n2 = 0;
        while (n2 < this.a.size()) {
            m m2;
            if (n2 != 0) {
                string = String.valueOf(string) + ",";
            }
            if ((m2 = (m)this.a.get(n2)) != null) {
                string = String.valueOf(string) + m2.d();
            }
            ++n2;
        }
        string = String.valueOf(string) + "}";
        return string;
    }

    @Override
    public final String a() {
        String string = "{";
        int n2 = 0;
        while (n2 < this.a.size()) {
            m m2;
            if (n2 != 0) {
                string = String.valueOf(string) + ",";
            }
            if ((m2 = (m)this.a.get(n2)) != null) {
                string = String.valueOf(string) + m2.d().c();
            }
            ++n2;
        }
        string = String.valueOf(string) + "}";
        return string;
    }

    @Override
    public final String b() {
        String string = "{";
        int n2 = 0;
        while (n2 < this.a.size()) {
            m m2;
            if (n2 != 0) {
                string = String.valueOf(string) + ",";
            }
            if ((m2 = (m)this.a.get(n2)) != null) {
                string = String.valueOf(string) + m2.d().d();
            }
            ++n2;
        }
        string = String.valueOf(string) + "}";
        return string;
    }

    @Override
    public final f c() {
        return new d(this.a);
    }
}

