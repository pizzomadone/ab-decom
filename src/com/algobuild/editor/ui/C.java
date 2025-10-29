/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.editor.ui;

import a.j.b.d_0;
import a.j.b.n;
import a.j.b.o;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class C {
    private d_0 b;
    protected n a;

    public C(d_0 d_02) {
        this.b = d_02;
    }

    public abstract void a(n var1, Graphics var2);

    public abstract void a(n var1);

    public final d_0 a() {
        return this.b;
    }

    public final void b(n n2) {
        this.a = n2;
    }

    public final void a(Rectangle rectangle) {
        if (this.a != null && this.a instanceof o) {
            ((o)this.a).b(rectangle);
        }
    }
}

