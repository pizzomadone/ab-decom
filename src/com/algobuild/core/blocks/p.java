/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.core.blocks;

public final class p {
    private int a;
    private int b;

    public p() {
        this.a = 0;
        this.b = 0;
    }

    public p(int n2, int n3) {
        this.a(1);
        this.b(n3);
    }

    public final int a() {
        return this.a;
    }

    private void a(int n2) {
        if (n2 >= 0) {
            this.a = n2;
        }
    }

    public final int b() {
        return this.b;
    }

    private void b(int n2) {
        if (n2 >= 0) {
            this.b = n2;
        }
    }

    public final void a(int n2, int n3) {
        this.a(this.a);
        if (n3 >= 0) {
            this.b(this.b + n3);
        }
    }

    public final void a(p p2) {
        if (p2.a >= 0) {
            this.a(this.a + p2.a);
        }
        if (p2.b >= 0) {
            this.b(this.b + p2.b);
        }
    }

    public final String toString() {
        String string = String.valueOf(Integer.toString(this.a)) + "(I) " + Integer.toString(this.b) + "(C)";
        return string;
    }
}

