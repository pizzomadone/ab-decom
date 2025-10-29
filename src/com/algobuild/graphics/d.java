/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.graphics;

import a.c.a.b;
import a.c.b.q;
import a.g.g;

public final class d
extends g {
    private b a;
    private q b;
    private a.f.g c = null;
    private a.f.g d = null;
    private String e = null;
    private String f = null;

    public d(b b2, q q2) {
        this.a = b2;
        this.b = q2;
        this.f = q2.j();
        this.c = q2.h();
    }

    @Override
    public final void a() {
        this.b.a(this.d);
        this.a.a(this.f, this.b);
    }

    @Override
    public final void b() {
        if (this.d == null) {
            this.d = this.b.h();
            this.e = this.b.j();
        }
        this.b.a(this.c);
        this.a.a(this.e, this.b);
    }
}

