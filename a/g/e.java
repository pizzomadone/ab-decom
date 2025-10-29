/*
 * Decompiled with CFR 0.152.
 */
package a.g;

import a.c.b.n;
import a.g.g;

public final class e
extends g {
    private n a;
    private a.f.g b = null;
    private a.f.g c = null;

    public e(n n2) {
        this.a = n2;
        this.b = n2.h();
    }

    @Override
    public final void a() {
        this.a.a(this.c);
    }

    @Override
    public final void b() {
        if (this.c == null) {
            this.c = this.a.h();
        }
        this.a.a(this.b);
    }
}

