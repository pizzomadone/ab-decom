/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.expression;

import c.l;

public final class k
implements l {
    String a;

    public k(String string) {
        this.a = string;
    }

    public k(char c2) {
        this.a = Character.toString(c2);
    }

    public k() {
        this.a = "";
    }

    @Override
    public final boolean a(l l2) {
        return l2 instanceof k && this.a.equals(((k)l2).a);
    }

    @Override
    public final boolean b(l l2) {
        return l2 instanceof k && this.a.compareTo(((k)l2).a) < 0;
    }

    @Override
    public final String toString() {
        return this.a;
    }

    @Override
    public final String b() {
        return "(string)";
    }

    @Override
    public final String c() {
        return "(string) \"" + this.a + "\"";
    }

    @Override
    public final String d() {
        return "\"" + this.a + "\"";
    }
}

