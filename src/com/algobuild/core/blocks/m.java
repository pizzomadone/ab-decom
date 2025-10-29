/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.core.blocks;

import a.c.b.n;
import a.c.b.p;
import a.f.g;
import b.a.c;

public abstract class m
extends n {
    private String b;

    public m(String string) {
        this.b = string;
    }

    public final String l() {
        return this.b;
    }

    public final void a(String string) {
        this.b = string;
        this.a(true);
    }

    @Override
    public final String b() {
        return this.b;
    }

    @Override
    public String toString() {
        return "ABISelection_Base [condition=" + this.b + ", getOrderInParent()=" + this.n() + "]";
    }

    @Override
    public final boolean a() {
        return true;
    }

    @Override
    public final g h() {
        g g2 = super.h();
        g2.a("condition", this.b);
        return g2;
    }

    @Override
    public final void a(g object) {
        super.a((g)object);
        object = ((g)object).a("condition");
        this.a((String)object);
    }

    @Override
    public c b(boolean bl) {
        c c2 = super.b(bl);
        c2.b("condition", this.b);
        return c2;
    }

    @Override
    public void a(c object, boolean bl) {
        super.a((c)object, bl);
        object = ((c)object).f("condition");
        this.a((String)object);
    }

    @Override
    public p i() {
        p p2 = new p(1, this.b.length());
        return p2;
    }
}

