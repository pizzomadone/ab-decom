/*
 * Decompiled with CFR 0.152.
 */
package c;

import c.f;
import c.g;
import c.l;
import c.m;
import java.util.Vector;

public final class e
implements f {
    private Vector a;
    private m b;

    public e() {
        this.a = new Vector(10, 10);
    }

    private e(Vector vector) {
        this.a = (Vector)vector.clone();
    }

    public final l a(int n2, int n3) {
        l l2 = null;
        if (n2 >= 0 && n2 < this.a.size()) {
            m m2 = (m)((Vector)this.a.get(n2)).get(n3);
            if (m2 != null) {
                l2 = m2.d();
            }
        } else {
            System.out.println("INDEX - OUT - OF - BOUND " + n2);
            throw new g(450);
        }
        return l2;
    }

    public final void a(l l2, int n2, int n3) {
        int n4;
        if (this.a == null) {
            n4 = (int)Math.ceil((double)(n2 + 1) / 10.0) * 10;
            this.a = new Vector(n4, 10);
        }
        if (n2 >= 0 && n3 >= 0) {
            Vector<m> vector;
            if (n2 >= this.a.size()) {
                n4 = (int)Math.ceil((double)(n2 + 1) / 10.0) * 10;
                this.a.ensureCapacity(n4);
                this.a.setSize(n2 + 1);
            }
            if ((vector = (Vector<m>)this.a.get(n2)) != null) {
                m m2;
                if (n3 >= vector.size()) {
                    int n5 = (int)Math.ceil((double)(n3 + 1) / 10.0) * 10;
                    vector.ensureCapacity(n5);
                    vector.setSize(n3 + 1);
                }
                if ((m2 = (m)vector.get(n3)) != null) {
                    m2.a(l2);
                    return;
                }
                if (this.b != null) {
                    this.b = (m)this.b.c();
                    this.b.a(l2);
                } else {
                    this.b = new m(l2);
                }
                vector.set(n3, new m(l2));
                return;
            }
            int n6 = (int)Math.ceil((double)(n3 + 1) / 10.0) * 10;
            System.out.println("index2=" + n3);
            System.out.println("dim2=" + n6);
            vector = new Vector<m>(n6, 10);
            if (this.b != null) {
                this.b = (m)this.b.c();
                this.b.a(l2);
            } else {
                this.b = new m(l2);
            }
            System.out.println(vector.capacity());
            System.out.println(vector.size());
            if (vector.size() <= n3) {
                vector.setSize(n3 + 1);
            }
            vector.setElementAt(new m(l2), n3);
            this.a.set(n2, vector);
        }
    }

    public final String toString() {
        return this.b();
    }

    @Override
    public final String a() {
        String string = "{";
        if (this.b != null) {
            string = String.valueOf(string) + this.b.e();
        }
        int n2 = 0;
        while (n2 < this.a.size()) {
            Vector vector;
            if (n2 != 0) {
                string = String.valueOf(string) + ",";
            }
            if ((vector = (Vector)this.a.get(n2)) != null) {
                string = String.valueOf(string) + "{";
                int n3 = 0;
                while (n3 < vector.size()) {
                    m m2;
                    if (n3 != 0) {
                        string = String.valueOf(string) + ",";
                    }
                    if ((m2 = (m)vector.get(n3)) != null) {
                        string = String.valueOf(string) + m2.d();
                    }
                    ++n3;
                }
                string = String.valueOf(string) + "}";
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
            Vector vector;
            if (n2 != 0) {
                string = String.valueOf(string) + ",";
            }
            if ((vector = (Vector)this.a.get(n2)) != null) {
                string = String.valueOf(string) + "{";
                int n3 = 0;
                while (n3 < vector.size()) {
                    m m2;
                    if (n3 != 0) {
                        string = String.valueOf(string) + ",";
                    }
                    if ((m2 = (m)vector.get(n3)) != null) {
                        string = String.valueOf(string) + m2.b();
                    }
                    ++n3;
                }
                string = String.valueOf(string) + "}";
            }
            ++n2;
        }
        string = String.valueOf(string) + "}";
        return string;
    }

    @Override
    public final f c() {
        return new e(this.a);
    }
}

